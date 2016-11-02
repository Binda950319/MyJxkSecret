package com.wbh.myjxksecret.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.adapter.ConponAdapter;
import com.wbh.myjxksecret.apiservice.CouponBeanData;
import com.wbh.myjxksecret.javabean.CouponBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConponActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private int pagesize=20;
    private int page=1;
    private List<CouponBean.ObjBean.DataBean> data=new ArrayList<>();
    @BindView(R.id.conpon_listview)
    ListView conpon_listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conpon);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String ContoryId = intent.getStringExtra("firstcontoryid");
        Log.e("zjzjzjzjzjzjzj", "onCreate: "+ ContoryId);
        getData(ContoryId);
        conpon_listview.setOnItemClickListener(this);

    }

    private void getData(String contoryId) {
        String baseUrl="http://app.interface.jescard.com/";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CouponBeanData couponBeanData = retrofit.create(CouponBeanData.class);
        Call<CouponBean> couponBean = couponBeanData.getCouponBean(pagesize, contoryId, page);
        couponBean.enqueue(new Callback<CouponBean>() {


            @Override
            public void onResponse(Call<CouponBean> call, Response<CouponBean> response) {
                if (response.body()!=null){
                    data = response.body().getObj().getData();
                    ConponAdapter conponAdapter = new ConponAdapter(ConponActivity.this, data, R.layout.item_conpon_listview);
                    conpon_listview.setAdapter(conponAdapter);
                }
            }

            @Override
            public void onFailure(Call<CouponBean> call, Throwable t) {

            }
        });

    }

    // TODO: 2016/10/28 ListView的监听事件
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CouponBean.ObjBean.DataBean dataBean = data.get(position);
        Intent intent = new Intent(this, ShowCouponActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("data",dataBean);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
