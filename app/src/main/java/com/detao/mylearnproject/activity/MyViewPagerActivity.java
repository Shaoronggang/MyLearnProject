package com.detao.mylearnproject.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;
import com.detao.mylearnproject.view.MyViewPager;

import butterknife.BindView;

/**
 * Created by shaoronggang on 2017/5/24.
 * 仿Viewpager
 *
 */

public class MyViewPagerActivity extends BaseActivity {

    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    @BindView(R.id.my_viewpager)
    MyViewPager myViewpager;

    private int[] ids ={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6};


    @Override
    protected int getResLayout() {
        return R.layout.viewpage_activity;
    }

    @Override
    public void afterView() {
        super.afterView();

        for (int i = 0; i <ids.length ; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(ids[i]);
            myViewpager.addView(imageView);
        }

        View view = View.inflate(this,R.layout.testviewpager,null);
        myViewpager.addView(view,2);


        for (int i = 0; i <myViewpager.getChildCount() ; i++) {
            RadioButton button = new RadioButton(this);
            button.setId(i); //如果未设置的话，那么就会导致第一个选择时第二个也会被选择
            if(i == 0) {
                button.setChecked(true);
            }

            //添加到RadioGroup
            rgMain.addView(button);
        }

        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
            myViewpager.scrollToPager(checkedId);

            }
        });

        myViewpager.setmOnPageChangeListener(new MyViewPager.OnPageChangeListenter() {
            @Override
            public void onScrollToPage(int positon) {
                rgMain.check(positon);
            }
        });
    }
}
