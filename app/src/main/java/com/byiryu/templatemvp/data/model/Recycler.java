package com.byiryu.templatemvp.data.model;

public class Recycler {
    int res;
    String txt;

    public Recycler(int res, String txt) {
        this.res = res;
        this.txt = txt;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
