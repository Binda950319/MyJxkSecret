package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.Secret_ItemPic;
import com.wbh.myjxksecret.javabean.Secret_SelectBean;
import com.wbh.myjxksecret.utils.MyBaseAdapter;
import com.wbh.myjxksecret.utils.MyGridView;
import com.wbh.myjxksecret.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
public class LoadingPicAdapter extends MyBaseAdapter<String> {
    private List<String> picList = new ArrayList<>();
    private Context context;
    private int width;

    public LoadingPicAdapter(List<String> list, Context mContext, int resId) {
        super(list, mContext, resId);
        this.picList = list;
        this.context = mContext;
        width = context.getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    public void setDate(ViewHolder holder, int position) {
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(width / 2, width / 2);
        llp.setMargins(5, 5, 5, 5);
        ImageView iv_load = (ImageView) holder.findView(R.id.iv_load);
        Glide.with(context).load(picList.get(position))
                .into(iv_load);
        iv_load.setLayoutParams(llp);
    }
}
