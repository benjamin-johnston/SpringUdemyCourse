package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortune implements FortuneService {
	private String[] fortunes = {"You will find something valuable.",
		"You will hear good news.", "You will see something beautiful."
	};

	@Override
	public String getFortune() {
		System.out.println("RandomFortune: inside getFortune()");
		
		Random rand = new Random();
		
		return fortunes[rand.nextInt(3)];	
	}

}
