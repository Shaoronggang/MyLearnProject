package com.detao.mylearnproject.activity;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;
import com.detao.mylearnproject.bean.MyBean;
import com.detao.mylearnproject.view.SlideLayout;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by shaoronggang on 2017/5/25.
 */

public class SlideActivity extends BaseActivity {
    @BindView(R.id.lv_main_slide)
    ListView lvMainSlide;
    private ArrayList<MyBean> items;


    @Override
    protected int getResLayout() {
        return R.layout.slide_activity;
    }

    @Override
    public void afterView() {
        super.afterView();

        //***测试代码：功能测试某段代码中是否包含了某一段代码  ***//
        String str1 = "suanfaaihaozhe";
        String str2 = "suanfa";
        Log.e("Max最新结果：",str1.indexOf(str2)>-1?"yes":"no");
        //******
        items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(new MyBean("Content" + i));
        }

        lvMainSlide.setAdapter(new SlideAdapter());
    }

    class SlideAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView == null) {
                convertView = View.inflate(SlideActivity.this,R.layout.item_slide,null);
                viewHolder = new ViewHolder();
                viewHolder.tv_content = (TextView) convertView.findViewById(R.id.item_content);
                viewHolder.tv_delete = (TextView) convertView.findViewById(R.id.item_menu);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            MyBean bean = items.get(position);
            viewHolder.tv_content.setText(bean.getName());
            viewHolder.tv_content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyBean myBean1 = items.get(position);
                    Toast.makeText(SlideActivity.this, myBean1.getName(), Toast.LENGTH_SHORT).show();
                }
            });
            viewHolder.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SlideLayout slidelayout = (SlideLayout) v.getParent();
                    slidelayout.closeMenu();
                    items.remove(position);
                    notifyDataSetChanged();
                }
            });

            SlideLayout slideLayout = (SlideLayout) convertView;
            slideLayout.setOnStateChangeListenter(new MyStateChangeListener());

            return convertView;
        }
    }


    class ViewHolder{
        TextView tv_content;
        TextView tv_delete;
    }

    private SlideLayout slideLayout;
    class MyStateChangeListener implements SlideLayout.OnStateChangeListenter {
        @Override
        public void onClose(SlideLayout layout) {
            if(slideLayout == layout) {
                slideLayout = null;
            }

        }

        @Override
        public void onDown(SlideLayout layout) {
            if(slideLayout != null && slideLayout != layout) {
                slideLayout.closeMenu();
            }
        }

        @Override
        public void onOpen(SlideLayout layout) {
                slideLayout = layout;
        }
    }
}
