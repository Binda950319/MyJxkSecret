package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.MallCategoryGoods;
import com.wbh.myjxksecret.javabean.MallDetailBean;
import com.wbh.myjxksecret.utils.MyBaseAdapter;
import com.wbh.myjxksecret.utils.ViewHolder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/28.
 */
public class Mall_CategoryGoodsAdapter extends BaseAdapter {
    private List<MallCategoryGoods.ObjBean.DataBean> dataBeen = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public Mall_CategoryGoodsAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDataBeen(List<MallCategoryGoods.ObjBean.DataBean> list) {
       this.dataBeen.addAll(list);
//        Log.e("Bing", "******全部商品的数量: ******"+dataBeen.size());
    }

    @Override
    public int getCount() {
        return dataBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return dataBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.mallgoods_item_layout, parent, false);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        MallCategoryGoods.ObjBean.DataBean data = dataBeen.get(position);
        Glide.with(context).load(data.getGoodsPicture()).placeholder(R.mipmap.default_drawing).into(holder.iv_goodsPic);
        holder.tv_mallName.setText(data.getName());
        //小数格式化，引号中的0.00表示保留小数点后两位（第三位四舍五入）
        DecimalFormat df = new DecimalFormat("0.00");
        holder.tv_mallCurrentType.setText(data.getCurrencyType() + ": " +  df.format(data.getOriginalPrice()));
        holder.tv_mallSellPrice.setText("人民币: " +  df.format(data.getSellPrice()));

        return convertView;
    }
    class ViewHolder{
        @BindView(R.id.iv_goodsPic)
        ImageView iv_goodsPic;
        @BindView(R.id.tv_mallName)
        TextView tv_mallName;
        @BindView(R.id.tv_mallCurrentType)
        TextView tv_mallCurrentType;
        @BindView(R.id.tv_mallSellPrice)
        TextView tv_mallSellPrice;
    }
}
