package com.detao.mylearnproject.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.detao.mylearnproject.R;

import java.util.List;

/**
 * Created by shaoronggang on 2017/2/23.
 */

public class MyGridViewAdapter extends BaseAdapter {
    private List<String> imageViews;
    private Context context;

    public MyGridViewAdapter(Context context, List<String> imageViews) {
        this.context = context;
        this.imageViews = imageViews;
    }

    @Override
    public int getCount() {
        return imageViews.size();
    }

    @Override
    public Object getItem(int position) {
        return imageViews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null) {
            convertView = View.inflate(context, R.layout.item_image,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (TextView) convertView.findViewById(R.id.iv_grid);
            viewHolder.textline = (TextView) convertView.findViewById(R.id.tv_line);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.setText("生态建筑");
        if(position>=3 && (position + 1)%4 == 0) {
            viewHolder.textline.setVisibility(View.GONE);
        }else {
            viewHolder.textline.setText("|");
        }


        return convertView;
    }


    class ViewHolder {
        TextView imageView;
        TextView textline;
    }
}
