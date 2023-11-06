package com.example.lapmarket.model;

public class account {
    private String taikhoan;
    private String hoten;
    private String matkhau;
    private String loaitaikhoan;


    public account() {
    }

    public account(String taikhoan, String hoten, String matkhau, String loaitaikhoan) {
        this.taikhoan = taikhoan;
        this.hoten = hoten;
        this.matkhau = matkhau;
        this.loaitaikhoan = loaitaikhoan;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getLoaitaikhoan() {
        return loaitaikhoan;
    }

    public void setLoaitaikhoan(String loaitaikhoan) {
        this.loaitaikhoan = loaitaikhoan;
    }
}
