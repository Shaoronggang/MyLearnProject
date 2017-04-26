package com.detao.mylearnproject.base;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.detao.mylearnproject.fragment.LazyFragment;

import butterknife.ButterKnife;

/**
 * Created by shaoronggang on 2017/4/12.
 */

public abstract class BaseFragment extends LazyFragment {
    public View rootView;

    //标志位，是都已经初始化完成
    protected boolean isPrepared;

    protected abstract void initView(View rootView);

    public abstract int contentViewId();

    protected abstract void onVisible();

    protected abstract void initData();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(contentViewId(), container, false);
            initView(rootView);
        }
        ButterKnife.bind(this, rootView); //绑定,初始化View的各控件
        isPrepared = true;
        lazyLoad();
        return rootView;
    }


    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        //填充各控件的数据
        initData();
    }


    /**
     * hide inputMethod
     */
    public void hideSoftKeyBoard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            View localView = getActivity().getCurrentFocus();
            if (localView != null && localView.getWindowToken() != null) {
                IBinder windowToken = localView.getWindowToken();
                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
            }
        }

    }


}
