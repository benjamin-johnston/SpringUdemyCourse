package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class KarateCoach implements Coach {
	private FortuneService fortuneService;
	
	@Autowired
	public KarateCoach(@Qualifier("strangeFortuneService") FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Perform 50 knuckel pushups.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
