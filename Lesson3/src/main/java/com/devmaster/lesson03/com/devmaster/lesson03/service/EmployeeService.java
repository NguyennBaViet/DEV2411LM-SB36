package com.devmaster.lesson03.com.devmaster.lesson03.service;

import com.devmaster.lesson03.com.devmaster.lesson03.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<Employee>();
    public EmployeeService() {
        employees.addAll(
                Arrays.asList(
                        new Employee("M31","Văn Bách","Nam",21,5000000),
                        new Employee("M11","Thu Hà","Nữ",20,5500000),
                        new Employee("M42","Đình Kiên","Nam",25,5500000),
                        new Employee("G53","Ngọc Minh","Nam",26,6000000),
                        new Employee("M101","Mai Hạ","Nữ",22,7000000)
                )
        );
    }
    //Lấy toàn bộ danh sách
    public List<Employee> getEmployees() {
        return employees;
    }
    //Lấy sách sách theo mã nhân viên
    public Employee getEmployee(String id) {
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }
    //Thêm mới một nhân viên
    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }
    //Sửa đổi thông tin theo mã nhân viên
    public Employee updateEmployee(String id,Employee employee) {
        Employee checkEmployee = getEmployee(id);
        if (checkEmployee == null) {
            return null;
        }
        employees.forEach(ep -> {
            if (checkEmployee.getId().equals(ep.getId())) {
                ep.setId(employee.getId());
                ep.setFullName(employee.getFullName());
                ep.setGender(employee.getGender());
                ep.setAge(employee.getAge());
                ep.setSalary(employee.getSalary());
            }
        });
        return employee;
    }
    //Xóa thông tin theo mã nhân viên
    public boolean deleteEmployee(String id) {
        Employee e = getEmployee(id);
        return employees.remove(e);
    }
}
