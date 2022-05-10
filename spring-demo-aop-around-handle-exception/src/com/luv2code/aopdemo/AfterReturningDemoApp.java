package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = accountDao.findAccounts(false);
		
		//display the accounts
		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("---------------------------------------");
		System.out.println(accounts);
		
		//close the context
		context.close();
	}

}
