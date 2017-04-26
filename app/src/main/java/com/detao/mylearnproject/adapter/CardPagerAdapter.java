package com.detao.mylearnproject.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dalong.zwlviewpager.PagerAdapter;
import com.detao.mylearnproject.R;
import com.detao.mylearnproject.bean.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaoronggang on 2017/3/1.
 * viewpager的适配器
 *
 */

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private List<CardView> mViews;
    public Context mContext;

    public List<Item> mData;
    private float mBaseElevation;

    public CardPagerAdapter(Context context, List<Item> mData) {
        this.mContext = context;
        mViews = new ArrayList<>();
        for (int i = 0; i < mData.size(); i++) {
            mViews.add(null);
        }
        this.mData = mData;
    }

    @Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    /**
     * 向viewPager中加载数据
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_sliding, container, false);


        container.addView(view);
        CardView cardView = (CardView) view.findViewById(R.id.cardView);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_master);
        TextView master_name = (TextView) view.findViewById(R.id.tv_master_name);//大师名字
        TextView master_nation = (TextView) view.findViewById(R.id.tv_nation_name);//大师国籍
        TextView master_des = (TextView) view.findViewById(R.id.tv_master_des); //描述
        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener != null) {
                    mOnItemClickListener.onClick(position);
                }
            }
        });
        cardView.setMaxCardElevation(mBaseElevation*MAX_ELEVATION_FACTOR);
        mViews.set(position,cardView);

        final Item item = mData.get(position);
        imageView.setImageResource(item.getImg());
        master_name.setText(item.getName());
        master_nation.setText(item.getNation());
        master_des.setText("来自瑞士的设计与精确性来自瑞士的设计与精确性");
        return view;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mViews.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);
        mViews.set(position, null);
    }

    OnItemClickListener mOnItemClickListener;

    /**
     * 添加点击事件的点击回调
     * @param mOnItemClickListener
     */
    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }

}
