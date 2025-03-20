package com.devmaster.lesson08.controller;

import com.devmaster.lesson08.entity.Product_Config;
import com.devmaster.lesson08.service.Product_ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product_config")
public class Product_Config_Controller {
    @Autowired
    private Product_ConfigService product_configService;

    @GetMapping
    public String product_config(Model model) {
        model.addAttribute("product_config", product_configService.getAll());
        return "product_config";
    }
    @GetMapping("/new")
    public String product_config_new(Model model) {
        model.addAttribute("product_config", new Product_Config());
        model.addAttribute("product_config", product_configService.getAll());
        return "product_config_new";
    }
    @PostMapping("/new")
    public String product_config_save(Product_Config product_config) {
        product_configService.save(product_config);
        return "redirect:/product_config";
    }
    @GetMapping("/edit/{id}")
    public String product_config_edit(Model model, @PathVariable Long id) {
        Product_Config edit = product_configService.findById(id);
        model.addAttribute("product_config", edit);
        model.addAttribute("product_config", product_configService.getAll());
        return "product_config_edit";
    }
    @GetMapping("/delete/{id}")
    public String product_config_delete( @PathVariable Long id) {
        product_configService.delete(id);
        return "redirect:/product_config";
    }

}
