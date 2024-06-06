package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.luv2code.aopdemo.Account;

// creating Target Object

@Repository //(do component scanning- sub annotation for component scanning)
public class AccountDAOImpl implements AccountDAO{
	
	private String name;
	
	private String serviceCode;
	
	public String getName() {
		System.out.println(getClass()+": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

	@Override
	public void addAccount(Account theAccount, boolean vipFlag) {
		// TODO Auto-generated method stub
		// call the business method
		System.out.println(getClass()+": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	@Override
	public boolean doWork() {
		// TODO Auto-generated method stub
		System.out.println(getClass()+": doWork()");
		return false;
	}

}
