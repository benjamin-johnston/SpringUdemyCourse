package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	//setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		String signature = joinPoint.getSignature().toShortString();
		logger.info("=====> in @Before: calling method: " + signature);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args)
			logger.info("=====> argument: " + arg);
	}
	
	//add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String signature = joinPoint.getSignature().toShortString();
		logger.info("=====> in @AfterReturning: from method: " + signature);
		
		logger.info("=====> result: " + result);
	}
}
