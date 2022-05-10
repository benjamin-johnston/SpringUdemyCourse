package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class StrangeFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "The trees no longer speak.";
	}

}
