package com.luv2code.cruddemo;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// CommandLineRunner from the spring boot framework
	// Executed after the Spring Beans have been loaded

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createCourseAndStudents(appDAO);
			//findCourseAndStudents(appDAO);
			//findStudentAndCourses(appDAO);
			//addMoreCoursesForStudent(appDAO);
			
			//we are not deleting the course here, we are deleting here the 
			//relationship between Course and Student
			//deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		System.out.println("Deleting the student id: "+theId);
		
		appDAO.deleteStudentById(theId);
		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
		
		// create more courses
		Course tempCourse1 = new Course("Title1");
		Course tempCourse2 = new Course("Title2");
		Course tempCourse3 = new Course("Title3");

		// add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		tempStudent.addCourse(tempCourse3);
		
		System.out.println("Updating student: "+tempStudent);
		System.out.println("associated Courses: "+tempStudent.getCourses());
		
		appDAO.updateStudentWithCourses(tempStudent);
		System.out.println("Done!!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId =2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
		
		System.out.println("Loaded student: "+tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());
		System.out.println("Done!!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);
		
		System.out.println("Loaded course: "+tempCourse);
		System.out.println("Students: "+tempCourse.getStudents());
		System.out.println("Done!!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		// create a course
		Course tempCourse = new Course("Pacman - How to Score One Million Points!!");
		
		// create the students
		Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
		Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");

		
		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		
		// save the course and associated students
		System.out.println("Saving the course: "+tempCourse);
		System.out.println("Saving Students: "+tempCourse.getStudents());
		
		//Cascade Persist
		appDAO.save(tempCourse);
		System.out.println("Done!!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 10;
		System.out.println("Deleting the course id: "+theId);
		
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		// get the course and reviews
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		
		// print the course
		System.out.println(tempCourse);
		
		// print the reviews
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// TODO Auto-generated method stub
		
		// create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points");
		
		// add some reviews
		tempCourse.addReview(new Review("Great course ... loved it!"));
		tempCourse.addReview(new Review("Cool Course, job well done"));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

		// save the course ... and leverage the cascade all
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		
		appDAO.save(tempCourse);
		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId=13;
		
		System.out.println("Deleting the course id: "+theId);
		appDAO.deleteCourseById(theId);
		
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 10;
		
		// find the course
		System.out.println("Finding course id: "+theId);
		Course tempCourse = appDAO.findCourseById(theId);
		
		// update the course
		System.out.println("Updating course id: "+theId);
		tempCourse.setTitle("Enjoy the Simple Things");
		
		appDAO.update(tempCourse);
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		
		// find the instructor
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		// update the instructor
		System.out.println("Updating instructor id: "+theId);
		tempInstructor.setLastName("TESTER");
		
		appDAO.update(tempInstructor);
		System.out.println("Done!!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		
		// find the instructor
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId=1;
		System.out.println("Finding instructor id: "+theId);
		
		// only loads the instructor because courses are lazy loaded
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: "+tempInstructor);
		
		// find courses for instructor
		System.out.println("Finding courses for instructor id: "+theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId=1;
		System.out.println("Finding instructor id: "+theId);
		
		// only loads the instructor because courses are lazy loaded
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor: "+tempInstructor);
		// by default the fetch is Lazy for the courses in Instructor, which will give error->so changing it to Eager
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		
		System.out.println("Done!!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// TODO Auto-generated method stub
		// create the instructor
		Instructor tempInstructor = new Instructor("Bhumika", "Saini", "bhumi@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://ww.luv2code.com-bhumikayoutube",
				"Cooking Food!");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create courses
		Course tempCourse1 = new Course("Air Guitar789078");
		Course tempCourse2 = new Course("The Pinball Masterclass365464");

		// add course to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		
		// save the instructor
		//because of CascadeType.PERSIST it will save instructor Detail as well as courses
		System.out.println("Saving Instructor: "+tempInstructor);
		System.out.println("The Courses: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done!!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 1;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// TODO Auto-generated method stub

		// get the instructor detail object
		int theId = 1;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		// print the associated instructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("Done!!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 3;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// TODO Auto-generated method stub

		// create the instructor
		Instructor tempInstructor = new Instructor("Bhumika", "Saini", "bhumi@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://ww.luv2code.com-bhumikayoutube",
				"Cooking Food!");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		// NOTE: this will also save the InstructorDetail object because of
		// CascadeType.ALL
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

}
