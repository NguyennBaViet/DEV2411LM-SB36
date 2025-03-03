package com.devmaster.lesson4.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MonHocDTO {
    @Max(value = 2, message = "Mã môn học chỉ gồm 2 kí tự")
     String maMH;

    @Size(min = 5, max = 50, message = "Tên môn học có độ dài khoảng 5 đến 50 kí tự")
     String tenMH;

    @Size(min = 45, max = 75,message = "Số tiết khoảng 45 đến 75 tiết")
     int soTiet;
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
