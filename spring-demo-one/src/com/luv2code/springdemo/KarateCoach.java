package com.luv2code.springdemo;

public class KarateCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Perform 50 back kicks";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}
	
	private void startup() {
		System.out.println("KarateCoach: inside startup()");
	}
	
	private void cleanup() {
		System.out.println("KarateCoach: inside cleanup()");
	}

}
