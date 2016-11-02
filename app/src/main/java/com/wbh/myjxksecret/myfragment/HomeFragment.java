package com.wbh.myjxksecret.myfragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.squareup.picasso.Picasso;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.activity.HomeBannerDetailActivity;
import com.wbh.myjxksecret.activity.HomeFm_DrawBackActivity;
import com.wbh.myjxksecret.activity.HomeMallDetailActivity;
import com.wbh.myjxksecret.activity.Home_GoodsDetailActivity;
import com.wbh.myjxksecret.activity.Home_MoreDailyActivity;
import com.wbh.myjxksecret.activity.ShoppingActivity;
import com.wbh.myjxksecret.activity.ShowCouponActivity;
import com.wbh.myjxksecret.adapter.BannerAdapter;
import com.wbh.myjxksecret.adapter.Home_CountryAdapter;
import com.wbh.myjxksecret.adapter.Home_CouponAdapter;
import com.wbh.myjxksecret.adapter.Home_GoodsAdapter;
import com.wbh.myjxksecret.apiservice.GetHomeBanner;
import com.wbh.myjxksecret.javabean.HomeBean;
import com.wbh.myjxksecret.utils.HorizontalListView;
import com.wbh.myjxksecret.utils.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements Handler.Callback {
    //  http://app.interface.jescard.com/index/indexInfo.html
    @BindView(R.id.refreshScrollView)
    PullToRefreshScrollView refreshScrollView;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.home_headLayout)
    RelativeLayout home_headLayout;
    @BindView(R.id.home_viewPager)
    AutoScrollViewPager home_viewPager;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    @BindView(R.id.left_Brand)
    ImageView left_Brand;
    @BindView(R.id.right_Brand)
    ImageView right_Brand;
    @BindView(R.id.brand_listView)
    HorizontalListView brand_listView;
    @BindView(R.id.home_MallViewPager)
    AutoScrollViewPager home_MallViewPager;
    @BindView(R.id.home_mallName)
    TextView home_mallName;
    @BindView(R.id.home_mallCountry)
    TextView home_mallCountry;
    @BindView(R.id.coupon_listView)
    HorizontalListView coupon_listView;
    @BindView(R.id.home_countryRecycler)
    MyGridView home_countryRecycler;
    @BindView(R.id.iv_home_daily)
    ImageView iv_home_daily;
    @BindView(R.id.tv_home_country)
    TextView tv_home_country;
    @BindView(R.id.home_mallPointLlinear)
    LinearLayout home_mallPointLlinear;
    @BindView(R.id.iv_home_brand)
    ImageView iv_home_brand;
    @BindView(R.id.iv_home_sort)
    ImageView iv_home_sort;
    @BindView(R.id.iv_home_drawback)
    ImageView iv_home_drawback;
    @BindView(R.id.iv_home_memo)
    ImageView iv_home_memo;
    @BindView(R.id.rl_check_more)
    RelativeLayout rl_check_more;

    private String baseUrl = " http://app.interface.jescard.com/";
    private List<HomeBean.ObjBean.IndexBannerBean.BrannerListBean> brannerList;
    //    HomeBean body;
    private BannerAdapter bannerAdapter;
    Context context;
    private Intent intent;
    private Handler handler = new Handler(this);
    private View decorView;
    private RadioButton global_rb, bourn_rb, home_rb;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        decorView = activity.getWindow().getDecorView();
        global_rb = (RadioButton) decorView.findViewById(R.id.global_rb);
        bourn_rb = (RadioButton) decorView.findViewById(R.id.bourn_rb);
        home_rb = (RadioButton) decorView.findViewById(R.id.home_rb);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        //头部RelativeLayout获取焦点
        home_headLayout.setFocusable(true);
        home_headLayout.setFocusableInTouchMode(true);
        initScrollView();
        getResponse();
        return view;
    }

    //PullToRefreshScrollView刷新
    private void initScrollView() {
        refreshScrollView.setMode(PullToRefreshBase.Mode.BOTH);
        refreshScrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                handler.sendEmptyMessageDelayed(100, 2000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                handler.sendEmptyMessageDelayed(200, 2000);
            }
        });
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 100:
                refreshScrollView.onRefreshComplete();
                break;
            case 200:
                refreshScrollView.onRefreshComplete();
                break;
        }
        return false;
    }

    //Retrofit网络请数据
    public void getResponse() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetHomeBanner getHomeBanner = retrofit.create(GetHomeBanner.class);
        Call<HomeBean> call = getHomeBanner.getHomeBanner();
        call.enqueue(new Callback<HomeBean>() {
            @Override
            public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                HomeBean body = response.body();
                if (body != null) {
                    //头部Banner
                    getIndexBanner(body);
                    //经典大牌
                    getIndexBrandRecomment(body);
                    //热门商城
                    getIndexMall(body);
                    //优惠券
                    getIndexCoupon(body);
                    //热门目的地
                    indexCountry(body);
                    //旅行购时尚
                    indexDaily(body);
                }
            }

            @Override
            public void onFailure(Call<HomeBean> call, Throwable t) {
                Log.e("Bing", "******onFailure: ******" + t.getMessage());
            }
        });
    }

    //头部Banner
    private void getIndexBanner(HomeBean body) {
        brannerList = body.getObj().getIndexBanner().getBrannerList();
        List<View> list = new ArrayList<>();
        for (int i = 0; i < brannerList.size(); i++) {
            ImageView image = new ImageView(context);
            image.setImageResource(R.mipmap.default_drawing);
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(getActivity()).load(brannerList.get(i).getPic())
                    .placeholder(R.mipmap.default_drawing)
                    .into(image);
            list.add(image);
            clickBrannerViewPager(image, i, body);

            //加原点指示器
            ImageView point = new ImageView(context);
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            llp.setMargins(10, 0, 10, 0);
            point.setLayoutParams(llp);
            if (i == 0) {
                point.setBackgroundResource(R.drawable.blue_point);
            } else {
                point.setBackgroundResource(R.drawable.white_point);
            }
            linearLayout.addView(point);
        }
        bannerAdapter = new BannerAdapter(list);
        home_viewPager.setAdapter(bannerAdapter);
        home_viewPager.startAutoScroll();
        //设置是否开启动画；
        home_viewPager.setBorderAnimation(false);
        //设置自动轮播的时间间隔
        home_viewPager.setInterval(3000);
        //是否循环播放
        home_viewPager.setCycle(true);
        //设置手触摸滚动停止自动动；
        home_viewPager.setStopScrollWhenTouch(true);
        //home_viewPager的监听事件
        homeViewPagerLinstener();
    }

    //Branner点击事件
    private void clickBrannerViewPager(ImageView image, final int i, final HomeBean body) {
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeBean.ObjBean.IndexBannerBean.BrannerListBean brannerBean = brannerList.get(i);
                int goType = brannerBean.getGoType();
                String title = brannerBean.getTitle();
                Log.e("Bing", "******Branner的Title: ******"+title);
                String goValue = brannerBean.getGoValue();
                Log.e("Bing", "******Branner的goValue: ******"+goValue);
                Log.e("Bing", "******: ******"+goValue.contains(title));
                if (108 == goType) { //进入商品列表
                    intent = new Intent(context, HomeMallDetailActivity.class);
                    String[] str = brannerBean.getGoValue().split(",");
                    intent.putExtra("pic", str[2]);
                    intent.putExtra("mallId", str[1]);
                    Log.e("Bing", "******首页的Branner传送的MallId: ******"+str[1]);
                    startActivity(intent);
                } else { //进入WebView
                    intent = new Intent(context, HomeBannerDetailActivity.class);
                    if (goValue.contains(",")) {
                        String[] str = goValue.split(",");
                        goValue = str[1];
                    }
                    intent.putExtra("title", title);
                    intent.putExtra("goValue", goValue);
                    startActivity(intent);
                }
            }
        });
    }

    //home_viewPager的监听事件
    private void homeViewPagerLinstener() {
        home_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //获取所有child个数
                int count = linearLayout.getChildCount();
                for (int i = 0; i < count; i++) {
                    ImageView img = (ImageView) linearLayout.getChildAt(i);
                    if (i == position) {
                        //选中状态
                        img.setImageResource(R.drawable.blue_point);
                    } else {
                        //未选中状态
                        img.setImageResource(R.drawable.white_point);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //点击品牌
    @OnClick(R.id.iv_home_brand)
    public void onGlobal(View view) {
        home_rb.setChecked(false);
        global_rb.setChecked(true);
        GlobalFragment globalFragment = new GlobalFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, globalFragment).hide(new HomeFragment()).commit();
    }

    //点击分类
    @OnClick(R.id.iv_home_sort)
    public void onSort(View view) {
        home_rb.setChecked(false);
        global_rb.setChecked(true);
        GlobalFragment globalFragment = new GlobalFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, globalFragment).hide(new HomeFragment()).commit();

    }

    //点击退税
    @OnClick(R.id.iv_home_drawback)
    public void onDrawBack(View view) {
        intent = new Intent(context, HomeFm_DrawBackActivity.class);
        startActivity(intent);
    }

    //经典大牌
    public void getIndexBrandRecomment(HomeBean body) {
        final HomeBean.ObjBean.IndexBrandRecommentBean indexBrandRecomment = body.getObj().getIndexBrandRecomment();
        Picasso.with(context).load(indexBrandRecomment.getBrandList().get(0).getHomePic()).placeholder(R.mipmap.default_drawing).into(left_Brand);
        Picasso.with(context).load(indexBrandRecomment.getBrandList().get(1).getHomePic()).placeholder(R.mipmap.default_drawing).into(right_Brand);
        left_Brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, ShoppingActivity.class);
                HomeBean.ObjBean.IndexBrandRecommentBean.BrandListBean brandListBean = indexBrandRecomment.getBrandList().get(0);
                String brandId = brandListBean.getBrandId();
                Log.e("Bing", "******阿玛尼: ******" + brandId);
                String brandName = brandListBean.getBrandName();
                intent.putExtra("brandId", brandId);
                intent.putExtra("englishName", brandName);
                startActivity(intent);
            }
        });
        right_Brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, ShoppingActivity.class);
                HomeBean.ObjBean.IndexBrandRecommentBean.BrandListBean brandListBean = indexBrandRecomment.getBrandList().get(1);
                String brandId = brandListBean.getBrandId();
                Log.e("Bing", "******: ******" + brandId);
                String brandName = brandListBean.getBrandName();
                intent.putExtra("brandId", brandId);
                intent.putExtra("englishName", brandName);
                startActivity(intent);
            }
        });
        //经典大牌
        final List<HomeBean.ObjBean.IndexBrandRecommentBean.GoodsListBean> goodsList = indexBrandRecomment.getGoodsList();
        Home_GoodsAdapter goodsAdapter = new Home_GoodsAdapter(goodsList, context);
        brand_listView.setAdapter(goodsAdapter);
        brand_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HomeBean.ObjBean.IndexBrandRecommentBean.GoodsListBean goodsListBean = goodsList.get(position);
                String goodsId = goodsListBean.getGoodId();
                intent = new Intent(context, Home_GoodsDetailActivity.class);
                Log.e("Bing", "******不传MallId的商品详情_goodsId: ******" + goodsId);
                intent.putExtra("goodId", goodsId);
                startActivity(intent);
            }
        });

    }

    //热门商城
    private void getIndexMall(HomeBean body) {
        //热门商城
        final List<HomeBean.ObjBean.IndexMallBean.MallListBean> mallList = body.getObj().getIndexMall().getMallList();
        List<View> malls = new ArrayList<>();
        for (int i = 0; i < mallList.size(); i++) {
            ImageView image = new ImageView(context);
            image.setImageResource(R.mipmap.plugin_camera_no_pictures);
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(context).load(mallList.get(i).getHomePic()).placeholder(R.mipmap.default_drawing).into(image);
            malls.add(image);

            //ViewPager的点击事件
            clickMallViewPager(image, i, mallList);
            //加原点指示器
            ImageView point = new ImageView(context);
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            llp.setMargins(10, 0, 10, 0);
            point.setLayoutParams(llp);
            if (i == 0) {
                point.setBackgroundResource(R.drawable.blue_point);
            } else {
                point.setBackgroundResource(R.drawable.white_point);
            }
            home_mallPointLlinear.addView(point);
        }
        bannerAdapter = new BannerAdapter(malls);
        home_MallViewPager.setAdapter(bannerAdapter);
        home_MallViewPager.startAutoScroll();
        //设置是否开启动画；
        home_MallViewPager.setBorderAnimation(false);
        //设置自动轮播的时间间隔
        home_MallViewPager.setInterval(3000);
        //是否循环播放
        home_MallViewPager.setCycle(true);
        //设置手触摸滚动停止自动动；
        home_MallViewPager.setStopScrollWhenTouch(true);
        home_MallViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //国家切换
                home_mallName.setText(mallList.get(position).getMallName());
                home_mallCountry.setText(mallList.get(position).getCountryName());
                //获取所有child个数
                int count = home_mallPointLlinear.getChildCount();
                for (int i = 0; i < count; i++) {
                    ImageView img = (ImageView) home_mallPointLlinear.getChildAt(i);
                    if (i == position) {
                        //选中状态
                        img.setImageResource(R.drawable.blue_point);
                    } else {
                        //未选中状态
                        img.setImageResource(R.drawable.white_point);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    //热门商城点击
    private void clickMallViewPager(ImageView image, final int i, final List<HomeBean.ObjBean.IndexMallBean.MallListBean> mallList) {
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeBean.ObjBean.IndexMallBean.MallListBean mallListBean = mallList.get(i);
                intent = new Intent(context, HomeMallDetailActivity.class);
                String mallPic = mallListBean.getMallPic();
                String mallId = mallListBean.getMallId();
                intent.putExtra("mallId", mallId);
                intent.putExtra("pic", mallPic);
                startActivity(intent);
            }
        });
    }

    //优惠券
    private void getIndexCoupon(HomeBean body) {
        final List<HomeBean.ObjBean.IndexCouponBean.CouponListBean> couponList = body.getObj().getIndexCoupon().getCouponList();
        Home_CouponAdapter couponAdapter = new Home_CouponAdapter(couponList, context, R.layout.home_coupon_item);
        coupon_listView.setAdapter(couponAdapter);
        coupon_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(context, ShowCouponActivity.class);
                String couponId = couponList.get(position).getCouponId();
                intent.putExtra("couponId", couponId);
                startActivity(intent);
            }
        });
    }

    //热门目的地
    private void indexCountry(HomeBean body) {
        List<HomeBean.ObjBean.IndexCountryBean.CountryListBean> countryList = body.getObj().getIndexCountry().getCountryList();
        Home_CountryAdapter countryAdapter = new Home_CountryAdapter(countryList, context, R.layout.home_countrypic_item);
        home_countryRecycler.setAdapter(countryAdapter);

        home_countryRecycler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bourn_rb.setChecked(true);
                home_rb.setChecked(false);
                BournFragment bournFragment = new BournFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, bournFragment).hide(new HomeFragment()).commit();

            }
        });
    }

    //旅行购时尚
    private void indexDaily(final HomeBean body) {
        final List<HomeBean.ObjBean.IndexDailyBean.DailyListBean> dailyList = body.getObj().getIndexDaily().getDailyList();
        Picasso.with(context).load(dailyList.get(0).getRecommendedPiclink()).placeholder(R.mipmap.default_drawing).into(iv_home_daily);
        tv_home_country.setText(dailyList.get(0).getRecommendedTitle());
        iv_home_daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, HomeBannerDetailActivity.class);
                String goValue = dailyList.get(0).getRecommendedPagelink();
                String title = body.getObj().getIndexDaily().getName();
                intent.putExtra("title", title);
                intent.putExtra("goValue", goValue);
                startActivity(intent);
            }
        });
    }

    //点击更多
    @OnClick(R.id.rl_check_more)
    public void getMoreDaily(View view) {
        intent = new Intent(context, Home_MoreDailyActivity.class);
        startActivity(intent);
    }

}
