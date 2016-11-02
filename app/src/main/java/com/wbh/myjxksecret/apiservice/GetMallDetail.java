package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.MallDetailBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/10/28.
 */
public interface GetMallDetail {
    @FormUrlEncoded
//    @Headers({"Content-Type:application/x-www-form-urlencoded"})
    @POST(value = "interimGoods/getPopularityByMall.html")
    Call<MallDetailBean> getMallDetail(@FieldMap Map<String, String> map);
}
