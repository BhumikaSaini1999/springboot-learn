package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
	
	// define field for entity manager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		// create a query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		
		// get employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		// return employee
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		
		//save Employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//return dbEmployee
		return dbEmployee;
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		// find employee by id
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		// remove employee
		entityManager.remove(theEmployee);
	}

}
