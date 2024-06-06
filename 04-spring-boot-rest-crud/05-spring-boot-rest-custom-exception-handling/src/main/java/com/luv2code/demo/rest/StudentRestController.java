package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.demo.Entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> theStudents;

	// define @PostConstruct to load the student data ... only once!
	// this is called only once when bean is constructed
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();

		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Digvijay", "Singh"));
		theStudents.add(new Student("Komal", "Singla"));
	}

	// define endpoint for "/students" - return a list of students
	@GetMapping("/students")
	public List<Student> getStudents() {

		return theStudents;
	}

	// define endpoint for "/students/{studentId}" - retrieving a single student by
	// Id
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		// just index into the list ... keep it simple for now

		// check the studentId against the list size
		if (studentId >= theStudents.size() || studentId < 0)
			throw new StudentNotFoundException("student id not found - " + studentId);

		return theStudents.get(studentId);
	}

	// Add an exception handler using @ExceptionHnadler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStaus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add another exception handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStaus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
