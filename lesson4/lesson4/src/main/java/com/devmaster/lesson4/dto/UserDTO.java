package com.devmaster.lesson4.dto;

import jakarta.validation.constraints.*;
import lombok.*;
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Data
    @Builder
    public class UserDTO {
        @NotNull(message = "Name không được để null")
        @NotBlank(message = "Name không được để trống")
        @NotEmpty(message = "Name không được rỗng")
        @Size(min = 2, max = 50, message = "Name có độ dài trong khoảng 2 đến 50 ký tự")
         String name;

        //    @NotNull(message = "Email không null")
        @Email(message = "Email không đúng định dạng")
         String email;

        @NotNull(message = "Age không null")
        @Min(value = 18, message = "Age tối thiểu 18 tuổi")
         int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
