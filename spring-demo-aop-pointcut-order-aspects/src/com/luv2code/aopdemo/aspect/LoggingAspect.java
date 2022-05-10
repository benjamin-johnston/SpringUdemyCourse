package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LoggingAspect {	
	//Use the pointcut expression declared above
	//exclude getters and setters
	@Before("com.luv2code.aopdemo.aspect.PointcutDeclarations.forDaoPackageNoGettersOrSetters()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing beforeAddAccountAdvice()");
	}
	

	

	
	
}
