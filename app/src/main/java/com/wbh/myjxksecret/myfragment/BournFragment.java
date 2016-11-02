package com.wbh.myjxksecret.myfragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.squareup.picasso.Picasso;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.activity.BoursChiceActivity;
import com.wbh.myjxksecret.activity.ConponActivity;
import com.wbh.myjxksecret.activity.GoodsDetailActivity;
import com.wbh.myjxksecret.activity.HomeBannerDetailActivity;
import com.wbh.myjxksecret.activity.HomeMallDetailActivity;
import com.wbh.myjxksecret.activity.ShowCouponActivity;
import com.wbh.myjxksecret.adapter.BournControyAdapter;
import com.wbh.myjxksecret.adapter.BournCouponAdapter;
import com.wbh.myjxksecret.adapter.BournStoreAdapter;
import com.wbh.myjxksecret.adapter.BournViewpagerAdapter;
import com.wbh.myjxksecret.apiservice.BournBeanData;
import com.wbh.myjxksecret.javabean.BournBean;
import com.wbh.myjxksecret.utils.HorizontalListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class BournFragment extends Fragment {

    @BindView(R.id.pullListView)
    PullToRefreshScrollView pullListView;
    @BindView(R.id.bourn_coupon_couponlistview)
    HorizontalListView couponListView;
    //本土必败
    @BindView(R.id.bourn_coutroy_listview)
    HorizontalListView controyListView;
    //人气商城
    @BindView(R.id.bourn_store_listview)
    ListView storeListview;
    //小点
    @BindView(R.id.bourn_point_container)
    LinearLayout point_container;
    @BindView(R.id.bourn_chice_bourn)
    RelativeLayout bourn_chice_btn;
    @BindView(R.id.bourn_chane_tv)
    TextView title;
    //点击更多优惠券
    @BindView(R.id.bourn_coupon)
    RelativeLayout bourn_coupon;


    private BournBeanData bournBeanData;
    private Call<BournBean> japan;
    private AutoScrollViewPager bourn_viewPager;
    private List<View> viewList = new ArrayList<>();
    private Context context;
    private String firstcontoryid = "Japan";
    private List<BournBean.ObjBean.CouponListBean> couponList;
    private List<BournBean.ObjBean.PopularMallListBean> popularMallList;
    private List<BournBean.ObjBean.TopGoodsListBean> topGoodsList;


    public BournFragment() {

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bourn, container, false);
        ButterKnife.bind(this, view);
        pullListView.getRefreshableView().smoothScrollTo(0, 0);
        getData(firstcontoryid,viewList);
        bourn_viewPager = ((AutoScrollViewPager) view.findViewById(R.id.bourn_viewpager));
        //优惠跳转
        bourn_coupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ConponActivity.class);
                intent.putExtra("firstcontoryid", firstcontoryid);
                startActivity(intent);
            }
        });

        //优惠券ListView跳转
        couponListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String couponId = couponList.get(position).getCouponId();
                Intent intent = new Intent(context, ShowCouponActivity.class);
                intent.putExtra("couponId", couponId);
                startActivity(intent);

            }
        });

        //人气商场的跳转
        storeListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mallId = popularMallList.get(position).getMallId();
                Log.e("77777777777", "onItemClick: " + mallId);
                String mallPic = popularMallList.get(position).getMallPic();
                Intent intent = new Intent(context, HomeMallDetailActivity.class);
                intent.putExtra("pic", mallPic);
                intent.putExtra("mallId", mallId);
                startActivity(intent);

            }
        });


        controyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mallId = topGoodsList.get(position).getMallId();
                String goodsNo = topGoodsList.get(position).getGoodsNo();
                Intent intent = new Intent(context, GoodsDetailActivity.class);
                intent.putExtra("goodsId", goodsNo);
                intent.putExtra("mallId", mallId);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        bourn_chice_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BoursChiceActivity.class);
                startActivityForResult(intent,200);
