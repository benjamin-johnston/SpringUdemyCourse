package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//this is where we add all of our related advices for logging
	
	//let's start with an @Before advice
	
	//match any classes with addAccount methods
	//@Before("execution(public void addAccount())")
	
	//match specific class with addAccount method
	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	
	//match method names using wild card
	
	//match method with return type must have fully qualified class name
	//@Before("execution(* add*(com.luv2code.aopdemo.dao.Account))")
	
	//match one argument of any type
	//@Before("execution(* add*(*))")
	
	//matches any number of arguments
	//@Before("execution(* add*(..))")
	
	//one argument must be account
	//@Before("execution(* add*(com.luv2code.aopdemo.dao.Account, ..))")
	
	//match any method in any class from a specific package ie package level matching
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
	
	//@PointCut allows you to create a variable for your PointCut expression
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Before("forDaoPackage()")
	public void beforeDAOPackageMethods() {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackage()")
	public void performAPIAnalytics() {
		
		System.out.println("\n=====>>> Executing performAPIAnalytics()");
	}
	
	
}
