package com.luv2code.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
		
		theStudents.add(new Student("Poornima","Patel"));
		theStudents.add(new Student("Digvijay","Singh"));
		theStudents.add(new Student("Komal","Singla"));
	}
	
	//define endpoint for "/students" - return a list of students
	@GetMapping("/students")
	public List<Student> getStudents(){

		return theStudents;
	}
}
