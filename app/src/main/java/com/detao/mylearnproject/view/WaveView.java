package com.detao.mylearnproject.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by shaoronggang on 2017/5/25.
 */

public class WaveView extends View {

    private Paint paint;
    private float downX;
    private float downY;
    private int radio ;


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            radio += 5;

            int alpha = paint.getAlpha();
            alpha -= 5;
            if(alpha < 0) {
                alpha = 0;
            }

            paint.setAlpha(alpha);
            paint.setStrokeWidth(radio/3);
            invalidate();

        }
    };
    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    private void initView() {
        //1.初始化画笔
        radio = 5;
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);  //描边
        paint.setStrokeWidth(radio/3);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(paint.getAlpha()>0 && downX > 0 && downY > 0) {
        canvas.drawCircle(downX,downY,radio,paint);
        handler.sendEmptyMessageDelayed(0,50);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case  MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                downX = event.getX();
                downY = event.getY();
                initView();
                invalidate();

                break;
            case MotionEvent.ACTION_UP:

                break;

        }

        return super.onTouchEvent(event);
    }
}
