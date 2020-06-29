package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//@Before("execution(public void addAccount())") will match addAccount method in any class
	//@Before("execution(public void add*t())") will match any method that starts with  method add in any class
	//@Before("execution(public void fullyQualifiedNameOfMethod())") will match particular method
	//@Before("execution(public void fullyQualifiedNameOfMethod(fullyQualifiedParameterName))") will match particular method with particular param name
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice()
	{
		System.out.println("======>>>  Executing Before advice ");
	}
}
