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
        String account = "CREATE TABLE ACCOUNT(id INTEGER PRIMARY KEY AUTOINCREMENT,taikhoan TEXT , hoten TEXT, matkhau TEXT,email TEXT, loaitaikhoan TEXT)";
        db.execSQL(account);

        db.execSQL("INSERT INTO ACCOUNT VALUES (1,'admin','Trịnh Đình Trường','123456','anhlabachu2004@gmail.com', 'admin'),(2,'user','Trịnh Đình Sơn ','654321','truongtdph40209@fpt.edu.vn', 'user')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("drop table if exists ACCOUNT");
            onCreate(db);
        }
    }
}
