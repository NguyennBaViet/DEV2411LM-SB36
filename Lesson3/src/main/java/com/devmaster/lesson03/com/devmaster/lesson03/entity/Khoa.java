package com.devmaster.lesson03.com.devmaster.lesson03.entity;

public class Khoa {
    String MaKhoa;
    String TenKhoa;

    public Khoa() {
    }
    public Khoa(String MaKhoa, String TenKhoa) {
        this.MaKhoa = MaKhoa;
        this.TenKhoa = TenKhoa;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        MaKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return TenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        TenKhoa = tenKhoa;
    }
}
