package com.detao.mylearnproject.activity;

import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by shaoronggang on 2017/5/23.
 */

public class EventTestActivity extends BaseActivity {


    @BindView(R.id.iv_event)
    ImageView ivEvent;

    @Override
    protected int getResLayout() {
        return R.layout.eventtestactivity;
    }


    private long exitTime = 0;
    private boolean isFirst = true;
    private long twoTime = 0;

    @Override
    public void afterView() {
        super.afterView();

        ivEvent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        ClickContinue();
                        //连续点击两次的逻辑代码
//                        Toast.makeText(EventTestActivity.this,  " MotionEvent.ACTION_DOWN：" + event.getX() + ",距离X轴的坐标：" + event.getRawX(), Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_MOVE:
//                        Toast.makeText(EventTestActivity.this, "MotionEvent.ACTION_MOVE:" + event.getX()+ ",距离X轴的坐标：" + event.getRawX(), Toast.LENGTH_SHORT).show();
                        break;
                    case MotionEvent.ACTION_UP:
                        twoTime = System.currentTimeMillis();

//                        Toast.makeText(EventTestActivity.this,  " MotionEvent.ACTION_UP:" + event.getX()+ ",距离X轴的坐标：" + event.getRawX(), Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });


    }

    /**
     * 手势操作之连续两次点击
     */
    private void ClickContinue() {
        if (isFirst) {
            isFirst = false;
            exitTime = System.currentTimeMillis();
        }else {
            twoTime = System.currentTimeMillis();
        }

        Log.e("Time", "isfirst:" + isFirst + "   " + "exittime:" + exitTime + "    "+"twotime:" + twoTime  +"  " + (twoTime - exitTime));
        if ((twoTime - exitTime) < 2000 && (twoTime - exitTime)> 0) {
            // ToastUtil.makeToastInBottom("再按一次退出应用", MainMyselfActivity);
            Toast.makeText(EventTestActivity.this, "连续点击", Toast.LENGTH_SHORT).show();
            exitTime = 0;
            twoTime = 0;
            isFirst = true;
        }else if((twoTime - exitTime) > 2000) {
            exitTime = 0;
            twoTime = 0;
            isFirst = true;
        }
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("TAG", "event:" + event.getAction());
        Toast.makeText(EventTestActivity.this, "一点击", Toast.LENGTH_SHORT).show();

        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {


        Log.e("TAG", "dispatchevent:" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @OnClick(R.id.iv_event)
    public void onClick() {
        Log.e("TAG", "sdfasfdafdafdafafdadfafd");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
       if(keyCode == KeyEvent.KEYCODE_O) {
           Toast.makeText(EventTestActivity.this, "我们需要你", Toast.LENGTH_SHORT).show();
       }


        return super.onKeyDown(keyCode, event);
    }
}
