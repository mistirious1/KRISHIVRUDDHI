package com.example.krishivruddhi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler1 extends SQLiteOpenHelper {

    public DBHandler1(Context context) {super(context, "KV11.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table user1(name1 TEXT,spinner TEXT, spinner1 TEXT,dob1 TEXT,address1 TEXT,acres TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists user1");
    }
    public Boolean insertuserdata(String spinner, String spinner1,String dob1, String address1)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("spinner", spinner);
        contentValues.put("spinner1", spinner1);
        contentValues.put("dob1", dob1);
        contentValues.put("address1", address1);

        long result=DB.insert("user1", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean insertuserdata1(String name1,String spinner, String spinner1,String dob1, String acres)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name1", name1);
        contentValues.put("spinner", spinner);
        contentValues.put("spinner1", spinner1);
        contentValues.put("dob1", dob1);
        contentValues.put("acres", acres);

        long result=DB.insert("user1", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean updateuserdata(String spinner, String spinner1, String dob1,String address1)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("spinner", spinner);
        contentValues.put("spinner1", spinner1);
        contentValues.put("dob1", dob1);
        contentValues.put("address1", address1);
        Cursor cursor = DB.rawQuery("Select * from user1 where spinner = ?", new String[]{spinner});
        if (cursor.getCount() > 0) {
            long result = DB.update("user1", contentValues, "spinner=?", new String[]{spinner});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public Boolean updateuserdata1(String name1,String spinner, String spinner1, String dob1,String acres)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name1", name1);
        contentValues.put("spinner", spinner);
        contentValues.put("spinner1", spinner1);
        contentValues.put("dob1", dob1);
        contentValues.put("acres", acres);
        Cursor cursor = DB.rawQuery("Select * from user1 where name1 = ?", new String[]{name1});
        if (cursor.getCount() > 0) {
            long result = DB.update("user1", contentValues, "name1=?", new String[]{name1});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public Cursor getdata ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select name1,spinner,spinner1,dob1,acres from user1 ", new String[]{});
        return cursor;

    }
    public Cursor getdata1 (String spinner,String spinner1)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select spinner,spinner1,address1 from user1 where spinner=? and spinner1=? ", new String[]{spinner,spinner1});
        return cursor;

    }

}

