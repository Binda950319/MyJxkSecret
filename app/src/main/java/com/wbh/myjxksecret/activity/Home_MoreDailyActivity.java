package com.wbh.myjxksecret.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.adapter.Home_MoreDailyAdapter;
import com.wbh.myjxksecret.apiservice.GetMoreDaily;
import com.wbh.myjxksecret.javabean.GetMoreDailyBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home_MoreDailyActivity extends AppCompatActivity {
    @BindView(R.id.iv_daily_back)
    ImageView iv_daily_back;
    @BindView(R.id.pull_listView)
    PullToRefreshListView pull_listView;
    private int page = 1;
    private Intent intent;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 100:
                    pull_listView.onRefreshComplete();
                    break;
                case 200:
                    pull_listView.onRefreshComplete();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__more_daily);
        ButterKnife.bind(this);
        initRetrofit();
    }

    @OnClick(R.id.iv_daily_back)
    public void backHome(View view) {
        finish();
    }

    private void initRetrofit() {
//        http://app.interface.jescard.com/recommended/recommendedDailyList.html
        String path = "http://app.interface.jescard.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Map<String, Integer> map = new HashMap<>();
        map.put("page", page);
        map.put("pagesize", 20);
        GetMoreDaily getMoreDaily = retrofit.create(GetMoreDaily.class);
        Call<GetMoreDailyBean> call = getMoreDaily.getMoreDaily(map);
        call.enqueue(new Callback<GetMoreDailyBean>() {
            @Override
            public void onResponse(Call<GetMoreDailyBean> call, Response<GetMoreDailyBean> response) {
                GetMoreDailyBean body = response.body();
                if (body != null) {
                    getMoreDailyList(body);
                }
            }

            @Override
            public void onFailure(Call<GetMoreDailyBean> call, Throwable t) {

            }
        });
    }

    private void getMoreDailyList(final GetMoreDailyBean body) {
        final List<GetMoreDailyBean.ObjBean.DataBean> data = body.getObj().getData();
        Home_MoreDailyAdapter dailyAdapter = new Home_MoreDailyAdapter(data, this, R.layout.moredaily_item);
        pull_listView.setAdapter(dailyAdapter);

        pull_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(Home_MoreDailyActivity.this, HomeBannerDetailActivity.class);
                String goValue = data.get(position - 1).getRecommendedPagelink();
                intent.putExtra("title", "旅行时尚购");
                intent.putExtra("goValue", goValue);
                startActivity(intent);
            }
        });
        pull_listView.setMode(PullToRefreshBase.Mode.BOTH);
        pull_listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                handler.sendEmptyMessageDelayed(100, 2000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                handler.sendEmptyMessageDelayed(200, 2000);
            }
        });
    }


}
