package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.ShopBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/10/27.
 */
public interface ShopBeanData {
    @POST(value = "goods/getGoodsListByPage.html")
    Call<ShopBean> getShopBeanBean(@Query("categoryId") String categoryId,@Query("page") int page,@Query("pagesize") int pagesize );
}
