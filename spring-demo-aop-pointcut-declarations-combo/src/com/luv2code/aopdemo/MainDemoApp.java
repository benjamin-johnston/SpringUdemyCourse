package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);

		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		accountDao.addAccount(new Account(), true);
		accountDao.doWork();
		String name = accountDao.getName();
		String level = accountDao.getLevel();
		accountDao.setLevel("ten");
		accountDao.setName("Bob");
		
		//Place a second call
		membershipDAO.addAccount();
		membershipDAO.goToSleep();
		
		//close the context
		context.close();
	}

}
