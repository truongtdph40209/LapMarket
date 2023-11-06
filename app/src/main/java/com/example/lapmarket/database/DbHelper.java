package com.example.lapmarket.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "LapMarket", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String account = "CREATE TABLE ACCOUNT(taikhoan TEXT PRIMARY KEY, hoten TEXT, matkhau TEXT, loaitaikhoan text)";
        db.execSQL(account);

        db.execSQL("INSERT INTO ACCOUNT VALUES ('admin','Trịnh Đình Trường','123456', 'admin'),('user','Trịnh Đình Sơn ','654321', 'user')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("drop table if exists ACCOUNT");
            onCreate(db);
        }
    }
}
