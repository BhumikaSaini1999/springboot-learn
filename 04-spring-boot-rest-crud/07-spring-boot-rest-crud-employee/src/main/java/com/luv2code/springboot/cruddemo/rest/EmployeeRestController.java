package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	// quick and dirty: inject EmployeeDAO
	private EmployeeDAO employeeDAO;
	
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {//constructor injection
		employeeDAO=theEmployeeDAO;
	}
	
	// expose "/employees" and return a list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeDAO.findAll();
	}
}