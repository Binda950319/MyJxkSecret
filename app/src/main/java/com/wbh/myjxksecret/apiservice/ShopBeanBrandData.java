package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.ShopBrandBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/10/27.
 */
public interface ShopBeanBrandData {

    @POST(value = "goods/getGoodsListByPage.html")
    Call<ShopBrandBean> getShopbrandBeanBean(@Query("pagesize") int pagesize,@Query("brandId") String brandId, @Query("page") int page);
}
