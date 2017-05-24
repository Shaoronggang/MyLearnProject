package com.detao.mylearnproject.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.Toast;

/**
 * Created by shaoronggang on 2017/5/24.
 * 自定义的viewpager
 *
 */

public class MyViewPager extends ViewGroup {

    /**
     * 手势识别器
     * 1.定义出来
     * 2.实例化-把想要的方法给重新
     * 3.在onTouchEvent()把事件传递给手势识别器
     */
    private GestureDetector detector;

    private Scroller scroller;

    /**
     * 当前位置的下标
     */
    private int currentIndex;


    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(final Context context) {
        scroller = new Scroller(context);
        detector = new GestureDetector(context,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
                Toast.makeText(context,"长按",Toast.LENGTH_SHORT).show();
            }

            /**
             *
             * @param e1
             * @param e2
             * @param distanceX  在x轴滑动的距离
             * @param distanceY  在y轴滑动的距离
             * @return
             */
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                /**
                 *x:要在X轴移动的距离
                 *y:要在Y轴移动的距离
                 */
                scrollBy((int) distanceX,0);

                return super.onScroll(e1, e2, distanceX, distanceY);
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Toast.makeText(context,"双击",Toast.LENGTH_SHORT).show();
                return super.onDoubleTapEvent(e);
            }
        });

    }

    private float startX;
    private float downX;
    private float downY;

    /**
     * 如果当前方法，返回ture,拦截事件，将会触发当前控件的onTouchEvent()方法
     * 如果当前方法,返回false,不拦截事件，事件继续传递给孩子
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        detector.onTouchEvent(ev); //将事件传递给手势识别器
        boolean result = false; //默认传递给孩子
        switch (ev.getAction()) {
            case  MotionEvent.ACTION_DOWN:
                System.out.println("onInterceptTouchEvent==ACTION_DOWN");
                //1.记录初始的坐标
                downX = ev.getX();
                downY = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("onInterceptTouchEvent==ACTION_DOWN");
                //2.记录结束值
                float endX = ev.getX();
                float endY = ev.getY();

                //计算绝对值
                float distanceX = Math.abs(endX - downX);
                float distanceY = Math.abs(endY - downY);

                //解决滑动的BUG,另外，在进行相应的SCrollView时，事件不会拦截，如果不是在相应的页面进行滑动，则会进行相应的

                Log.e("DisTance:", distanceX - distanceY + "   " + "distanceX:" + distanceX + "distanceY:" + distanceY);
                if(distanceX > distanceY && distanceX > 5) {
                    return true;
                }else {
                    scrollToPager(currentIndex);
                }

                break;
            case MotionEvent.ACTION_UP:

                break;
        }

        return result;
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        super.onTouchEvent(event);
        detector.onTouchEvent(event); //将事件传递给手势识别器
        switch (event.getAction()) {
            case  MotionEvent.ACTION_DOWN:
                //记录初始位置
                startX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:



                break;
            case MotionEvent.ACTION_UP:
                //来到新的坐标
                float endX = event.getX();

                //下标位置
                int tempIndex = currentIndex;

                Log.e("Direction:", ""+ getWidth());
                //// TODO: 2017/5/24  有一个BUG滑动到第二个页面后，反向滑动会导致startX值，不正确
                if((startX - endX) > getWidth()/2 ) {
                    tempIndex++;  //显示下一个页面
                }else if((endX - startX) >getWidth()/2) {
                    tempIndex--; //显示上一个页面
                }

                //根据下标位置移动到指定的页面
                scrollToPager(tempIndex);
                break;
        }

        return true;
    }

    /**
     * 屏蔽非法值，根据位置移动到指定页面
     * @param tempIndex
     */
    public void scrollToPager(int tempIndex) {
        if(tempIndex < 0) {
            tempIndex = 0;
        }
        if(tempIndex > getChildCount() -1) {
            tempIndex = getChildCount() - 1;
        }

        //当前页面的下标位置
        currentIndex = tempIndex;

        if(mOnPageChangeListener != null) {
            mOnPageChangeListener.onScrollToPage(currentIndex);
        }

        //总距离计算出来
        int distanceX = currentIndex*getWidth() - getScrollX();  //  getScrollX  :The left edge of the displayed part of your view, in pixels.
        Log.e("SCROLL",getScrollX() + "" + "distanceX:" + distanceX);
        scroller.startScroll(getScrollX(),getScrollY(),distanceX,0,Math.abs(distanceX)); //更加平滑的过度到相应位置
        invalidate();  //重绘
    }

    /**
     *
     */
    @Override
    public void computeScroll() {
//        super.computeScroll();
        if(scroller.computeScrollOffset()) {
            //得到移动这个一小段对应的坐标
            float currX = scroller.getCurrX();

            scrollTo((int) currX,0);
            invalidate();
        }

    }

    /**
     * 遍历父容器，指定每个孩子在屏幕上的坐标位置
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.layout(i*getWidth(),0,(i+1)*getWidth(),getHeight());
        }

    }

    /**
     *  * 1.测量的时候测量多次
     * 2.widthMeasureSpec父层视图给当前视图的宽和模式
     * 系统的onMesaure中所干的事：
      1、根据 widthMeasureSpec 求得宽度width，和父view给的模式
      2、根据自身的宽度width 和自身的padding 值，相减，求得子view可以拥有的宽度newWidth
      3、根据 newWidth 和模式求得一个新的MeasureSpec值:
       MeasureSpec.makeMeasureSpec(newSize, newmode);
      4、用新的MeasureSpec来计算子view

     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int mode = MeasureSpec.getMode(widthMeasureSpec);

        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        int newSize = MeasureSpec.makeMeasureSpec(size,mode);
        System.out.println("widthMeasureSpec=="+widthMeasureSpec+"size=="+size+",mode=="+mode);
        System.out.println("widthMeasureSpec=="+widthMeasureSpec+"sizeHeight=="+sizeHeight+",modeHeight=="+modeHeight);

        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec,heightMeasureSpec); //ViewGroup有义务对每一个子View进行测量
        }
    }

    /**
     * 设置页面监听的回调，
     */
    public interface OnPageChangeListenter {
        void onScrollToPage(int positon);
    }

    private OnPageChangeListenter mOnPageChangeListener;

    public void setmOnPageChangeListener(OnPageChangeListenter mOnPageChangeListener) {
        this.mOnPageChangeListener = mOnPageChangeListener;
    }
}
