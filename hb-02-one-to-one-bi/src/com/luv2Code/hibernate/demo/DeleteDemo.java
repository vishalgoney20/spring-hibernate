package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2Code.hibernate.demo.entity.Instructor;
import com.luv2Code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {	
			
			session.beginTransaction();
			Instructor theInstructor=session.get(Instructor.class, 2);
			System.out.println("Found Instructor :"+theInstructor);
			
			if(theInstructor!=null) {
				//also deletes InstructorDetails object #cascade all delete   
				session.delete(theInstructor);
			}
			
			session.getTransaction().commit();
			System.out.println("Done..!");
			
		}
		finally {
			factory.close();
		}
		
	}
}
