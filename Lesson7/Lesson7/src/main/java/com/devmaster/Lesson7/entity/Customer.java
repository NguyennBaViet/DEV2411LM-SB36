package com.devmaster.Lesson7.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Họ và tên không để trống")
    @Size(min = 3,message = "Họ và tên có tối thiểu 3 kí tự")
    private String fullName;

    @NotBlank(message = "Tài khoản không được để trống")
    @Size(min = 5,message = "Tài khoản có tối thiểu 5 kí tự")
    @Column(unique = true)
    private String userName;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6,message = "Mật khẩu có ít nhất 6 kí tự")
    private String password;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @Pattern(regexp = "\\+?[0-9]{10,15}$",message = "Điện thoại ch chứa kí tự số")
    private String phone;

    private String address;
    private Boolean active;
}
