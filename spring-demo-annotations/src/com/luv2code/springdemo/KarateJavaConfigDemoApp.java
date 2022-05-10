package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KarateJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//read spring config
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(KarateConfig.class);
				
		//get the bean from spring container
		Coach theCoach = context.getBean("karateCoach", Coach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune()); 
		
		//close the context
		context.close();
	}

}
