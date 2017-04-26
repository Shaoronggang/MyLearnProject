package com.detao.mylearnproject.util;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.View;

import com.detao.mylearnproject.adapter.CardAdapter;

//import com.dalong.zwlviewpager.ViewPager;

/**
 * 改变ViewPager两边的透明度，以及改变选中的页面的大小的工具类
 */
public class ShadowTransformer implements ViewPager.OnPageChangeListener, ViewPager.PageTransformer {

    private float mScale = 0f;//缩放比例  这里缩放是中间比两边大0.2  也就是说两边是你设定的值  中间缩放到了1.2
    private float mAlpha = 1f;//左右透明度，1：完全不透明 0：完全透明
    private ViewPager mViewPager;
    private CardAdapter mAdapter;
    private float mLastOffset;

    public ShadowTransformer(ViewPager viewPager, CardAdapter adapter) {
        mViewPager = viewPager;
        mAdapter = adapter;
        viewPager.setOnPageChangeListener(this);
    }

    /**
     * 设置缩放
     *
     * @param mScale
     */
    public void setScale(float mScale) {
        this.mScale = mScale;
        CardView currentCard = mAdapter.getCardViewAt(mViewPager.getCurrentItem());
        if (currentCard != null) {
            currentCard.animate().scaleY(1 + mScale);
            currentCard.animate().scaleX(1 + mScale);
        }
    }

    /**
     * 设置透明度
     *
     * @param mAlpha
     */
    public void setAlpha(float mAlpha) {
        this.mAlpha = mAlpha;
        for (int i = 0; i < mAdapter.getCount(); i++) {
            CardView cardView = mAdapter.getCardViewAt(i);
            if (i == mViewPager.getCurrentItem()) {
                if (cardView != null) {
                    cardView.setAlpha(1f);
                }
            } else {
                if (cardView != null) {
                    cardView.setAlpha(mAlpha);
                }
            }
        }
    }


    @Override
    public void transformPage(View page, float position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        int realCurrentPosition;
        int nextPosition;
        float baseElevation = mAdapter.getBaseElevation();
        float realOffset;
        boolean goingLeft = mLastOffset > positionOffset;

        // If we're going backwards, onPageScrolled receives the last position
        // instead of the current one
        if (goingLeft) {
            realCurrentPosition = position + 1;
            nextPosition = position;
            realOffset = 1 - positionOffset;
        } else {
            nextPosition = position + 1;
            realCurrentPosition = position;
            realOffset = positionOffset;
        }
        // Avoid crash on overscroll
        if (nextPosition > mAdapter.getCount() - 1
                || realCurrentPosition > mAdapter.getCount() - 1) {
            return;
        }

        CardView currentCard = mAdapter.getCardViewAt(realCurrentPosition);
        // This might be null if a fragment is being used
        // and the views weren't created yet
        if (currentCard != null) {
            currentCard.setScaleX(1 + mScale * (1 - realOffset));
            currentCard.setScaleY(1 + mScale * (1 - realOffset));
            currentCard.setAlpha(1 - realOffset + mAlpha);
            currentCard.setCardElevation((baseElevation + baseElevation
                    * (CardAdapter.MAX_ELEVATION_FACTOR - 1) * (1 - realOffset)));
        }

        CardView nextCard = mAdapter.getCardViewAt(nextPosition);

        // We might be scrolling fast enough so that the next (or previous) card
        // was already destroyed or a fragment might not have been created yet
        if (nextCard != null) {
            nextCard.setScaleX(1 + mScale * (realOffset));
            nextCard.setScaleY(1 + mScale * (realOffset));
            nextCard.setAlpha(realOffset + mAlpha);
            nextCard.setCardElevation((baseElevation + baseElevation
                    * (CardAdapter.MAX_ELEVATION_FACTOR - 1) * (realOffset)));
        }
        //记录最后的
        mLastOffset = positionOffset;
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
