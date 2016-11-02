package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.Home_DrawBackBean;
import com.wbh.myjxksecret.utils.MyBaseAdapter;
import com.wbh.myjxksecret.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
public class DrawBackAdapter extends MyBaseAdapter<Home_DrawBackBean.ObjBean.TaxRefundInstitutionListBean> {
    private List<Home_DrawBackBean.ObjBean.TaxRefundInstitutionListBean> list = new ArrayList<>();
    private Context context;

    public DrawBackAdapter(List<Home_DrawBackBean.ObjBean.TaxRefundInstitutionListBean> list, Context mContext, int resId) {
        super(list, mContext, resId);
        this.list = list;
        this.context = mContext;
    }

    @Override
    public void setDate(ViewHolder holder, int position) {
        ImageView imageView = (ImageView) holder.findView(R.id.institutionLogo);
        TextView textView1 = (TextView) holder.findView(R.id.institutionName1);
        TextView textView2 = (TextView) holder.findView(R.id.institutionName2);
        Glide.with(context).load(list.get(position).getInstitutionLogo()).placeholder(R.mipmap.default_drawing).into(imageView);
        String name = list.get(position).getInstitutionName();
        String[] names = name.split("\\*");
        textView1.setText(names[0]);
        textView2.setText(names[1]);

    }
}
