package com.detao.mylearnproject.activity;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;
import com.detao.mylearnproject.bean.Person;
import com.detao.mylearnproject.view.IndexView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import butterknife.BindView;

/**
 * Created by shaoronggang on 2017/5/24.
 */

public class QuickIndexActivity extends BaseActivity {

    @BindView(R.id.lv_main)
    ListView listView;
    @BindView(R.id.tv_word)
    TextView textView;
    @BindView(R.id.iv_words)
    IndexView ivWord;

    private IndexAdapter indexAdapter;
    private ArrayList<Person> nameList;

    private Handler handler = new Handler();

    @Override
    protected int getResLayout() {
        return R.layout.quickindexactivity;
    }

    @Override
    public void afterView() {
        super.afterView();
        initData();
        ivWord.setOnIndexChangeListener(new MyOnIndexChangeListener());

        indexAdapter = new IndexAdapter();
        listView.setAdapter(indexAdapter);
    }

    class IndexAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return nameList.size();
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
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView == null) {
                convertView = View.inflate(QuickIndexActivity.this,R.layout.item_index,null);
                viewHolder = new ViewHolder();
                viewHolder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
                viewHolder.tvPinYin = (TextView) convertView.findViewById(R.id.tv_word);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            String name = nameList.get(position).getName();
            String word = nameList.get(position).getPinyin().substring(0,1);
            viewHolder.tvName.setText(name);
            viewHolder.tvPinYin.setText(word);

            if(position == 0) {
                viewHolder.tvPinYin.setVisibility(View.VISIBLE);
            }else {
                 //获取前一个条目的字母，与后面的字母比较，如果相同则将其隐藏，如果不同将其显示出来
                String preWord = nameList.get(position - 1).getPinyin().substring(0,1);
                if(word.equals(preWord)) {
                    viewHolder.tvPinYin.setVisibility(View.GONE);
                }else {
                     viewHolder.tvPinYin.setVisibility(View.VISIBLE);
                }
                
            }

            return convertView;
        }
    }



    static class ViewHolder{
        TextView tvPinYin;
        TextView tvName;
    }

    /**
     * 初始化数据
     */
    private void initData() {
        nameList = new ArrayList<>();
        nameList.add(new Person("邵荣刚"));
        nameList.add(new Person("张晓飞"));
        nameList.add(new Person("杨光福"));
        nameList.add(new Person("胡继群"));
        nameList.add(new Person("刘畅"));

        nameList.add(new Person("钟泽兴"));
        nameList.add(new Person("尹革新"));
        nameList.add(new Person("安传鑫"));
        nameList.add(new Person("张骞壬"));

        nameList.add(new Person("温松"));
        nameList.add(new Person("李凤秋"));
        nameList.add(new Person("刘甫"));
        nameList.add(new Person("娄全超"));
        nameList.add(new Person("张猛"));

        nameList.add(new Person("王英杰"));
        nameList.add(new Person("李振南"));
        nameList.add(new Person("孙仁政"));
        nameList.add(new Person("唐春雷"));
        nameList.add(new Person("牛鹏伟"));
        nameList.add(new Person("姜宇航"));

        nameList.add(new Person("刘挺"));
        nameList.add(new Person("张洪瑞"));
        nameList.add(new Person("张建忠"));
        nameList.add(new Person("侯亚帅"));
        nameList.add(new Person("刘帅"));

        nameList.add(new Person("乔竞飞"));
        nameList.add(new Person("徐雨健"));
        nameList.add(new Person("吴亮"));
        nameList.add(new Person("王兆霖"));

        nameList.add(new Person("阿三"));
        nameList.add(new Person("李博俊"));

        //很棒的数据处理技巧
        Collections.sort(nameList, new Comparator<Person>() {  // 按照比较的结果，来进行排序
            @Override
            public int compare(Person lhs, Person rhs) {
                return lhs.getPinyin().compareTo(rhs.getPinyin()); //lhs 大于 rhs 返回大于0的整形数， lhs 小于 rhs 返回小于0的整形数
            }
        });

//        测试数据
//        for (int i = 0; i < nameList.size(); i++) {
//            Log.e("TAG", nameList.get(i) + "");
//        }

    }


    private class MyOnIndexChangeListener implements IndexView.OnIndexChangeListener {
        @Override
        public void onIndexChange(String word) {
            updateWord(word);
            updataListView(word);
        }
    }

    private void updataListView(String word) {
        for (int i = 0; i < nameList.size(); i++) {
          String indexword =  nameList.get(i).getPinyin().substring(0,1);
           if(word.equals(indexword)) {
               listView.setSelection(i); //定位到ListVeiw中的某个位置
               return;
           }
        }
    }

    private void updateWord(String word) {
        //先显示出来
        textView.setVisibility(View.VISIBLE);
        textView.setText(word);
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //也是运行在主线程
                System.out.println(Thread.currentThread().getName()+"------------");
                textView.setVisibility(View.GONE);
            }
        },2000);

    }
}
