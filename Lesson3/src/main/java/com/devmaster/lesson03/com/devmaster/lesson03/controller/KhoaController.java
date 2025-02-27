package com.devmaster.lesson03.com.devmaster.lesson03.controller;

import com.devmaster.lesson03.com.devmaster.lesson03.entity.Khoa;
import com.devmaster.lesson03.com.devmaster.lesson03.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KhoaController {
    @Autowired
    private KhoaService khoaService;

    //Lấy danh sách khoa
    @GetMapping("/khoa-list")
    public List<Khoa> getAllKhoa() {
        return khoaService.getKhoaList();
    }
    //Lấy thông tin khoa theo mã khoa
    @GetMapping("/khoa/{MaKhoa}")
    public Khoa getKhoa(@PathVariable String MaKhoa) {
        Long idKhoa = Long.parseLong(MaKhoa);
        return khoaService.getKhoa(String.valueOf(idKhoa));
    }
    //Thêm mới 1 khoa
    @PostMapping("/khoa-add")
    public void addKhoa(@RequestBody Khoa khoa) {
        khoaService.addKhoa(khoa);
    }
    //Sửa thông tin sinh viên
    @PutMapping("/khoa/{MaKhoa}")
    public void updateKhoa(@PathVariable String MaKhoa, @RequestBody Khoa khoa) {
        Long idKhoa = Long.parseLong(MaKhoa);
        khoaService.updateKhoa(String.valueOf(idKhoa),khoa);
    }
    @DeleteMapping("/khoa/{MaKhoa}")
    public void deleteKhoa(@PathVariable String MaKhoa) {
        Long idKhoa = Long.parseLong(MaKhoa);
        khoaService.deleteKhoa(String.valueOf(idKhoa));
    }
}
