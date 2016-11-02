package com.wbh.myjxksecret.myfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.adapter.Secret_SelectAdapter;
import com.wbh.myjxksecret.apiservice.GetSerect_SelectData;
import com.wbh.myjxksecret.javabean.Secret_SelectBean;
import com.wbh.myjxksecret.mysql.LoveSqlHelp;
import com.wbh.myjxksecret.mysql.SelectSqlHelp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class Secret_SelectFragment extends Fragment {

    //    http://app.interface.jescard.com/globalExposure/getGlobalExposureList.html
    private String baseUrl = "http://app.interface.jescard.com/";
    @BindView(R.id.secret_listView)
    PullToRefreshListView secret_listView;

    private Context context;
    private TextView tv_secret_search;
    View headView;
    private LoveSqlHelp selectSqlHelp;
    private SelectSqlHelp selectSqlHelp1;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_secret__select, container, false);
        headView = View.inflate(context, R.layout.secret_search_layout, null);
        tv_secret_search = (TextView) headView.findViewById(R.id.tv_secret_search);
        ButterKnife.bind(this, view);
        //添加头布局
        secret_listView.getRefreshableView().addHeaderView(headView);
        getRetrofit();
        return view;
    }

    public void getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Map<String, Integer> map = new HashMap<>();
        map.put("type", 1);
        map.put("page", 1);
        map.put("pageSize", 10);
        GetSerect_SelectData serectSelectData = retrofit.create(GetSerect_SelectData.class);
        Call<Secret_SelectBean> call = serectSelectData.getSelectData(map);
        call.enqueue(new Callback<Secret_SelectBean>() {
            @Override
            public void onResponse(Call<Secret_SelectBean> call, Response<Secret_SelectBean> response) {
//                Base64.decode(data.getBytes("utf-8"), Base64.DEFAULT);
                Secret_SelectBean body = response.body();
                if (body != null) {
                    initData(body);
                }

            }

            @Override
            public void onFailure(Call<Secret_SelectBean> call, Throwable t) {
                Log.e("Bing", "******秘密堂_精选onFailure: ******" + t.getMessage());
            }
        });
    }

    private void initData(Secret_SelectBean body) {
        selectSqlHelp= new LoveSqlHelp(context, "select.db");
        selectSqlHelp1 = new SelectSqlHelp(context,"zan.db");
        List<Secret_SelectBean.ObjBean.DataBean> dataList = body.getObj().getData();
        Secret_SelectAdapter secretSelectAdapter = new Secret_SelectAdapter(dataList, context,selectSqlHelp,selectSqlHelp1);

        secret_listView.setAdapter(secretSelectAdapter);



    }
}
