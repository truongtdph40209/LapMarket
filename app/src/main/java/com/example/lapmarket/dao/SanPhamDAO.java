package com.example.lapmarket.dao;

import android.content.ContentValues;
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
                list.add(new sanpham(cursor.getInt(0), cursor.getString(1),  cursor.getInt(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16)));

            }while (cursor.moveToNext());
        }
        return list;


    }

    public ArrayList<sanpham> selectGAMING(){
        ArrayList<sanpham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM GAMING",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new sanpham(cursor.getInt(0), cursor.getString(1),  cursor.getInt(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16)));

            }while (cursor.moveToNext());
        }
        return list;
    }

    public ArrayList<sanpham> selectMACBOOK(){
        ArrayList<sanpham> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM VANPHONG",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new sanpham(cursor.getInt(0), cursor.getString(1),  cursor.getInt(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getString(15), cursor.getString(16)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public void addToCart(sanpham sanPham) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TENSP", sanPham.getTensp());
        values.put("GIA", sanPham.getGia());

        // Insert the product into the GIOHANG table
        sqLiteDatabase.insert("GIOHANG", null, values);
        sqLiteDatabase.close();
    }

}
