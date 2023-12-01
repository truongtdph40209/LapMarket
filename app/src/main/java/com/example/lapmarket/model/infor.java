package com.example.lapmarket.model;

public class infor {
    private int id;
    private String sdt;
    private String namsinh;
    private String diachi;


    public infor() {
    }

    public infor(int id, String sdt, String namsinh, String diachi) {
        this.id = id;
        this.sdt = sdt;
        this.namsinh = namsinh;
        this.diachi = diachi;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
}
