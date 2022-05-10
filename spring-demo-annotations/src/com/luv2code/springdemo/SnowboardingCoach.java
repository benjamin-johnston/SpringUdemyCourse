package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") bean ID is optional
//defaults to ClassName in camelCase -- tennisCoach
@Component
public class SnowboardingCoach implements Coach {
	
	private FortuneService fortuneService;
	@Value("${foo.email}")
	private String email;
	@Value("${foo.team}")
	private String team;
	
	public SnowboardingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice twenty butters";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}
