package com.example.lapmarket.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lapmarket.database.DbHelper;
import com.example.lapmarket.model.giohang;
import com.example.lapmarket.model.sanpham;

import java.util.ArrayList;

public class GioHangDAO {
    DbHelper dbHelper;
    public GioHangDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public ArrayList<giohang> listGH() {
        ArrayList<giohang> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM GIOHANG", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();
            do {
                list.add(new giohang(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
            } while (cursor.moveToNext());
        }
        return list;
    }

    public void addToCart(sanpham sanPham) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("TENSP", sanPham.getTensp());
        values.put("GIA", sanPham.getGia());

        sqLiteDatabase.insert("GIOHANG", null, values);
        sqLiteDatabase.close();
    }

    public void deleteFromCart(int magh) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        sqLiteDatabase.delete("GIOHANG", "ID=?", new String[]{String.valueOf(magh)});
        sqLiteDatabase.close();
    }

    public void updateQuantity(int ID, int newQuantity) {
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("SOLUONG", newQuantity);

        sqLiteDatabase.update("GIOHANG", values, "ID=?", new String[]{String.valueOf(ID)});
        sqLiteDatabase.close();
    }

}
