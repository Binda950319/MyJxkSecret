package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.ShowUpdataCouBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/10/29.
 */
public interface ShowUpdataBeanData {
    @POST(value = "discountCoupon/getCouponDetials.html")
    Call<ShowUpdataCouBean> getShowUpdataBeanBean(@Query("couponId") String couponId );

}
