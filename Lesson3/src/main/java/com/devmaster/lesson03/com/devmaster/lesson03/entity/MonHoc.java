package com.devmaster.lesson03.com.devmaster.lesson03.entity;

public class MonHoc {
    String MaMonHoc;
    String TenMonHoc;
    int SoTiet;

    public MonHoc() {
    }

    public MonHoc(String maMonHoc, String tenMonHoc, int soTiet) {
        MaMonHoc = maMonHoc;
        TenMonHoc = tenMonHoc;
        SoTiet = soTiet;
    }

    public String getMaMonHoc() {
        return MaMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        MaMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return TenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        TenMonHoc = tenMonHoc;
    }

    public int getSoTiet() {
        return SoTiet;
    }

    public void setSoTiet(int soTiet) {
        SoTiet = soTiet;
    }
}