//                startActivity(intent);

            }

        });

    }

    // TODO: 2016/10/25 网络数据加载,以及viewpager的实现
    public void getData(String firstcontoryid, final List<View> viewList) {
//        viewList.clear();
        pullListView.getRefreshableView().smoothScrollTo(0, 0);
        String baseUrl = "http://app.interface.jescard.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        bournBeanData = retrofit.create(BournBeanData.class);
        Call<BournBean> japan = bournBeanData.getBournBean(firstcontoryid);
        japan.enqueue(new Callback<BournBean>() {
            @Override
            public void onResponse(Call<BournBean> call, final Response<BournBean> response) {
                //viewpager实现
                int size = response.body().getObj().getCountryActivitiesList().size();
                for (int i = 0; i < size; i++) {
                    ImageView imageView = new ImageView(context);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    Picasso.with(context).load(response.body().getObj().getCountryActivitiesList().get(i).getActivitiesPic()).into(imageView);
                    viewList.add(imageView);
                    final int finalI = i;
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String link = response.body().getObj().getCountryActivitiesList().get(finalI).getActivitiesLink();
                            String brountitle = "杰西卡带你全球购";
                            Intent intent = new Intent(context, HomeBannerDetailActivity.class);
                            intent.putExtra("goValue", link);
                            intent.putExtra("title", brountitle);
                            startActivity(intent);
                        }
                    });

                    //添加小点
                    ImageView point = new ImageView(context);
                    if (i == 0) {
                        point.setImageResource(R.drawable.white_point);
                    } else {
                        point.setImageResource(R.drawable.blue_point);
                    }
                    point.setPadding(10, 0, 10, 0);
                    point_container.addView(point);
                }
                BournViewpagerAdapter viewpagerAdapter = new BournViewpagerAdapter(viewList);
                bourn_viewPager.setAdapter(viewpagerAdapter);
                bourn_viewPager.startAutoScroll();
                bourn_viewPager.setInterval(3000);
                bourn_viewPager.setCycle(true);
                bourn_viewPager.setStopScrollWhenTouch(true);


                bourn_viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        //获取所有child个数
                        int count = point_container.getChildCount();
                        for (int i = 0; i < count; i++) {
                            ImageView img = (ImageView) point_container.getChildAt(i);
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

                //优惠券的数据初始化方法
                setDataCouponListView(response);
                //本土必败的数据初始化的方法
                setDataControyListView(response);
                //人气商城的数据初始化的方法
                setDataStoreListView(response);


            }

            @Override
            public void onFailure(Call<BournBean> call, Throwable t) {

            }
        });
    }

    // TODO: 2016/10/25 优惠券的listView
    public void setDataCouponListView(Response<BournBean> response) {


        couponList = response.body().getObj().getCouponList();
        BournCouponAdapter bournCouponAdapter = new BournCouponAdapter(context, couponList, R.layout.fragment_bourn_coupon);
        couponListView.setAdapter(bournCouponAdapter);

    }

    // TODO: 2016/10/25 本土必败的listView
    public void setDataControyListView(Response<BournBean> response) {

        topGoodsList = response.body().getObj().getTopGoodsList();
        BournControyAdapter bournControyAdapter = new BournControyAdapter(context, topGoodsList, R.layout.item_bourn_controy);
        controyListView.setAdapter(bournControyAdapter);

    }

    // TODO: 2016/10/25 人气商城的ListView
    public void setDataStoreListView(Response<BournBean> response) {
        Log.e("11111111111111111", "setDataStoreListView: " + response.body().getObj().getPopularMallList().size());

        popularMallList = response.body().getObj().getPopularMallList();
        BournStoreAdapter bournStoreAdapter = new BournStoreAdapter(context, popularMallList, R.layout.item_bouen_store);

        storeListview.setAdapter(bournStoreAdapter);
        setListViewHeight(storeListview);

    }

    // TODO: 2016/10/25 测试下测量listView
    public void setListViewHeight(ListView listView) {

        // 获取ListView对应的Adapter

        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 200) {
            String contoryid = data.getStringExtra("contoryid");
            title.setText(contoryid);
            Log.e("22222222", "onActivityResult: "+contoryid );
            String[] split = contoryid.split("\\.");
            viewList=new ArrayList<>();
            getData(split[1],viewList);
        }
    }
}
