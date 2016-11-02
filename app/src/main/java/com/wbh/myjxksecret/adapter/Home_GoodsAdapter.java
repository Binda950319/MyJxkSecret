package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.HomeBean;
import com.wbh.myjxksecret.utils.MyBaseAdapter;
import com.wbh.myjxksecret.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/25.
 */
public class Home_GoodsAdapter extends BaseAdapter {
    List<HomeBean.ObjBean.IndexBrandRecommentBean.GoodsListBean> goodsList = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public Home_GoodsAdapter(List<HomeBean.ObjBean.IndexBrandRecommentBean.GoodsListBean> goodsList, Context context) {
        this.goodsList = goodsList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return goodsList.size();
    }

    @Override
    public Object getItem(int position) {
        return goodsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.home_goods_item, parent, false);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Glide.with(context).load(goodsList.get(position).getGoodPic()).into(holder.home_goods_pic);
        holder.home_goods_label.setText(goodsList.get(position).getGoodLable());
//        if (position == getCount()){
//            ImageView image = new ImageView(context);
//            image.setImageResource(R.mipmap.more);
//        }
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.home_goods_label)
        TextView home_goods_label;
        @BindView(R.id.home_goods_pic)
        ImageView home_goods_pic;
    }
}
