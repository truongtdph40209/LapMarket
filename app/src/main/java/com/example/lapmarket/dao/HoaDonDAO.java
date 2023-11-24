package com.example.lapmarket.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lapmarket.database.DbHelper;
import com.example.lapmarket.designPantter.AccountSingle;
import com.example.lapmarket.model.giohang;
import com.example.lapmarket.model.hoadon;
import com.example.lapmarket.model.sanpham;

import java.util.ArrayList;

public class HoaDonDAO {


    DbHelper dbHelper;
    public HoaDonDAO(Context context){
        dbHelper = new DbHelper(context);
    }


    public ArrayList<hoadon> selectHoaDon() {
        ArrayList<hoadon> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM HOADON", null);
        if (cursor.getCount() != 0) {
            cursor.moveToFirst();

                do {
                    if (cursor.getInt(7) == AccountSingle.getInstance().getAccount().getId()){
                        list.add(new hoadon(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getInt(3),cursor.getInt(4), cursor.getString(5), cursor.getInt(6)));
                    }
                } while (cursor.moveToNext());


        }
        return list;
    }



//    public void addHoaDon(giohang hd) {
//        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("tensp", hd.getTensp());
//        values.put("SOLUONG", hd.getSOLUONG());
//        values.put("gia", hd.getGia());
//
//        sqLiteDatabase.insert("HOADON", null, values);
//        sqLiteDatabase.close();
//    }

    public boolean thayDoiTrangThai ( int mahd){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("trangthai", 1);
        long check = sqLiteDatabase.update("HOADON", contentValues, "mahd = ?", new String[]{String.valueOf(mahd)});
        if (check == -1){
            return false;
        }
        return true;
    }




}
