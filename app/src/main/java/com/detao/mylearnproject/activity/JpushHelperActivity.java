package com.detao.mylearnproject.activity;

import android.view.View;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;

import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by shaoronggang on 2017/4/6.
 */

public class JpushHelperActivity extends BaseActivity {
    @Override
    protected int getResLayout() {
        return R.layout.jpush_activty;
    }

    @OnClick({R.id.btn_stop_jpush, R.id.btn_resume_jpush})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_stop_jpush:  // 点击停止按钮后，极光推送服务会被停止掉
                JPushInterface.stopPush(getApplicationContext());
                break;
            case R.id.btn_resume_jpush: // 点击恢复按钮后，极光推送服务会恢复正常工作
                JPushInterface.resumePush(getApplicationContext());
                break;
        }
    }
}
