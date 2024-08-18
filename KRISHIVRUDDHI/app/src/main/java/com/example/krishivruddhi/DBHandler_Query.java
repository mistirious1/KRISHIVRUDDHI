package com.example.krishivruddhi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler_Query extends SQLiteOpenHelper {
    public DBHandler_Query(Context context) {
        super(context, "KV12.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Farmerquery(user TEXT primary key,question TEXT,answer1 TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Farmerquery");
    }

    public Boolean insertuserdata(String user, String question) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user", user);
        contentValues.put("question", question);
        long result = DB.insert("Farmerquery", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Boolean insertuserdata1(String user, String question,String answer1) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user", user);
        contentValues.put("question", question);
        contentValues.put("answer1", answer1);

        long result = DB.insert("Farmerquery", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateuserdata(String user,String answer1) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user", user);
        contentValues.put("answer1", answer1);
        Cursor cursor = DB.rawQuery("Select * from Farmerquery where user = ?", new String[]{user});
        if (cursor.getCount() > 0) {
            long result = DB.update("Farmerquery", contentValues, "user=?", new String[]{user});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deletedata (String user)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Farmerquery where user = ?", new String[]{user});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Farmerquery", "user=?", new String[]{user});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public Cursor getdata (String user)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Farmerquery where user= ? ", new String[]{user});
        return cursor;

    }
    public Cursor getdata1 ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Farmerquery ", new String[]{});
        return cursor;

    }
}

