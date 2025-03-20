package com.devmaster.lesson08.service;

import com.devmaster.lesson08.entity.Product_Config;
import com.devmaster.lesson08.repository.Product_ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Product_ConfigService {
    @Autowired
    private Product_ConfigRepository product_ConfigRepository;

    public List<Product_Config> getAll() {
        return product_ConfigRepository.findAll();
    }
    public Product_Config findById(Long id) {
        return product_ConfigRepository.findById(id).orElse(null);
    }
    public Product_Config save(Product_Config product_Config) {
        return product_ConfigRepository.save(product_Config);
    }
    public void delete(Long id) {
        product_ConfigRepository.deleteById(id);
    }

}
