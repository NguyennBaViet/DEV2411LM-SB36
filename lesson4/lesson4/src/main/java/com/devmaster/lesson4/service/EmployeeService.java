package com.devmaster.lesson4.service;

import com.devmaster.lesson4.dto.EmployeeDTO;
import com.devmaster.lesson4.entity.Employee;
import com.devmaster.lesson4.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@Service
@AllArgsConstructor
public class EmployeeService {
    //Lấy toàn bộ danh sách
    List<Employee> employees = new ArrayList<Employee>();
    public EmployeeService() {
        employees.add(new Employee("NV1","Vương Kiên",19,2000000));
        employees.add(new Employee("NV10","Văn Khánh",21,2200000));
        employees.add(new Employee("NV11","Nam Hải",18,3000000));
        employees.add(new Employee("NV21","Đình Kiên",25,4000000));
        employees.add(new Employee("NV33","Vương Trang",20,5000000));
    }
    //Lấy ds
    public List<Employee> getEmployees() {
        return employees;
    }
    //Lấy theo id
    public Employee getByEmployee(String id) {
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }
    //Add
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    //Sửa
    public void updateEmployee(String id,Employee employee) {
        Employee emp = getByEmployee(id);
        if(emp != null) {
            emp.setId(employee.getId());
            emp.setFullName(employee.getFullName());
            emp.setAge(employee.getAge());
            emp.setSalary(employee.getSalary());
        }
    }
    //Xóa
    public void deleteEmployee(String id) {
        Employee emp = getByEmployee(id);
        employees.removeIf(employee -> employee.getId().equals(id));
    }
}
