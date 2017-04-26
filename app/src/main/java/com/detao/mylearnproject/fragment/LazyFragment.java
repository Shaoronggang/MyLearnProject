package com.detao.mylearnproject.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by shaoronggang on 2017/4/12.
 */

public abstract class LazyFragment extends Fragment {
    //fragement可见的
    protected boolean isVisible;

    /**
     * 在这里实现Fragment的数据的缓加载
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        }else {
            isVisible = false;
            onInVisible();
        }
    }

    private void onInVisible() {

    }

    protected void onVisible() {
        lazyLoad();
    }

    protected abstract void lazyLoad();


}
