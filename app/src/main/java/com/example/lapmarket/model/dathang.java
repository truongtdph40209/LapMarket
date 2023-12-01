package com.example.lapmarket.model;

public class dathang {
    private int sophieu;

    private String sdt;
    private String namsinh;
    private String diachi;
    private String tensp;
    private int soluong;
    private int gia;
    private int xacnhan;

    public dathang() {
    }

    public dathang(int sophieu, String sdt, String namsinh, String diachi, String tensp, int soluong, int gia, int xacnhan) {
        this.sophieu = sophieu;
        this.sdt = sdt;
        this.namsinh = namsinh;
        this.diachi = diachi;
        this.tensp = tensp;
        this.soluong = soluong;
        this.gia = gia;
        this.xacnhan = xacnhan;
    }

    public dathang(String sdt, String namsinh, String diachi, String tensp, int soluong, int gia, int xacnhan) {
        this.sdt = sdt;
        this.namsinh = namsinh;
        this.diachi = diachi;
        this.tensp = tensp;
        this.soluong = soluong;
        this.gia = gia;
        this.xacnhan = xacnhan;
    }

    public int getSophieu() {
        return sophieu;
    }

    public void setSophieu(int sophieu) {
        this.sophieu = sophieu;
    }


    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }


    public int getXacnhan() {
        return xacnhan;
    }

    public void setXacnhan(int xacnhan) {
        this.xacnhan = xacnhan;
    }
}
