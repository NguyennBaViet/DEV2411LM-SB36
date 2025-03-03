package com.devmaster.lesson4.service;

import com.devmaster.lesson4.entity.Khoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@Service
public class KhoaService {
    //Lấy toàn bộ danh sách
    List<Khoa> khoaList = new ArrayList<>();
    public KhoaService() {
        khoaList.add(new Khoa("IT","Công nghệ thông tin"));
        khoaList.add(new Khoa("KT","Kinh tế"));
        khoaList.add(new Khoa("LS","Lịch sử"));
        khoaList.add(new Khoa("MT","Môi trường"));
        khoaList.add(new Khoa("LA","Luật"));
    }
    public List<Khoa> getKhoaList() {
        return khoaList;
    }
    public Khoa getByKhoa(String maKH) {
        return khoaList.stream().filter(k -> k.getMaKH().equals(maKH)).findFirst().orElse(null);
    }
    public void addKhoa(Khoa khoa) {
        khoaList.add(khoa);
    }
    public void updateKhoa(String maKH,Khoa khoa) {
        Khoa k = getByKhoa(maKH);
        if(k != null) {
            k.setMaKH(khoa.getMaKH());
            k.setTenKH(khoa.getTenKH());
        }
    }
    public void deleteKhoa(String khoa) {
        khoaList.removeIf(k -> k.getMaKH().equals(khoa));
    }

}
