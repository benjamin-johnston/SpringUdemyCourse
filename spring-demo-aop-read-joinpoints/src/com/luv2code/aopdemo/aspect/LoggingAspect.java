package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.dao.Account;

@Aspect
@Component
@Order(1)
public class LoggingAspect {	
	//joinpoint gives meta data about the method signature
	@Before("com.luv2code.aopdemo.aspect.PointcutDeclarations.forDaoPackageNoGettersOrSetters()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		
		//display the method signature
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("\nMethod: " + signature);
		
		//get args 
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			System.out.println(arg);
			
			if (arg instanceof Account) {
				//downcast and print stuff when there is no toString() method
				Account account = (Account) arg;
				
				System.out.println("Name: " + account.getName());
				System.out.println("Level: " + account.getLevel());
				
			}
			
		}
		
		//display arguments
		
		System.out.println("\n=====>>> Executing beforeAddAccountAdvice()");
	}
	

	

	
	
}
