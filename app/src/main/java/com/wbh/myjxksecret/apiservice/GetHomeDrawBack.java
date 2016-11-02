package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.Home_DrawBackBean;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/10/26.
 */
public interface GetHomeDrawBack {

    @POST(value = "taxRefund/getTaxRefundIndex.html")
    Call<Home_DrawBackBean> getDrawBean();
}
