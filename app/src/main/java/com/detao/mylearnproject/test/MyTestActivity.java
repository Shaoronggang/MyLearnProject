package com.detao.mylearnproject.test;

import android.os.Handler;
import android.util.Log;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;

import butterknife.OnClick;

import static com.detao.mylearnproject.util.AppUtils.getAppName;
import static com.detao.mylearnproject.util.AppUtils.getAppVersion;
import static com.detao.mylearnproject.util.AppUtils.getDeviceHeight;
import static com.detao.mylearnproject.util.AppUtils.getDeviceIMEI;
import static com.detao.mylearnproject.util.AppUtils.getDeviceWidth;
import static com.detao.mylearnproject.util.AppUtils.getMacAddress;
import static com.detao.mylearnproject.util.AppUtils.getVersionName;
import static com.detao.mylearnproject.util.AppUtils.isOnline;
import static com.detao.mylearnproject.util.AppUtils.isPhone;
import static com.detao.mylearnproject.util.AppUtils.isWifiConnected;

/**
 * Created by shaoronggang on 2017/5/9.
 * 代码测试类：进行一些基础得功能性代码的测试
 */

public class MyTestActivity extends BaseActivity {
    private Handler handler = new Handler();


    @Override
    protected int getResLayout() {
        return R.layout.test_activity;
    }

    @Override
    public void afterView() {
        super.afterView();
    }

    @OnClick(R.id.tv_test_click)
    void testClick(){
//        call(this,"15810681269");
//        callDial(this,"15810681269");
//        sendSms(this,"15810681269","我爱你，你知道吗？");

        //延时方法一 计时器：
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                wakeUpAndUnlock(MyTestActivity.this);
//            }
//        };
//
//        Timer timer = new Timer();
//        timer.schedule(task,6000);//6秒后之后执行
        //线程的休眠实现延时
//       new Thread(){
//           @Override
//           public void run() {
//               super.run();
//               try {
//                   Thread.sleep(3000);
//                   wakeUpAndUnlock(MyTestActivity.this);
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//
//           }
//       }.start();

//        使用Handler的postDelayed方法实现延时操作
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                wakeUpAndUnlock(MyTestActivity.this);
//                if(isApplicationBackground(MyTestActivity.this)) { //判断是否是在后台
//                    Toast.makeText(MyTestActivity.this, "你好吗", Toast.LENGTH_SHORT).show();
//                }
                Log.e("Sleep", "是否有网络：" + isOnline(MyTestActivity.this) + "\n" + "是否是WiFi连接：" + isWifiConnected(MyTestActivity.this) + "\n" + "当前是否是手机" + isPhone(MyTestActivity.this)
                + "\n" +"设备宽度：" + getDeviceWidth(MyTestActivity.this) + "\n" +"设备高度：" + getDeviceHeight(MyTestActivity.this) + "\n" +"当前设备的IMEI：" + getDeviceIMEI(MyTestActivity.this)
                +"\n" +"获取当前设备的MAC地址：" + getMacAddress(MyTestActivity.this) + "\n" +"获取当前程序的版本号：" + getAppVersion(MyTestActivity.this) + "\n" +"获取当前程序版本名称：" + getVersionName(MyTestActivity.this)
                 + "获取当前程序名：" + getAppName(MyTestActivity.this)
                );
//                Log.e("Sleep", "待唤醒" + isSleeping(MyTestActivity.this));
//                if (isSleeping(MyTestActivity.this)) { //判断是否是睡眠(锁屏)状态
//                    Log.e("Sleep", "即将唤醒");
//                    wakeUpAndUnlock(MyTestActivity.this);
//                    Toast.makeText(MyTestActivity.this, "你好吗", Toast.LENGTH_SHORT).show();
//                }
            }
        },3000);



    }

}
