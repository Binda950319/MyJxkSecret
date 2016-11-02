package com.wbh.myjxksecret.javabean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Administrator on 2016/10/31.
 */
@Entity
public class GoodsInfo {

    @Id(autoincrement = false)
    long goodsId;
    String name;
    String lowestCountry;
    double lowestPrice;
    double sellPrice;
    String goodsPicture;
    String picList;

    public GoodsInfo() {
    }

    @Generated(hash = 1316439153)
    public GoodsInfo(long goodsId, String name, String lowestCountry, double lowestPrice, double sellPrice, String goodsPicture, String picList) {
        this.goodsId = goodsId;
        this.name = name;
        this.lowestCountry = lowestCountry;
        this.lowestPrice = lowestPrice;
        this.sellPrice = sellPrice;
        this.goodsPicture = goodsPicture;
        this.picList = picList;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
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
