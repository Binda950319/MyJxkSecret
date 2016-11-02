package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.MallDetailBean;
import com.wbh.myjxksecret.utils.MyBaseAdapter;
import com.wbh.myjxksecret.utils.ViewHolder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */
public class MallGoodsAdapter extends MyBaseAdapter<MallDetailBean.ObjBean.Hot10goodsBean> {
    private List<MallDetailBean.ObjBean.Hot10goodsBean> hotGoodsList = new ArrayList<>();
    private Context context;

    public MallGoodsAdapter(List<MallDetailBean.ObjBean.Hot10goodsBean> list, Context mContext, int resId) {
        super(list, mContext, resId);
        this.context = mContext;
        this.hotGoodsList = list;
    }

    @Override
    public void setDate(ViewHolder holder, int position) {
        ImageView iv_goodsPic = (ImageView) holder.findView(R.id.iv_goodsPic);
        TextView tv_mallName = (TextView) holder.findView(R.id.tv_mallName);
        TextView tv_mallCurrentType = (TextView) holder.findView(R.id.tv_mallCurrentType);
        TextView tv_mallSellPrice = (TextView) holder.findView(R.id.tv_mallSellPrice);
        MallDetailBean.ObjBean.Hot10goodsBean goodsBean = hotGoodsList.get(position);
        Glide.with(context).load(goodsBean.getGoodsPicture()).placeholder(R.mipmap.default_drawing).into(iv_goodsPic);
        tv_mallName.setText(goodsBean.getName());
        //小数格式化，引号中的0.00表示保留小数点后两位（第三位四舍五入）
        DecimalFormat df = new DecimalFormat("0.00");
        tv_mallCurrentType.setText(goodsBean.getCurrencyType() + ": " +   df.format(goodsBean.getOriginalPrice()));
        tv_mallSellPrice.setText("人民币: " +  df.format(goodsBean.getSellPrice()));
    }
}
