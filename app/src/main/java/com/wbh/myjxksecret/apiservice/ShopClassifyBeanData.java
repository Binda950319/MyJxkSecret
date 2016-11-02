package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.ShopClassifyBean;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/10/28.
 */
public interface ShopClassifyBeanData {

        @POST(value = "categoryBrand/getCategoryList.html")
        Call<ShopClassifyBean> getShopClassifyBeanBean(@Query("parentId") String parentId );

}
