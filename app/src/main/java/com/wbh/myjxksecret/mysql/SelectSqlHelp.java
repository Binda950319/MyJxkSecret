package com.wbh.myjxksecret.mysql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/11/2.
 */
public class SelectSqlHelp extends SQLiteOpenHelper {
    public SelectSqlHelp(Context context, String name) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql2 = "create table if not  exists zanfirsttb(_id integer primary key autoincrement,zanfirstid text)";
        db.execSQL(sql2);
        String sql3 = "create table if not  exists zansecondtb(_id integer primary key autoincrement,zansecondid text)";
        db.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
