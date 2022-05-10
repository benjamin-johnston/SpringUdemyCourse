package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	
	//define bean for fortune service
	@Bean
	public FortuneService shittyFortuneService() {
		return new ShittyFortuneService();
	}
	
	//define bean for boarding coach and inject dependency
	@Bean
	public Coach snowboardingCoach() {
		return new SnowboardingCoach(shittyFortuneService());
	}
}
