package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SnowboardingJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(SportConfig.class);
				
		//get the bean from spring container
		SnowboardingCoach theCoach = context.getBean("snowboardingCoach", SnowboardingCoach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println(theCoach.getEmail()); 
		System.out.println(theCoach.getTeam()); 
		
		//close the context
		context.close();
	}

}
