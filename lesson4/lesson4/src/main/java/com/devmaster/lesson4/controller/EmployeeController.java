package com.devmaster.lesson4.controller;

import com.devmaster.lesson4.entity.Employee;
import com.devmaster.lesson4.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //Lấy thông tin nhân viên
    @GetMapping("/employee-list")
    public ResponseEntity<List<Employee>> getEmployeeList() {
        employeeService.getEmployees();
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }
    //Lấy thông tin nhân viên theo mã nhân viên
    @GetMapping("/emloyee/{id}")
    public Employee getEmployee(@PathVariable String id) {
        Long idEmployee = Long.valueOf(id);
        return employeeService.getByEmployee(String.valueOf(idEmployee));
    }
    //Thêm mới một nhân viên
    @PostMapping("/employee-add")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return ResponseEntity.badRequest().body("Employee added successfully");
    }
    //Sửa thông tin nhân viên
    @PutMapping("/employee/{id}")
    public void updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }
    //Xóa một nhân viên
    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable String id) {
        Long idEmployee = Long.valueOf(id);
        employeeService.deleteEmployee(String.valueOf(idEmployee));
    }
}
