package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutDeclarations {
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
}
