package com.wbh.myjxksecret.javabean;

/**
 * Created by Administrator on 2016/10/27.
 */
public class Secret_ItemPic {
    private int type;
    private String url;

    public Secret_ItemPic(int type, String url) {
        this.type = type;
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
