package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2Code.hibernate.demo.entity.Instructor;
import com.luv2Code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating the objects..");
			
			//Instructor theInstructor=new Instructor("a","A","a@gmail.com");
			
			//InstructorDetail theInstructorDetail=new InstructorDetail("luv2code.com", "coding");
			
			Instructor theInstructor=new Instructor("b","B","b@gmail.com");
			
			InstructorDetail theInstructorDetail=new InstructorDetail("geeksforgeeks", "programming");
			
			//associate objects
			theInstructor.setInstructorDetail(theInstructorDetail);
			
			
			session.beginTransaction();
			
			System.out.println("Saving the student details...");
			// saves the details of InstructorDetails  Cascade type
			session.save(theInstructor);
			session.getTransaction().commit();
			System.out.println("Done..!");
			
		}
		finally {
			factory.close();
		}
		
	}
}
