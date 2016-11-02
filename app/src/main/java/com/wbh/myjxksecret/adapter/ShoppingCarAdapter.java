package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.ShoppingGoodsBean;
import com.wbh.myjxksecret.myinterface.MyOnItemSelect;
import com.wbh.myjxksecret.myinterface.MyOnItemSelectLinstener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/1.
 */
public class ShoppingCarAdapter extends BaseAdapter implements View.OnClickListener{
    List<ShoppingGoodsBean> list = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater ;
    private MyOnItemSelectLinstener myOnItemSelectLinstener;
    Map<Integer, Integer> map;
    CheckBox cb_goods_all;
    private MyOnItemSelect myOnItemSelect;

    public ShoppingCarAdapter(Map<Integer, Integer> map,Context context, CheckBox cb_goods_all) {
        this.context = context;
        this.map = map;
        this.cb_goods_all = cb_goods_all;
        inflater = LayoutInflater.from(context);
    }

    public void setMyOnItemSelect(MyOnItemSelect myOnItemSelect) {
        this.myOnItemSelect = myOnItemSelect;
    }

    public void setMyOnItemSelectLinstener(MyOnItemSelectLinstener myOnItemSelectLinstener) {
        this.myOnItemSelectLinstener = myOnItemSelectLinstener;
    }

    public void setList(List<ShoppingGoodsBean> list) {
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ShoppingGoodsBean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.shoppingcar_item, parent, false);
            holder = new ViewHolder();
            ButterKnife.bind(holder,convertView);
            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }
        ShoppingGoodsBean goodsBean = list.get(position);
        if (goodsBean!=null){
            Log.e("Bing", "******图片: ******"+goodsBean.getGoodsPicture());
            Glide.with(context).load(goodsBean.getGoodsPicture()).placeholder(R.mipmap.default_drawing).into(holder.iv_shoppingIcon);
            holder.tv_shoppingName.setText(goodsBean.getName());
            holder.tv_shoppingPrice.setText("￥"+goodsBean.getLowestPrice());
            holder.tv_shopgoodsCount.setText(""+goodsBean.getCount());
            //减号
            holder.tv_subgoodsCount.setOnClickListener(this);
            //加号
            holder.tv_addgoodsCount.setOnClickListener(this);
            holder.tv_subgoodsCount.setTag(position);
            holder.tv_addgoodsCount.setTag(position);
            holder.cb_shopping_select.setTag(position);
            if (map.containsKey(position)){
                holder.cb_shopping_select.setChecked(true);
            } else{
                holder.cb_shopping_select.setChecked(false);
            }
            final ViewHolder finalHolder = holder;
            holder.cb_shopping_select.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (myOnItemSelect!=null){
                        Log.e("Bing", "******单选成功: ******");
                        myOnItemSelect.myOnItemSelect(position, true);
                    }
                    Integer position =  (Integer) finalHolder.cb_shopping_select.getTag();
                    if (finalHolder.cb_shopping_select.isChecked()) {
                        Log.e("=====", "=dddd===");
                        if (!map.containsKey(finalHolder.cb_shopping_select.getTag())) {
                            map.put((Integer) finalHolder.cb_shopping_select.getTag(), position);
                        }
                        if (getCount() == map.size()) {
                            cb_goods_all.setChecked(true);
                        }
                    } else {
                        map.remove((Integer) finalHolder.cb_shopping_select.getTag());
                        cb_goods_all.setChecked(false);
                    }
                }
            });
            //商品选择
            holder.cb_shopping_select.setTag(position);

        }
        return convertView;
    }

    //商品加减
    @Override
    public void onClick(View v) {
        Integer position = (Integer) v.getTag();
        switch (v.getId()){
            case R.id.tv_subgoodsCount:
                Log.e("Bing", "******减号点击: ******");
                if (myOnItemSelectLinstener!=null){
                    myOnItemSelectLinstener.myOnItemSelectLinstener(position, false);
                }
                break;
            case R.id.tv_addgoodsCount:
                Log.e("Bing", "******加号点击: ******");
                if (myOnItemSelectLinstener!=null){
                    myOnItemSelectLinstener.myOnItemSelectLinstener(position, true);
                }
                break;

        }
    }
    class ViewHolder{
        @BindView(R.id.cb_shopping_select)
        CheckBox cb_shopping_select;
        @BindView(R.id.iv_shoppingIcon)
        ImageView iv_shoppingIcon;
        @BindView(R.id.tv_shoppingName)
        TextView tv_shoppingName;
        @BindView(R.id.tv_shoppingPrice)
        TextView tv_shoppingPrice;
        @BindView(R.id.tv_subgoodsCount)
        TextView tv_subgoodsCount;
        @BindView(R.id.tv_shopgoodsCount)
        TextView tv_shopgoodsCount;
        @BindView(R.id.tv_addgoodsCount)
        TextView tv_addgoodsCount;
    }
    
    
    
}
