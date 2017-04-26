package com.detao.mylearnproject.api;

import com.detao.mylearnproject.MyApplication;

/**
 * Created by shaoronggang on 2017/4/14.
 */

public class ServerConfig {

    public static String getUrl(String urlEnd){
        return URL_PATH + urlEnd;
    }

    public static String URL_PATH = "http:localhost:8080/";

    public static void initBaseUrl(){
        if(MyApplication.isRelease) {
            //线上环境的基础拼接地址的配置
        }else {
            //测试环境的基础拼接地址的配置
        }
    }

    //聚合数据中的历史的今天的接口
    public static String HISTORY_TODAY = "http://api.juheapi.com/japi/toh";




}
