package com.detao.mylearnproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.bean.GuoNeiBean;
import com.detao.mylearnproject.bean.MyViewHolder;
import com.detao.mylearnproject.callback.OnItemClickListener;

import java.util.List;

/**
 * Created by shaoronggang on 2017/4/25.
 */

public class SlideRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<GuoNeiBean.NewslistBean> mDatas;
    private Context mContext;
    //added view types
    private static final int TYPE_HEADER = 2;
    private static final int TYPE_ITEM = 1;

    public SlideRecyclerAdapter(Context mContext, List<GuoNeiBean.NewslistBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            final View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_slide_item, parent, false);
            return MyViewHolder.newInstance(view);
        } else if (viewType == TYPE_HEADER) {
            final View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_header, parent, false);
            return new RecyclerHeaderViewHolder(view);
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_slide_item, parent, false);
        return MyViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if(holder != null && !isPositionHeader(position)) {
                MyViewHolder holder1 = (MyViewHolder) holder;
                String itemText = mDatas.get(position - 1).getTitle();
                holder1.setItemText(itemText);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null) {
                    onItemClickListener.onItemClick(v,mDatas.get(position - 1));
                }
            }
        });
        }
    }

    public int getBasicItemCount(){
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public int getItemCount() {
        Log.e("TAGAdapter", mDatas.size() + "");
        return getBasicItemCount() + 1; // header
    }



    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if(isPositionHeader(position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position){
        return position == 0;
    }

    public class RecyclerHeaderViewHolder extends RecyclerView.ViewHolder {
        public RecyclerHeaderViewHolder(View view) {
            super(view);
        }
    }
}
