package com.devmaster.lesson4.controller;

import com.devmaster.lesson4.dto.MonHocDTO;
import com.devmaster.lesson4.entity.MonHoc;
import com.devmaster.lesson4.service.MonHocService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class MonHocController {
    @Autowired
    private MonHocService monHocService;

    //Lấy danh sách môn học
    @GetMapping("/monHoc-list")
    public List<MonHoc> monHocList() {
        return monHocService.getByMaMH();
    }
    //Lấy thông tin theo mã môn học
    @GetMapping("/monHoc/{maMonHoc}")
    public MonHoc monHoc(@PathVariable String maMonHoc) {
        return monHocService.getByMaMH(maMonHoc);
    }
    //Thêm mới một môn học
    @PostMapping("/monHoc-add")
    public void addMonHoc(@RequestBody MonHocDTO monHocDTO) {
        MonHoc monHoc = new MonHoc();
        monHoc.setMaMH(monHocDTO.getMaMH());
        monHoc.setTenMH(monHocDTO.getTenMH());
        monHoc.setSoTiet(monHocDTO.getSoTiet());
        monHocService.add(monHoc);
    }
    //Sửa thông tin môn học
    @PutMapping("/monHoc/{maMonHoc}")
    public void updateMonHoc(@PathVariable String maMonHoc, @RequestBody MonHoc monHoc) {
        Long maMonHocId = Long.parseLong(maMonHoc);
        monHocService.updateMonHoc(String.valueOf(maMonHocId), monHoc);
    }
    //Xóa một môn học
    @DeleteMapping("/monHoc/{maMonHoc}")
    public void deleteMonHoc(@PathVariable String maMonHoc) {
        monHocService.deleteMonHoc(maMonHoc);
    }
}
