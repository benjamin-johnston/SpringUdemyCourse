package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.dao.Account;

@Aspect
@Component
@Order(1)
public class LoggingAspect {
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint proceedingJoingPoint) throws Throwable {
		
		//print out method we are advising on
		String method = proceedingJoingPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @Around on method: " + method);
		
		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		//execute method
		Object result = proceedingJoingPoint.proceed();
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		long duration = end - begin;
		System.out.println("\n=====> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinnallyFindAccountsAdvice(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterFinally on method: " + method);
	}
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="e")
	//public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable e) {
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, RuntimeException e) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterThrowing on method: " + method);
	}
	
	
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n======>>> Executing @AfterReturning on method: " + method);
		
		System.out.println("\n======>>> result is: " + result);
		
		//post-process the data
		
		//convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result)
			account.setName(account.getName().toUpperCase());
		
	}


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
