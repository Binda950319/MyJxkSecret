package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.ClassifyBean;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/10/27.
 */
public interface ClassifyBeanData {
    @POST(value = "categoryBrand/getCategoryList.html")
    Call<ClassifyBean> getClassifyBean();
}
