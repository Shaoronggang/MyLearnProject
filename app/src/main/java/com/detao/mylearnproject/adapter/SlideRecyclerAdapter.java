package com.detao.mylearnproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.bean.MyViewHolder;

import java.util.List;

/**
 * Created by shaoronggang on 2017/4/25.
 */

public class SlideRecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<String> mDatas;
    private Context mContext;

    public SlideRecyclerAdapter(Context mContext, List<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_slide_item, parent, false);
        return MyViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String itemText = mDatas.get(position);
        holder.setItemText(itemText);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

}
