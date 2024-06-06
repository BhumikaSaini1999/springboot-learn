package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.luv2code.aopdemo.Account;

// creating Target Object

@Repository //(do component scanning- sub annotation for component scanning)
public class AccountDAOImpl implements AccountDAO{

	@Override
	public void addAccount(Account theAccount, boolean vipFlag) {
		// TODO Auto-generated method stub
		// call the business method
		System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

}
