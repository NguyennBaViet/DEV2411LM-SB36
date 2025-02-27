package com.devmaster.lesson03.com.devmaster.lesson03.service;

import com.devmaster.lesson03.com.devmaster.lesson03.entity.MonHoc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class MonHocService {
    List<MonHoc> monHoc = new ArrayList<MonHoc>();
    public MonHocService() {
        monHoc.addAll(
                Arrays.asList(
                        new MonHoc("G1","Tiếng Anh",45),
                        new MonHoc("N3","Toán rời rạc",30),
                        new MonHoc("L3","Pháp luật đại cương",30),
                        new MonHoc("TC4","Cầu lông",45),
                        new MonHoc("LT3","Lập trình hướng đối tượng",45)
                )
        );
    }
    //Lấy toàn bộ danh sách
    public List<MonHoc> getMonHoc() {
        return monHoc;
    }
    //Tìm môn học theo mã môn
    public MonHoc getMonHoc(String maMonHoc) {
        return monHoc.stream().filter(mh -> mh.getMaMonHoc().equals(maMonHoc)).findFirst().get();
    }
    //Thêm mới một môn hóc
    public MonHoc addMonHoc(MonHoc mh) {
        monHoc.add(mh);
        return mh;
    }
    //Sửa đổi thông tin theo mã môn học
    public MonHoc updateMonHoc(String MaMH,MonHoc mh) {
        MonHoc checkMH = getMonHoc(MaMH);
        if(checkMH == null){
            return null;
        }
        monHoc.forEach(m -> {
            if(m.getMaMonHoc().equals(MaMH)){
                m.setMaMonHoc(mh.getMaMonHoc());
                m.setTenMonHoc(mh.getTenMonHoc());
            }
        });
        return mh;
    }
    //Xóa thông tin theo mã môn học
    public boolean deleteMonHoc(String MaMH) {
        MonHoc m = getMonHoc(MaMH);
        return monHoc.remove(m);
    }
}
