package com.devmaster.lesson4.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
public class Khoa {
     String maKH;
     String tenKH;

     public Khoa() {
     }

     public Khoa(String maKH, String tenKH) {
          this.maKH = maKH;
          this.tenKH = tenKH;
     }

     public String getTenKH() {
          return tenKH;
     }

     public void setTenKH(String tenKH) {
          this.tenKH = tenKH;
     }

     public String getMaKH() {
          return maKH;
     }

     public void setMaKH(String maKH) {
          this.maKH = maKH;
     }
}

