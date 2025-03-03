package com.devmaster.lesson4.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class EmployeeDTO {

    @NotNull
    @Size(min = 3,max = 25,message = "Độ dài tên chỉ trong khoảng 5 đến 25 chữ cái")
     String name;

    @NotNull
    @Size(min = 18,max = 86,message = "Độ tuổi trong khoảng từ 18 đến 86")
     int age;
}
