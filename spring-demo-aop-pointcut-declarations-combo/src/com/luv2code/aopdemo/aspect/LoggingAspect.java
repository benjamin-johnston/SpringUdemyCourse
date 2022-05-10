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
	
	//match getters
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	//match setters
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//match anything in dao package except getter/setter methods
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGettersOrSetters() {}
	
	//Use the pointcut expression declared above
	//exclude getters and setters
	@Before("forDaoPackageNoGettersOrSetters()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before method()");
	}
	
	@Before("forDaoPackage()")
	public void performAPIAnalytics() {
		
		System.out.println("\n=====>>> Executing performAPIAnalytics()");
	}
	
	
}
