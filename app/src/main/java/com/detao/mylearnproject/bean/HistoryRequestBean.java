package com.detao.mylearnproject.bean;

/**
 * Created by shaoronggang on 2017/4/14.
 */

public class HistoryRequestBean {
    private String v;
    private int month;
    private int day;
    private String key;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }
}
