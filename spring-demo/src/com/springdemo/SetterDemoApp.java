package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CricketCoach theCricketCoach=context.getBean("myCricketCoach",CricketCoach.class);
		
		System.out.println(theCricketCoach.getDailyFortune());
		
		context.close();

	}

}
