package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context =
			new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		logger.info("\nMain Program: AroundDemoApp");
		
		logger.info("Calling getFortune");
		
		logger.info("\nMy fortune is: " + service.getFortune());
		
		logger.info("\nFinished");

		//close the context
		context.close();
	}

}
