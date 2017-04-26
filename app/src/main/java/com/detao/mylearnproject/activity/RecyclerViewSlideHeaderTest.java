package com.detao.mylearnproject.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.adapter.SlideRecyclerAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaoronggang on 2017/4/25.
 */

public class RecyclerViewSlideHeaderTest extends ActionBarActivity {


    @BindView(R.id.recyclerView_slide)
    RecyclerView recyclerViewSlide;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fabButton)
    ImageButton fabButton;
    private List<String> datas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_slide_activity);
        ButterKnife.bind(this);
        initData();
    }

    //初始化数据
    private void initData() {
        for (int i = 0; i < 11; i++) {
            datas.add("你在哪里，让我看到你的手：" + i);
        }


        //初始化toolbar
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        //初始化recyclerview
        recyclerViewSlide.setLayoutManager(new LinearLayoutManager(this));
        SlideRecyclerAdapter slideRecyclerAdapter = new SlideRecyclerAdapter(this, datas);
        recyclerViewSlide.setAdapter(slideRecyclerAdapter);
    }
}
