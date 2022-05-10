package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class ShittyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "You will step in dog poo :(";
	}

}
