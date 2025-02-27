package com.devmaster.lesson03.com.devmaster.lesson03.controller;

import com.devmaster.lesson03.com.devmaster.lesson03.entity.MonHoc;
import com.devmaster.lesson03.com.devmaster.lesson03.service.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonHocController {
    @Autowired
    private MonHocService monHocService;

    //Lấy danh sách môn học
    @GetMapping("/monHoc-list")
    public List<MonHoc> monHocList() {
        return monHocService.getMonHoc();
    }
    //Lấy thông tin theo mã môn học
    @GetMapping("/monHoc/{maMonHoc}")
    public MonHoc monHoc(@PathVariable String maMonHoc) {
        return monHocService.getMonHoc(maMonHoc);
    }
    //Thêm mới một môn học
    @PostMapping("/monHoc-add")
    public void addMonHoc(@RequestBody MonHoc monHoc) {
        monHocService.addMonHoc(monHoc);
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
