package com.wbh.myjxksecret.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.RelativeLayout;

import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.adapter.ChoiceContoryAdatper;
import com.wbh.myjxksecret.apiservice.ChiceBeanData;
import com.wbh.myjxksecret.javabean.ChiceControyBean;
import com.wbh.myjxksecret.utils.ControyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BoursChiceActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.chice_exlisetview)
    ExpandableListView expandableListView;
    @BindView(R.id.choice_header)
    RelativeLayout titlebar;
    private List<String> contoryList;
    private List<List<String>> totalList;

    @BindView(R.id.hehe)
    ControyView controyView;
//    @BindView(R.id.teach_selected_letter)
//    TextView tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bours_chice);
        ButterKnife.bind(this);
        //加载数据
        getData();
        //头部点击监听
        titlebar.setOnClickListener(BoursChiceActivity.this);
        //expandableListView的子Item监听事件
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String contory = totalList.get(groupPosition).get(childPosition);

                Intent intent = new Intent();
                intent.putExtra("contoryid",contory);
                Log.e("33333333333333333", "onChildClick: "+contory );
                setResult(200,intent);



                finish();
                return false;
            }
        });
        controyView.setselectedItem(expandableListView);
    }
    // TODO: 2016/10/25  网络获取数据
    public void getData(){
        String baseUrl="http://app.interface.jescard.com/";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ChiceBeanData chiceBeanData = retrofit.create(ChiceBeanData.class);
        Call<ChiceControyBean> call = chiceBeanData.getChiceBean();
        call.enqueue(new Callback<ChiceControyBean>() {
            @Override
            public void onResponse(Call<ChiceControyBean> call, Response<ChiceControyBean> response) {
                setData(response);
            }

            @Override
            public void onFailure(Call<ChiceControyBean> call, Throwable t) {

            }
        });
    }

    // TODO: 2016/10/26  加载数据
    public void setData(Response<ChiceControyBean> response){
        int size = response.body().getObj().getCountryList().size();
        contoryList=new ArrayList<String>();
        List<String> asia= new ArrayList<>();
        List<String>  europe= new ArrayList<>();
        List<String>  america= new ArrayList<>();
        List<String>  oceania= new ArrayList<>();
        List<String>  africa= new ArrayList<>();
        List<String>  hot= new ArrayList<>();
        totalList=new ArrayList<List<String>>();
        contoryList.add("热门目的地");
        contoryList.add("亚洲");
        contoryList.add("欧洲");
        contoryList.add("美洲");
        contoryList.add("大洋洲");
        contoryList.add("非洲");
        for (int i = 0; i < size; i++) {
            String region = response.body().getObj().getCountryList().get(i).getRegion();
            if (region.equals("亚洲")){
                String info=response.body().getObj().getCountryList().get(i).getChineseName()+"."+response.body().getObj().getCountryList().get(i).getEnglishName();
                asia.add(info);
            }else if (region.equals("欧洲")){
                String info=response.body().getObj().getCountryList().get(i).getChineseName()+"."+response.body().getObj().getCountryList().get(i).getEnglishName();
                europe.add(info);
            }else if(region.equals("美洲")){
                String info=response.body().getObj().getCountryList().get(i).getChineseName()+"."+response.body().getObj().getCountryList().get(i).getEnglishName();
                america.add(info);
            }else if(region.equals("大洋洲")){
                String info=response.body().getObj().getCountryList().get(i).getChineseName()+"."+response.body().getObj().getCountryList().get(i).getEnglishName();
                oceania.add(info);
            }else if (region.equals("非洲")){
                String info=response.body().getObj().getCountryList().get(i).getChineseName()+"."+response.body().getObj().getCountryList().get(i).getEnglishName();
                africa.add(info);
            }else {
                Log.e("info", "onResponse: " );
            }
        }
        //热门数据
        int size1 = response.body().getObj().getHotCountryList().size();
        for (int i = 0; i < size1; i++) {
            String info=  response.body().getObj().getHotCountryList().get(i).getChineseName()+"."+response.body().getObj().getHotCountryList().get(i).getEnglishName();
            hot.add(info);
        }
        totalList.add(hot);
        totalList.add(asia);
        totalList.add(europe);
        totalList.add(america);
        totalList.add(oceania);
        totalList.add(africa);
        ChoiceContoryAdatper choiceContoryAdatper = new ChoiceContoryAdatper(contoryList, totalList, BoursChiceActivity.this);
        expandableListView.setAdapter(choiceContoryAdatper);
        expandableListView.setGroupIndicator(null);
        for(int i = 0; i < choiceContoryAdatper.getGroupCount(); i++){

            expandableListView.expandGroup(i);

        }


    }

    // TODO: 2016/10/26 返回上一界面的bar监听
    @Override
    public void onClick(View v) {
        finish();
    }

}
