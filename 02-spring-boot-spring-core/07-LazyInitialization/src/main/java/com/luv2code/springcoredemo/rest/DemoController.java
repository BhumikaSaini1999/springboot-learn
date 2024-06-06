package com.luv2code.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springcoredemo.common.Coach;

@RestController
public class DemoController {
	// create a constructor in your class for injections
	
	//define a private field for the dependency
	private Coach myCoach;

	
	//if both @Primary and @Qualifier specified, then @Qualifier has higher priority
	@Autowired
	public DemoController(@Qualifier("cricketCoach")Coach theCoach) {
		System.out.println("In constructor: "+getClass().getSimpleName());
		myCoach=theCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
