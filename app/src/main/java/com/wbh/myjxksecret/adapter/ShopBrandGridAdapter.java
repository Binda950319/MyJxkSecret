package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.ShopBrandBean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/29.
 */
public class ShopBrandGridAdapter extends CwddBaseAdapter<ShopBrandBean.ObjBean.DataBean> {
    private List<ShopBrandBean.ObjBean.DataBean> data;
    private Context context;

    public ShopBrandGridAdapter(Context context, List<ShopBrandBean.ObjBean.DataBean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.data=data;
        this.context=context;
    }




    @Override
    public void setDate(ViewHolder holder, int position) {
        ImageView view = (ImageView) holder.findView(R.id.shop_grid_iv);
        Glide.with(context).load(data.get(position).getGoodsPicture()).into(view);

        TextView title = (TextView) holder.findView(R.id.shop_grid_title);
        title.setText(data.get(position).getName());
        TextView lowprice = (TextView) holder.findView(R.id.shop_grid_lowprice);
        lowprice.setText("$ "+String.valueOf(data.get(position).getLowestPrice()));
        TextView highprice = (TextView) holder.findView(R.id.shop_grid_highprice);
        highprice.setText(String.valueOf(data.get(position).getSellPrice()));
    }
}
