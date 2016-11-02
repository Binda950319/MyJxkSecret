package com.wbh.myjxksecret.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.adapter.MallGoodsAdapter;
import com.wbh.myjxksecret.adapter.Mall_CategoryGoodsAdapter;
import com.wbh.myjxksecret.apiservice.GetMallCategoryGoods;
import com.wbh.myjxksecret.apiservice.GetMallDetail;
import com.wbh.myjxksecret.javabean.MallCategoryGoods;
import com.wbh.myjxksecret.javabean.MallDetailBean;
import com.wbh.myjxksecret.utils.MyGridView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeMallDetailActivity extends AppCompatActivity {

    //    http://app.interface.jescard.com/interimGoods/getPopularityByMall.html
    String baseUrl = "http://app.interface.jescard.com/";
    @BindView(R.id.mall_scrollView)
    ScrollView mall_scrollView;
    @BindView(R.id.iv_banner_back)
    ImageView iv_banner_back;
    @BindView(R.id.rl_mall_search)
    RelativeLayout rl_mall_search;
    @BindView(R.id.iv_mall)
    ImageView iv_mall;
    @BindView(R.id.iv_mallIcon)
    CircleImageView iv_mallIcon;
    @BindView(R.id.tv_mallType)
    TextView tv_mallType;
    @BindView(R.id.tv_mallPresetCnt)
    TextView tv_mallPresetCnt;
    @BindView(R.id.tv_mallPraiseCount)
    TextView tv_mallPraiseCount;
    @BindView(R.id.tv_mallRecommendedLevel)
    TextView tv_mallRecommendedLevel;
    @BindView(R.id.gv_mallgoods)
    MyGridView gv_mallgoods;
    @BindView(R.id.toolbar_mallCategory)
    Toolbar toolbar_mallCategory;
    @BindView(R.id.tabL_mall_category)
    TabLayout tabL_mall_category;
    @BindView(R.id.gv_mallCategoryGoods)
    PullToRefreshGridView gv_mallCategoryGoods;
    private Intent intent;
    private Mall_CategoryGoodsAdapter goodsAdapter;
    //默认Tablayout选中第一条;
    private int position = 0;
    private int page = 1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 100:
                    gv_mallCategoryGoods.onRefreshComplete();
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mall_category_goods);
        ButterKnife.bind(this);
        mall_scrollView.smoothScrollTo(0, 0);
        getCallBack();
        getRetrfit();
    }

    @OnClick(R.id.iv_banner_back)
    public void backHome(View view) {
        finish();
    }

    @OnClick(R.id.rl_mall_search)
    public void search(View view) {
        Toast.makeText(HomeMallDetailActivity.this, "搜索", Toast.LENGTH_SHORT).show();
    }


    public void getCallBack() {
        intent = getIntent();
        String pic = intent.getStringExtra("pic");
        Glide.with(this).load(pic).placeholder(R.mipmap.default_drawing).into(iv_mall);
        Glide.with(this).load(pic).into(iv_mallIcon);
    }

    public void getRetrfit() {
        String mallId = intent.getStringExtra("mallId");
        Log.e("Bing", "******HomeMallDetailActivity收到的MallId: ******"+mallId);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetMallDetail mallDetail = retrofit.create(GetMallDetail.class);
        Map<String, String> map = new HashMap<>();
        map.put("mallId", mallId);
        Call<MallDetailBean> call = mallDetail.getMallDetail(map);
        call.enqueue(new Callback<MallDetailBean>() {
            @Override
            public void onResponse(Call<MallDetailBean> call, Response<MallDetailBean> response) {
                MallDetailBean body = response.body();
                if (body != null) {
                    //根据mallId得到品牌商品页面头部Banner
                    getMallInfo(body);
                    //人气单品
                    getMallHotGoods(body);
                    //全部商品Tab
                    getTabTitle(body);
                    //全部商品列表
                    getCategoryGoodsList(body, 0);
                    onRefreshCategoryGoods(body, 0);
                }
            }

            @Override
            public void onFailure(Call<MallDetailBean> call, Throwable t) {
                Log.e("Bing", "******根据mallId得到品牌商品页面onFailure: ******" + t.getMessage());
            }
        });

    }

    //全部商品Tab
    private void getTabTitle(final MallDetailBean body) {
        final List<MallDetailBean.ObjBean.CategoryListBean> categoryList = body.getObj().getCategoryList();
        int size = categoryList.size();
        tabL_mall_category.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < size; i++) {
            MallDetailBean.ObjBean.CategoryListBean bean = categoryList.get(i);
            tabL_mall_category.addTab(tabL_mall_category.newTab().setText(bean.getCategoryName()));
        }
        //TabLayout的选择点击监听
        tabL_mall_category.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 position = tab.getPosition();
                getCategoryGoodsList(body, position);
                goodsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    //全部商品列表, 有分页
    private void getCategoryGoodsList(final MallDetailBean body, final int position) {
        String url = "http://app.interface.jescard.com/";
        List<MallDetailBean.ObjBean.CategoryListBean> categoryList = body.getObj().getCategoryList();
        String categoryId = categoryList.get(position).getCategoryId();
        String mallId = body.getObj().getCategoryGoodsList().getData().get(position).getMallId();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Map<String, Object> map = new HashMap<>();
        map.put("categoryId", categoryId);
        map.put("pagesize", 20);
        map.put("page", page);
        map.put("mallId", mallId);
        GetMallCategoryGoods categoryGoods = retrofit.create(GetMallCategoryGoods.class);
        Call<MallCategoryGoods> call = categoryGoods.getCategoryGoods(map);
        call.enqueue(new Callback<MallCategoryGoods>() {
            @Override
            public void onResponse(Call<MallCategoryGoods> call, Response<MallCategoryGoods> response) {
                MallCategoryGoods goods = response.body();
                if (goods!=null){
                    makeCategoryGoods(body, goods);
                }

            }

            @Override
            public void onFailure(Call<MallCategoryGoods> call, Throwable t) {
                Log.e("Bing", "******CategoryGoods商品列表onFailure: ******" + t.getMessage());
            }
        });


    }
    //填充商品数据
    private void makeCategoryGoods(MallDetailBean body, MallCategoryGoods goods) {
        final List<MallCategoryGoods.ObjBean.DataBean> dataBeen = goods.getObj().getData();
        goodsAdapter = new Mall_CategoryGoodsAdapter(this);
        goodsAdapter.setDataBeen(dataBeen);
        gv_mallCategoryGoods.setAdapter(goodsAdapter);
        onRefreshCategoryGoods(body, position);

        gv_mallCategoryGoods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(HomeMallDetailActivity.this, GoodsDetailActivity.class);
                String goodsId = dataBeen.get(position).getGoodsId();
                String mallId = dataBeen.get(position).getMallId();
                intent.putExtra("goodsId", goodsId);
                intent.putExtra("mallId", mallId);
                startActivity(intent);
            }
        });
    }

    //上拉加载更多商品
    private void onRefreshCategoryGoods(final MallDetailBean body, final int position){
        gv_mallCategoryGoods.setMode(PullToRefreshBase.Mode.PULL_FROM_END);
        gv_mallCategoryGoods.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<GridView>() {
            @Override
            public void onRefresh(PullToRefreshBase<GridView> refreshView) {
                page++;
                getCategoryGoodsList(body, position);
                handler.sendEmptyMessageDelayed(100, 2000);
            }
        });
    }

    //根据mallId得到品牌商品页面头部Banner
    private void getMallInfo(MallDetailBean body) {
        MallDetailBean.ObjBean.MallInfoBean mallInfo = body.getObj().getMallInfo();
        String mallPic = mallInfo.getMallPic();
        Log.e("Bing", "******MallPic: ******"+mallPic);
//        Glide.with(this).load(mallPic).placeholder(R.mipmap.default_drawing).into(iv_mallIcon);
        String mallType = mallInfo.getMallName() + " • " + mallInfo.getMallType();
        tv_mallType.setText(mallType);
        tv_mallPresetCnt.setText(mallInfo.getPresetCnt() + "预定");
        tv_mallPraiseCount.setText(mallInfo.getPraiseCount() + "赞");
        tv_mallRecommendedLevel.setText("推荐星级: " + mallInfo.getRecommendedLevel());
    }

    //人气单品
    private void getMallHotGoods(MallDetailBean body) {
        final List<MallDetailBean.ObjBean.Hot10goodsBean> hotGoodsList = body.getObj().getHot10goods();
        MallGoodsAdapter goodsAdapter = new MallGoodsAdapter(hotGoodsList, this, R.layout.mallgoods_item_layout);
        gv_mallgoods.setAdapter(goodsAdapter);

        gv_mallgoods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(HomeMallDetailActivity.this, GoodsDetailActivity.class);
                String goodsId = hotGoodsList.get(position).getGoodsId();
                String mallId = hotGoodsList.get(position).getMallId();
                intent.putExtra("goodsId", goodsId);
                intent.putExtra("mallId", mallId);
                startActivity(intent);
            }
        });
    }


}
