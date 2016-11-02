package com.wbh.myjxksecret.mysql;

import android.content.Context;
import android.text.TextUtils;

import com.wbh.myjxksecret.javabean.DaoMaster;
import com.wbh.myjxksecret.javabean.DaoSession;
import com.wbh.myjxksecret.javabean.ShoppingGoodsBean;
import com.wbh.myjxksecret.javabean.ShoppingGoodsBeanDao;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */
public class ShoppingDBManager {
    ShoppingGoodsBeanDao shoppingGoodsBeanDao;
    private static ShoppingDBManager shoppingDBManager = null;

    public ShoppingDBManager(Context context) {
        DaoSession shoppingCars = DaoMaster.newDevSession(context, "shoppingcar");
        shoppingGoodsBeanDao = shoppingCars.getShoppingGoodsBeanDao();
    }

    public static ShoppingDBManager newShoppingCarInstance(Context context) {
        if (shoppingDBManager == null) {
            shoppingDBManager = new ShoppingDBManager(context);
        }
        return shoppingDBManager;
    }

    //单条插入
    public void insertSingleGoods(ShoppingGoodsBean shoppingGoods){
        shoppingGoodsBeanDao.insert(shoppingGoods);
    }

    //查询
    public List<ShoppingGoodsBean> queryAllGoods(String key){
        //模糊查询,QueryBuilder, 建造者模式
        QueryBuilder<ShoppingGoodsBean> queryBuilder = shoppingGoodsBeanDao.queryBuilder();
        Query<ShoppingGoodsBean> build = null;
        if (!TextUtils.isEmpty(key)){
            //条件查询
            build = queryBuilder.where(ShoppingGoodsBeanDao.Properties.Name.like("%"+key+"%"))
                    .build();
        } else{
            //全部查询
            build = queryBuilder.build();
        }
        List<ShoppingGoodsBean> ShoppingGoodsBeanList = build.list();
        return ShoppingGoodsBeanList;
    }

    //删除单条
    public void deleteSingleGoods(ShoppingGoodsBean ShoppingGoodsBean){
        shoppingGoodsBeanDao.delete(ShoppingGoodsBean);
    }

    //删除所有
    public void delectGoodsList(){
        shoppingGoodsBeanDao.deleteAll();
    }

    //更新
    public void updateGoods(ShoppingGoodsBean ShoppingGoodsBean){
        shoppingGoodsBeanDao.update(ShoppingGoodsBean);
    }
}
