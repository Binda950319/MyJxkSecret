package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.GoodsDetailsBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/10/29.
 */
public interface GetGoodsDetail {

    @FormUrlEncoded
    @POST(value = "interimGoods/getMarketGoodsDetail.html")
    Call<GoodsDetailsBean> getGoodsDetail(@FieldMap Map<String, String> map);
}
