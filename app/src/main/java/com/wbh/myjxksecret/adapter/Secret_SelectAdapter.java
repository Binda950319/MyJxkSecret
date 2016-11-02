package com.wbh.myjxksecret.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.javabean.Secret_ItemPic;
import com.wbh.myjxksecret.javabean.Secret_SelectBean;
import com.wbh.myjxksecret.mysql.LoveSqlHelp;
import com.wbh.myjxksecret.mysql.SelectSqlHelp;
import com.wbh.myjxksecret.utils.MyGridView;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/10/27.
 */
public class Secret_SelectAdapter extends BaseAdapter {
    private List<Secret_SelectBean.ObjBean.DataBean> dataList = new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;
    private int width;
    private List<Secret_ItemPic> picList = new ArrayList<>();
    private SQLiteDatabase db;
    private List<String> lovelist=new ArrayList<>();
    private List<String> zanlist=new ArrayList<>();
    private boolean islove;
    private LoveSqlHelp SqlHelp;
    private ContentValues values;
    private LoveSqlHelp SqlHelp2;
    private SQLiteDatabase db2;
    private SelectSqlHelp selectSqlHelp1;


    public Secret_SelectAdapter(List<Secret_SelectBean.ObjBean.DataBean> dataList, Context context, LoveSqlHelp loveSqlHelp,SelectSqlHelp selectSqlHelp1) {
        this.dataList = dataList;
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.SqlHelp=loveSqlHelp;
        this.selectSqlHelp1=selectSqlHelp1;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        Pic_ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.secret_item_2pic, parent, false);
            holder = new Pic_ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        } else {
            holder = (Pic_ViewHolder) convertView.getTag();
        }
        Secret_SelectBean.ObjBean.DataBean dataBean = dataList.get(position);
        if (dataBean != null) {
            //加载头像
            Glide.with(context).load(dataBean.getUserInfo().getHeadicon()).into(holder.iv_headIcon_2pic);
            holder.tv_useName_2pic.setText(dataBean.getUserInfo().getUsername());
            holder.tv_createTime_2pic.setText(dataBean.getCreateTime());
            holder.tv_subName_2pic.setText(dataBean.getSubnames());
            String data = dataBean.getContent();
            byte[] content = null;
            try {
                content = Base64.decode(data.getBytes("utf-8"), Base64.DEFAULT);
                holder.tv_content_2pic.setText(new String(content));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            holder.tv_clickCount_2pic.setText("" + dataList.get(position).getClickCount());
            holder.tv_collectCount_2pic.setText("" + dataList.get(position).getCollectCount());
            holder.tv_commentCount_2pic.setText("" + dataList.get(position).getCommentCount());
            holder.tv_praiseCount_2pic.setText("" + dataBean.getPraiseCount());
            int picSize = dataBean.getPicInfoList().size();
            if (picSize == 1) {
                width = screenWidth;
                holder.gridView_2pic.setNumColumns(1);
                Secret_ItemPic itemPic = new Secret_ItemPic(1, dataBean.getPicInfoList().get(0).getPicUrl());
                picList.add(itemPic);
            } else if (picSize >= 2 && picSize % 2 == 0 && picSize <= 4) {
                for (int i = 0; i < picSize; i++) {
                    width = screenWidth / 2;
                    holder.gridView_2pic.setNumColumns(2);
                }
            } else {
                width = screenWidth / 3;
                holder.gridView_2pic.setNumColumns(3);
            }
            if (picSize >= 0) {
                LoadingPicAdapter2 adapter = new LoadingPicAdapter2(dataBean.getPicInfoList(), context, width);
                holder.gridView_2pic.setAdapter(adapter);
            }

        }



        db = SqlHelp.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from  selecttb",null);

        if (cursor!=null){
            while (cursor.moveToNext()){
                String loveid = cursor.getString(cursor.getColumnIndex("selectid"));
                lovelist.add(loveid);
                Log.e("点击之前", "onClick: 读取成功" );
            }
        }

        //心
        for (int m = 0; m < dataList.size(); m++) {
            String id = dataList.get(m).getId();

            for (int i = 0; i < lovelist.size(); i++) {
                if (id.equals(lovelist.get(i))&&id.equals(dataList.get(position).getId())){
                    holder.cb_secret_favout.setChecked(true);

                }
            }
        }
        Log.e("点击之前", "onClick: 判断成功" );
        final Pic_ViewHolder finalHolder1 = holder;
        holder.cb_secret_favout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < lovelist.size(); i++) {
                    String idd = dataList.get(position).getId();
                    if (lovelist.get(i).equals(idd)) {
                        islove=false;
                        finalHolder1.cb_secret_favout.setChecked(islove);
                        db.delete("selecttb","selectid=?",new String[]{idd});
                        Log.e("点击以后", "onClick: 删除成功" );
                    }else {
                        values = new ContentValues();
                        islove=true;
                        finalHolder1.cb_secret_favout.setChecked(islove);
                        values.put("selectid",idd);
                        db.insert("selecttb",null,values);
                        values.clear();
                        Log.e("点击以后", "onClick: 添加成功" );
                    }
                }
                if (lovelist.size()==0){
                    String dd = dataList.get(position).getId();
                    values = new ContentValues();
                    islove=true;
                    finalHolder1.cb_secret_favout.setChecked(true);
                    values.put("selectid",dd);
                    db.insert("selecttb",null,values);
                    values.clear();
                    Log.e("22222222", "onClick: 添加成功" );
                }
            }
        });



        //点赞
        db2 = selectSqlHelp1.getReadableDatabase();
        Cursor cursor2 = db2.rawQuery("select * from zanfirsttb",null);

        if (cursor2!=null){
            while (cursor2.moveToNext()){
                String zanid = cursor2.getString(cursor2.getColumnIndex("zanfirstid"));
                zanlist.add(zanid);
                Log.e("点击之前", "onClick: 读取成功" );
            }
        }

        //
        for (int m = 0; m < dataList.size(); m++) {
            String id = dataList.get(m).getId();

            for (int i = 0; i < zanlist.size(); i++) {
                if (id.equals(zanlist.get(i))&&id.equals(dataList.get(position).getId())){
                    holder.cb_secret_praise.setChecked(true);

                }
            }
        }
        Log.e("点击之前", "onClick: 判断成功" );
        final Pic_ViewHolder finalHolder2 = holder;
        holder.cb_secret_praise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < zanlist.size(); i++) {
                    String idd = dataList.get(position).getId();
                    if (zanlist.get(i).equals(idd)) {
                        islove=false;
                        finalHolder2.cb_secret_praise.setChecked(islove);
                        db2.delete("zanfirsttb","zanfirstid=?",new String[]{idd});
                        Log.e("点击以后", "onClick: 删除成功" );
                    }else {
                        values = new ContentValues();
                        islove=true;
                        finalHolder2.cb_secret_praise.setChecked(islove);
                        values.put("zanfirstid",idd);
                        db2.insert("zanfirsttb",null,values);
                        values.clear();
                        Log.e("点击以后", "onClick: 添加成功" );
                    }
                }
                if (zanlist.size()==0){
                    String dd = dataList.get(position).getId();
                    values = new ContentValues();
                    islove=true;
                    finalHolder2.cb_secret_praise.setChecked(true);
                    values.put("zanfirstid",dd);
                    db2.insert("zanfirsttb",null,values);
                    values.clear();
                    Log.e("22222222", "onClick: 添加成功" );
                }


            }
        });

        return convertView;
    }




    class Pic_ViewHolder {
        @BindView(R.id.iv_headIcon_2pic)
        ImageView iv_headIcon_2pic;
        @BindView(R.id.tv_useName_2pic)
        TextView tv_useName_2pic;
        @BindView(R.id.tv_createTime_2pic)
        TextView tv_createTime_2pic;
        @BindView(R.id.gridView_2pic)
        MyGridView gridView_2pic;
        @BindView(R.id.tv_subName_2pic)
        TextView tv_subName_2pic;
        @BindView(R.id.tv_content_2pic)
        TextView tv_content_2pic;
        @BindView(R.id.tv_clickCount_2pic)
        TextView tv_clickCount_2pic;
        @BindView(R.id.tv_collectCount_2pic)
        TextView tv_collectCount_2pic;
        @BindView(R.id.tv_commentCount_2pic)
        TextView tv_commentCount_2pic;
        @BindView(R.id.tv_praiseCount_2pic)
        TextView tv_praiseCount_2pic;
        @BindView(R.id.secret_love)
        LinearLayout secret_love;
        @BindView(R.id.secret_talk)
        LinearLayout secret_talk;
        @BindView(R.id.secret_good)
        LinearLayout secret_good;
        @BindView(R.id.cb_secret_favout)
        CheckBox cb_secret_favout;
        @BindView(R.id.cb_secret_praise)
        CheckBox cb_secret_praise;
    }
}
