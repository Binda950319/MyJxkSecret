package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.BournBean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class BournCouponAdapter extends CwddBaseAdapter<BournBean.ObjBean.CouponListBean> {
     private List<BournBean.ObjBean.CouponListBean> data;
     private Context context;

    public BournCouponAdapter(Context context, List<BournBean.ObjBean.CouponListBean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
        this.data=data;
    }

    @Override
    public void setDate(ViewHolder holder, int position) {
        ImageView view = (ImageView) holder.findView(R.id.bourn_coupon_img);
        Picasso.with(context).load(data.get(position).getAdvertisementPicUrl()).into(view);


    }
}
