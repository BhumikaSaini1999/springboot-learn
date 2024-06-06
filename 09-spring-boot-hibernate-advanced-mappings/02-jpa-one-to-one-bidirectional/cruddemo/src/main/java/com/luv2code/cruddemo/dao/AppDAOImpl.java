package com.luv2code.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{
	
	// define field for entity manager
	private EntityManager entityManager;
	
	// inject entity manager using constructor injection
	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Transactional
	@Override
	public void save(Instructor theInstructor) {
		// TODO Auto-generated method stub
		entityManager.persist(theInstructor);
	}
	
	//Because of default behaviour of @OnetoOne fetch type is eager

	@Override
	public Instructor findInstructorById(int theId) {
		// TODO Auto-generated method stub
		
		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		// TODO Auto-generated method stub
		
		// retrieve the instructor
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);
		
		// delete the instructor
		entityManager.remove(tempInstructor);
	}

	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		// TODO Auto-generated method stub
		return entityManager.find(InstructorDetail.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {
		// TODO Auto-generated method stub
		
		// retrieve instructor detail 
		InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
		
		// delete the instructor detail and cascade will delete the instructor also
		entityManager.remove(tempInstructorDetail);
	}

}
