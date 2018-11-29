package com.example.admin.duanmotfix.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.admin.duanmotfix.Constants;
import com.example.admin.duanmotfix.database.DatabaseHelper;
import com.example.admin.duanmotfix.model.Giay;

import java.util.ArrayList;

public class GIAYDAO implements Constants {
    private DatabaseHelper databaseHelper;

    public GIAYDAO(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }


    public void insertGIAY(Giay giay) {

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID,giay.id);
        contentValues.put(COLUMN_PRICE, giay.price);
        contentValues.put(COLUMN_RATING,giay.rating);
        contentValues.put(COLUMN_SHORTDES, giay.shortdesc);
        contentValues.put(COLUMN_TITLE, giay.title);
        contentValues.put(COLUMN_IMG, giay.image);

        // tao cau lenh insert

        long id = sqLiteDatabase.insert(TABLE_GIAY, null, contentValues);


        sqLiteDatabase.close();

    }

    public Giay getGiaybyName(String giay) {

        Giay giay1 = null;

        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_GIAY,
                new String[]{COLUMN_ID, COLUMN_TITLE, COLUMN_SHORTDES, COLUMN_PRICE,COLUMN_RATING,COLUMN_IMG},
                COLUMN_TITLE + "=?",
                new String[]{giay}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {

            String idPC = cursor.getString(cursor.getColumnIndex(COLUMN_ID));

            String title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
            String shortdesc = cursor.getString(cursor.getColumnIndex(COLUMN_SHORTDES));
            String img = cursor.getString(cursor.getColumnIndex(COLUMN_IMG));
            double price = cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE));
            double rating = cursor.getDouble(cursor.getColumnIndex(COLUMN_RATING));

            giay1 = new Giay();
            giay1.setId(idPC);
            giay1.setPrice(price);
            giay1.setRating(rating);
            giay1.setShortdesc(shortdesc);
            giay1.setTitle(title);
            giay1.setImage(img);
        }

        return giay1;
    }

    public ArrayList<Giay> getAllGiay() {


        ArrayList<Giay> giayArrayList = new ArrayList<>();

        String SELECT_ALL_Giay = "SELECT * FROM " + TABLE_GIAY;


        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_Giay, null);


        if (cursor != null && cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex(COLUMN_ID));

                String title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
                String shortdesc = cursor.getString(cursor.getColumnIndex(COLUMN_SHORTDES));
                String img = cursor.getString(cursor.getColumnIndex(COLUMN_IMG));
                double price = cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE));
                double rating = cursor.getDouble(cursor.getColumnIndex(COLUMN_RATING));

                Giay giay1 = new Giay();
                giay1.setId(id);
                giay1.setPrice(price);
                giay1.setRating(rating);
                giay1.setShortdesc(shortdesc);
                giay1.setTitle(title);
                giay1.setImage(img);
                giayArrayList.add(giay1);


            } while (cursor.moveToNext());
        }

        cursor.close();
        sqLiteDatabase.close();

        return giayArrayList;
    }



}
