package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;
		
		try {
			//add a boolean flag to simulate exceptions;
			boolean tripWire = true;
			
			accountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("\nMain Program ... caught exception: " + e);
		}
		
		//display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("---------------------------------------");
		System.out.println(accounts);
		
		//close the context
		context.close();
	}

}
