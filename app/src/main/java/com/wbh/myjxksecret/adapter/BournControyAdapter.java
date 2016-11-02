package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.BournBean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class BournControyAdapter extends CwddBaseAdapter<BournBean.ObjBean.TopGoodsListBean> {
    private List<BournBean.ObjBean.TopGoodsListBean> data;
    private Context context;

    public BournControyAdapter(Context context, List<BournBean.ObjBean.TopGoodsListBean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
        this.data=data;
    }

    @Override
    public void setDate(ViewHolder holder, int position) {
        ImageView view = (ImageView) holder.findView(R.id.bourn_controy_iv);
        Picasso.with(context).load(data.get(position).getGoodsPic()).into(view);
        TextView textView = (TextView) holder.findView(R.id.bourn_controy_tv);
        textView.setText(data.get(position).getActivitiesLabel());
    }
}
