package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
	
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;

	@Autowired
	@Qualifier("randomFortuneService") //Required when you multiple implementations
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		System.out.println("SwimCoach Email: " + email);
		System.out.println("SwimCoach Team: " + team);
		return fortuneService.getFortune();
	}
	

	

}
