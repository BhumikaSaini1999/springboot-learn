package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	//Here matching only addAccount() method for AccountDAO
	//give fully qualified classname for AccountDAO --> package+(class/interface)
	@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())") //point cut expression
	public void beforeAddAccountAdvice() {
		System.out.println("\n======>>>>>>> Executing @Before advice on addAccount()");
	}
}
