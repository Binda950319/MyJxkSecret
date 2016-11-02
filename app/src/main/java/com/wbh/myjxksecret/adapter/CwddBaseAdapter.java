package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/22.
 */
public abstract class CwddBaseAdapter<T> extends BaseAdapter {
    private List<T> data;
    private LayoutInflater inflater;
    private int layoutResId;
    private Context context;

    public CwddBaseAdapter(Context context,List<T> data,int layoutResId) {
        this.context=context;
        this.layoutResId=layoutResId;

        inflater=LayoutInflater.from(context);
        if(data!=null){
            this.data=data;
        }else{
            this.data=new ArrayList<>();
        }

    }

    public void addRes(List<T> data){
        if (data!=null){
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }
    public void updateRes(List<T> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //.1   获取实例化 ViewHolder
        ViewHolder holder = ViewHolder.getHolder(context, layoutResId, convertView);
        //.2   填充数据到View
        setDate(holder, position);
        //.3   将View 返回
        return holder.getView();

    }

    public abstract void setDate(ViewHolder holder, int position) ;

    public static class ViewHolder{
        private View convertView;
        private SparseArray<View> array=new SparseArray<>();
        public ViewHolder(Context context,int resId){
            //初始化布局
            convertView=LayoutInflater.from(context).inflate(resId,null);
            //设置标签
            convertView.setTag(this);
        }
        //自定义一个将convertView返回的方法
        public View getView(){
            return convertView;
        }
      //自定义一个静态方法 作为Holder的实例化方法  convertView的重复使用
        public static ViewHolder getHolder(Context context, int resId, View view){
            ViewHolder holder=null;
            if (view==null) {
                holder=new ViewHolder(context,resId);
            }else {
                holder= (ViewHolder) view.getTag();
            }
            return holder;
        }
      //根据ID 查找View的方法
      public View findView(int viewId){
          View view = array.get(viewId);
          if (view==null) {
              //没有的话 FindViewById
              view=convertView.findViewById(viewId);
              array.append(viewId,view);
          }
          return view;
      }

    }
}
