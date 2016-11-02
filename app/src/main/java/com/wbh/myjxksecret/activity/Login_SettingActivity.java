package com.wbh.myjxksecret.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;

public class Login_SettingActivity extends AppCompatActivity {

    @BindView(R.id.btn_login_unLogin)
    Button btn_login_unLogin;
    @BindView(R.id.iv_loginSetting_back)
    ImageView iv_loginSetting_back;
    @BindView(R.id.cb_login_JPush)
    CheckBox cb_login_JPush;
    private SharedPreferences sharePre;
    private boolean isLogin;
    private Intent intent;
    private boolean isJPush = true;

    //推送AppKey 0ccaf9c3c9ab6697504021dd
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__setting);
        ButterKnife.bind(this);
        sharePre = getSharedPreferences("user", Context.MODE_PRIVATE);
        isLogin = sharePre.getBoolean("isLogin", false);
    }


    @OnClick(R.id.iv_loginSetting_back)
    public void clickBack(View view) {
        finish();
    }

    //点击退出登录
    @OnClick(R.id.btn_login_unLogin)
    public void clickUnLogin(View view) {
        SharedPreferences.Editor edit = sharePre.edit();
        edit.clear();
        intent = new Intent();
        intent.putExtra("userName", "用户名");
        intent.putExtra("userIcon", "R.mipmap.default_drawing");
        setResult(400, intent);
        Toast.makeText(Login_SettingActivity.this, "退出登录", Toast.LENGTH_SHORT).show();
        finish();
    }
    @OnClick(R.id.cb_login_JPush)
    public void clickJPush(View view) {
        Log.e("Bing", "******CheckBox: ******" + cb_login_JPush.isChecked());
        if (!isJPush) {
            isJPush = true;
            Toast.makeText(Login_SettingActivity.this, "开启推送", Toast.LENGTH_SHORT).show();
            JPushInterface.resumePush(this);
        } else {
            isJPush = false;
            Toast.makeText(Login_SettingActivity.this, "关闭推送", Toast.LENGTH_SHORT).show();
            JPushInterface.stopPush(this);
        }
    }

    //统计功能:统计用户使用时长或者活跃度, 打开次数(必须添加)
    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JPushInterface.onPause(this);
    }
}
