package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.GetMoreDailyBean;
import com.wbh.myjxksecret.utils.MyBaseAdapter;
import com.wbh.myjxksecret.utils.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */
public class Home_MoreDailyAdapter extends MyBaseAdapter<GetMoreDailyBean.ObjBean.DataBean> {
    private List<GetMoreDailyBean.ObjBean.DataBean> data = new ArrayList<>();
    private Context context;

    public Home_MoreDailyAdapter(List<GetMoreDailyBean.ObjBean.DataBean> list, Context mContext, int resId) {
        super(list, mContext, resId);
        this.data = list;
        this.context = mContext;
    }

    @Override
    public void setDate(ViewHolder holder, int position) {
        ImageView iv_more_daily = (ImageView) holder.findView(R.id.iv_more_daily);
        TextView tv_more_country = (TextView) holder.findView(R.id.tv_more_country);
        GetMoreDailyBean.ObjBean.DataBean dataBean = data.get(position);
        Glide.with(context).load(dataBean.getRecommendedPiclink()).into(iv_more_daily);
        tv_more_country.setText(dataBean.getRecommendedTitle());

    }
}
