package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.MallCategoryGoods;
import com.wbh.myjxksecret.javabean.MallDetailBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/10/28.
 */
public interface GetMallCategoryGoods {
    @FormUrlEncoded
    @POST(value = "interimGoods/getInterimListByCateBrand.html")
    Call<MallCategoryGoods> getCategoryGoods(@FieldMap Map<String, Object> map);
}
