package com.example.admin.duanmotfix.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


import com.example.admin.duanmotfix.Constants;




public class DatabaseHelper extends SQLiteOpenHelper implements Constants {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "shop giay", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_GIAY);
        sqLiteDatabase.execSQL(CREATE_TABLE_CART);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_GIAY);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);

        onCreate(sqLiteDatabase);

    }
}
