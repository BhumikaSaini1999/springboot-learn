package com.luv2code.springboot.thymeleaf.service;

import java.util.List;

import com.luv2code.springboot.thymeleaf.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
