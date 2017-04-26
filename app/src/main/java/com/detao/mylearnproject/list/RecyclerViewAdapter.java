package com.detao.mylearnproject.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.detao.mylearnproject.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shaoronggang on 2017/2/22.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<String> mDatas ;
    private Context mContext;
    private int currentPosition;

    public RecyclerViewAdapter(Context mContext,List<String> mDatas,int position) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        this.currentPosition = position;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_test,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(mDatas.get(position + currentPosition));
            if((position+1)%2 == 0) {
                holder.view.setVisibility(View.GONE);
            }else {
                holder.view.setVisibility(View.VISIBLE);
            }
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    public void setmDatas(List<String> mDatas) {
        this.mDatas = mDatas;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_test)
        TextView textView;
        @BindView(R.id.view_test)
        View view;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}
