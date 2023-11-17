package com.example.lapmarket.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lapmarket.database.DbHelper;
import com.example.lapmarket.model.phukien;
import com.example.lapmarket.model.sanpham;

import java.util.ArrayList;

public class PhuKienDAO {
    DbHelper dbHelper;
    public PhuKienDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<phukien> selectPHUKIEN(){
        ArrayList<phukien> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM PHUKIEN",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new phukien(cursor.getInt(0), cursor.getString(1),  cursor.getInt(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8)));

            }while (cursor.moveToNext());
        }
        return list;


    }

    public void addToCart(phukien phuKien) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TENPK", phuKien.getTenpk());
        values.put("GIA", phuKien.getGia());

        // Insert the product into the GIOHANG table
        sqLiteDatabase.insert("GIOHANG", null, values);
        sqLiteDatabase.close();
    }

}
