package com.devmaster.lesson03.com.devmaster.lesson03.controller;

import com.devmaster.lesson03.com.devmaster.lesson03.entity.Employee;
import com.devmaster.lesson03.com.devmaster.lesson03.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //Lấy thông tin nhân viên
    @GetMapping("/employee-list")
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployees();
    }
    //Lấy thông tin nhân viên theo mã nhân viên
    @GetMapping("/emloyee/{id}")
    public Employee getEmployee(@PathVariable String id) {
        Long idEmployee = Long.valueOf(id);
        return employeeService.getEmployee(String.valueOf(idEmployee));
    }
    //Thêm mới một nhân viên
    @PostMapping("/employee-add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
    //Sửa thông tin nhân viên
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        Long idEmployee = Long.valueOf(id);
        return employeeService.updateEmployee(String.valueOf(idEmployee), employee);

    }
    //Xóa một nhân viên
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable String id) {
        Long idEmployee = Long.valueOf(id);
        employeeService.deleteEmployee(String.valueOf(idEmployee));
    }
}
