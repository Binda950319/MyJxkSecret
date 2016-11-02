package com.wbh.myjxksecret.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.adapter.ChoiceBournAdatper;
import com.wbh.myjxksecret.adapter.ShopBournAdatper;
import com.wbh.myjxksecret.adapter.ShopBrandGridAdapter;
import com.wbh.myjxksecret.adapter.ShopClassifAadapter;
import com.wbh.myjxksecret.adapter.ShopGridAdapetr;
import com.wbh.myjxksecret.adapter.ShopPriceAadapter;
import com.wbh.myjxksecret.apiservice.BrandBeanData;
import com.wbh.myjxksecret.apiservice.ShopBeanBrandData;
import com.wbh.myjxksecret.apiservice.ShopBeanData;
import com.wbh.myjxksecret.apiservice.ShopClassifyBeanData;
import com.wbh.myjxksecret.javabean.BrandBean;
import com.wbh.myjxksecret.javabean.ShopBean;
import com.wbh.myjxksecret.javabean.ShopBrandBean;
import com.wbh.myjxksecret.javabean.ShopClassifyBean;
import com.wbh.myjxksecret.utils.GobalView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShoppingActivity extends AppCompatActivity implements View.OnClickListener {

    private String categoryId;
    private String categoryName;
    private int page=1;
    private int pagesize=20;
    @BindView(R.id.shopping_goback)
    ImageView shopping_goback;
    @BindView(R.id.shoplayout_gridView)
    PullToRefreshGridView shoplayout_gridView;
    @BindView(R.id.shop_title)
    TextView shop_title;
    @BindView(R.id.shopping_classify)
    RelativeLayout shopping_classify;
    @BindView(R.id.shopping_brand)
    RelativeLayout shopping_brand;
    @BindView(R.id.shopping_choice)
    RelativeLayout shopping_choice;
    private  List<ShopClassifyBean.ObjBean> obj1=new ArrayList<>();
    private  List<ShopClassifyBean.ObjBean> popobj=new ArrayList<>();
    @BindView(R.id.shoplayout_choice)
    LinearLayout shoplayout_choice;

    private boolean open=false;
    private ShopGridAdapetr shopGridAdapetr;
    private List<ShopBean.ObjBean.DataBean> data;
    private String brandId;
    private String englishName;
    private  ShopBrandGridAdapter shopBrandGridAdapter;
    private View popClassify;
    private ListView classifyList;
    private List<String> groupList=new ArrayList<>();
    private List<List<String>> totalList=new ArrayList<>();
    private View popBrand;
    private ExpandableListView exbrandList;
    private BrandBean responseforbrand;
    private GobalView brandView;
    private List<ShopBrandBean.ObjBean.DataBean> data1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);
        Intent intent = getIntent();
        categoryId = intent.getStringExtra("categoryId");
        Log.e("ddddd", "onCreate: "+categoryId );
        categoryName = intent.getStringExtra("categoryName");


        ButterKnife.bind(this);
        getData(categoryId);
        shop_title.setText(categoryName);
        shopping_classify.setOnClickListener(this);
        shopping_brand.setOnClickListener(this);
        shopping_choice.setOnClickListener(this);

        gridView();

        classifyData();

        getDatabrand();



    }
    //gridView的监听
    private void gridView() {
        shoplayout_gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String goodsId = data.get(position).getGoodsId();
                Intent intent = new Intent(ShoppingActivity.this,Home_GoodsDetailActivity.class);
                intent.putExtra("goodId",goodsId);
                startActivity(intent);
            }
        });
    }


    @OnClick(R.id.shopping_goback)
    public void clickBack(View view){
        finish();
    }
    // TODO: 2016/10/27 gridView加载数据cateid
    public void getData(String cc){
        String baseUrl="http://app.interface.jescard.com/";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ShopBeanData shopBeanData = retrofit.create(ShopBeanData.class);
        Log.e("11111111111111111111", "getData: "+cc );
        Call<ShopBean> call = shopBeanData.getShopBeanBean(cc,page,pagesize);
        call.enqueue(new Callback<ShopBean>() {
            @Override
            public void onResponse(Call<ShopBean> call, Response<ShopBean> response) {
                int size = response.body().getObj().getData().size();
                data = response.body().getObj().getData();
                for (int i = 0; i < size; i++) {
                    ShopBean.ObjBean.DataBean dataBean = response.body().getObj().getData().get(i);
                    data.add(dataBean);
                }
                shopGridAdapetr = new ShopGridAdapetr(ShoppingActivity.this, data, R.layout.item_shop_grid);
                shoplayout_gridView.setAdapter(shopGridAdapetr);
            }

            @Override
            public void onFailure(Call<ShopBean> call, Throwable t) {
            }
        });
    }

    // TODO: 2016/10/27 加载 分类
    public void classifyData(){

        String baseUrl="http://app.interface.jescard.com/";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ShopClassifyBeanData shopClassifyBeanData = retrofit.create(ShopClassifyBeanData.class);
        Call<ShopClassifyBean> call = shopClassifyBeanData.getShopClassifyBeanBean(categoryId);
        call.enqueue(new Callback<ShopClassifyBean>() {
            @Override
            public void onResponse(Call<ShopClassifyBean> call, Response<ShopClassifyBean> response) {
                obj1 = response.body().getObj();
                popobj.addAll(obj1);
            }
            @Override
            public void onFailure(Call<ShopClassifyBean> call, Throwable t) {

            }
        });
    }

    //品牌
    public void getDatabrand() {
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
                responseforbrand = response.body();
                getexpa();
            }
            @Override
            public void onFailure(Call<BrandBean> call, Throwable t) {

            }
        });
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
    // TODO: 2016/10/27  填充可拓展ListView
    public void setListViewData(BrandBean responseforbrand,ExpandableListView exbrandList){
        int brandsize = responseforbrand.getObj().getBrandList().size();


        String[] LETTERS = {"A","B","C","D","E","F","G","H","I",
                "J","K","L","M","N","O","P","R","S","T","U","V","W","Y","Z","#"};

        totalList=new ArrayList<List<String>>();

        for (int i = 0; i < LETTERS.length; i++) {
            //a的对象集合
            List<BrandBean.ObjBean.BrandListBean.BrandListBean2> brandList = responseforbrand.getObj().getBrandList().get(i).getBrandList();
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
        ChoiceBournAdatper choiceBournAdatper1 = new ChoiceBournAdatper(groupList, totalList, ShoppingActivity.this);
        exbrandList.setAdapter(choiceBournAdatper1);
        exbrandList.setGroupIndicator(null);
//        for(int i = 0; i < choiceBournAdatper.getGroupCount(); i++){
//
//            global_classify_expandListView.expandGroup(i);
//
//        }




    }

    // TODO: 2016/10/27 选择器的监听,并弹出对话框
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shopping_classify:
                popClassify = LayoutInflater.from(this).inflate(R.layout.shop_pop_layout, null, false);
                classifyList = (ListView) popClassify.findViewById(R.id.pop_classify_list);
                ShopClassifAadapter shopClassifAadapter = new ShopClassifAadapter(this, popobj, R.layout.shop_pop_item);
                classifyList.setAdapter(shopClassifAadapter);
                final PopupWindow popupWindow = new PopupWindow(popClassify, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, false);

                popupWindow.setTouchable(true);
                popupWindow.setOutsideTouchable(true);
                // 配合 点击外部区域消失使用 否则 没有效果
                popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.classify_backgrand));
                classifyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String categoryIdpop = popobj.get(position).getCategoryId();
                        popupWindow.dismiss();
                        getData(categoryIdpop);
                    }
                });
                popupWindow.showAsDropDown(shoplayout_choice, 0, 0);
                break;
            case R.id.shopping_brand:
                popBrand = LayoutInflater.from(this).inflate(R.layout.shop_pop_brand_layout, null, false);
                exbrandList = ((ExpandableListView) popBrand.findViewById(R.id.pop_brand_expandlistview));
                brandView = ((GobalView) popBrand.findViewById(R.id.gobal_brand));
                Log.e("qwqwqwqwq", "onClick: "+groupList.size() );
                Log.e("qwqwqwqwq", "onClick: "+totalList.get(0).size() );
                ShopBournAdatper shopBournAdatper = new ShopBournAdatper(groupList,totalList,this);
                exbrandList.setAdapter(shopBournAdatper);
                exbrandList.setGroupIndicator(null);

                for(int i = 0; i < shopBournAdatper.getGroupCount(); i++){

                    exbrandList.expandGroup(i);

                }
                brandView.setselectedItem(exbrandList);
                final PopupWindow brandpopupWindow = new PopupWindow(popBrand, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, false);

                brandpopupWindow.setTouchable(true);
                brandpopupWindow.setOutsideTouchable(true);
                // 配合 点击外部区域消失使用 否则 没有效果
                brandpopupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.classify_backgrand));

                exbrandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                        String brandId11 = responseforbrand.getObj().getBrandList().get(groupPosition).getBrandList().get(childPosition).getBrandId();
                        Log.e("45454545454", "onChildClick: "+brandId11 );
                        getbrandIdData(pagesize,brandId11,page);
                        brandpopupWindow.dismiss();
                        return false;
                    }
                });
                brandpopupWindow.showAsDropDown(shoplayout_choice, 0, 0);
                break;
            case R.id.shopping_choice:
                popClassify = LayoutInflater.from(this).inflate(R.layout.shop_pop_layout, null, false);
                classifyList = (ListView) popClassify.findViewById(R.id.pop_classify_list);
                List<String> price=new ArrayList<>();
                price.add("价格从高到低");
                price.add("价格从低到高");
                ShopPriceAadapter shopPriceAadapter1 = new ShopPriceAadapter(this, price, R.layout.shop_pop_item);
                classifyList.setAdapter(shopPriceAadapter1);
                final PopupWindow popupWindow2 = new PopupWindow(popClassify, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, false);

                popupWindow2.setTouchable(true);
                popupWindow2.setOutsideTouchable(true);
                // 配合 点击外部区域消失使用 否则 没有效果
                popupWindow2.setBackgroundDrawable(getResources().getDrawable(R.drawable.classify_backgrand));
                classifyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        popupWindow2.dismiss();

                    }
                });
                popupWindow2.showAsDropDown(shoplayout_choice, 0, 0);
                break;
        }
    }
    // TODO: 2016/10/31 得到exlistView
    public void getexpa(){
        newList();


//                setListViewData(responseforbrand,exbrandList);


        String[] LETTERS = {"A","B","C","D","E","F","G","H","I",
                "J","K","L","M","N","O","P","R","S","T","U","V","W","Y","Z","#"};

        totalList=new ArrayList<List<String>>();

        for (int i = 0; i < LETTERS.length; i++) {
            //a的对象集合
            List<BrandBean.ObjBean.BrandListBean.BrandListBean2> brandList = responseforbrand.getObj().getBrandList().get(i).getBrandList();

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


    }

    public void getbrandIdData(int pagesize,String cc,int page){
        String baseUrl="http://app.interface.jescard.com/";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ShopBeanBrandData shopBeanBrandDataData = retrofit.create(ShopBeanBrandData.class);

        Call<ShopBrandBean> call = shopBeanBrandDataData.getShopbrandBeanBean(pagesize,cc,page);
        call.enqueue(new Callback<ShopBrandBean>() {


            @Override
            public void onResponse(Call<ShopBrandBean> call, Response<ShopBrandBean> response) {
                data1 = response.body().getObj().getData();

                Log.e("yuyuyuyuyuy", "onResponse: "+data1.size() );

                shopGridAdapetr = new ShopGridAdapetr(ShoppingActivity.this, data, R.layout.item_shop_grid);
                shoplayout_gridView.setAdapter(shopGridAdapetr);
            }
            @Override
            public void onFailure(Call<ShopBrandBean> call, Throwable t) {
            }
        });
    }
}
