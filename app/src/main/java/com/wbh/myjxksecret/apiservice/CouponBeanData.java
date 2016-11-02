package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.CouponBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/10/28.
 */
public interface CouponBeanData {
    @POST(value = "discountCoupon/getCountryCouponLists.html")
    Call<CouponBean> getCouponBean(@Query("pagesize") int pagesize,@Query("countryId") String countryId, @Query("page") int page);

}
