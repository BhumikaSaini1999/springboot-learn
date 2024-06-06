package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	// executed after the spring beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner->{
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows count: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		int studentId=3;
		System.out.println("Deleting the student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		//retrieve student based on the id: primary key
		int studentId=1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);
		
		//change first name to "John"
		System.out.println("Updating the Student");
		myStudent.setFirstName("John");
		
		//update the student
		studentDAO.update(myStudent);
		
		//display the updated student
		System.out.println("Updated Student: "+myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		
		// display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		// get a list of students
		List<Student> theStudents = studentDAO.findAll();
		
		// display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		// create a student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");
		
		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		
		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+theId);
		
		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent = studentDAO.findById(theId);
		
		// display student
		System.out.println("Found the student: "+myStudent);
		System.out.println("Student with id 2: "+studentDAO.findById(2));
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 student objects...");
		Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
		Student tempStudent2 = new Student("Mary","Chad","marychadn@luv2code.com");
		Student tempStudent3 = new Student("Kate","Williams","kate@luv2code.com");
		
		// save the student object
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Bhumika","Saini","bhumikasaini189@gmail.com");
		
		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);
		
		// display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}
}
