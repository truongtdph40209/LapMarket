package com.example.lapmarket.model;

public class giohang {
    private int ID;
    private String tensp;
    private int gia;
    private int SOLUONG;
    private int masp;

    public giohang(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }


    public giohang(int ID, String tensp, int gia, int SOLUONG, int masp) {
        this.ID = ID;
        this.tensp = tensp;
        this.gia = gia;
        this.SOLUONG = SOLUONG;
        this.masp = masp;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG ;
    }

    public giohang(int ID, String tensp, int gia) {
        this.ID = ID;
        this.tensp = tensp;
        this.gia = gia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
