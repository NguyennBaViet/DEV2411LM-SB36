package com.devmaster.Lesson7.service;

import com.devmaster.Lesson7.entity.Customer;
import com.devmaster.Lesson7.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    //Customer List
    @Transactional
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    //Customer find by id
    @Transactional
    public Optional<Customer> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }
    //save
    @Transactional
    public Customer save(Customer customer) {
        //Thêm mới
        if(customer.getId() == null) {
            return customerRepository.save(customer);
        }
            //Sửa, cập nhật
        Customer newCustomer = new Customer();
        newCustomer.setId(customer.getId());
        newCustomer.setFullName(customer.getFullName());
        newCustomer.setUserName(customer.getUserName());
        newCustomer.setPassword(customer.getPassword());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setAddress(customer.getAddress());
        newCustomer.setActive(customer.getActive());
        return customerRepository.save(newCustomer);
    }
    //Delete customer
    @Transactional
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
    //exist username
    public Boolean existsByUserName(String userName) {
        return customerRepository.existsByUserName(userName);
    }
}
