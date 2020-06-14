package com.example.sqlitetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, "PACE", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists student" +
                "(id integer primary key autoincrement," +
                "name varchar(200),mobile varchar(10));");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Long insertData(ContentValues values){
        SQLiteDatabase db = getWritableDatabase();
        Long i = db.insert("student",null,values);
        return i;

    }


    public Cursor getData(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from student",null);
        return c;
    }

}
