package com.detao.mylearnproject.activity;

import android.view.WindowManager;
import android.widget.TextView;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * Created by shaoronggang on 2017/4/1.
 */

public class StatusBarAcivity extends BaseActivity {


    @BindView(R.id.tv_test_list)
    TextView tvTestList;
    List<Integer> integers;


    @Override
    protected int getResLayout() {
        return R.layout.status_activity;
    }

    @Override
    public void setTitleState() {
        super.setTitleState();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //设置相应的状态栏为全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    @Override
    public void afterView() {
        super.afterView();
        StringBuilder sb = new StringBuilder();
        integers = new ArrayList<>();
        List<String> list = new ArrayList<>();
        integers.add(25);
        integers.add(45);
        integers.add(60);
        integers.add(70);
        integers.add(56);
        integers.add(41);
        integers.add(99);
        integers.add(11);
        Collections.sort(integers);
        for (int i = 0; i < integers.size(); i++) {
            list.add(integers.get(i) + "");
            if (i == (integers.size() - 1))
                sb.append(list.get(i) + ".");

            else sb.append(list.get(i) + ",");
        }

        tvTestList.setText(sb);
    }
}
