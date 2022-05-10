package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//@PointCut allows you to create a variable for your PointCut expression
	//match any method in any class from a specific package ie package level matching
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//Use the pointcut expression declared above
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackage()")
	public void performAPIAnalytics() {
		
		System.out.println("\n=====>>> Executing performAPIAnalytics()");
	}
	
	
}
