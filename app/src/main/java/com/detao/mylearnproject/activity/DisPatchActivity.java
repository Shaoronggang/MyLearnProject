package com.detao.mylearnproject.activity;

import android.content.Intent;
import android.view.View;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;
import com.detao.mylearnproject.youkumenu.YoukuActivity;

import butterknife.OnClick;

/**
 * Created by shaoronggang on 2017/4/1.
 */

public class DisPatchActivity extends BaseActivity {
    @Override
    protected int getResLayout() {
        return R.layout.dispatchactivity;
    }

    @OnClick({R.id.first_btn, R.id.second_btn, R.id.third_btn, R.id.four_btn, R.id.five_btn, R.id.six_btn, R.id.seven_btn, R.id.eight_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.first_btn: //数据存储
                Intent intent = new Intent(this, RecyclerViewSlideHeaderTest.class);
                startActivity(intent);
                break;
            case R.id.second_btn: //系统状态栏
                Intent intentrefresh = new Intent(this, StatusBarAcivity.class);
                startActivity(intentrefresh);
                break;
            case R.id.third_btn: //下拉刷新，列表，搜索的实现

                break;
            case R.id.four_btn: //推送，分享
                Intent intentJpush = new Intent(this, JpushHelperActivity.class);
                startActivity(intentJpush);
                break;
            case R.id.five_btn: //二维码以及webView
                Intent intent2 = new Intent(this, HistoryTodayActivity.class);
                startActivity(intent2);
                break;
            case R.id.six_btn: //系统多媒体
                Intent intentyouku = new Intent(this, YoukuActivity.class);
                startActivity(intentyouku);
                break;
            case R.id.seven_btn: //RxJava配合Retrofit2网络请求
                Intent intentPager = new Intent(this, ViewPagerActivity.class);
                startActivity(intentPager);
                break;
            case R.id.eight_btn: //百度地图
//                Intent intent3 = new Intent(this,MyTestActivity.class);  //测试视图
//                startActivity(intent3);
//                Intent intentExpand = new Intent(this, ViewpagerTabHost.class);  //轮播图广告
//                startActivity(intentExpand);
//                Intent intentpull = new Intent(this, PullDownActivity.class);  //自定义视图--下拉框
//                startActivity(intentpull);
//                Intent attriIntent = new Intent(this, MyattrActivity.class);  //自定义属性
//                startActivity(attriIntent);
                Intent slideIntent = new Intent(this, SlideActivity.class);  //侧滑菜单属性
                startActivity(slideIntent);
//                Intent eventIntent = new Intent(this,EventTestActivity.class);  //事件处理
//                startActivity(eventIntent);
//                Intent viewpagerIntent = new Intent(this, MyViewPagerActivity.class); // 仿ViewPager
//                startActivity(viewpagerIntent);
//                Intent viewpagerIntent = new Intent(this, QuickIndexActivity.class); //联系人快速索引
//                startActivity(viewpagerIntent);

//                Intent toggleIntent = new Intent(this, ToggleButtonActivity.class); //自定义开关
//                startActivity(toggleIntent);
                break;
        }
    }


}
