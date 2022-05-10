package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	private String name;
	private String level;
	
	public List<Account> findAccounts(boolean tripWire) {
		if (tripWire)
			throw new RuntimeException();
		
		List<Account> accounts = new ArrayList<>();
		
		accounts.add(new Account("Debbie", "Silver"));
		accounts.add(new Account("Beverly", "Base"));
		accounts.add(new Account("Fred", "Master"));
		
		return accounts;
	}
	
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
