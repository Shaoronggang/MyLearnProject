package com.detao.mylearnproject.bean;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.detao.mylearnproject.R;

/**
 * Created by shaoronggang on 2017/4/26.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    private final TextView mItemTextView;

    public MyViewHolder(final View parent, TextView itemTextView) {
        super(parent);
        mItemTextView = itemTextView;
    }
    public static MyViewHolder newInstance(View parent) {
        TextView itemTextView = (TextView) parent.findViewById(R.id.tv_card_item);
        return new MyViewHolder(parent, itemTextView);
    }
    public void setItemText(CharSequence text) {
        mItemTextView.setText(text);
    }


}
