package com.devmaster.lesson03.com.devmaster.lesson03.service;

import com.devmaster.lesson03.com.devmaster.lesson03.entity.Khoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class KhoaService {
    List<Khoa> khoaList = new ArrayList<>();
    public KhoaService() {
        khoaList.addAll(
                Arrays.asList(
                        new Khoa("NA","Ngoại ngữ"),
                        new Khoa("KT","Kinh tế"),
                        new Khoa("LA","Luật"),
                        new Khoa("QT","Quản trị kinh doanh"),
                        new Khoa("IT","Công nghệ thông tin")
                )
        );
    }
        //Lấy toàn bộ danh sách
        public List<Khoa> getKhoaList() {
        return khoaList;
        }
        //Lấy sinh viên theo mã khoa
        public Khoa getKhoa(String MaKhoa) {
        return khoaList.stream().filter(khoa -> khoa.getMaKhoa().equals(MaKhoa)).findFirst().get();
        }
        //Thêm mới một khoa
    public Khoa addKhoa(Khoa khoa) {
        khoaList.add(khoa);
        return khoa;
    }
    //Sửa đổi thông tin khoa theo mã
    public Khoa updateKhoa(String MaKhoa, Khoa khoa) {
        Khoa checkKhoa = getKhoa(MaKhoa);
        if(checkKhoa == null){
            return null;
        }
        khoaList.forEach(k -> {
            if(k.getMaKhoa().equals(MaKhoa)){
                k.setMaKhoa(khoa.getMaKhoa());
                k.setTenKhoa(khoa.getTenKhoa());
            }
        });
        return khoa;
    }
    //Xóa thông tin theo mã khoa
    public boolean deleteKhoa(String MaKhoa) {
        Khoa khoa = getKhoa(MaKhoa);
        return khoaList.remove(khoa);
    }
}
