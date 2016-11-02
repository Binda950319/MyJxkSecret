package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.BournBean;
import com.wbh.myjxksecret.javabean.HomeBean;
import com.wbh.myjxksecret.utils.MyBaseAdapter;
import com.wbh.myjxksecret.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class Home_CouponAdapter extends MyBaseAdapter<HomeBean.ObjBean.IndexCouponBean.CouponListBean> {
    List<HomeBean.ObjBean.IndexCouponBean.CouponListBean> couponList = new ArrayList<>();
    private Context context;

    public Home_CouponAdapter(List<HomeBean.ObjBean.IndexCouponBean.CouponListBean> list, Context mContext, int resId) {
        super(list, mContext, resId);
        this.couponList = list;
        this.context = mContext;
    }

    @Override
    public void setDate(ViewHolder holder, int position) {
        ImageView iv_home_coupon = (ImageView) holder.findView(R.id.iv_home_coupon);
        TextView tv_home_coupon = (TextView) holder.findView(R.id.tv_home_coupon);
        Picasso.with(context).load(couponList.get(position).getAdvertisementPicUrl()).into(iv_home_coupon);
        tv_home_coupon.setText(couponList.get(position).getMallName());
    }
}
