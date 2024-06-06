package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

// @Component annotation marks the class as a Spring Bean,
//makes it available for the Dependency Injection

@Component
public class TennisCoach implements Coach{
	
	public TennisCoach() {
		System.out.println("In constructor: "+getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your backhand volley";
	}
	
}
