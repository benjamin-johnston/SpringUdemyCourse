package com.luv2code.springdemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") bean ID is optional
//defaults to ClassName in camelCase -- tennisCoach
//@Scope("prototype")
@Component
public class TennisCoach implements Coach {
	
	//Field injection -- no setter is needed
	//Spring will construct the class and inject a FortuneService 
	//Implementation
	@Autowired
	@Qualifier("randomFortuneService") //Required when you multiple implementations
	private FortuneService fortuneService;
	
	//constructor injection
	/*
	 * @Autowired public TennisCoach(FortuneService theFortuneService) {
	 * fortuneService = theFortuneService; }
	 */
	
	public TennisCoach() {
		System.out.println("Tennis Coach: inside default constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	//define init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TennisCoach: inside of doMyStartupStuff");
	}
	
	//define destroy method
	@PostDestroy
	public void doMyCleanupStuff() {
		System.out.println("TennisCoach: inside of doMyCleanupStuff");
	}

	//setter injection
	//can be any kind of method, doesn't have to be a setter
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println("Tennis Coach: Inside doSomeCrazyStuff");
//		this.fortuneService = fortuneService;
//	}
}
