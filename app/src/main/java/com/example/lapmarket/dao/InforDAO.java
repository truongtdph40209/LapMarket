package com.example.lapmarket.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lapmarket.database.DbHelper;
import com.example.lapmarket.model.hoadon;
import com.example.lapmarket.model.infor;

import java.util.ArrayList;

public class InforDAO {
    DbHelper dbHelper;
    public InforDAO(Context context) {
        dbHelper = new DbHelper(context);
    }
    public ArrayList<infor> list = new ArrayList<>();

    public ArrayList<infor> selectInfor(){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM INFOR",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new infor(cursor.getInt(0), cursor.getString(1),  cursor.getString(2), cursor.getString(3) ));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public infor getInfor(int index){
        return list.get(index);
    }

    public boolean addInfor(String sdt, String namsinh, String diachi){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("sdt", sdt);
        contentValues.put("namsinh", namsinh);
        contentValues.put("diachi", diachi);
        long check = sqLiteDatabase.insert("INFOR", null, contentValues);
        if (check == -1){
            return false;
        }
        return true;
    }


}
