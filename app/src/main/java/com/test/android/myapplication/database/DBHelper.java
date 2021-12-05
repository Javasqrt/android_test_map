package com.test.android.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "deal";
    public static final  String DATABASE_TABLE = "new_deal";

    public static final String KEY_ID = "_id";
    public static final String NAME_DEAL = "name_deal";
    public static final String DEAL_SPINNER = "spinner_deal";
    public static final String DEAL_VALUE = "value_deal";
    public static final String DEAL_TIME = "value_time";
    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + DATABASE_TABLE + "(" + KEY_ID + " integer primary key," + NAME_DEAL + " text," + DEAL_SPINNER + " text,"
        + DEAL_VALUE + " text," + DEAL_TIME + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + DATABASE_TABLE);
        onCreate(db);

    }
}
