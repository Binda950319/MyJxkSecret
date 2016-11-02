package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.GoodsDetailsBean;
import com.wbh.myjxksecret.javabean.Home_GoodsDetailsBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/10/29.
 */
public interface GetHomeGoodsDetail {

    @FormUrlEncoded
    @POST(value = "goods/getGoodsDetailByNo.html")
    Call<Home_GoodsDetailsBean> getHomeGoodsDetail(@FieldMap Map<String, String> map);
}
