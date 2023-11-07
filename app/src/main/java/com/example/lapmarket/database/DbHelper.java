package com.example.lapmarket.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "LapMarket", null, 4);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String account = "CREATE TABLE ACCOUNT(id INTEGER PRIMARY KEY AUTOINCREMENT,taikhoan TEXT , hoten TEXT, matkhau TEXT,email TEXT, loaitaikhoan TEXT)";
        db.execSQL(account);

        db.execSQL("INSERT INTO ACCOUNT VALUES (1,'admin','Trịnh Đình Trường','123456','anhlabachu2004@gmail.com', 'admin')," +
                "(2,'user','Trịnh Đình Sơn ','654321','truongtdph40209@fpt.edu.vn', 'user')");

        String sanpham_home = "CREATE TABLE SANPHAM(masp INTEGER PRIMARY KEY AUTOINCREMENT,tensp TEXT , gia INTEGER)";
        db.execSQL(sanpham_home);

        db.execSQL("INSERT INTO SANPHAM VALUES (1,'Acer Nitro 5',15900000)," +
                "(2,'Asus Vivo Book',16900000),"  +
                "(3,'Lenovo Thinkpad',18900000),"  +
                "(4,'Acer Aspire 3',8600000),"  +
                "(5,'MSI Modern 15',13790000),"  +
                "(6,'Macbook Air 2020',17690000),"  +
                "(7,'Macbook Air 2022',25450000),"  +
                "(8,'Macbook Pro 16',57000000)" );

        String sanpham_gaming = "CREATE TABLE GAMING(masp INTEGER PRIMARY KEY AUTOINCREMENT,tensp TEXT , gia INTEGER)";
        db.execSQL(sanpham_gaming);

        db.execSQL("INSERT INTO GAMING VALUES (1,'Acer Nitro Gaming',15900000)," +
                "(2,'Asus TUF Gaming',16900000),"  +
                "(3,'MSI Thin GF63 Gaming',18900000),"  +
                "(4,'Acer Aspire 3',15600000),"  +
                "(5,'Nitro 5 Tiger',23900000),"  +
                "(6,'Nitro 5 2022',17690000),"  +
                "(7,'HP Victus Gaming',15900000),"  +
                "(8,'Lenovo Thinkpad Gaming',17900000)");


        String sanpham_vanphong = "CREATE TABLE VANPHONG(masp INTEGER PRIMARY KEY AUTOINCREMENT,tensp TEXT , gia INTEGER)";
        db.execSQL(sanpham_vanphong);

        db.execSQL("INSERT INTO VANPHONG VALUES (1,'HP Pavilion 15',16800000)," +
                "(2,'HP 240 G9 ',15790000),"  +
                "(3,'Dell Inspiron T7430',21690000),"  +
                "(4,'Dell Vostro',16990000),"  +
                "(5,'Asus Zenbook 14',24590000),"  +
                "(6,'Zenbook 14X OLED',18790000),"  +
                "(7,'Macbook Air 2020',17690000),"  +
                "(8,'Macbook Air 2020',17690000),"  +
                "(9,'Macbook Pro 16',57000000)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion) {
            db.execSQL("drop table if exists ACCOUNT");
            db.execSQL("drop table if exists SANPHAM");
            db.execSQL("drop table if exists GAMING");
            db.execSQL("drop table if exists VANPHONG");
            onCreate(db);
        }
    }
}
