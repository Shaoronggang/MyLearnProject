package com.detao.mylearnproject.youkumenu;

import android.animation.ObjectAnimator;
import android.view.ViewGroup;

/**
 * Created by shaoronggang on 2017/5/10.
 * 作用:显示或隐藏指定控件
 */

public class Tools {

    public static void hideView(ViewGroup view) {
        hideView(view, 0);
    }

    public static void showView(ViewGroup view){
        showView(view,0);
    }

    public static void showView(ViewGroup view, int startOffset) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view,"rotation",180,360);
        animator.setDuration(500);
        animator.setStartDelay(startOffset);
        animator.start();

        view.setPivotX(view.getWidth()/2);
        view.setPivotY(view.getHeight());
    }

    public static void hideView(ViewGroup view, int startOffset) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 0, 180);
        animator.setDuration(500);
        animator.setStartDelay(startOffset);
        animator.start();

        view.setPivotX(view.getWidth() / 2);
        view.setPivotY(view.getHeight());
    }

}
