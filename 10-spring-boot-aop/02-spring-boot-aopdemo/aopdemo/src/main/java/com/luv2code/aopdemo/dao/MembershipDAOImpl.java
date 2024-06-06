package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

// creating Target Object

@Repository //(do component scanning- sub annotation for component scanning)
public class MembershipDAOImpl implements MembershipDAO{

	@Override
	public void addAccount() {
		// TODO Auto-generated method stub
		// call the business method
		System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

}
