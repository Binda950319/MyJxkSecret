package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.ClassifyBean;

import java.util.List;

/**
 * Created by Administrator on 2016/10/27.
 */
public class ClassifyListAdapter extends CwddBaseAdapter<ClassifyBean.ObjBean> {
    private List<ClassifyBean.ObjBean> data;
    private Context context;

    public ClassifyListAdapter(Context context, List<ClassifyBean.ObjBean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.data=data;
        this.context=context;
    }

    @Override
    public void setDate(ViewHolder holder, int position) {
        ImageView view = (ImageView) holder.findView(R.id.item_global_class_imageview);
        Glide.with(context).load(data.get(position).getCategorypicUrl()).into(view);
    }
}
