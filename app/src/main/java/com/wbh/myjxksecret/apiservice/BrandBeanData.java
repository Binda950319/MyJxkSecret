package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.BrandBean;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/10/27.
 */
public interface BrandBeanData {
    @POST(value = "categoryBrand/getBrandInfoList.html")
    Call<BrandBean> getBrandBean();
}
