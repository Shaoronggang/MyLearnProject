package com.detao.mylearnproject.activity;

import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;
import com.detao.mylearnproject.util.DensityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by shaoronggang on 2017/5/12.
 */

public class PullDownActivity extends BaseActivity {
    @BindView(R.id.et_input)
    EditText etInput;
    @BindView(R.id.iv_down_arrow)
    ImageView ivDownArrow;

    private PopupWindow popupWindow;
    private ListView listView;
    private MyAdapter myAdapter;
    private List<String> msgs;
    /**
     * popupWindow是否显示
     */
    private boolean isShowing = false;

    @Override
    protected int getResLayout() {
        return R.layout.pull_activity;
    }

    @Override
    public void afterView() {
        super.afterView();
        int value = 1;
        String color = Integer.toHexString(value);
        etInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.e("TAG", isShowing + "");
                if(isShowing) {
                    isShowing = false;
                    ObjectAnimator animator = ObjectAnimator.ofFloat(ivDownArrow,"rotation",180,360);
                    animator.setDuration(500);
                    animator.start();
                }else{
                    isShowing = true;
                    ObjectAnimator animator = ObjectAnimator.ofFloat(ivDownArrow,"rotation",0,180);
                    animator.setDuration(500);
                    animator.start();
                }
                if(popupWindow == null) {
                    popupWindow = new PopupWindow(PullDownActivity.this);
                    popupWindow.setWidth(etInput.getWidth());
                    int height = DensityUtils.dip2px(PullDownActivity.this,200);
                    popupWindow.setHeight(height);

                    popupWindow.setContentView(listView);
                    popupWindow.setFocusable(true);//设置焦点

                }

                //popupwindow的显示位置
                popupWindow.showAsDropDown(etInput,0,0);
                Log.e("TAGAfter", isShowing + "");
                //设置popupwindow的显示监听
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        if(isShowing) {
                            isShowing = false;
                            ObjectAnimator animator = ObjectAnimator.ofFloat(ivDownArrow,"rotation",180,360);
                            animator.setDuration(500);
                            animator.start();
                        }else{
                            isShowing = true;
                            ObjectAnimator animator = ObjectAnimator.ofFloat(ivDownArrow,"rotation",0,180);
                            animator.setDuration(500);
                            animator.start();
                        }
                    }
                });

            }


        });

        listView = new ListView(this);
        listView.setBackgroundResource(R.drawable.listview_background);

        msgs = new ArrayList<>();
        for (int i = 0; i <60 ; i++) {
            msgs.add(i+"--aaaaaaaaaaaaaa--"+i);
        }

        myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = msgs.get(position);

                etInput.setText(text);
                if(popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }
            }
        });



    }

     class MyAdapter extends BaseAdapter {
         @Override
         public int getCount() {
             return msgs.size();
         }

         @Override
         public Object getItem(int position) {
             return msgs.get(position);
         }

         @Override
         public long getItemId(int position) {
             return position;
         }

         @Override
         public View getView(final int position, View convertView, ViewGroup parent) {
             ViewHolder holder;
             if(convertView == null) {
                 convertView = View.inflate(PullDownActivity.this,R.layout.item_main,null);
                 holder  = new ViewHolder();
                holder.tv_msg = (TextView) convertView.findViewById(R.id.tv_msg);
                holder.iv_delete = (ImageView) convertView.findViewById(R.id.iv_delete);
                convertView.setTag(holder);
             }else {
                holder = (ViewHolder) convertView.getTag();
             }

             String msg = msgs.get(position);
             holder.tv_msg.setText(msg);

             holder.iv_delete.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     //数据从集合中删除
                     msgs.remove(position);
                     //刷新Ui--适配器刷新
                     myAdapter.notifyDataSetChanged();

                 }
             });

             return convertView;
         }
     }

    static class ViewHolder{
        TextView tv_msg;
        ImageView iv_delete;
    }

}
