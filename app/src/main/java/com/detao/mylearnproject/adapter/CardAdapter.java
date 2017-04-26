package com.detao.mylearnproject.adapter;

import android.support.v7.widget.CardView;

/**
 * Created by shaoronggang on 2017/3/1.
 * 操作卡片的相应的适配器
 */

public interface CardAdapter {

    int  MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
