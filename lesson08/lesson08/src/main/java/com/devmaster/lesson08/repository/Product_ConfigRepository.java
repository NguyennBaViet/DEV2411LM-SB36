package com.devmaster.lesson08.repository;

import com.devmaster.lesson08.entity.Product_Config;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Product_ConfigRepository extends JpaRepository<Product_Config, Long> {

}
