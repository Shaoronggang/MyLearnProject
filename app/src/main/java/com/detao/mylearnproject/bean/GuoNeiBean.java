package com.detao.mylearnproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shaoronggang on 2017/5/2.
 */

public class GuoNeiBean implements Serializable {


    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-05-02 14:18","title":"刘鹤任中央经济体制和生态文明体制改革小组组长","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20170502/Img491456411_ss.jpg","url":"http://news.sohu.com/20170502/n491458295.shtml"},{"ctime":"2017-05-02 14:51","title":"国土部：分类压缩不动产登记办理时限","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20170502/Img491458296_ss.jpeg","url":"http://news.sohu.com/20170502/n491463091.shtml"},{"ctime":"2017-05-02 13:05","title":"内蒙古首条高铁进行联调联试 预计7月正式运营","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20170502/Img491442503_ss.jpeg","url":"http://news.sohu.com/20170502/n491450035.shtml"},{"ctime":"2017-05-02 13:10","title":"台湾女孩加入韩女团 标\u201c中国国籍\u201d引爆两岸","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20170502/Img491449304_ss.jpeg","url":"http://news.sohu.com/20170502/n491450445.shtml"},{"ctime":"2017-05-02 13:39","title":"起底安徽原副省长陈树隆：想和他谈得来 就聊股票","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20170502/Img491450446_ss.jpeg","url":"http://news.sohu.com/20170502/n491453159.shtml"},{"ctime":"2017-05-02 13:59","title":"英国小哥讲述中国传奇：厉害了中国制造！","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20170502/Img491453160_ss.jpeg","url":"http://news.sohu.com/20170502/n491455498.shtml"},{"ctime":"2017-05-02 11:41","title":"800米水道\u201c水穿街巷\u201d旧景重现 前门三里河成新景点","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20170502/Img491442503_ss.jpeg","url":"http://news.sohu.com/20170502/n491438987.shtml"},{"ctime":"2017-05-02 12:15","title":"揭秘40名红通人员落网的背后：25人系被劝返","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20170502/Img491442503_ss.jpeg","url":"http://news.sohu.com/20170502/n491442501.shtml"},{"ctime":"2017-05-02 12:52","title":"美国华文媒体起底红通逃犯王黎明在美藏身地址","description":"搜狐国内","picUrl":"http://photocdn.sohu.com/20170502/Img491449304_ss.jpeg","url":"http://news.sohu.com/20170502/n491449303.shtml"},{"ctime":"2017-05-02 10:51","title":"官方：2017年全国公立医院医疗费涨幅拟不超10%","description":"搜狐国内","picUrl":"","url":"http://news.sohu.com/20170502/n491433650.shtml"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2017-05-02 14:18
         * title : 刘鹤任中央经济体制和生态文明体制改革小组组长
         * description : 搜狐国内
         * picUrl : http://photocdn.sohu.com/20170502/Img491456411_ss.jpg
         * url : http://news.sohu.com/20170502/n491458295.shtml
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
