package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.widget.TextView;

import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.CouponBean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */
public class ConponAdapter extends CwddBaseAdapter<CouponBean.ObjBean.DataBean> {
    private List<CouponBean.ObjBean.DataBean> data;

    public ConponAdapter(Context context, List<CouponBean.ObjBean.DataBean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.data=data;
    }

    @Override
    public void setDate(ViewHolder holder, int position) {
        TextView title = (TextView) holder.findView(R.id.conpon_item_tv);
        title.setText(data.get(position).getMallName());
        TextView highzhekou = (TextView) holder.findView(R.id.conpon_item_zhekou);
        highzhekou.setText(data.get(position).getTypeValue());
        TextView common = (TextView) holder.findView(R.id.conpon_item_common);
        common.setText(data.get(position).getMallName());
        TextView shiyong = (TextView) holder.findView(R.id.conpon_item_shiyong);
        shiyong.setText(data.get(position).getTrialObject());
        TextView conpon = (TextView) holder.findView(R.id.conpon_item_conpon);
        conpon.setText(data.get(position).getConditionValue());
        TextView time = (TextView) holder.findView(R.id.conpon_item_time);
        time.setText(data.get(position).getStartTime());







    }
}
