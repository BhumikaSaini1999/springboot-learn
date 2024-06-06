package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	//@Before("execution(public void add*())") //point cut expression
	//@Before("execution(void add*())") // modifier is optional
	//@Before("execution(* add*())")
	
	//@Before("execution(* add*(com.luv2code.aopdemo.Account))") // fully qualified class name, can't give Class without package
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") //account param followed by any params
	@Before("execution(* com.luv2code..add*(..))") //pass any params
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>>>>>> Executing @Before advice on method");
	}
}
