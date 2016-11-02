package com.wbh.myjxksecret.mysql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/11/1.
 */
public class LoveSqlHelp extends SQLiteOpenHelper{


    public LoveSqlHelp(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not  exists lovetb(_id integer primary key autoincrement,loveid text)";
        db.execSQL(sql);
        String sql1 = "create table if not  exists selecttb(_id integer primary key autoincrement,selectid text)";
        db.execSQL(sql1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
