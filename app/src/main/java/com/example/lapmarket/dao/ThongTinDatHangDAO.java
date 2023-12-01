package com.example.lapmarket.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lapmarket.database.DbHelper;
import com.example.lapmarket.model.dathang;
import com.example.lapmarket.model.infor;

import java.util.ArrayList;

public class ThongTinDatHangDAO {
    DbHelper dbHelper;
    public ThongTinDatHangDAO(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<dathang> selectThongTinDatHang(){
        ArrayList<dathang> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM CTHOADON",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new dathang(cursor.getInt(0), cursor.getString(1),  cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getInt(5), cursor.getInt(6), cursor.getInt(7)));

            }while (cursor.moveToNext());
        }
        return list;
    }

    public boolean add_TT_DatHang(dathang dh){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sdt", dh.getSdt());
        contentValues.put("namsinh", dh.getNamsinh());
        contentValues.put("diachi", dh.getDiachi());
        contentValues.put("tensp", dh.getTensp());
        contentValues.put("soluong", dh.getSoluong());
        contentValues.put("gia", dh.getGia());
        contentValues.put("xacnhan", dh.getXacnhan());
        long check = sqLiteDatabase.insert("CTHOADON", null, contentValues);
        if (check == -1){
            return false;
        }
        return true;
    }

}
