package com.wbh.myjxksecret.adapter;


import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.wbh.myjxksecret.R;

import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */
public class ShopPriceAadapter extends CwddBaseAdapter<String> {
    private List<String> data;
    private Context context;

    public ShopPriceAadapter(Context context, List<String> data, int layoutResId) {
        super(context, data, layoutResId);
        this.data=data;
        this.context=context;
    }


    @Override
    public void setDate(ViewHolder holder, int position) {
        TextView view = (TextView) holder.findView(R.id.shop_pop_item_tv);
        view.setText(data.get(position));
        Log.e("44444444543543543534", "setDate: "+data.get(position));
    }
}
