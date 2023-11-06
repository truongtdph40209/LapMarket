package com.example.lapmarket.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lapmarket.database.DbHelper;
import com.example.lapmarket.model.account;

import java.util.ArrayList;

public class AccountDAO {

    DbHelper dbHelper;
    public AccountDAO(Context context) {
        dbHelper = new DbHelper(context);

    }
    public ArrayList<account> selectALL_Account(){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        ArrayList<account> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM ACCOUNT",null);
        if (cursor.getCount() != 0){
            cursor.moveToFirst();
            do {
                list.add(new account(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));

            }while (cursor.moveToNext());
        }
        return list;
    }

    public boolean checkdn(String taikhoan, String matkhau){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM ACCOUNT WHERE taikhoan = ? AND matkhau = ?", new String[]{taikhoan, matkhau});
        if (cursor.getCount() != 0) {
            return true;
        }else {
            return false;
        }
    }
}
