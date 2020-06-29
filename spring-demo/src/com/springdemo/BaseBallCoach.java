package com.springdemo;

public class BaseBallCoach implements Coach {
	
	FortuneService fortuneservice;
	public BaseBallCoach(FortuneService theFortuneService) {
		
		fortuneservice=theFortuneService;
		
	}

	public String getDailyWorkOut() {
		return "Base Ball Coach class workOut ";
	}

	@Override
	public String getDailyFortune() {
		return "Base Ball Coach "+fortuneservice.getFortune();
	}

}
