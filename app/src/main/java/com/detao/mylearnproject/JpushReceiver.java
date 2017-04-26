package com.detao.mylearnproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by shaoronggang on 2017/4/5.
 */

public class JpushReceiver extends BroadcastReceiver {
    private static final String TAG = "JpushReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if(JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            Toast.makeText(context, "谢谢点击", Toast.LENGTH_SHORT).show();
        }else if(JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            String regId = JPushInterface.getRegistrationID(context);
            Log.d(TAG, "[MyReceiver] 接收Registration Id : " + regId);
        }

    }
}
