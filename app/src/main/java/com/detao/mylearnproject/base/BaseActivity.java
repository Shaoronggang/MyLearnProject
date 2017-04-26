package com.detao.mylearnproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by shaoronggang on 2017/4/1.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitleState();
        setContentView(getResLayout());
        ButterKnife.bind(this);
        afterView();
    }

    public void afterView() {

    }

    protected abstract int getResLayout();

    public void setTitleState() {
    }
}
