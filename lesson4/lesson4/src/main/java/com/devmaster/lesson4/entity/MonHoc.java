package com.devmaster.lesson4.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
public class MonHoc {
     String maMH;
     String tenMH;
     int soTiet;

     public MonHoc() {
     }

     public MonHoc(String maMH, String tenMH, int soTiet) {
          this.maMH = maMH;
          this.tenMH = tenMH;
          this.soTiet = soTiet;
     }

     public String getMaMH() {
          return maMH;
     }

     public void setMaMH(String maMH) {
          this.maMH = maMH;
     }

     public String getTenMH() {
          return tenMH;
     }

     public void setTenMH(String tenMH) {
          this.tenMH = tenMH;
     }

     public int getSoTiet() {
          return soTiet;
     }

     public void setSoTiet(int soTiet) {
          this.soTiet = soTiet;
     }
}
