package com.luv2code.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.utils.Coach;

@RestController
public class DemoController {
	// create a constructor in your class for injections
	
	//define a private field for the dependency
	private Coach myCoach;
	
	//define a constructor for dependency injection
	//@Autowired annotation tells Spring to inject a dependency
	//putting @Autowired annotation is optional if only 1 constructor
	@Autowired
	public DemoController(Coach theCoach) {
		myCoach=theCoach;
	}
	
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
