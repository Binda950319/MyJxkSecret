package com.wbh.myjxksecret.javabean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Administrator on 2016/11/1.
 */
@Entity
public class ShoppingGoodsBean {
    @Id(autoincrement = false)
    long id;
    int count;
    String name;
    String lowestCountry;
    double lowestPrice;
    double sellPrice;
    String goodsPicture;
    String picList;

    public ShoppingGoodsBean() {
    }

    @Generated(hash = 1280923030)
    public ShoppingGoodsBean(long id, int count, String name, String lowestCountry, double lowestPrice, double sellPrice, String goodsPicture, String picList) {
        this.id = id;
        this.count = count;
        this.name = name;
        this.lowestCountry = lowestCountry;
        this.lowestPrice = lowestPrice;
        this.sellPrice = sellPrice;
        this.goodsPicture = goodsPicture;
        this.picList = picList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLowestCountry() {
        return lowestCountry;
    }

    public void setLowestCountry(String lowestCountry) {
        this.lowestCountry = lowestCountry;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    public String getPicList() {
        return picList;
    }

    public void setPicList(String picList) {
        this.picList = picList;
    }
}
