package com.example.samsung.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by samsung on 2016/11/30.
 */

public class DBHelper {
    private static final String DATABASE_NAME="lj_db";//保存数据库名
    private static final int DATABASE_VERSION=1;      //保存数据库版本
    private static final String TABLE_NAME="users";   //保存数据库表名
    private static final String ID="_id";              //保存字段名：id
    private static final String USERNAME="username"; //保存字段名：帐号
    private static final String PASSWORD="password"; //保存字段名：密码
    private static final String REALNAME="realname"; //保存字段名：姓名
    private static final String TEL="tel";             //保存字段名：电话
    private static final String REL="rel";             //保存字段名：关系
    private static final String REMARK="remark";      //保存字段名：备注
    private static final String BIRTHDAY="birthday"; //保存字段名：生日
    private static final String BIRTHDAY_TYPE="birthday_type"; //保存字段名：生日类型，，如公历的阳历即几月几号（国际通用日历）或农历的阴历，几月初几（夏历）

    private static final String[] COLUMNS= new String[]{ID,USERNAME,REALNAME,TEL,REL,REALNAME};
    private DBOpenHelper helper;
    private SQLiteDatabase db;
    private static class DBOpenHelper extends SQLiteOpenHelper{
        private static final String CREATE_TABLE="create table "+ TABLE_NAME +
                "("+ ID +" integer primary key autoincrement,"+ USERNAME +" text not null,"+ PASSWORD +
                " text not null,"+ REALNAME +" text null,"+ TEL +" text not null,"+ REL +" text null,"+ REMARK +" text null);";
        public DBOpenHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);//引用父类函数实现数据库的创建
        }
        @Override//表示编译器可以给你验证@Override下面的方法名是否是你父类中所有，如果没有则报错
        public void onCreate(SQLiteDatabase db){
            db.execSQL(CREATE_TABLE);//创建数据库表结构
        }
        @Override
        public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
            db.execSQL("drop table if exists "+TABLE_NAME);//删除旧版数据库表
            onCreate(db);//重新创建表格
        }
    }
    public DBHelper(Context context){
    helper=new DBOpenHelper(context);
    db=helper.getWritableDatabase();
    }
    public void insert(User user){
        ContentValues values=new ContentValues();
        values.put(USERNAME, user.getUsername());
        values.put(PASSWORD,user.getPassword());
        values.put(REALNAME,user.getRealname());
        values.put(TEL,user.getTel());
        values.put(REL,user.getRel());
        values.put(REMARK,user.getRemark());
        db.insert(TABLE_NAME,null,values);
    }
    public User query(int id){
        User user=new User();
        //public Cursor query(String table,String [] columns,String selection,String[] selectionArgs,String groupBy,String having,String orderBy)
        //table:要查询数据的数据表名；columns:列数组；selection:查询条件；selectionArgs:查询条件中用到的参数；groupBy:分组字段；having:分组字段；orderBy:排序字段
        Cursor cursor=db.query(TABLE_NAME,new String[]{USERNAME,PASSWORD,REALNAME,TEL,REL,REMARK},"_id="+id,null,null,null,null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            user.setUsername(cursor.getString(0));
            user.setPassword(cursor.getString(1));
            user.setRealname(cursor.getString(2));
            user.setTel(cursor.getString(3));
            user.setRel(cursor.getString(4));
            user.setRemark(cursor.getString(5));
            return user;
        }
        cursor.close();//关闭游标
        return null;
    }
    //查询所有字段
    public List<String> queryAll(){
        List<String> result=new ArrayList<String>();
        Cursor cursor=db.query(TABLE_NAME,new String[]{ID,USERNAME,REALNAME,TEL,REL,REMARK},null,null,null,null,null);
        while (cursor.moveToNext()){
            result.add(cursor.getInt(0)+"-"+cursor.getString(1)+"-"+cursor.getString(2)+"-"+cursor.getString(3)+"-"+cursor.getString(4)+"-"+cursor.getString(5));
            //result.add(cursor.getInt(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" "+cursor.getString(5)+" "+cursor.getString(6));
        }
        return result;
    }
    //查询电话
    public List<String> queryTel(){
        List<String> result=new ArrayList<String>();
        Cursor cursor=db.query(TABLE_NAME,new String[]{TEL},null,null,null,null,null);
        while (cursor.moveToNext()){
            result.add(cursor.getString(0));
            //result.add(cursor.getInt(1)+" "+cursor.getString(2)+" "+cursor.getString(3)+" "+cursor.getString(4)+" "+cursor.getString(5)+" "+cursor.getString(6));
        }
        return result;
    }

    //判断电话是否存在
    public boolean checkTelExist(String tel){
        boolean result = false ;
        Cursor cursor = null ;
        try{
            cursor = db.rawQuery( "select * from "+TABLE_NAME+" where tel = ?"
                    , new String[]{tel } );
            result = null != cursor && cursor.moveToFirst() ;
        }catch (Exception e){
            Log.e("TAG","checkTelExists..." + e.getMessage()) ;
        }finally{
            if(null != cursor && !cursor.isClosed()){
                cursor.close() ;
            }
        }
        return result;
    }
}
