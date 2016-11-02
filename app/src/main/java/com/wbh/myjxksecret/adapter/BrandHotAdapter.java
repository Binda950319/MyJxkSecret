package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.BrandBean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
public class BrandHotAdapter extends CwddBaseAdapter<BrandBean.ObjBean.HotBrandListBean> {
    private List<BrandBean.ObjBean.HotBrandListBean> data;
    private Context context;

    public BrandHotAdapter(Context context, List<BrandBean.ObjBean.HotBrandListBean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.data=data;
        this.context=context;
    }

    @Override
    public void setDate(ViewHolder holder, int position) {
        ImageView view = (ImageView) holder.findView(R.id.item_global_brand_imageview);
        Glide.with(context).load(data.get(position).getBrandPicUrl()).into(view);
    }
}
