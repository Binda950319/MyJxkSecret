package com.wbh.myjxksecret.myfragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.activity.ShoppingSecondActivity;
import com.wbh.myjxksecret.adapter.BrandHotAdapter;
import com.wbh.myjxksecret.adapter.ChoiceBournAdatper;
import com.wbh.myjxksecret.apiservice.BrandBeanData;
import com.wbh.myjxksecret.javabean.BrandBean;
import com.wbh.myjxksecret.utils.AbcdView;
import com.wbh.myjxksecret.utils.MyExpandView;
import com.wbh.myjxksecret.utils.MyGridView;

import java.util.ArrayList;
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
public class BrandFragment extends Fragment {
    @BindView(R.id.global_classify_gridview)
    MyGridView global_classify_gridview;
    @BindView(R.id.brand_hot_changetv)
    TextView brand_hot_changetv;
    @BindView(R.id.global_classify_expandListView)
    MyExpandView global_classify_expandListView;
    @BindView(R.id.abcd)
    AbcdView abcdView;
    private int change=6;
    private int getchange;
    private List<BrandBean.ObjBean.HotBrandListBean> hotBrandList=new ArrayList<>();
    private List<BrandBean.ObjBean.HotBrandListBean> firsthotBrandList=new ArrayList<>();
    private int size=0;
    private Context context;
    private BrandHotAdapter brandHotAdapter;
    private List<String> groupList;
    private List<List<String>> totalList;


    public BrandFragment(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.global_brandd_fragment, container, false);
        ButterKnife.bind(this,view);
        getData();
        changeGrid();
        global_classify_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String brandId = firsthotBrandList.get(position).getBrandId();
                String englishName = firsthotBrandList.get(position).getEnglishName();
                Intent intent = new Intent(context, ShoppingSecondActivity.class);
                intent.putExtra("brandId",brandId);
                intent.putExtra("englishName",englishName);
                Log.e("ccccccccccccc", "onItemClick: "+firsthotBrandList.get(position).getChineseName() );
                startActivity(intent);
            }
        });

        abcdView.setselectedItem(global_classify_expandListView);
        return view;
    }

    // TODO: 2016/10/27 加载数据 填充第一次gridView
    public void getData() {
        String baseUrl="http://app.interface.jescard.com/";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        BrandBeanData brandBeanData = retrofit.create(BrandBeanData.class);
        Call<BrandBean> call = brandBeanData.getBrandBean();
        call.enqueue(new Callback<BrandBean>() {
            @Override
            public void onResponse(Call<BrandBean> call, Response<BrandBean> response) {
                size = response.body().getObj().getHotBrandList().size();
                hotBrandList = response.body().getObj().getHotBrandList();
                for (int i = 0; i < 6; i++) {
                    BrandBean.ObjBean.HotBrandListBean hotBrandListBean = response.body().getObj().getHotBrandList().get(i);
                    firsthotBrandList.add(hotBrandListBean);
                }
                brandHotAdapter = new BrandHotAdapter(context,firsthotBrandList, R.layout.item_brand_hot);
                global_classify_gridview.setAdapter(brandHotAdapter);
                setListViewData(response);
            }
            @Override
            public void onFailure(Call<BrandBean> call, Throwable t) {

            }
        });
    }

    // TODO: 2016/10/27 点击切换gridView
    public void changeGrid(){
        //监听换一换
        brand_hot_changetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.brand_hot_changetv:
                        getchange=change+6;
                        firsthotBrandList.clear();
                        if (getchange<size&&change<getchange){
                            for (int i = change; i <getchange ; i++) {
                                firsthotBrandList.add(hotBrandList.get(i));
                            }
                            change=getchange;
                            brandHotAdapter.notifyDataSetChanged();
                        }else {
                            change=0;
                            getchange=change+6;
                            for (int i = change; i < getchange; i++) {
                                firsthotBrandList.add(hotBrandList.get(i));
                            }
                            change=getchange;
                            brandHotAdapter.notifyDataSetChanged();
                        }
                        break;
                }
            }
        });
    }
    // TODO: 2016/10/27  填充可拓展ListView
    public void setListViewData(Response<BrandBean> response){
        int brandsize = response.body().getObj().getBrandList().size();
        newList();

        String[] LETTERS = {"A","B","C","D","E","F","G","H","I",
                "J","K","L","M","N","O","P","R","S","T","U","V","W","Y","Z","#"};

        totalList=new ArrayList<List<String>>();

        for (int i = 0; i < LETTERS.length; i++) {
            //a的对象集合
            List<BrandBean.ObjBean.BrandListBean.BrandListBean2> brandList = response.body().getObj().getBrandList().get(i).getBrandList();
            int sizea = brandList.size();
            List<String> aaList = new ArrayList<>();
            for (int m = 0; m < sizea; m++) {
                String englishName = brandList.get(m).getEnglishName();
                String chineseName = brandList.get(m).getChineseName();
                String recommend = brandList.get(m).getRecommend();
                String totalInfo=englishName+"-"+chineseName+"."+recommend;
                aaList.add(totalInfo);
            }
            totalList.add(aaList);
        }
        Log.e("qwqwqwqwq1111", "onClick: "+groupList.size() );
        Log.e("qwqwqwqwq1111", "onClick: "+totalList.get(0).size() );
        ChoiceBournAdatper choiceBournAdatper = new ChoiceBournAdatper(groupList, totalList, context);
        global_classify_expandListView.setAdapter(choiceBournAdatper);
        global_classify_expandListView.setGroupIndicator(null);
//        for(int i = 0; i < choiceBournAdatper.getGroupCount(); i++){
//
//            global_classify_expandListView.expandGroup(i);
//
//        }




    }
    // TODO: 2016/10/27  数组初始化
    public void newList(){
        groupList=new ArrayList<>();
        groupList.add("A");
        groupList.add("B");
        groupList.add("C");
        groupList.add("D");
        groupList.add("E");
        groupList.add("F");
        groupList.add("G");
        groupList.add("H");
        groupList.add("I");
        groupList.add("G");
        groupList.add("K");
        groupList.add("L");
        groupList.add("M");
        groupList.add("N");
        groupList.add("O");
        groupList.add("P");

        groupList.add("R");
        groupList.add("S");
        groupList.add("T");
        groupList.add("U");
        groupList.add("V");
        groupList.add("W");

        groupList.add("Y");
        groupList.add("Z");
        groupList.add("#");

    }
}
