package com.devmaster.lesson4.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Data
    @Builder
public class KhoaDTO {
    @Min(value = 2, message = "Phải có ít nhất 2 giá trị")
    @NotNull(message = "Không được để trống")
     String maKH;

    @NotNull
    @Size(min = 5, max = 25, message = "Tên khoa có độ dài từ 5 đến 25 kí tự")
     String tenKH;

}
