package com.wbh.myjxksecret.myfragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.activity.CheckPersonActivity;
import com.wbh.myjxksecret.activity.LoginActivity;
import com.wbh.myjxksecret.activity.Login_SettingActivity;
import com.wbh.myjxksecret.activity.PerCollectionActivity;
import com.wbh.myjxksecret.activity.PersonMessageQueueActivity;
import com.wbh.myjxksecret.activity.ShoppingActivity;
import com.wbh.myjxksecret.activity.ShoppingCarActivity;
import com.wbh.myjxksecret.activity.UserInfoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends Fragment {

    @BindView(R.id.iv_login)
    ImageView iv_login;
    @BindView(R.id.iv_login_setting)
    ImageView iv_login_setting;
    @BindView(R.id.iv_per_userIcon)
    CircleImageView iv_per_userIcon;
    @BindView(R.id.tv_per_userName)
    TextView tv_per_userName;
    @BindView(R.id.rl_per_collect)
    RelativeLayout rl_per_collect;
    @BindView(R.id.rl_per_shopping)
    RelativeLayout rl_per_shopping;
    private Context context;
    private Intent intent;
    private SharedPreferences sharePre;
    boolean isLogin;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharePre = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        isLogin = sharePre.getBoolean("isLogin", false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        ButterKnife.bind(this, view);

        initUserInfo();
        return view;
    }

    //设置用户头像/名称
    private void initUserInfo() {
        String userName = sharePre.getString("userName", "用户名");
        String userIcon = sharePre.getString("userIcon", "R.mipmap.default_drawing");
        Log.e("Bing", "******用户名: ******" + userName);
        Log.e("Bing", "******用户头像: ******" + userIcon);
        tv_per_userName.setText(userName);
        Glide.with(context).load(userIcon).placeholder(R.mipmap.default_drawing).into(iv_per_userIcon);
    }

    //点击用户头像
    @OnClick(R.id.iv_per_userIcon)
    public void clicklogin(View view) {
        if (!isLogin) {
            intent = new Intent(context, LoginActivity.class);
            startActivityForResult(intent, 100);
        }
    }

    //点击左上角进入登录界面
    @OnClick(R.id.iv_login)
    public void clickLogin(View view) {
        if (!isLogin) {
            intent = new Intent(context, LoginActivity.class);
            startActivityForResult(intent, 100);
        } else {
            intent = new Intent(context, CheckPersonActivity.class);
            startActivity(intent);
        }
    }

    //点击进入设置
    @OnClick(R.id.iv_login_setting)
    public void clickSetting(View view) {
        if (!isLogin) {
            intent = new Intent(context, LoginActivity.class);
            startActivityForResult(intent, 100);
        } else {
            intent = new Intent(context, Login_SettingActivity.class);
            startActivityForResult(intent, 300);
        }
    }

    //点击进入信息
    @OnClick(R.id.tv_per_userName)
    public void clickToInfo(View view) {
        if (!isLogin) {
            intent = new Intent(context, LoginActivity.class);
            startActivityForResult(intent, 100);
        } else {
            intent = new Intent(context, UserInfoActivity.class);
            startActivity(intent);
        }
    }

    //旅行便笺
    @OnClick(R.id.rl_per_shopping)
    public void clickShoppingCar(View view) {
        intent = new Intent(context, ShoppingCarActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.rl_per_collect)
    public void clickToMyCollect(View view) {
        intent = new Intent(context, PerCollectionActivity.class);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (100 == requestCode) {
            if (resultCode == 200) {
                if (data != null) {
                    isLogin = true;
                    tv_per_userName.setText(data.getStringExtra("userName"));
                    String userIcon = data.getStringExtra("userIcon");
                    Glide.with(this).load(userIcon)
                            .into(iv_per_userIcon);
                }
            }
        } else if (300 == requestCode) {
            if (resultCode == 400) {
                if (data != null) {
                    isLogin = false;
//                    initUserInfo();
                    tv_per_userName.setText(data.getStringExtra("userName"));
                    String userIcon = data.getStringExtra("userIcon");
                    Glide.with(this).load(userIcon)
                            .placeholder(R.mipmap.default_drawing)
                            .into(iv_per_userIcon);
                }
            }
        }
    }
}

