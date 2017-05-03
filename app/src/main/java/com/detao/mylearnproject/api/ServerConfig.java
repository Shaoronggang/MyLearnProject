package com.detao.mylearnproject.api;

import com.detao.mylearnproject.MyApplication;

/**
 * Created by shaoronggang on 2017/4/14.
 */

public class ServerConfig {

    public static String getUrl(String urlEnd) {
        return URL_PATH + urlEnd;
    }

    public static String URL_PATH = "http:localhost:8080/";

    public static void initBaseUrl() {
        if (MyApplication.isRelease) {
            //线上环境的基础拼接地址的配置
        } else {
            //测试环境的基础拼接地址的配置
        }
    }

    //聚合数据中的历史的今天的接口
    public static String HISTORY_TODAY = "http://api.juheapi.com/japi/toh";


    /**
     * 天行Api：website: http://www.tianapi.com/#yule
     */

    //天行数据 大部分都是使用了get请求
    public final static String APIKEY = "9da6c841bc4cdb755dd7f31f5c14184f";
    //天行数据的使用
    public final static String TIANBASEURLONE = "https://api.tianapi.com";
    public final static String TIANBASEURLTWO = "https://api.tianapi.com/txapi";

    /*
    *新闻资讯Api接口服务
    */

    //社会
    public static String SOCIAL = TIANBASEURLONE + "/social";
    //国内
    public static String GUONEI = TIANBASEURLONE + "/guonei";
    //国际
    public static String WORLD = TIANBASEURLONE + "/world";
    //娱乐
    public static String HUABIAN = TIANBASEURLONE + "/huabian";  // 娱乐新闻、明星花边、探班、娱乐活动等
    //体育
    public static String TIYU = TIANBASEURLONE + "/tiyu";  // 国内体育行业、体育明星动态等
    //NBA
    public static String NBA = TIANBASEURLONE + "/nba";   // NBA动态、篮球赛等
    //足球新闻
    public static String FOOTBALL = TIANBASEURLONE + "/football";  // 国足资讯、国足明星动态等
    //科技新闻
    public static String KEJI = TIANBASEURLONE + "/keji";    // 信息科技、数码科技、物理科技
    //创业新闻
    public static String STARTUP = TIANBASEURLONE + "/startup";  // 互联网创业、创新、创业人物动态
    //苹果新闻
    public static String APPLE = TIANBASEURLONE + "/apple";   // Apple产品动态，果粉、教程帮助
    //移动互联
    public static String MOBILE = TIANBASEURLONE + "/mobile";    //移动互联网行业资讯
    //旅游资讯
    public static String TRAVEL = TIANBASEURLONE + "/travel";    //旅游、周边、景点
    //健康知识
    public static String HEALTH = TIANBASEURLONE + "/health";    //健康知识、养生、中西医
    //奇闻异事
    public static String QIWEN = TIANBASEURLONE + "/qiwen";    //世界奇闻、民间趣事、灵异事件等
    //美女图片
    public static String MEINV = TIANBASEURLONE + "/meinv";    //美女图片、大家都懂
    //VR科技
    public static String VR = TIANBASEURLONE + "/vr";    //VR虚拟现实相关新闻资讯
    //IT资讯
    public static String IT = TIANBASEURLONE + "/it";   //IT行业相关新闻资讯

    /*
    * 生活娱乐API
    * */

    //菜谱
    public static String CAIPU = TIANBASEURLTWO + "/caipu";
    //周公解梦
    public static String DREAM = TIANBASEURLTWO + "/dream";
    //雷人笑话
    public static String JOKE = TIANBASEURLTWO + "/joke";
    //名言警句
    public static String DICTUM = TIANBASEURLTWO + "/dictum";
    //生日预测
    public static String DOB = TIANBASEURLTWO + "/dob";
    //脑筋急转弯
    public static String NAOWAN = TIANBASEURLTWO + "/naowan";
    //历史的今天
    public static String LISHI = TIANBASEURLTWO + "/lishi";
    //成语典故
    public static String CHENGYU = TIANBASEURLTWO + "/chengyu";
    //简说历史
    public static String PITLISHI = TIANBASEURLTWO + "/pitlishi";
    //一战问答
    public static String WENDA = TIANBASEURLTWO + "/wenda";
    //网络热词
    public static String HOTWORD = TIANBASEURLTWO + "/hotword";
    //股市术语
    public static String SHARES = TIANBASEURLTWO + "/shares";
    //网址转换
    public static String TURL = TIANBASEURLTWO + "/turl";
    //网络取名
    public static String CNAME = TIANBASEURLTWO + "/cname";
    //歇后语
    public static String XIEHOU = TIANBASEURLTWO + "/xiehou";
    //绕口令
    public static String RKL = TIANBASEURLTWO + "/rkl";


}
