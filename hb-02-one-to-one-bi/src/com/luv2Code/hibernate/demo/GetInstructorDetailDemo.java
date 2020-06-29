package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2Code.hibernate.demo.entity.Instructor;
import com.luv2Code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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
			InstructorDetail theInstructorDetail=session.get(InstructorDetail.class, 1);
			System.out.println(theInstructorDetail);
			session.delete(theInstructorDetail);
			session.getTransaction().commit();
			System.out.println("Done..!");
			
		}
		finally {
			factory.close();
		}
		
	}
}



/*
To break the Bi-directional link 
-> To stop cascade delete 
   instead of mentioning cascadeType.ALL mention the cascades  Separately and avoid cascade delete.
   
   then EntityNotFoundException will be raised i.e, from the instructor we can save object again in instructor detail.
   so perform below in instructorDetail.java
 
   theInstructorDetail.getInstructor.setInstructorDetail(null)
 
 
 */