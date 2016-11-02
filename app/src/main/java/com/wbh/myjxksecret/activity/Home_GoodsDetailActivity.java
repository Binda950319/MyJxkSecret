package com.wbh.myjxksecret.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.apiservice.GetGoodsDetail;
import com.wbh.myjxksecret.apiservice.GetHomeGoodsDetail;
import com.wbh.myjxksecret.javabean.GoodsDetailsBean;
import com.wbh.myjxksecret.javabean.GoodsInfo;
import com.wbh.myjxksecret.javabean.Home_GoodsDetailsBean;
import com.wbh.myjxksecret.javabean.ShoppingGoodsBean;
import com.wbh.myjxksecret.mysql.DBManager;
import com.wbh.myjxksecret.mysql.ShoppingDBManager;
import com.wbh.myjxksecret.utils.MyShareSDK;

import java.text.DecimalFormat;
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

public class Home_GoodsDetailActivity extends AppCompatActivity {

    @BindView(R.id.iv_homegoods_back)
    ImageView iv_homegoods_back;
    @BindView(R.id.iv_homegoods_share)
    ImageView iv_homegoods_share;
    @BindView(R.id.iv_homegoods_picture)
    ImageView iv_homegoods_picture;
    @BindView(R.id.tv_homegoods_name)
    TextView tv_homegoods_name;
    @BindView(R.id.tv_homegoods_lowestCountry)
    TextView tv_homegoods_lowestCountry;
    @BindView(R.id.tv_homegoods_lowestPrice)
    TextView tv_homegoods_lowestPrice;
    @BindView(R.id.tv_homegoods_sellprice)
    TextView tv_homegoods_sellprice;
    @BindView(R.id.ll_home_goodsIntro)
    LinearLayout ll_home_goodsIntro;
    @BindView(R.id.ll_home_collect)
    LinearLayout ll_home_collect;
    @BindView(R.id.tv_home_collect)
    TextView tv_home_collect;
    @BindView(R.id.iv_home_collect)
    ImageView iv_home_collect;
    @BindView(R.id.rl_addShoppingCar)
    RelativeLayout rl_addShoppingCar;
    @BindView(R.id.ll_container)
    LinearLayout ll_container;
    @BindView(R.id.tv_add_shoppingcar)
    TextView tv_add_shoppingcar;
    private Intent intent;
    boolean isCollected = false;
    private GoodsInfo goodsInfo;
    Home_GoodsDetailsBean body;
    private ShoppingGoodsBean shoppingGoods;
    private boolean isAdded = false;
    private SharedPreferences sharePre;
    boolean isLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_goods_detail);
        ButterKnife.bind(this);
        sharePre = getSharedPreferences("user", Context.MODE_PRIVATE);
        isLogin = sharePre.getBoolean("isLogin", false);
        getRetrofit();
    }

    @OnClick(R.id.iv_homegoods_back)
    public void clickBack(View view) {
        finish();
    }

    @OnClick(R.id.iv_homegoods_share)
    public void clickShare(View view) {
        MyShareSDK.showShare(this);
    }

    //点击收藏
    @OnClick(R.id.ll_home_collect)
    public void clickCollect(View view) {
        if (!isLogin) {
            isLogin = true;
            intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, 100);
        } else{
            if (!isCollected) {
                //收藏
                GoodsInfo goodsInfo = collectGoods(body);
                Log.e("Bing", "******: ******" + goodsInfo.getName());
                DBManager.getMyDBInstance(this).insertSingleGoods(goodsInfo);
                isCollected = true;
                tv_home_collect.setText("取消收藏");
                iv_home_collect.setImageResource(R.mipmap.icon_favorite_clicked);
                Toast.makeText(Home_GoodsDetailActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
            } else {
                GoodsInfo goodsInfo = collectGoods(body);
                Log.e("Bing", "******: ******" + goodsInfo.getGoodsId());
                DBManager.getMyDBInstance(this).deleteSingleGoods(goodsInfo);
                isCollected = false;
                tv_home_collect.setText("收藏");
                iv_home_collect.setImageResource(R.mipmap.me_like);
                Toast.makeText(Home_GoodsDetailActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //加入旅行便笺
    @OnClick(R.id.rl_addShoppingCar)
    public void clickAddShoppingCar(View view) {
        int height = getResources().getDisplayMetrics().heightPixels;
        Log.e("Bing", "******屏幕高度: ******" + height);
        final View inflate = LayoutInflater.from(this).inflate(R.layout.pop_shopping_goods, null, false);
        TextView tv_subCount = (TextView) inflate.findViewById(R.id.tv_subCount);
        final TextView tv_goodsCount = (TextView) inflate.findViewById(R.id.tv_goodsCount);
        TextView tv_addCount = (TextView) inflate.findViewById(R.id.tv_addCount);
        final Button btn_addShoppintCar = (Button) inflate.findViewById(R.id.btn_addShoppintCar);
        PopupWindow popupWindow = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, height / 4);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.classify_backgrand));
        tv_subCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home_GoodsDetailActivity.this, "减减减减", Toast.LENGTH_SHORT).show();
                int count = Integer.parseInt(tv_goodsCount.getText().toString());
                if (count >= 0) {
                    tv_goodsCount.setText(count--);
                }
            }
        });
        tv_addCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int addCount = Integer.parseInt(tv_goodsCount.getText().toString());
                tv_goodsCount.setText(addCount++);
            }
        });
        btn_addShoppintCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //加入购物车
                if (!isLogin) {
                    isLogin = true;
                    intent = new Intent(Home_GoodsDetailActivity.this, LoginActivity.class);
                    startActivityForResult(intent, 100);
                } else {
                    if (!isAdded) {
                        isAdded = true;
                        btn_addShoppintCar.setText("已经添加到我的旅行便笺");
                        tv_add_shoppingcar.setText("已经添加到我的旅行便笺");
                        tv_add_shoppingcar.setTextColor(getResources().getColor(R.color.colorGray));
                        btn_addShoppintCar.setTextColor(getResources().getColor(R.color.colorGray));
                        ShoppingGoodsBean shoppingCar = addShoppingCar(body);
                        Log.e("Bing", "******添加到我的旅行便笺: ******" + goodsInfo.getName());
                        ShoppingDBManager.newShoppingCarInstance(Home_GoodsDetailActivity.this).insertSingleGoods(shoppingCar);
                        Toast.makeText(Home_GoodsDetailActivity.this, "已经添加到我的旅行便笺", Toast.LENGTH_SHORT).show();
                    } else {
                        isAdded = false;
                        btn_addShoppintCar.setText("添加到我的旅行便笺");
                        ShoppingGoodsBean shoppingCar = addShoppingCar(body);
                        Log.e("Bing", "******从我的旅行便笺中移除: ******" + goodsInfo.getName());
                        ShoppingDBManager.newShoppingCarInstance(Home_GoodsDetailActivity.this).deleteSingleGoods(shoppingCar);
                        Toast.makeText(Home_GoodsDetailActivity.this, "已经从我的旅行便笺中移除", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        popupWindow.showAtLocation(ll_container, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    public void getRetrofit() {
        intent = getIntent();
        String goodsId = intent.getStringExtra("goodId");
        Log.e("Bing", "******传过来的goodsId: ******" + goodsId);
//       http://app.interface.jescard.com/goods/getGoodsDetailByNo.html
        String path = "http://app.interface.jescard.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Map<String, String> map = new HashMap<>();
        map.put("goodsId", goodsId);
        GetHomeGoodsDetail homeGoodsDetail = retrofit.create(GetHomeGoodsDetail.class);
        Call<Home_GoodsDetailsBean> call = homeGoodsDetail.getHomeGoodsDetail(map);
        call.enqueue(new Callback<Home_GoodsDetailsBean>() {


            @Override
            public void onResponse(Call<Home_GoodsDetailsBean> call, Response<Home_GoodsDetailsBean> response) {
                body = response.body();
                if (body != null) {
                    getHomeGoodsDetail(body);
                    //收藏
                    goodsInfo = collectGoods(body);
                    //查询
                    queryGoods(body);
                    //加入购物车
                    shoppingGoods = addShoppingCar(body);
                }
            }

            @Override
            public void onFailure(Call<Home_GoodsDetailsBean> call, Throwable t) {
            }
        });
    }

    private ShoppingGoodsBean addShoppingCar(Home_GoodsDetailsBean body) {
        Home_GoodsDetailsBean.ObjBean.GoodsBean goods = body.getObj().getGoods();
        String lowestCountry = goods.getLowestCountry();
        double lowestPrice = goods.getLowestPrice();
        String[] split = String.valueOf(lowestPrice).split("\\.");
        long id = Long.parseLong(split[0] + split[1]);
        int count = 0;
        String name = goods.getName();
        double sellPrice = goods.getSellPrice();
        String goodsPicture = goods.getGoodsPicture();
        String goodsPic = goods.getPicList().get(0);
        ShoppingGoodsBean shoppingGoods = new ShoppingGoodsBean(id, count, name, lowestCountry, lowestPrice, sellPrice, goodsPicture, goodsPic);
        return shoppingGoods;
    }

    private void queryGoods(Home_GoodsDetailsBean body) {
        Home_GoodsDetailsBean.ObjBean.GoodsBean goods = body.getObj().getGoods();
        String name = goods.getName();
        Log.e("Bing", "******收藏数据: ******" + name);
        List<GoodsInfo> list = DBManager.getMyDBInstance(this).queryAllGoods(name);
        Log.e("Bing", "******: 查询到的内容******" + list.size());
        if (list.size() > 0) {
            isCollected = true;
            tv_home_collect.setText("取消收藏");
            iv_home_collect.setImageResource(R.mipmap.icon_favorite_clicked);
        }
    }


    private GoodsInfo collectGoods(Home_GoodsDetailsBean body) {
        Home_GoodsDetailsBean.ObjBean.GoodsBean goods = body.getObj().getGoods();
        String name = goods.getName();
        Log.e("Bing", "******kdsjfkajsdkfjakj: ******");
        String lowestCountry = goods.getLowestCountry();
        double lowestPrice = goods.getLowestPrice();
        String[] split = String.valueOf(lowestPrice).split("\\.");
        long goodsId = Long.parseLong(split[0] + split[1]);
        double sellPrice = goods.getSellPrice();
        String goodsPicture = goods.getGoodsPicture();
        String goodsPic = goods.getPicList().get(0);
        GoodsInfo goodsInfo = new GoodsInfo(goodsId, name, lowestCountry, lowestPrice, sellPrice, goodsPicture, goodsPic);
        return goodsInfo;
    }

    private void getHomeGoodsDetail(Home_GoodsDetailsBean body) {
        Home_GoodsDetailsBean.ObjBean.GoodsBean goods = body.getObj().getGoods();
        tv_homegoods_name.setText(goods.getName());
        Log.e("Bing", "******GoodsName: ******" + goods.getName());
        Glide.with(this).load(goods.getGoodsPicture()).placeholder(R.mipmap.default_drawing).into(iv_homegoods_picture);
        tv_homegoods_lowestCountry.setText(goods.getLowestCountry());
        DecimalFormat df = new DecimalFormat("0.00");
        double lowestPrice = goods.getLowestPrice();
        tv_homegoods_lowestPrice.setText(df.format(lowestPrice));
        tv_homegoods_sellprice.setText("国内参考价: " + goods.getSellPrice());

        List<String> picList = goods.getPicList();
        int size = picList.size();
        for (int i = 0; i < size; i++) {
            LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ll.setMargins(10, 10, 10, 10);
            ImageView image = new ImageView(this);
            image.setLayoutParams(ll);
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Picasso.with(this).load(picList.get(i))
                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                    .placeholder(R.mipmap.default_drawing)
                    .config(Bitmap.Config.RGB_565)
                    .into(image);
            ll_home_goodsIntro.addView(image);
        }
    }
}
