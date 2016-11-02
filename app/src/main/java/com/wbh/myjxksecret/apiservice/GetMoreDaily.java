package com.wbh.myjxksecret.apiservice;

import com.wbh.myjxksecret.javabean.GetMoreDailyBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/10/28.
 */
public interface GetMoreDaily {

    @FormUrlEncoded
    @POST(value = "recommended/recommendedDailyList.html")
    Call<GetMoreDailyBean> getMoreDaily(@FieldMap Map<String, Integer> map);
}
