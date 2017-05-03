package com.detao.mylearnproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shaoronggang on 2017/4/28.
 */
public class ServerModel implements Serializable {


    /**
     * result : [{"_id":"17580506","title":"法国政治家罗伯斯庇尔诞辰","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201005/5/31235659989.jpg","year":1758,"month":5,"day":6,"des":"在259年前的今天，1758年5月6日 (农历三月廿九)，法国政治家罗伯斯庇尔诞辰。","lunar":"戊寅年三月廿九"},{"_id":"18400506","title":"世界上第一批邮票的诞生","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201005/5/0323491509.jpg","year":1840,"month":5,"day":6,"des":"在177年前的今天，1840年5月6日 (农历四月初五)，世界上第一批邮票的诞生。","lunar":"庚子年四月初五"},{"_id":"18560506","title":"奥地利精神病学家、精神分析学派的创始人弗洛伊德出生","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201005/5/F7235833923.bmp","year":1856,"month":5,"day":6,"des":"在161年前的今天，1856年5月6日 (农历四月初三)，奥地利精神病学家、精神分析学派的创始人弗洛伊德出生。","lunar":"丙辰年四月初三"},{"_id":"18590506","title":"杰出的德国科学家洪堡在柏林逝世","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201005/6/66215926667.jpg","year":1859,"month":5,"day":6,"des":"在158年前的今天，1859年5月6日 (农历四月初四)，杰出的德国科学家洪堡在柏林逝世。","lunar":"己未年四月初四"},{"_id":"18710506","title":"伟大的发明者维克多·格林尼亚教授出生","pic":"","year":1871,"month":5,"day":6,"des":"在146年前的今天，1871年5月6日 (农历三月十七)，伟大的发明者维克多·格林尼亚教授出生。","lunar":"辛未年三月十七"},{"_id":"18820506","title":"美国通过《排华法案》","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201310/25/CD7574995.jpg","year":1882,"month":5,"day":6,"des":"在135年前的今天，1882年5月6日 (农历三月十九)，美国通过《排华法案》。","lunar":"壬午年三月十九"},{"_id":"19100506","title":"英国国王爱德华七世逝世","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200905/17/BD161555131.jpg","year":1910,"month":5,"day":6,"des":"在107年前的今天，1910年5月6日 (农历三月廿七)，英国国王爱德华七世逝世。","lunar":"庚戌年三月廿七"},{"_id":"19190506","title":"五四学潮扩大到全国","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200905/17/DF161430312.jpg","year":1919,"month":5,"day":6,"des":"在98年前的今天，1919年5月6日 (农历四月初七)，五四学潮扩大到全国。","lunar":"己未年四月初七"},{"_id":"19330506","title":"南京国民政府谋求与在华北停战","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200905/17/5D161051321.jpg","year":1933,"month":5,"day":6,"des":"在84年前的今天，1933年5月6日 (农历四月十二)，南京国民政府谋求与在华北停战。","lunar":"癸酉年四月十二"},{"_id":"19340506","title":"中共中央批评肃反扩大化","pic":"","year":1934,"month":5,"day":6,"des":"在83年前的今天，1934年5月6日 (农历三月廿三)，中共中央批评肃反扩大化。","lunar":"甲戌年三月廿三"},{"_id":"19370506","title":"\u201c兴登堡\u201d号被焚毁","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200405/6/BA234044373.jpg","year":1937,"month":5,"day":6,"des":"在80年前的今天，1937年5月6日 (农历三月廿六)，\u201c兴登堡\u201d号被焚毁。","lunar":"丁丑年三月廿六"},{"_id":"19390506","title":"汪精卫通电投敌","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200905/17/5A1687573.jpg","year":1939,"month":5,"day":6,"des":"在78年前的今天，1939年5月6日 (农历三月十七)，汪精卫通电投敌。","lunar":"己卯年三月十七"},{"_id":"19490506","title":"司徒雷登与中共进行第一次会晤","pic":"","year":1949,"month":5,"day":6,"des":"1949年5月6日 (农历四月初九)，司徒雷登与中共进行第一次会晤。","lunar":"己丑年四月初九"},{"_id":"19500506","title":"艾格妮丝·史沫特莱逝世","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201005/6/D922115540.jpg","year":1950,"month":5,"day":6,"des":"1950年5月6日 (农历三月二十)，艾格妮丝·史沫特莱逝世。","lunar":"庚寅年三月二十"},{"_id":"19530506","title":"英国首相布莱尔诞辰","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200405/6/4B23415260.jpg","year":1953,"month":5,"day":6,"des":"1953年5月6日 (农历三月廿三)，英国首相布莱尔诞辰。","lunar":"癸巳年三月廿三"},{"_id":"19540506","title":"班尼斯特第一个突破1英里跑4分钟大关","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200905/17/5815598930.jpg","year":1954,"month":5,"day":6,"des":"1954年5月6日 (农历四月初四)，班尼斯特第一个突破1英里跑4分钟大关。","lunar":"甲午年四月初四"},{"_id":"19710506","title":"我国与圣马力诺建立领事级外交关系","pic":"","year":1971,"month":5,"day":6,"des":"1971年5月6日 (农历四月十二)，我国与圣马力诺建立领事级外交关系。","lunar":"辛亥年四月十二"},{"_id":"19740506","title":"德国总理勃兰特辞职","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200405/6/5D234122151.jpg","year":1974,"month":5,"day":6,"des":"1974年5月6日 (农历四月十五)，德国总理勃兰特辞职。","lunar":"甲寅年四月十五"},{"_id":"19870506","title":"我国十大传统名花评出　梅花荣居万花之首","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201405/19/99123014209.jpg","year":1987,"month":5,"day":6,"des":"1987年5月6日 (农历四月初九)，我国十大传统名花评出　梅花荣居万花之首。","lunar":"丁卯年四月初九"},{"_id":"19870506m2","title":"世界十大隧道之一的大瑶山隧道贯通","pic":"","year":1987,"month":5,"day":6,"des":"1987年5月6日 (农历四月初九)，世界十大隧道之一的大瑶山隧道贯通。","lunar":"丁卯年四月初九"},{"_id":"19870506m1","title":"大兴安岭发生特大森林火灾","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200905/17/B5154755320.jpg","year":1987,"month":5,"day":6,"des":"1987年5月6日 (农历四月初九)，大兴安岭发生特大森林火灾。","lunar":"丁卯年四月初九"},{"_id":"19880506","title":"贵州发生特大瓦斯爆炸事故","pic":"","year":1988,"month":5,"day":6,"des":"1988年5月6日 (农历三月廿一)，贵州发生特大瓦斯爆炸事故。","lunar":"戊辰年三月廿一"},{"_id":"19880506m1","title":"我渔船被美国\u201c门罗总统\u201d号货轮撞沉　17名船员遇难","pic":"","year":1988,"month":5,"day":6,"des":"1988年5月6日 (农历三月廿一)，我渔船被美国\u201c门罗总统\u201d号货轮撞沉　17名船员遇难。","lunar":"戊辰年三月廿一"},{"_id":"19940506m1","title":"广东大亚湾核电站正式投入商业运行","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201005/5/29235247826.jpg","year":1994,"month":5,"day":6,"des":"1994年5月6日 (农历三月廿六)，广东大亚湾核电站正式投入商业运行。","lunar":"甲戌年三月廿六"},{"_id":"19940506","title":"英法海底隧道通车","pic":"","year":1994,"month":5,"day":6,"des":"1994年5月6日 (农历三月廿六)，英法海底隧道通车。","lunar":"甲戌年三月廿六"},{"_id":"19980506m1","title":"印尼骚乱升级","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200905/17/F3154237160.jpg","year":1998,"month":5,"day":6,"des":"1998年5月6日 (农历四月十一)，印尼骚乱升级。","lunar":"戊寅年四月十一"},{"_id":"19980506","title":"奔驰汽车公司与克莱斯勒公司合并","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/200905/17/F7154235978.jpg","year":1998,"month":5,"day":6,"des":"1998年5月6日 (农历四月十一)，奔驰汽车公司与克莱斯勒公司合并。","lunar":"戊寅年四月十一"},{"_id":"20030506","title":"国家发展和改革委员会正式挂牌","pic":"","year":2003,"month":5,"day":6,"des":"2003年5月6日 (农历四月初六)，国家发展和改革委员会正式挂牌。","lunar":"癸未年四月初六"},{"_id":"20080506","title":"陈水扁为\u201c金钱外交\u201d爆发重大丑闻道歉","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201005/5/EE235522958.jpg","year":2008,"month":5,"day":6,"des":"2008年5月6日 (农历四月初二)，陈水扁为\u201c金钱外交\u201d爆发重大丑闻道歉。","lunar":"戊子年四月初二"},{"_id":"20100506","title":"重庆大风暴雨灾害 致31人死亡","pic":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201005/8/44192816905.jpg","year":2010,"month":5,"day":6,"des":"2010年5月6日 (农历三月廿三)，重庆大风暴雨灾害 致31人死亡。","lunar":"庚寅年三月廿三"},{"_id":"6800506","title":"阿拉伯帝国倭马亚王朝建立者穆阿维叶逝世","pic":"","year":680,"month":5,"day":6,"des":"在1337年前的今天，0680年5月6日 (农历四月初三)，阿拉伯帝国倭马亚王朝建立者穆阿维叶逝世。","lunar":"庚辰年四月初三"}]
     * reason : 请求成功！
     * error_code : 0
     */

    private String reason;
    private int error_code;
    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * _id : 17580506
         * title : 法国政治家罗伯斯庇尔诞辰
         * pic : http://juheimg.oss-cn-hangzhou.aliyuncs.com/toh/201005/5/31235659989.jpg
         * year : 1758
         * month : 5
         * day : 6
         * des : 在259年前的今天，1758年5月6日 (农历三月廿九)，法国政治家罗伯斯庇尔诞辰。
         * lunar : 戊寅年三月廿九
         */

        private String _id;
        private String title;
        private String pic;
        private int year;
        private int month;
        private int day;
        private String des;
        private String lunar;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getLunar() {
            return lunar;
        }

        public void setLunar(String lunar) {
            this.lunar = lunar;
        }
    }
}
