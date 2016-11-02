package com.wbh.myjxksecret.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.adapter.DrawBackAdapter;
import com.wbh.myjxksecret.apiservice.GetHomeDrawBack;
import com.wbh.myjxksecret.javabean.Home_DrawBackBean;
import com.wbh.myjxksecret.utils.HorizontalListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFm_DrawBackActivity extends AppCompatActivity {
    //    http://app.interface.jescard.com/taxRefund/getTaxRefundIndex.html
    private String baseUrl = "http://app.interface.jescard.com/";
    @BindView(R.id.drawback_listView)
    HorizontalListView drawback_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_fm__draw_back);
        ButterKnife.bind(this);
        initRetrofit();
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetHomeDrawBack homeDrawBack = retrofit.create(GetHomeDrawBack.class);
        Call<Home_DrawBackBean> call = homeDrawBack.getDrawBean();
        call.enqueue(new Callback<Home_DrawBackBean>() {
            @Override
            public void onResponse(Call<Home_DrawBackBean> call, Response<Home_DrawBackBean> response) {
                Home_DrawBackBean body = response.body();
                if (body != null) {
                    initView(body);
                }
            }

            @Override
            public void onFailure(Call<Home_DrawBackBean> call, Throwable t) {
                Log.e("Bing", "******点击退税onFainlure: ******" + t.getMessage());
            }
        });
    }

    private void initView(Home_DrawBackBean body) {
        List<Home_DrawBackBean.ObjBean.TaxRefundInstitutionListBean> list = body.getObj().getTaxRefundInstitutionList();
        DrawBackAdapter drawBackAdapter = new DrawBackAdapter(list, this, R.layout.drawback_listview_item);
        drawback_listView.setAdapter(drawBackAdapter);

    }
}
