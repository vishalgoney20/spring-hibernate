package com.springdemo;

public class TrackCoach implements Coach {
	
    FortuneService fortuneService;
	TrackCoach(FortuneService fortuneService){
		this.fortuneService=fortuneService;
	}

	public String getDailyWorkOut() {
		return "Track Coach Class workOut ";
	}

	@Override
	public String getDailyFortune() {
		return "Track Coach  "+fortuneService.getFortune();
	}

}
