package com.wbh.myjxksecret.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.wbh.myjxksecret.R;
import com.wbh.myjxksecret.adapter.CollectGoodsAdapter;
import com.wbh.myjxksecret.javabean.GoodsInfo;
import com.wbh.myjxksecret.mysql.DBManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PerCollectionActivity extends AppCompatActivity {

    @BindView(R.id.et_coll_listView)
    PullToRefreshListView et_coll_listView;
    @BindView(R.id.iv_coll_back)
    ImageView iv_coll_back;
    private CollectGoodsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per_collection);
        ButterKnife.bind(this);
        initDBManager();
        //操作ListView
        initListView();
    }

    @OnClick(R.id.iv_coll_back)
    public void clickBack(View view){
        finish();
    }
    private void initDBManager() {

    }

    private void initListView() {
        adapter = new CollectGoodsAdapter(this);
        quaryGoods(null);
        //加载空列表
        et_coll_listView.setAdapter(adapter);
    }

    public void quaryGoods(String key) {
        List<GoodsInfo> goodsInfos = new DBManager(this).queryAllGoods(key);
        Log.e("Bing", "******收藏列表中的数据: ******"+goodsInfos.size());
        refresh(goodsInfos);
    }

    public void refresh(List<GoodsInfo> goodsInfos) {
        adapter.setList(goodsInfos);
        adapter.notifyDataSetChanged();
    }

}
