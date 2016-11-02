package com.wbh.myjxksecret.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wbh.myjxksecret.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.iv_login_back)
    ImageView iv_login_back;
    @BindView(R.id.login_qq)
    ImageView login_qq;
    @BindView(R.id.login_wechat)
    ImageView login_wechat;
    @BindView(R.id.login_sina)
    ImageView login_sina;
    @BindView(R.id.et_login_phoneNum)
    EditText et_login_phoneNum;
    @BindView(R.id.iv_login_cleanPhone)
    ImageView iv_login_cleanPhone;
    @BindView(R.id.et_login_pwd)
    EditText et_login_pwd;
    @BindView(R.id.iv_login_pwd)
    CheckBox iv_login_pwd;
    @BindView(R.id.tv_login_new)
    TextView tv_login_new;
    private SharedPreferences sharePre;
    private SharedPreferences.Editor edit;
    String phoneNum;
    String userPhonePwd;
    private Intent intent;

    //Appkey 187c39d6de918
    //App Secret ef7fc9fb515dcad661fb16c0305ebf7d
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        ShareSDK.initSDK(this);
        sharePre = getSharedPreferences("user", MODE_PRIVATE);
        edit = sharePre.edit();
//        initView();
//        checkLogin();
    }

    private void initView() {
        phoneNum = et_login_phoneNum.getText().toString();
        userPhonePwd = et_login_pwd.getText().toString();
    }


    //新用户注册
    @OnClick(R.id.tv_login_new)
    public void clickRegist(View view) {
        intent = new Intent(this, RegistActivity.class);
        startActivity(intent);
    }

    //登录
    private void checkLogin() {
        String userPhone = sharePre.getString("userPhone", "10010");
        String userPwd = sharePre.getString("userPwd", "123456");
        if (userPhone.equals(phoneNum) && userPwd.equals(userPhonePwd)) {
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "用户名或密码输入错误", Toast.LENGTH_SHORT).show();
        }
    }


    //点击登录
    public void clickLogin(View view) {

//        edit.putString("userPhone", phoneNum);
//        edit.putString("userPwd", userPhonePwd);
//        edit.commit();
    }

    //点击清空手机号
    @OnClick(R.id.iv_login_cleanPhone)
    public void clickCleanPhone(View view) {
        et_login_phoneNum.setText("");
    }

    @OnClick(R.id.iv_login_pwd)
    public void clickHidePwd(View view) {
        if (iv_login_pwd.isChecked()) {
            iv_login_pwd.setChecked(true);
            et_login_pwd.setInputType(InputType.TYPE_CLASS_TEXT);
        } else {
            iv_login_pwd.setChecked(false);
            et_login_pwd.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    @OnClick(R.id.iv_login_back)
    public void clickBack(View view) {
        finish();
    }

    @OnClick(R.id.login_qq)
    public void loginByQQ(View view) {
        loginPlatfom(QQ.NAME);
    }

    @OnClick(R.id.login_wechat)
    public void loginByWeChat(View view) {
        loginPlatfom(Wechat.NAME);
    }

    @OnClick(R.id.login_sina)
    public void loginBySina(View view) {
        loginPlatfom(SinaWeibo.NAME);
    }

    private void loginPlatfom(String name) {
        Platform platform = ShareSDK.getPlatform(this, name);
        platform.removeAccount();
        platform.showUser(null);

        platform.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Looper.prepare();
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                String userName = platform.getDb().getUserName();
                String userIcon = platform.getDb().getUserIcon();
                String userId = platform.getDb().getUserId();
                Log.e("Bing", "******用户ID: ******" + userId);
                Log.e("Bing", "******用户名: ******" + userName);
                Log.e("Bing", "******用户头像: ******" + userIcon);
                intent = new Intent();
                intent.putExtra("userName", userName);
                intent.putExtra("userIcon", userIcon);
                setResult(200, intent);
                edit.putString("userName", userName);
                edit.putString("userIcon", userIcon);
                edit.putBoolean("isLogin", true);
                edit.commit();
                finish();
                Looper.loop();
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                Log.e("Bing", "******登录失败: ******" + throwable.getMessage());
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Toast.makeText(LoginActivity.this, "取消登录", Toast.LENGTH_SHORT).show();
                Log.e("Bing", "******取消登录: ******");
            }
        });

    }

}
