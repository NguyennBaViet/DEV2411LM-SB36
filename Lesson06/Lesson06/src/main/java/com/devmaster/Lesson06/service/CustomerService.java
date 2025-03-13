package com.devmaster.Lesson06.service;

import com.devmaster.Lesson06.dto.CustomerDTO;
import com.devmaster.Lesson06.entity.Customer;
import com.devmaster.Lesson06.repository.CustomerRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    public Optional<Customer> findById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(id);
        customerDTO.setUserName(customer.getUserName());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setFullName(customer.getFullName());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setBirthday(customer.getBirthday());
        customerDTO.setAction(String.valueOf(customer.getAction()));
        return Optional.of(customer);
    }
    public Customer save(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setUserName(customerDTO.getUserName());
        customer.setPassword(customerDTO.getPassword());
        customer.setFullName(customerDTO.getFullName());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhone(customerDTO.getPhone());
        customer.setEmail(customerDTO.getEmail());
        customer.setBirthday(customerDTO.getBirthday());
        customer.setAction(customerDTO.getAction());
        return customerRepository.save(customer);
    }
    public Customer update(Long id ,CustomerDTO updateCustomer) {
        return customerRepository.findById(id).map(customer ->
        {
            customer.setUserName(updateCustomer.getUserName());
            customer.setPassword(updateCustomer.getPassword());
            customer.setFullName(updateCustomer.getFullName());
            customer.setAddress(updateCustomer.getAddress());
            customer.setPhone(updateCustomer.getPhone());
            customer.setEmail(updateCustomer.getEmail());
            customer.setBirthday(updateCustomer.getBirthday());
            customer.setAction(updateCustomer.getAction());
            return customerRepository.save(customer);
        })
                .orElseThrow(() -> new IllegalArgumentException("Id Customer không hợp lệ"+id));
    }
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

}
