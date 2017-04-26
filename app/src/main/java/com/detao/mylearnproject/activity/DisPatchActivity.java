package com.detao.mylearnproject.activity;

import android.content.Intent;
import android.view.View;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;

import butterknife.OnClick;

/**
 * Created by shaoronggang on 2017/4/1.
 */

public class DisPatchActivity extends BaseActivity {
    @Override
    protected int getResLayout() {
        return R.layout.dispatchactivity;
    }

    @OnClick({R.id.first_btn, R.id.second_btn, R.id.third_btn, R.id.four_btn, R.id.five_btn, R.id.six_btn,R.id.seven_btn,R.id.eight_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first_btn: //数据存储
                //// TODO: 2017/4/26 点击奔溃解决
                Intent intent = new Intent(this, RecyclerViewSlideHeaderTest.class);
                startActivity(intent);
                break;
            case R.id.second_btn: //系统状态栏
                Intent intentrefresh = new Intent(this,StatusBarAcivity.class);
                startActivity(intentrefresh);
                break;
            case R.id.third_btn: //下拉刷新，列表，搜索的实现

                break;
            case R.id.four_btn: //推送，分享
            Intent intentJpush = new Intent(this,JpushHelperActivity.class);
            startActivity(intentJpush);
                break;
            case R.id.five_btn: //二维码以及webView
            Intent intent2 = new Intent(this,HistoryTodayActivity.class);
            startActivity(intent2);
                break;
            case R.id.six_btn: //系统多媒体
                break;
            case R.id.seven_btn: //RxJava配合Retrofit2网络请求

                break;
            case R.id.eight_btn: //百度地图
                break;
        }
    }



}
