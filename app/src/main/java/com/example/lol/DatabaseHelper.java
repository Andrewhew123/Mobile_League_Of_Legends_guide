package com.example.lol;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context){
        super(context, "myDB",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table top(id integer primary key autoincrement, name varchar(25), roles varchar(30))");
        db.execSQL("create table mid(id integer primary key autoincrement, name varchar(25), roles varchar(30))");
        db.execSQL("create table bot(id integer primary key autoincrement, name varchar(25), roles varchar(30))");
        db.execSQL("create table jungler(id integer primary key autoincrement, name varchar(25), roles varchar(30))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

