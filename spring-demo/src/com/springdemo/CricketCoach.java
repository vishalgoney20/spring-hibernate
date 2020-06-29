package com.springdemo;

public class CricketCoach implements Coach {

	FortuneService fortuneService;
	
	CricketCoach()
	{
		System.out.println("no arg constructor");
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("inside setter");
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkOut() {
		return "Cricket Coach class workOut  ";
	}

	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
