package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


//Specialized annotation for repositories
//Supports component scanning
//Translates JDBC exception

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	// define field for entity manager
	private EntityManager entityManager;
	
	// inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	// implement save method
	@Transactional // applied when there is an update or modifications performed on the database
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		
		// create query
		//TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
		//retrieving based on sort order in ascending order by default
		// asc for ascending or desc for descending
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
		
		//return query results
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		// TODO Auto-generated method stub
		
		// create query
		//JPQL Named parameters are prefixed with a colon:
		//Think of this as a placeholder that is filled in later
		TypedQuery<Student> theQuery = entityManager.createQuery(
				"FROM Student WHERE lastName=:theData", Student.class);

		
		// set query parameters
		theQuery.setParameter("theData", theLastName);
		
		// return query parameters
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.merge(theStudent);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
		//retrieve the student
		Student theStudent = entityManager.find(Student.class, id);
		
		//delete the student
		entityManager.remove(theStudent);
	}

	@Override
	@Transactional
	public int deleteAll() {
		// TODO Auto-generated method stub
		int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowsDeleted;
	}

}
