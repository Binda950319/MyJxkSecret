package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.Secret_ItemPic;
import com.wbh.myjxksecret.utils.MyBaseAdapter;
import com.wbh.myjxksecret.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
public class LoadingPicAdapter3 extends MyBaseAdapter<String> {
    private List<String> picList = new ArrayList<>();
    private Context context;
    private int width;

    public LoadingPicAdapter3(List<String> list, Context mContext, int resId) {
        super(list, mContext, resId);
        this.picList = list;
        this.context = mContext;
        width = context.getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    public void setDate(ViewHolder holder, int position) {
        ImageView iv_load = (ImageView) holder.findView(R.id.iv_load);
        iv_load.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
        Glide.with(context).load(picList.get(position)).placeholder(R.mipmap.default_drawing).into(iv_load);
    }
}
