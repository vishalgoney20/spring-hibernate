package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	public static void main(String[] args)
	{

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO theMembershipDAO=context.getBean("membershipDAO",MembershipDAO.class);

		theAccountDAO.addAccount();
		System.out.println("\n\nRunning again\n");
		theAccountDAO.addAccount();
		//System.out.println("\n\nRunning again\n");
		theMembershipDAO.addAccount();
		context.close();
	}

}
