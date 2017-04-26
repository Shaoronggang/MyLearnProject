package com.detao.mylearnproject.list;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.detao.mylearnproject.R;
import com.detao.mylearnproject.base.BaseActivity;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTv;
    private String currentTime,currentDate;
    private int currentDay;
    @BindView(R.id.recycleView)
    RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private GridView gridView;
    private MyGridViewAdapter viewAdapter;
    private ImageView imageView;
    private List<String> mDatas;
    private List<String> mImages;
    @BindView(R.id.et_test_shore)
    EditText etSave;
    @BindView(R.id.et_test_password)
    EditText etPassword;
    @BindView(R.id.iv_test_top)
    ImageView ivTestTop;

    //获取日格式器对象
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //获取一个日历类对象
    Calendar dataAndTime = Calendar.getInstance(Locale.CHINA);
    Date date = new Date();
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @OnClick(R.id.btn_keep)
    void keepData(){
        editor.putString("user_name",etSave.getText().toString().trim());
        editor.commit();  // 提交，数据真正保存到文件中
        Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_get)
    void getData(){
       String user_name =  sp.getString("user_name","");
        Log.e("获取的数据是：", user_name);
       etSave.setText(user_name);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//       this.requestWindowFeature(Window.FEATURE_NO_TITLE); // 无效的代码，需要到功能清单文件中进行相应的主题设置

//        if(Build.VERSION.SDK_INT>=19){
//            View decorView=getWindow().getDecorView();
//            int option=View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//        }

        sp = this.getSharedPreferences("save_et_data",MODE_PRIVATE);
        editor = sp.edit();
        initData();
        initView();
    }

    @Override
    protected int getResLayout() {
        return R.layout.activity_main;
    }

    //初始化数据
    private void initData() {
        try {
            //创建流
            InputStream is = this.getAssets().open("dedao_two.jpg");
            //读出数据
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();
            is = null;
            ivTestTop.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //存数据
        try {
            OutputStream os = this.openFileOutput("out",MODE_PRIVATE);
            os.write("wa".getBytes());
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //取数据
        try {
            InputStream in = this.openFileInput("out");
            //缓冲区
            byte b[] = new byte[1024];
            //创建缓存

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void setStartDate(int year,int monthOfYear,int dayOfMonth){
        dataAndTime.set(Calendar.YEAR,year);
        dataAndTime.set(Calendar.MONTH,monthOfYear);
        dataAndTime.set(Calendar.DAY_OF_MONTH,dayOfMonth);
    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            setStartDate(i,i1,i2);
            currentTime = dateFormat.format(dataAndTime.getTime());
            if(!dateCompare(currentDate, currentTime)){
                Toast.makeText(getBaseContext(),"只能选择今日之后日期",Toast.LENGTH_SHORT).show();
                return;
            }
            //更新时间
            mTv.setText(dateFormat.format(dataAndTime.getTime()));
        }
    };

    private void initView() {

//        findViewById(R.id.btn_get)
//        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        imageView = (ImageView) findViewById(R.id.iv_next);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        GridLayoutManager manager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(MainActivity.this).sizeResId(R.dimen.dimens0_5).margin(R.dimen.dimens2,R.dimen.dimens2)
                .color(Color.BLUE).build());
        recyclerView.setLayoutManager(manager);
        mImages = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            mImages.add("你好美女");
        }

        mDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDatas.add("第" + i + "个测试");
        }

        gridView = (GridView) findViewById(R.id.line_gridview);
        viewAdapter = new MyGridViewAdapter(this,mImages);
        gridView.setAdapter(viewAdapter);

        recyclerViewAdapter = new RecyclerViewAdapter(this,mDatas,count);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        imageView.setOnClickListener(this);

        mTv = (TextView) findViewById(R.id.tv);
        currentDate = dateFormat.format(date);
        mTv.setText(currentDate);
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,dateSetListener,dataAndTime.get(Calendar.YEAR),dataAndTime.get(Calendar.MONTH),dataAndTime.get(Calendar.DAY_OF_MONTH));
//                datePickerDialog.show();
                //进行相应的策划item的测试
//                Intent intent = new Intent(MainActivity.this, SlidingViewPagerActivity.class);
//                startActivity(intent);

                //进行存储的测试
//                editor.remove("user_name");
//                editor.commit();
//                etPassword.setText(sp.getString("user_name",""));
                if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    File dir = Environment.getExternalStorageDirectory(); //得到SdCard路径

                Toast.makeText(MainActivity.this,"内存卡可用", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public static boolean dateCompare(String current,String select) {
        boolean flag;
        //设定时间的模板
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //得到指定模范的时间
        try {
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(sdf.parse(current));
            c2.setTime(sdf.parse(select));
            flag = c1.compareTo(c2) <= 0;  //查看API如果，你得如果，c1大于c2,返回1，c1等于c2，返回0，c1小于c2，返回-1；
        }catch (Exception e){
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    private int count = 0;
    /**
     * 点击按钮，显示下一条数据,实现数据的反复更新显示
      * @param v
     */
    @Override
    public void onClick(View v) {
      if(count < mDatas.size()-1) {
      count += 1;
      }else if(count == mDatas.size() - 1) {
          count = 0;
      }
      initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
