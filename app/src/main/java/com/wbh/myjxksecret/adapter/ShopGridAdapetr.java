package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.ShopBean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
public class ShopGridAdapetr extends CwddBaseAdapter<ShopBean.ObjBean.DataBean> {
    private  List<ShopBean.ObjBean.DataBean> data;
    private Context context;
    public void update(List<ShopBean.ObjBean.DataBean> data){
        if (data!=null){
            data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public ShopGridAdapetr(Context context, List<ShopBean.ObjBean.DataBean> data, int layoutResId) {
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
