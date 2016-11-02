package com.wbh.myjxksecret.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.apiservice.ShowUpdataBeanData;
import com.wbh.myjxksecret.javabean.CouponBean;
import com.wbh.myjxksecret.javabean.ShowUpdataCouBean;
import com.wbh.myjxksecret.utils.MyShareSDK;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowCouponActivity extends AppCompatActivity implements View.OnClickListener {

    private CouponBean.ObjBean.DataBean data;
    @BindView(R.id.showcou_iv)
    ImageView showcou_iv;
    @BindView(R.id.showcou_title)
    TextView showcou_title;
    @BindView(R.id.showcou_first)
    TextView showcou_first;
    @BindView(R.id.showcou_second)
    TextView showcou_second;
    @BindView(R.id.showcou_three)
    TextView showcou_three;
    @BindView(R.id.showcou_four)
    TextView showcou_four;
    @BindView(R.id.iv_coupon_back)
    ImageView iv_coupon_back;
    @BindView(R.id.iv_coupon_share)
    ImageView iv_coupon_share;
    private ShowUpdataCouBean.ObjBean updata;
    private String couponId;
    @BindView(R.id.coupon_upsql)
    Button coupon_upsql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_coupon);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        data = ((CouponBean.ObjBean.DataBean) extras.get("data"));
        couponId = intent.getStringExtra("couponId");
        Log.e("dddddddddddd", "onCreate: "+couponId );
        if (couponId != null && data == null) {
            getData(couponId);
        } else if (data != null && couponId == null) {
            Glide.with(this).load(data.getCouponPicUrl()).into(showcou_iv);
            showcou_title.setText(data.getConditionValue());
            showcou_first.setText(data.getTrialObject());
            showcou_second.setText(data.getStartTime() + "--" + data.getEndTime());
            showcou_three.setText(data.getUseScene());
            showcou_four.setText(data.getUseWay());
        }

        coupon_upsql.setOnClickListener(this);
    }


    @OnClick(R.id.iv_coupon_back)
    public void clickBack(View view) {
        finish();
    }

    @OnClick(R.id.iv_coupon_share)
    public void clickShare(View view) {
        MyShareSDK.showShare(this);
    }

    private void getData(String couponId) {
        String baseUrl = "http://app.interface.jescard.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ShowUpdataBeanData showUpdataBeanData = retrofit.create(ShowUpdataBeanData.class);
        Call<ShowUpdataCouBean> showUpdataCouBean = showUpdataBeanData.getShowUpdataBeanBean(couponId);
        showUpdataCouBean.enqueue(new Callback<ShowUpdataCouBean>() {
            @Override
            public void onResponse(Call<ShowUpdataCouBean> call, Response<ShowUpdataCouBean> response) {
                if (response != null) {
                    updata = response.body().getObj();
//                    String mallName = updata.getMallName();
                    Log.e("45345345243524354325", "onResponse: " + updata.getCouponPicUrl());
                    Glide.with(ShowCouponActivity.this).load(updata.getCouponPicUrl()).placeholder(R.mipmap.default_drawing).into(showcou_iv);
                    showcou_title.setText(updata.getConditionValue());
                    showcou_first.setText(updata.getTrialObject());
                    showcou_second.setText(updata.getStartTime() + "--" + updata.getEndTime());
                    showcou_three.setText(updata.getUseScene());
                    showcou_four.setText(updata.getUseWay());
                }

            }

            @Override
            public void onFailure(Call<ShowUpdataCouBean> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.coupon_upsql:
                coupon_upsql.setClickable(false);
                coupon_upsql.setText("已经领取");


                break;
        }
    }
}
