package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.Secret_SelectBean;
import com.wbh.myjxksecret.utils.MyBaseAdapter;
import com.wbh.myjxksecret.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
public class LoadingPicAdapter2 extends BaseAdapter {
    private List<Secret_SelectBean.ObjBean.DataBean.PicInfoListBean> list;
    private Context context;
    private LayoutInflater inflater;
    private int width;

    public LoadingPicAdapter2(List<Secret_SelectBean.ObjBean.DataBean.PicInfoListBean> picInfoList, Context context, int width) {
        this.list = picInfoList;
        this.context = context;
        this.width = width;
        inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.iv_comment_item_gridview, parent, false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv_load);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(list.get(position).getPicUrl()).resize(width, width).placeholder(R.mipmap.default_drawing).into(holder.imageView);
//        Log.e("Bing", "******getView: ******"+ list.get(position).getPicUrl());
        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
    }
}


//
//        extends MyBaseAdapter<String> {
//    private List<String> picList = new ArrayList<>();
//    private Context context;
//    private int width;
//
//    public LoadingPicAdapter2(List<String> list, Context mContext, int resId) {
//        super(list, mContext, resId);
//        this.picList = list;
//        this.context = mContext;
//        width = context.getResources().getDisplayMetrics().widthPixels;
//    }
//
//    @Override
//    public void setDate(ViewHolder holder, int position) {
//        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(width / 2, width / 2);
//        llp.setMargins(5, 5, 5, 5);
//        ImageView iv_load = (ImageView) holder.findView(R.id.iv_load);
//        Glide.with(context).load(picList.get(position))
//                .into(iv_load);
//        iv_load.setLayoutParams(llp);
//    }
//}
