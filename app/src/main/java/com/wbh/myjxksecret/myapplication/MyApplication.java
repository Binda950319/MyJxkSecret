package com.wbh.myjxksecret.myapplication;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2016/11/1.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //jpush初始化
        JPushInterface.init(this);
        //设置调试模式；
        JPushInterface.setDebugMode(true);
    }

}
