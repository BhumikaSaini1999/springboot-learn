package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Employee;

//JpaRepository<Employee,Integer>->Entity Type and Primary Key
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	// that's it ... no need to write any code LOL!
}
