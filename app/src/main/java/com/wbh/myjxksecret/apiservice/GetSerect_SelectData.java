package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.Secret_SelectBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/10/26.
 */
public interface GetSerect_SelectData {
    @FormUrlEncoded
    @Headers({"Content-Type:application/x-www-form-urlencoded"})
    @POST(value = "globalExposure/getGlobalExposureList.html")
    Call<Secret_SelectBean> getSelectData(@FieldMap Map<String, Integer> map);
}
