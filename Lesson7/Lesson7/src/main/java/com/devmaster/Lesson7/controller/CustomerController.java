package com.devmaster.Lesson7.controller;

import com.devmaster.Lesson7.entity.Customer;
import com.devmaster.Lesson7.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String customers(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }

    @GetMapping("/new")
    public String newCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", new Customer());
        customer.setActive(true);
        return "customers/form";
    }

    @GetMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") @Validated Customer customer, BindingResult bindingResult) {
        if(customerService.existsByUserName(customer.getUserName()) && customer.getId() == null) {
            bindingResult.rejectValue("userName", "err.customer","Tài khoản đã tồn tại");
        }
        return "redirect:/customers";
    }
    @GetMapping("/edit/{id}")
    public String editCustomer( @PathVariable Long id,Model model) {
        Customer customer = customerService.findCustomerById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy id"));
        model.addAttribute("customer", customer);
        return "customers/form";
    }
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return "redirect:/customers";
    }
}
