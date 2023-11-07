package com.example.lapmarket.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "LapMarket", null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String account = "CREATE TABLE ACCOUNT(id INTEGER PRIMARY KEY AUTOINCREMENT,taikhoan TEXT , hoten TEXT, matkhau TEXT,email TEXT, loaitaikhoan TEXT)";
        db.execSQL(account);

        db.execSQL("INSERT INTO ACCOUNT VALUES (1,'admin','Trịnh Đình Trường','123456','anhlabachu2004@gmail.com', 'admin')," +
                "(2,'user','Trịnh Đình Sơn ','654321','truongtdph40209@fpt.edu.vn', 'user')");

        String sanpham_home = "CREATE TABLE SANPHAM(masp INTEGER PRIMARY KEY AUTOINCREMENT,tensp TEXT , gia INTEGER)";
        db.execSQL(sanpham_home);

        db.execSQL("INSERT INTO SANPHAM VALUES (1,'Acer Nitro 5',15900)," +
                "(2,'Asus Vivo Book',16900000),"  +
                "(3,'Lenovo Thinkpad',18900000),"  +
                "(4,'Acer Aspire 3',8600000),"  +
                "(5,'MSI Modern 15',13790000),"  +
                "(6,'Macbook Air 2020',17690000),"  +
                "(7,'Macbook Air 2022',25450000),"  +
                "(8,'Macbook Pro 16',57000000)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("drop table if exists ACCOUNT");
            db.execSQL("drop table if exists SANPHAM");
            onCreate(db);
        }
    }
}
