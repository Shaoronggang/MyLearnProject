package com.detao.mylearnproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shaoronggang on 2017/3/28.
 */

public class MyTestDataOpenHelper extends SQLiteOpenHelper {
    public MyTestDataOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MyTestDataOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String sql = "insert into user(username,password)valus('Jack','123456')"; //数据库添加的第一种方法
        db.execSQL(sql);
        //数据库添加的第二种方法
        insert(db);
        String sqldel = "delete from user where username='Jack'"; //删除操作的SQl语句
        db.execSQL(sqldel);
        //删除的第二种方法
        delete(db);
        //修改的第一种方法
        String sqlup = "update user set password='asd12345' where username='Jack'"; //修改SQL语句
        db.execSQL(sqlup);
        //修改的第二种方法
        update(db);

    }

    private void update(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put("password","asd123"); //添加要更改的字段以及内容
        String whereClause = "username=?"; //修改条件
        String []whereArgs = {"Jack"}; //修改条件的参数
        db.update("user",cv,whereClause,whereArgs); // 执行修改
    }

    private void delete(SQLiteDatabase db) {
        String whereClause = "username=?";//删除的条件
        String []whereArgs = {"Jack"}; //删除的条件数 ,这是一个数组
        db.delete("user",whereClause,whereArgs);
    }

    public void  insert(SQLiteDatabase db){
        ContentValues cv = new ContentValues();//实例化一个ContentValues用来装载待插入的数据
        cv.put("title","发布会");
        cv.put("weather","sun");
        cv.put("context","上下文");
        db.insert("diary",null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
