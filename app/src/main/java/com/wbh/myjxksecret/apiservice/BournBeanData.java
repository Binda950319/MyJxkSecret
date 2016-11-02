package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.BournBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/10/24.
 */
public interface BournBeanData {
    @POST(value = "market/queryTargetMarketInfoList.html")
    Call<BournBean> getBournBean(@Query("countryId") String dizhi);
}
