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
public class BournStoreAdapter extends CwddBaseAdapter<BournBean.ObjBean.PopularMallListBean> {
    private List<BournBean.ObjBean.PopularMallListBean> data;
    private Context context;


    public BournStoreAdapter(Context context, List<BournBean.ObjBean.PopularMallListBean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
        this.data=data;
    }

    @Override
    public void setDate(ViewHolder holder, int position) {
        ImageView iv = (ImageView) holder.findView(R.id.bourn_item_store_iv);




        Picasso.with(context).load(data.get(position).getMallPic()).into(iv);
        TextView title = (TextView) holder.findView(R.id.bourn_item_store_title);
        title.setText(data.get(position).getMallName());
        TextView show = (TextView) holder.findView(R.id.bourn_item_store_show);
        show.setText(data.get(position).getOriginalName());
        TextView moods = (TextView) holder.findView(R.id.bourn_item_store_moods);
        moods.setText(String.valueOf(data.get(position).getPraiseCount()));

    }
}
