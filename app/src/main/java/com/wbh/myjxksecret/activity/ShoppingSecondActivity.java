package com.wbh.myjxksecret.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.adapter.ShopBrandGridAdapter;
import com.wbh.myjxksecret.apiservice.ShopBeanBrandData;
import com.wbh.myjxksecret.apiservice.ShopOrtherBeanBrandData;
import com.wbh.myjxksecret.javabean.ShopBrandBean;
import com.wbh.myjxksecret.javabean.ShopOtherBrandBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShoppingSecondActivity extends AppCompatActivity {
    private String brandId;
    private String englishName;
    private int page=1;
    private int pagesize=20;
    @BindView(R.id.shopping_goback)
    ImageView shopping_goback;
    @BindView(R.id.shop_title)
    TextView shop_title;
    @BindView(R.id.shoplayout_gridView2)
    PullToRefreshGridView shoplayout_gridView2;
    private ShopBrandGridAdapter shopBrandGridAdapter;
    private List<ShopBrandBean.ObjBean.DataBean> data1;
    private List<ShopOtherBrandBean.ObjBean.DataBean> otherdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_second);
        Intent intent = getIntent();
        brandId = intent.getStringExtra("brandId");
        englishName = intent.getStringExtra("englishName");
        ButterKnife.bind(this);
        Log.e("11111111111111111111", "getData: "+brandId );
        if (brandId.equals("APPLE")||brandId.equals("BOSE")){
            getbrandIdData(pagesize,brandId,page);
        }else{
            getbrandIdDataOthers(pagesize,brandId,page);
        }



        shop_title.setText(englishName);


        gridViewlistenner();
    }

    private void gridViewlistenner() {
        shoplayout_gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String goodsId = data1.get(position).getGoodsId();

                Intent intent = new Intent(ShoppingSecondActivity.this,Home_GoodsDetailActivity.class);
                intent.putExtra("goodId",goodsId);
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.shopping_goback)
    public void clickBack(View view){
        finish();
    }
    // TODO: 2016/10/28 苹果和bose
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
                Log.e("yuyuyuyuyuy", "onResponse: "+data1.get(0).getName() );
                shopBrandGridAdapter = new ShopBrandGridAdapter(ShoppingSecondActivity.this, data1, R.layout.item_shop_grid);
                shoplayout_gridView2.setAdapter(shopBrandGridAdapter);
            }
            @Override
            public void onFailure(Call<ShopBrandBean> call, Throwable t) {
            }
        });
    }

    // TODO: 2016/11/1 别的下载
    public void getbrandIdDataOthers(int pagesize,String cc,int page){
        String baseUrl="http://app.interface.jescard.com/";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ShopOrtherBeanBrandData shopOrtherBeanBrandData = retrofit.create(ShopOrtherBeanBrandData.class);

        Call<ShopOtherBrandBean> call = shopOrtherBeanBrandData.getShopOtherbrandBeanBean(pagesize,cc,page);
        call.enqueue(new Callback<ShopOtherBrandBean>() {


            @Override
            public void onResponse(Call<ShopOtherBrandBean> call, Response<ShopOtherBrandBean> response) {
                otherdata = response.body().getObj().getData();
                Log.e("yuyuyuyuyuy", "onResponse: "+data1.size() );
                Log.e("yuyuyuyuyuy", "onResponse: "+data1.get(0).getName() );
                shopBrandGridAdapter = new ShopBrandGridAdapter(ShoppingSecondActivity.this, data1, R.layout.item_shop_grid);
                shoplayout_gridView2.setAdapter(shopBrandGridAdapter);
            }

            @Override
            public void onFailure(Call<ShopOtherBrandBean> call, Throwable t) {

            }
        });
    }
}
