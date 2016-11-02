package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.HomeBean;
import com.wbh.myjxksecret.utils.FullyGridLayoutManager;
import com.wbh.myjxksecret.utils.MyBaseAdapter;
import com.wbh.myjxksecret.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class Home_CountryAdapter extends MyBaseAdapter<HomeBean.ObjBean.IndexCountryBean.CountryListBean> {
    private List<HomeBean.ObjBean.IndexCountryBean.CountryListBean> countryList = new ArrayList<>();
    private Context context;

    public Home_CountryAdapter(List<HomeBean.ObjBean.IndexCountryBean.CountryListBean> list, Context mContext, int resId) {
        super(list, mContext, resId);
        this.countryList = list;
        this.context = mContext;
    }

    @Override
    public void setDate(ViewHolder holder, int position) {
        ImageView iv_home_countrypic = (ImageView) holder.findView(R.id.iv_home_countrypic);
        Picasso.with(context).load(countryList.get(position).getHomePic())
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .config(Bitmap.Config.RGB_565)
                .into(iv_home_countrypic);
    }
}
