package com.detao.mylearnproject;

import android.app.Application;

import com.lzy.okgo.*;
import com.lzy.okgo.BuildConfig;

import org.xutils.x;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by shaoronggang on 2017/4/5.
 */

public class MyApplication extends Application {
    /**
     * 用于标记是否上线,正式环境打包改为true
     */
    public static boolean isRelease = false;

    @Override
    public void onCreate() {
        super.onCreate();

        OkGo.init(this);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
