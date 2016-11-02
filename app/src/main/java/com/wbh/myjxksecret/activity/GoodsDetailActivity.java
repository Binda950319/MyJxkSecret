package com.wbh.myjxksecret.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.apiservice.GetGoodsDetail;
import com.wbh.myjxksecret.javabean.GoodsDetailsBean;
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

public class GoodsDetailActivity extends AppCompatActivity {

    @BindView(R.id.iv_goodsDetail_back)
    ImageView iv_goodsDetail_back;
    @BindView(R.id.iv_goods_share)
    ImageView iv_goods_share;
    @BindView(R.id.iv_goods_picture)
    ImageView iv_goods_picture;
    @BindView(R.id.tv_goods_name)
    TextView tv_goods_name;
    @BindView(R.id.tv_country)
    TextView tv_country;
    @BindView(R.id.tv_goods_priceTypeName)
    TextView tv_goods_priceTypeName;
    @BindView(R.id.tv_goods_sellprice)
    TextView tv_goods_sellprice;
    @BindView(R.id.ll_goodsIntro)
    LinearLayout ll_goodsIntro;
    @BindView(R.id.ll_goods_collect)
    LinearLayout ll_goods_collect;
    @BindView(R.id.tv_goods_collect)
    TextView tv_goods_collect;
    @BindView(R.id.iv_goods_collect)
    ImageView iv_goods_collect;
    private Intent intent;
    boolean isCollected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_detail);
        ButterKnife.bind(this);
        getRetrofit();
    }

    @OnClick(R.id.iv_goodsDetail_back)
    public void clickBack(View view) {
        finish();
    }

    @OnClick(R.id.iv_goods_share)
    public void clickShare(View view) {
        MyShareSDK.showShare(this);
    }

    @OnClick(R.id.ll_goods_collect)
    public void clickCollect(View view) {
        if (!isCollected) {
            //收藏
            isCollected = true;
            tv_goods_collect.setText("取消收藏");
            iv_goods_collect.setImageResource(R.mipmap.icon_favorite_clicked);
            Toast.makeText(GoodsDetailActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
        } else {
            isCollected = false;
            tv_goods_collect.setText("收藏");
            iv_goods_collect.setImageResource(R.mipmap.me_like);
            Toast.makeText(GoodsDetailActivity.this, "取消收藏", Toast.LENGTH_SHORT).show();
        }
    }

    public void getRetrofit() {
        intent = getIntent();
        String goodsId = intent.getStringExtra("goodsId");
        String mallId = intent.getStringExtra("mallId");
//        long goodsid = Long.parseLong("goodsId");
        Log.e("Bing", "******带MallId的商品详情_goodsId: ******" + goodsId);
//        Log.e("Bing", "******带MallId的商品详情_goodsId(Long):  ******" + goodsid);
        Log.e("Bing", "******带MallId的商品详情_mallId: ******" + mallId);
//       http://app.interface.jescard.com/interimGoods/getMarketGoodsDetail.html
        String path = "http://app.interface.jescard.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Map<String, String> map = new HashMap<>();
        map.put("goodsId", goodsId);
        map.put("mallId", mallId);
        GetGoodsDetail goodsDetail = retrofit.create(GetGoodsDetail.class);
        Call<GoodsDetailsBean> call = goodsDetail.getGoodsDetail(map);
        call.enqueue(new Callback<GoodsDetailsBean>() {
            @Override
            public void onResponse(Call<GoodsDetailsBean> call, Response<GoodsDetailsBean> response) {
                GoodsDetailsBean body = response.body();
                if (body != null) {
                    getGoodsDetail(body);
                }
            }

            @Override
            public void onFailure(Call<GoodsDetailsBean> call, Throwable t) {

            }
        });
    }

    private void getGoodsDetail(GoodsDetailsBean body) {
        GoodsDetailsBean.ObjBean objBean = body.getObj();
        Glide.with(this).load(objBean.getGoods().getGoodsPicture()).placeholder(R.mipmap.default_drawing).into(iv_goods_picture);
        tv_goods_name.setText(objBean.getGoods().getName());
        tv_country.setText(objBean.getGoods().getCountry() + objBean.getGoods().getMallId() + "特价:");
        GoodsDetailsBean.ObjBean.GoodsBean.PriceListBean priceListBean = objBean.getGoods().getPriceList().get(0);
        DecimalFormat df = new DecimalFormat("0.00");
        double inLandPrice = priceListBean.getInLandPrice();
        String num = df.format(inLandPrice);
        tv_goods_priceTypeName.setText(priceListBean.getPriceTypeName() + ": ￥" + num + "(" + priceListBean.getCurrencyType() + priceListBean.getOriginalPrice() + ")");

        List<String> picList = objBean.getGoods().getPicList();
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
            ll_goodsIntro.addView(image);
        }
    }
}
