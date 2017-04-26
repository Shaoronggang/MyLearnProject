package com.detao.mylearnproject;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by shaoronggang on 2017/3/13.
 */

public class MyTextview extends EditText {
    public MyTextview(Context context) {
        super(context);
    }

    public MyTextview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected boolean getDefaultEditable() {
        return false;
    }
}
