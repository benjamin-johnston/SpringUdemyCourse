package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String fortunes[] = {
		"You will find something useful.",
		"You will solve a mystery.",
		"You will do something risky."
	};

	@Override
	public String getFortune() {
		Random random = new Random();
		
		return fortunes[random.nextInt(fortunes.length)];
	}

}
