package com.detao.mylearnproject.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.detao.mylearnproject.R;

/**
 * Created by shaoronggang on 2017/5/18.
 */

public class MyToggleButton extends View implements View.OnClickListener {
    private Bitmap backgroudBitmap;
    private Bitmap slidingBitmap;

    //距离左边的最大值
    private int slidingLeftMax;
    private int slidingLeft;
    private boolean isOpen = false;
    private Paint paint;

    private float startX;
    private float lastX;

    public MyToggleButton(Context context) {
        super(context);
    }

    public MyToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        paint = new Paint();
        paint.setAntiAlias(true); //设置抗锯齿
        backgroudBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.switch_background);
        slidingBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.slide_button);
        slidingLeftMax = backgroudBitmap.getWidth() - slidingBitmap.getWidth();

        setOnClickListener(this);
    }

    /**
     * 测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(backgroudBitmap.getWidth(), backgroudBitmap.getHeight());
    }

    /**
     * 绘制
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(backgroudBitmap, 0, 0, paint);
        canvas.drawBitmap(slidingBitmap, slidingLeft, 0, paint);
    }

    /**
     * true:点击事件生效，滑动事件不生效
     *false:点击事件不生效，滑动事件生效
     */
    private boolean isEnableClick = true;
    @Override
    public void onClick(View v) {
        if(isEnableClick) {
        isOpen = !isOpen; //将该项置反
        flushView();
        }
    }

    private void flushView() {
        if (isOpen) {
            slidingLeft = slidingLeftMax;
        } else {
            slidingLeft = 0;
        }
        invalidate(); //导致onDraw()方法的执行
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);  //执行父类的方法  这个方法必须执行，不然会导致点击事件无效
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //1.记录初始位置
                lastX = startX = event.getX();
                isEnableClick = true;

                break;
            case MotionEvent.ACTION_MOVE:
            //2.计算结束值
            float endX = event.getX();
            //3.计算偏移量
            float distanceX = endX - startX;
//            slidingLeft = (int) (slidingLeft + distanceX);
                slidingLeft += distanceX;
                //4.屏蔽非法值
                if(slidingLeft < 0) {
                    slidingLeft = 0;
                }else if(slidingLeft > slidingLeftMax) {
                    slidingLeft = slidingLeftMax;
                }
                //5.刷新
                invalidate();

                //6.数据还原
                startX = event.getX();
                if(Math.abs(endX - lastX) > 5) {
                    //滑动
                    isEnableClick = false;
                }

                break;
            case MotionEvent.ACTION_UP:
            if(!isEnableClick) {
                if(slidingLeft > slidingLeftMax / 2) {
                    //显示打开
                    isOpen = true;
                }else {
                    isOpen = false;
                }
                flushView();
            }

                break;
        }

        return true;
    }
}
