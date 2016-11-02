package com.wbh.myjxksecret.javabean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2016/11/1.
 */
@Entity
public class CouponSql {
    @Id(autoincrement = true)
    long id;
    String mallname;
    String zhekou;
    String smallzhekou;
    String frist;


    @Keep
    public CouponSql(long id, String mallname, String zhekou, String smallzhekou, String frist) {
        this.id = id;
        this.mallname = mallname;
        this.zhekou = zhekou;
        this.smallzhekou = smallzhekou;
        this.frist = frist;
    }

    @Generated(hash = 2024705145)
    public CouponSql() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMallname() {
        return mallname;
    }

    public void setMallname(String mallname) {
        this.mallname = mallname;
    }

    public String getZhekou() {
        return zhekou;
    }

    public void setZhekou(String zhekou) {
        this.zhekou = zhekou;
    }

    public String getSmallzhekou() {
        return smallzhekou;
    }

    public void setSmallzhekou(String smallzhekou) {
        this.smallzhekou = smallzhekou;
    }

    public String getFrist() {
        return frist;
    }

    public void setFrist(String frist) {
        this.frist = frist;
    }
}
