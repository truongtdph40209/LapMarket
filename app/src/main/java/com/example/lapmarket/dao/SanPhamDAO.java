package com.example.lapmarket.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lapmarket.database.DbHelper;
import com.example.lapmarket.model.sanpham;

import java.util.ArrayList;

public class SanPhamDAO {
    DbHelper dbHelper;


    public SanPhamDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<sanpham> selectSANPHAM(){
        ArrayList<sanpham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM SANPHAM",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new sanpham(cursor.getInt(0), cursor.getString(1),  cursor.getInt(2)));

            }while (cursor.moveToNext());
        }
        return list;


    }
}
