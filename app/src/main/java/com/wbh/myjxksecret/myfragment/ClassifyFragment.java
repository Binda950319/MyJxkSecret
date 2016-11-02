package com.wbh.myjxksecret.myfragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.activity.ShoppingActivity;
import com.wbh.myjxksecret.adapter.ClassifyListAdapter;
import com.wbh.myjxksecret.apiservice.ClassifyBeanData;
import com.wbh.myjxksecret.javabean.ClassifyBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/10/25 0025.
 */
public class ClassifyFragment extends Fragment {
    @BindView(R.id.global_classify_listview)
    PullToRefreshListView global_classify_listview;
    private List<ClassifyBean.ObjBean> obj;


    private Context context;

    public ClassifyFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.global_classify_fragment, container, false);
        ButterKnife.bind(this,view);
        global_classify_listview.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        getData();
        // TODO: 2016/10/27 listView点击事件
        global_classify_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String categoryId = obj.get(position-1).getCategoryId();
                String categoryName = obj.get(position-1).getCategoryName();
                Intent intent = new Intent(context, ShoppingActivity.class);
                intent.putExtra("categoryId",categoryId);
                intent.putExtra("categoryName",categoryName);

                startActivity(intent);
            }
        });
        return view;
    }



    public void  getData(){
       String baseUrl="http://app.interface.jescard.com/";
       Retrofit retrofit=new Retrofit.Builder()
               .baseUrl(baseUrl)
               .addConverterFactory(GsonConverterFactory.create())
               .build();
       ClassifyBeanData classifyBeanData = retrofit.create(ClassifyBeanData.class);
       Call<ClassifyBean> call = classifyBeanData.getClassifyBean();
       call.enqueue(new Callback<ClassifyBean>() {
           @Override
           public void onResponse(Call<ClassifyBean> call, Response<ClassifyBean> response) {
               obj = response.body().getObj();
               ClassifyListAdapter classifyListAdapter = new ClassifyListAdapter(context, obj, R.layout.item_global_classify);
               global_classify_listview.setAdapter(classifyListAdapter);
           }

           @Override
           public void onFailure(Call<ClassifyBean> call, Throwable t) {

           }
       });
    }



}
