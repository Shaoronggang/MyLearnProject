package com.detao.mylearnproject.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by shaoronggang on 2017/5/10.
 */

public class ViewPagerActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    private static final String TAG = ViewPagerActivity.class.getSimpleName();
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll_point_group)
    LinearLayout llPointGroup;

    //上一次被选中的位置
    private int prePosition = 0;

    ArrayList<ImageView> imageViews;

    /**
     * 是否已经滑动
     */
    private boolean isDragging = false;

    //图片资源ID
    private final int[] imageIds = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e
    };

    //图片标题集合
    private final String[] imageDescriptions = {
            "天空中没有翅膀的痕迹",
            "如果你因为失去了太阳而流泪",
            "那么你将失去群星了",
            "你看不见你自己,你所看见的只是你的影子",
            "你微微地笑着，不同我说什么话"
    };

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int pos = viewpager.getCurrentItem() + 1;
            viewpager.setCurrentItem(pos);

            //延迟发送消息，使图片不断轮播
            handler.sendEmptyMessageDelayed(0, 4000);
        }
    };


    @Override
    protected int getResLayout() {
        return R.layout.viewpageractivity;
    }

    @Override
    public void afterView() {
        super.afterView();
        imageViews = new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);

            imageViews.add(imageView);

            //添加点
            ImageView imagepoint = new ImageView(this);
            imagepoint.setBackgroundResource(R.drawable.point_selector);
            LinearLayout.LayoutParams layoutparams = new LinearLayout.LayoutParams(8, 8); //父布局来决定他的布局参数
            if (i == 0) {
                imagepoint.setEnabled(true); //选中时为红色
            } else {
                imagepoint.setEnabled(false); //未选中时为灰色
                layoutparams.leftMargin = 8;
            }

            imagepoint.setLayoutParams(layoutparams); //最后要将布局参数给子视图
            llPointGroup.addView(imagepoint); //将子视图添加到父视图中
        }

        viewpager.setAdapter(new MyPagerAdapter()); //设置适配器
        //设置监听ViewPager页面的变化
        viewpager.addOnPageChangeListener(this);

        //设置中间位置
        int item = Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % imageViews.size();//要保证imageViews的整数倍

        viewpager.setCurrentItem(item);

        tvTitle.setText(imageDescriptions[prePosition]);
        handler.sendEmptyMessageDelayed(0, 3000);
    }


    /**
     * 当页面滚动了的时候回调这个方法
     *
     * @param position             当前页面的位置
     * @param positionOffset       滑动页面的百分比
     * @param positionOffsetPixels 在屏幕上滑动的像数
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 当某个页面被选中了的时候回调
     *
     * @param position 被选中页面的位置
     */
    @Override
    public void onPageSelected(int position) {
        int realPosition = position % imageViews.size();
        //设置对应的文本的描述
        tvTitle.setText(imageDescriptions[realPosition]);

        //把上一个点设置为灰色
        llPointGroup.getChildAt(prePosition).setEnabled(false);
        //把当前的点设置为高亮
        llPointGroup.getChildAt(realPosition).setEnabled(true);

        prePosition = realPosition;
    }

    /**
     * 当页面滚动状态变化的时候回调这个方法
     * 静止->滑动
     * 滑动-->静止
     * 静止-->拖拽
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == ViewPager.SCROLL_STATE_DRAGGING) {
            isDragging = true;
            handler.removeCallbacksAndMessages(null);
        } else if (state == ViewPager.SCROLL_STATE_SETTLING) {
            Log.e(TAG, "SCROLL_STATE_SETTLING-----------------");
        } else if (state == ViewPager.SCROLL_STATE_IDLE && isDragging) {
            isDragging = false;
            handler.removeCallbacksAndMessages(null);
            handler.sendEmptyMessageDelayed(0, 4000);
        }

    }


    class MyPagerAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        /**
         * 比较view和object是否同一个实例
         *
         * @param view   页面
         * @param object 这个方法instantiateItem返回的结果
         * @return
         */
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 相当于listView中的getView方法
         *
         * @param container viewPager自身
         * @param position  当前实例化页面的位置
         * @return
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int realPosition = position % imageViews.size();
            final ImageView imageView = imageViews.get(realPosition);
            container.addView(imageView);

            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: //手指按下
                            Log.e(TAG,"onTouch==手指按下");
                        handler.removeCallbacksAndMessages(null);
                            break;
                        case MotionEvent.ACTION_MOVE: //手指在控件上移动
                            break;
                        case MotionEvent.ACTION_CANCEL: //手指按下
                            Log.e(TAG,"onTouch==事件取消");
                            break;
                        case MotionEvent.ACTION_UP: //手指离开
                        handler.removeCallbacksAndMessages(null);
                        handler.sendEmptyMessageDelayed(0,4000);
                            break;
                    }
                    return false;
                }
            });

            imageView.setTag(position);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(TAG,"点击事件");
                    int pos = (int)v.getTag()%imageViews.size();
                    String text = imageDescriptions[pos];
                    Toast.makeText(ViewPagerActivity.this, "text=="+text, Toast.LENGTH_SHORT).show();
                }
            });


            return imageView;
        }

        /**
         * 释放资源
         *
         * @param container viewpager
         * @param position  要释放的位置
         * @param object    要释放的页面
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }
}
