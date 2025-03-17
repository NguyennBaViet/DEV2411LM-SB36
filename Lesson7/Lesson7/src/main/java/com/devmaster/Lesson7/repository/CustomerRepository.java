package com.devmaster.Lesson7.repository;

import com.devmaster.Lesson7.entity.Customer;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Boolean existsCustomerByUserName(String userName);

    boolean existsByUserName(@NotBlank(message = "Tài khoản không được để trống") @Size(min = 5,message = "Tài khoản có tối thiểu 5 kí tự") String userName);
}
