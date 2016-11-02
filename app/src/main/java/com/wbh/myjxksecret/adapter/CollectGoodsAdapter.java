package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.GoodsInfo;
import com.wbh.myjxksecret.utils.MyBaseAdapter;
import com.wbh.myjxksecret.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/1.
 */
public class CollectGoodsAdapter extends BaseAdapter {
    private List<GoodsInfo> list = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public CollectGoodsAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setList(List<GoodsInfo> list) {
        this.list = list;
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
        MyViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.per_collect_item, parent, false);
            holder = new MyViewHolder();
            ButterKnife.bind(holder, convertView);
            holder.iv_collgoods_icon = (ImageView) convertView.findViewById(R.id.iv_collgoods_icon);
            holder.tv_collgoods_name = (TextView) convertView.findViewById(R.id.tv_collgoods_name);
            holder.tv_collgoods_title = (TextView) convertView.findViewById(R.id.tv_collgoods_title);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }
        GoodsInfo goodsInfo = list.get(position);
        if (goodsInfo != null) {
            Glide.with(context).load(goodsInfo.getGoodsPicture()).placeholder(R.mipmap.default_drawing).into(holder.iv_collgoods_icon);
            String[] split = goodsInfo.getName().split(" ");
            holder.tv_collgoods_name.setText(split[0]+" "+split[1]);
            holder.tv_collgoods_title.setText(goodsInfo.getName());
        }
        return convertView;
    }

    class MyViewHolder {
        @BindView(R.id.iv_collgoods_icon)
        ImageView iv_collgoods_icon;
        @BindView(R.id.tv_collgoods_name)
        TextView tv_collgoods_name;
        @BindView(R.id.tv_collgoods_title)
        TextView tv_collgoods_title;
    }
}
