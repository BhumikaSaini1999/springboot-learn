package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

// @Component annotation marks the class as a Spring Bean,
//makes it available for the Dependency Injection

@Component
public class CricketCoach implements Coach{

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 minutes!!!!";
	}
	
}
