package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.HomeBean;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/10/24.
 */
public interface GetHomeBanner {
//    @FormUrlEncoded
//    @Headers({"Content-Type:application/x-www-form-urlencoded"})
    @POST(value = "index/indexInfo.html")
    Call<HomeBean> getHomeBanner();
//    @FieldMap Map<String, String> map
}
