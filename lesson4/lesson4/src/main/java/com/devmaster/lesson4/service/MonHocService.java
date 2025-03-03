package com.devmaster.lesson4.service;

import com.devmaster.lesson4.entity.MonHoc;
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
public class MonHocService {
    List<MonHoc> monHoc = new ArrayList<MonHoc>();
    public MonHocService() {
        monHoc.add(new MonHoc("TA","Tiếng Anh",45));
        monHoc.add(new MonHoc("GD","Giáo dục quốc phòng và an ninh",45));
        monHoc.add(new MonHoc("LS","Lịch sử Đảng",45));
        monHoc.add(new MonHoc("TR","Toán rời rạc",75));
        monHoc.add(new MonHoc("KT","Thương mại điện tử",45));
    }
    public List<MonHoc> getByMaMH() {
        return monHoc;
    }
    public MonHoc getByMaMH(String maMH) {
        return monHoc.stream().filter(mh -> maMH.equals(mh.getMaMH())).findFirst().get();
    }
    public void add(MonHoc mh) {
        monHoc.add(mh);
    }
    public void updateMonHoc(String maMH,MonHoc mh) {
        MonHoc mh1 = getByMaMH(maMH);
        if (mh1 != null) {
            mh1.setMaMH(mh.getMaMH());
            mh1.setTenMH(mh.getTenMH());
            mh1.setSoTiet(mh.getSoTiet());
        }
    }
    public void deleteMonHoc(String maMH) {
        monHoc.removeIf(mh -> maMH.equals(mh.getMaMH()));
    }
}
