package com.example.krishivruddhi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {super(context, "KV13.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Market(id TEXT primary key,lc TEXT, cp TEXT, pr TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Market");
    }
    public Boolean insertuserdata(String id,String lc, String cp, String pr)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("lc", lc);
        contentValues.put("cp", cp);
        contentValues.put("pr", pr);
        long result=DB.insert("Market", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Boolean updateuserdata(String id,String lc, String cp, String pr)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("lc", lc);
        contentValues.put("cp", cp);
        contentValues.put("pr", pr);
        Cursor cursor = DB.rawQuery("Select * from Market where id = ?", new String[]{id});
        if (cursor.getCount() > 0) {
            long result = DB.update("Market", contentValues, "id=?", new String[]{id});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public Boolean deletedata (String id)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Market where id = ?", new String[]{id});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Market", "id=?", new String[]{id});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor getdata (String lc)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Market where lc =?", new String[]{lc});
        return cursor;

    }
}

