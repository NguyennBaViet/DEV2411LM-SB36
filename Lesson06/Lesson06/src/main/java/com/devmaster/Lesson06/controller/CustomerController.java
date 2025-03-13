package com.devmaster.Lesson06.controller;

import com.devmaster.Lesson06.dto.CustomerDTO;
import com.devmaster.Lesson06.entity.Customer;
import com.devmaster.Lesson06.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public CustomerController (CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/")
    public String customers(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customers/customer-list";
    }
    @GetMapping("/add-new")
    public String addNewCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/customer-add";
    }
    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable (value = "id")Long id , Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customers/customer-edit";
    }
    @PostMapping("/")
    public String saveCustomer(@ModelAttribute("customer") CustomerDTO customerDTO) {
        customerService.save(customerDTO);
        return "redirect:/customers";
    }
    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable (value = "id")Long id ,@ModelAttribute("customer") CustomerDTO customerDTO) {
        customerService.update(id, customerDTO);
        return "redirect:/customers";
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable (value = "id")Long id , Model model) {
        customerService.delete(id);
        return "redirect:/customers";
    }
}
