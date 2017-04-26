package com.detao.mylearnproject.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.adapter.CardPagerAdapter;
import com.detao.mylearnproject.bean.Item;
import com.detao.mylearnproject.util.ShadowTransformer;

import java.util.ArrayList;
import java.util.List;

//import com.dalong.zwlviewpager.ViewPager;

/**
 * Created by shaoronggang on 2017/3/1.
 */

public class SlidingViewPagerActivity extends AppCompatActivity {
    private List<Item> items = new ArrayList<>();
    private int[] mImgs = {R.drawable.meinv1, R.drawable.meinv2, R.drawable.meinv3, R.drawable.meinv4, R.drawable.meinv5};
    private String[] names = {"Angela", "奶茶妹", "赵奕欢", "萌妹子", "张馨予"};
    private String[] nations = {"美国", "中国", "法国", "日本", "加拿大"};
    private ViewPager mViewPager;
    private CardPagerAdapter cardPagerAdapter;
    private ShadowTransformer mCardShadowTransformer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding_activity);
        initData();  //1.初始化数据
        initView();  //2.初始化视图
        initLintener(); //3.初始化监听器
    }

    private void initData() {
        for (int i = 0; i < mImgs.length; i++) {
            Item item = new Item();
            item.setImg(mImgs[i]);
            item.setName(names[i]);
            item.setNation(nations[i]);
            items.add(item);
        }
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        cardPagerAdapter = new CardPagerAdapter(this, items);
        mCardShadowTransformer = new ShadowTransformer(mViewPager, cardPagerAdapter);
        mCardShadowTransformer.setAlpha(0.5f);
        mCardShadowTransformer.setScale(0.3f);
        mViewPager.setAdapter(cardPagerAdapter);
        mViewPager.setPageTransformer(false,new ScaleTrasformer());
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(4);
    }

    private void initLintener() {
        cardPagerAdapter.setmOnItemClickListener(new CardPagerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                mViewPager.setCurrentItem(position);
            }
        });

    }

}
