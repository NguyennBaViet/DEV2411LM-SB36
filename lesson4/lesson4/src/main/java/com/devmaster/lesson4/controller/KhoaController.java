package com.devmaster.lesson4.controller;

import com.devmaster.lesson4.entity.Khoa;
import com.devmaster.lesson4.service.KhoaService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
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
        return null;
    }
    //Thêm mới 1 khoa
    @PostMapping("/khoa-add")
    public ResponseEntity<String> addKhoa(@RequestBody Khoa khoa) {
        return ResponseEntity.badRequest().body("Khoa added successfully");
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
