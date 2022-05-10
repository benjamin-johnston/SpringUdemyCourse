package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	private String name;
	private String level;
	
	public void addAccount(Account account, boolean bool) {
		System.out.println(getClass() + " DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + ": doWork()");
		
		return true;
	}

	public String getName() {
		System.out.println(getClass() + ": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": setName()");
		this.name = name;
	}

	public String getLevel() {
		System.out.println(getClass() + ": getLevel()");
		return level;
	}

	public void setLevel(String level) {
		System.out.println(getClass() + ": setLevel()");
		this.level = level;
	}
}
