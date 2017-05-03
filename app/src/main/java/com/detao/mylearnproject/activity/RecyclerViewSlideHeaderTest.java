package com.detao.mylearnproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONObject;
import com.detao.mylearnproject.R;
import com.detao.mylearnproject.adapter.SlideRecyclerAdapter;
import com.detao.mylearnproject.api.ServerConfig;
import com.detao.mylearnproject.base.BaseActivity;
import com.detao.mylearnproject.bean.GuoNeiBean;
import com.detao.mylearnproject.bean.ServerModel;
import com.detao.mylearnproject.callback.HidingScrollListener;
import com.detao.mylearnproject.callback.OnItemClickListener;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by shaoronggang on 2017/4/25.
 */

public class RecyclerViewSlideHeaderTest extends BaseActivity {
    private final String TAG = "slide" + getClass().getName();

    @BindView(R.id.recyclerView_slide)
    RecyclerView recyclerViewSlide;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fabButton)
    ImageView fabButton;
    private List<String> datas;
    private List<ServerModel.ResultBean> results;
    private List<GuoNeiBean.NewslistBean> result;
    private SlideRecyclerAdapter slideRecyclerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        getDataFromNet();
    }

    private void initView() {
        //初始化toolbar
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
    }

    @Override
    protected int getResLayout() {
        return R.layout.recyclerview_slide_activity;
    }

    //联网获取数据
    private void getDataFromNet() {

//        Map<String,String> params = new HashMap<>();


        final String url = "http://api.juheapi.com/japi/toh";//聚合数据
        new Thread(new Runnable() {
            @Override
            public void run() {

                //创建一个Request对象
                OkHttpClient client = new OkHttpClient();
                //这里是对天行数据的接口的数据的调用
                HttpUrl.Builder urlBuiler = HttpUrl.parse(ServerConfig.MOBILE).newBuilder();
                //addQueryParameter 添加查询参数
//                    urlBuiler.addQueryParameter("key", "471bbf2feddb0389c7390f2a0a632282");
//                    urlBuiler.addQueryParameter("v", 1.0 + "");
//                    urlBuiler.addQueryParameter("month", 10 + "");
//                    urlBuiler.addQueryParameter("day", 1 + "");

                urlBuiler.addQueryParameter("key", "9da6c841bc4cdb755dd7f31f5c14184f");
                urlBuiler.addQueryParameter("num", 20 + "");
                urlBuiler.addQueryParameter("m", 1 + "");
                urlBuiler.addQueryParameter("d", 2 + "");
                urlBuiler.addQueryParameter("url", "https://www.youtube.com/playlist?list=PLvmaC-XMqeBbw72l2G7FG7CntDTErjbHc");
                urlBuiler.addQueryParameter("date", 06 / 25 + "");
                urlBuiler.addQueryParameter("word", "你");
                urlBuiler.addQueryParameter("mode", 1 + "");

                String url1 = urlBuiler.build().toString();
                Request request = new Request.Builder().url(url1).build();
//                    Response response = null;

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String data = response.body().string();
                        Log.e("Data", data + "");
                        //在主线程中进行UI修改操作
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                                ServerModel serverModel = JSONObject.parseObject(data,ServerModel.class);
//                                Log.e("SERVERMODEL", serverModel.getResult().get(0).getTitle()
//                                        +"");
//                                results = serverModel.getResult();
//                                initData(results);

                                GuoNeiBean serverModel = JSONObject.parseObject(data, GuoNeiBean.class);
                                result = serverModel.getNewslist();
                                if (result != null) {
                                    initData(result);
                                }


                            }
                        });

                    }
                });

            }
        }).start();


//        OkGo.get(url)
//                .params(params).
//                execute(new AbsCallback<Object>() {
//            @Override
//            public Object convertSuccess(Response response) throws Exception {
//                ServerModel serverModel = new ServerModel();
//                return serverModel;
//            }
//
//            @Override
//            public void onSuccess(Object o, Call call, Response response) {
//                        ServerModel serverModel = (ServerModel) o;
//                       int code =  serverModel.getError_code();
//                        Log.e(TAG, serverModel.getReason() + "" + code);
//            Toast.makeText(RecyclerViewSlideHeaderTest.this, "联网成功", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onError(Call call, Response response, Exception e) {
//                super.onError(call, response, e);
//                Toast.makeText(RecyclerViewSlideHeaderTest.this, "联网失败", Toast.LENGTH_SHORT).show();
//            }
//        });


//        x.http().get(params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                Log.e("TAG", result.toString() + "");
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//
//
//        });


    }


    //初始化数据
    private void initData(final List<GuoNeiBean.NewslistBean> results) {
//        datas = new ArrayList<>();
//        for (int i = 0; i < 11; i++) {
//            datas.add("你在哪里，让我看到你的手：" + i);
//        }
//
//        Gson gson = new Gson();
//
//        //解析序列数据
//        Type listType = new TypeToken<List<UserInfo>>(){}.getType();
//        List<UserInfo> userInfos = new ArrayList<>();
//        String jsonDatas = "[{\"username\":\"mike\",\"userId\":002},{\"username\":\"joe\",\"userId\":005}]";
//        userInfos = gson.fromJson(jsonDatas,listType);
//        for (int i = 0,len = userInfos.size(); i <len ; i++) {
//            datas.add(userInfos.get(i).getUsername());
//            datas.add(userInfos.get(i).getUserId());
//        }
//
//        //解析标量数据
//        String jsonData = "{\"username\":\"arthinking\",\"userId\":001}";
//        UserInfo userInfo = gson.fromJson(jsonData, UserInfo.class);
//        datas.add(userInfo.getUsername());
//        datas.add(userInfo.getUserId());


//        Log.e("TAG", list.get(1).getTitle() + "");


        //初始化recyclerview
        recyclerViewSlide.setLayoutManager(new LinearLayoutManager(this));
        slideRecyclerAdapter = new SlideRecyclerAdapter(this, results);
        recyclerViewSlide.setAdapter(slideRecyclerAdapter);
        slideRecyclerAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View View, Object o) {
                GuoNeiBean.NewslistBean results = (GuoNeiBean.NewslistBean) o;
                Intent intent = new Intent(RecyclerViewSlideHeaderTest.this, WebViewActivtiy.class);
                intent.putExtra("url", results.getUrl());
                startActivity(intent);
            }
        });

        recyclerViewSlide.setOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                hideViews();
            }

            @Override
            public void onShow() {
                showViews();
            }
        });




    }

    private void showViews() {
        toolbar.animate().translationY(0).setInterpolator(new AccelerateInterpolator(2));
        fabButton.animate().translationY(0).setInterpolator(new AccelerateInterpolator(2)).start();
    }

    private void hideViews() {
        toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) fabButton.getLayoutParams();
        int fabBottomMargin = lp.bottomMargin;
        fabButton.animate().translationY(fabButton.getHeight() + fabBottomMargin).setInterpolator(new AccelerateInterpolator(2)).start();
    }

}
