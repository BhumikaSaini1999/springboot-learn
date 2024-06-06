package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}//Name of Pointcut declaration
		
	
	@Before("forDaoPackage()") //match any method
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>>>>>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackage()") //match any method
	public void performApiAnalytics() {
		System.out.println("\n======>>>>>>> Performing API analytics");
	}
}