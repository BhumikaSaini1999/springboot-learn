package com.luv2code.springcoredemo.common;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component annotation marks the class as a Spring Bean,
//makes it available for the Dependency Injection

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class BaseballCoach implements Coach{
	
	public BaseballCoach() {
		System.out.println("In constructor: "+getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Spend 30 minutes in batting practice";
	}
	
}
