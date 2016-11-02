package com.wbh.myjxksecret.mysql;

import android.content.Context;
import android.text.TextUtils;

import com.wbh.myjxksecret.javabean.DaoMaster;
import com.wbh.myjxksecret.javabean.DaoSession;
import com.wbh.myjxksecret.javabean.GoodsInfo;
import com.wbh.myjxksecret.javabean.GoodsInfoDao;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */
public class DBManager {
    GoodsInfoDao goodsInfoDao;
    private static DBManager dbManager = null;

    public DBManager(Context context){
        //数据库名称
        DaoSession daoSession = DaoMaster.newDevSession(context, "goods");
        //获取实体类对应的表
        goodsInfoDao = daoSession.getGoodsInfoDao();
    }

    //单例模式
    public static DBManager getMyDBInstance(Context context){
        if (dbManager == null){
            dbManager = new DBManager(context);
        }
        return dbManager;
    }

    //单条插入
    public void insertSingleGoods(GoodsInfo goodsInfo){
        goodsInfoDao.insert(goodsInfo);
    }
    //多条插入
    public void insertGoodsList(List<GoodsInfo> list){
        goodsInfoDao.insertOrReplaceInTx(list);
    }

    //查询
    public List<GoodsInfo> queryAllGoods(String key){
        //模糊查询,QueryBuilder, 建造者模式
        QueryBuilder<GoodsInfo> queryBuilder = goodsInfoDao.queryBuilder();
        Query<GoodsInfo> build = null;
        if (!TextUtils.isEmpty(key)){
            //条件查询
            build = queryBuilder.where(GoodsInfoDao.Properties.Name.like("%"+key+"%"))
                    .build();
        } else{
            //全部查询
            build = queryBuilder.build();
        }
        List<GoodsInfo> goodsInfoList = build.list();
     return goodsInfoList;
    }

    //删除单条
    public void deleteSingleGoods(GoodsInfo goodsInfo){
        goodsInfoDao.delete(goodsInfo);
    }

    //删除所有
    public void delectGoodsList(){
        goodsInfoDao.deleteAll();
    }

    //更新
    public void updateGoods(GoodsInfo goodsInfo){
        goodsInfoDao.update(goodsInfo);
    }

}
