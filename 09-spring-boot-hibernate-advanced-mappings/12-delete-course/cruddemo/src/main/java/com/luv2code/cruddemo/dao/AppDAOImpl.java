package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
		
		// get the courses
		List<Course> courses = tempInstructor.getCourses();
		
		// break association of all courses for the instructor
		for(Course tempCourse : courses) {
			tempCourse.setInstructor(null);
		}
		
		// delete the instructor
		// we only delete the instructor, not the associated courses based on our cascade types
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
		
		// remove the associated object refrence
		// breaking bi-directional link
		tempInstructorDetail.getInstructor().setInstructorDetail(null);
		
		// delete the instructor detail and instructor won't be deleted here
		entityManager.remove(tempInstructorDetail);
	}

	@Override
	public List<Course> findCoursesByInstructorId(int theId) {
		// TODO Auto-generated method stub
		
		// create query
		TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
		query.setParameter("data", theId);
		
		// execute query
		List<Course> courses = query.getResultList();
		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {
		// TODO Auto-generated method stub

		// create query
		// Here JOIN FETCH is similar to Eager loading
		TypedQuery<Instructor> query = entityManager
				.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:data", Instructor.class);
        query.setParameter("data", theId);
        
        // execute the query
        Instructor instructor = query.getSingleResult();
		return instructor;
	}

	@Override
	@Transactional
	public void update(Instructor tempInstructor) {
		// TODO Auto-generated method stub
		entityManager.merge(tempInstructor);
	}

	@Override
	@Transactional
	public void update(Course tempCourse) {
		// TODO Auto-generated method stub
		entityManager.merge(tempCourse);
	}

	@Override
	public Course findCourseById(int theId) {
		// TODO Auto-generated method stub
	  return entityManager.find(Course.class, theId);

	}

	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		// TODO Auto-generated method stub
		
		//retrieve the course
		Course tempCourse = entityManager.find(Course.class, theId);
		
		//delete the course
		entityManager.remove(tempCourse);
	}

}
