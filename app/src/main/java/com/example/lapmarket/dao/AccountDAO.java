package com.example.lapmarket.dao;

import android.content.ContentValues;
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
                list.add(new account(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),cursor.getString(5)));

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

    //singup
    public boolean signup(String taikhoan,String hoten, String matkhau,String email ){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("taikhoan", taikhoan);
        contentValues.put("hoten", hoten);
        contentValues.put("matkhau", matkhau);
        contentValues.put("email", email);


        long check = sqLiteDatabase.insert("ACCOUNT", null, contentValues);

            return check != -1;

    }

    //quenmk
    public String fogotpass(String email ){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT matkhau FROM ACCOUNT WHERE email = ? ", new String []{email} );
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            return cursor.getString(0) ;

        }
        return "";
    }



    //xoatk
    public int delete(int id){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM ACCOUNT WHERE id = ?", new String[]{String.valueOf(id)});
        if (cursor.getCount() != 0){
            return -1;
        }
        long check = sqLiteDatabase.delete("ACCOUNT","id = ?", new String[]{String.valueOf(id)});

        if (check == -1){
            return 0;
        }
        return 1;
    }
}
