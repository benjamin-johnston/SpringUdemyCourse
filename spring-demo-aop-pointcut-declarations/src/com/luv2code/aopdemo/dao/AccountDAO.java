package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount(Account account, boolean bool) {
		System.out.println(getClass() + " DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		
		return true;
	}
}
