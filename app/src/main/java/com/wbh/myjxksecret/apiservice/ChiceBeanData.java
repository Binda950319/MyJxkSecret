package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.ChiceControyBean;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/10/25.
 */
public interface ChiceBeanData {
    @POST(value = "country/selectCountryList.html")
    Call<ChiceControyBean> getChiceBean();
}
