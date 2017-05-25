package com.detao.mylearnproject.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Scroller;

/**
 * Created by shaoronggang on 2017/5/25.
 * 侧滑菜单的主要类
 * 1.需要进行测量，另外还需要进行相应的指定子view位置
 * 2.
 */

public class SlideLayout extends FrameLayout {
    private static final String TAG = SlideLayout.class.getSimpleName();
    //两个子View
    private View contentView;
    private View menuView;

    /**
     * 滚动者
     */
    private Scroller scroller;

    private int contentWidth;
    private int menuWidth;
    private int viewHeight;

    public SlideLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
    }

    /**
     * 当布局文件加载完成的时候，回调这个方法
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        contentView = getChildAt(0);
        menuView = getChildAt(1);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        contentWidth = contentView.getMeasuredWidth();
        menuWidth = menuView.getMeasuredWidth();
        viewHeight = getMeasuredHeight();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //指定菜单的位置
        menuView.layout(contentWidth, 0, contentWidth + menuWidth, viewHeight);
    }


    private float startX;
    private float startY;
    private float downX;
    private float downY;

    /**
     * 处理事件
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //1.记录初始位置
                startX = downX = event.getX();
                startY = downY = event.getY();

                break;
            case MotionEvent.ACTION_MOVE:
                //2.记录下结束值
                float endX = event.getX();
                float endY = event.getY();

                //3.计算偏移量
                float distanceX = endX - downX;

                //4.屏蔽非法值
                int toScrollX = (int) (getScrollX() - distanceX);
                if(toScrollX < 0) {
                    toScrollX = 0;
                }else if(toScrollX > menuWidth) {
                    toScrollX = menuWidth;
                }

                /**
                 * 移动到相应的位置
                 */
                scrollTo(toScrollX,getScrollY());

                //恢复数据
                startX = event.getX();
                startY = event.getY();

                /**
                 * 在X轴与y轴距离
                 */
                float Dx =  Math.abs(endX - downX);
                float Dy =  Math.abs(endY - downY);
                if(Dx > Dy && Dx > 8) {
                    //水平方向滑动
                    //响应侧滑
                    //反拦截-事件给SlideLayout
                    getParent().requestDisallowInterceptTouchEvent(true);
                }

                break;
            case MotionEvent.ACTION_UP:
                int totalScrollX = getScrollX(); //偏移量
                if(totalScrollX > menuWidth/2) {
                    openMenu();

                }else {
                    closeMenu();
                }
                break;
        }

        return true;
    }

    public void closeMenu() {
        int distanceX = 0 - getScrollX();
        scroller.startScroll(getScrollX(),getScrollY(),distanceX,getScrollY());
        invalidate();//强行绘制
        if(onStateChangeListenter != null) {
            onStateChangeListenter.onClose(this);
        }

    }

    public void openMenu() {
        int distanceX = menuWidth - getScrollX();
        scroller.startScroll(getScrollX(),getScrollY(),distanceX,getScrollY());
        invalidate();
        if(onStateChangeListenter != null) {
            onStateChangeListenter.onOpen(this);
        }
    }

    /**
     * true:拦截孩子的事件，但会执行当前控件的onTouchEvent()方法
     * false:不拦截孩子的事件，事件继续传递
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //1.记录下初始位置
                startX = downX = ev.getX();
                if (onStateChangeListenter != null) {
                    onStateChangeListenter.onDown(this);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                //2.记录结束值
                float endX = ev.getX();

                startX = ev.getX();
                //在X轴的滑动距离
                float Dx = Math.abs(endX - downX);
                if (Dx > 8) {
                    intercept = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return intercept;
    }

    /**
     * 匀速滑动
     */
    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            invalidate();
        }

    }

    public interface OnStateChangeListenter {
        void onClose(SlideLayout layout);

        void onDown(SlideLayout layout);

        void onOpen(SlideLayout layout);
    }

    private OnStateChangeListenter onStateChangeListenter;

    public void setOnStateChangeListenter(OnStateChangeListenter onStateChangeListenter) {
        this.onStateChangeListenter = onStateChangeListenter;
    }
}
