package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2Code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object...");
			Student theStudent=new Student("Paul","Wall","Paul@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student details...");
			session.save(theStudent);
			
			session.getTransaction().commit();
			System.out.println("saved student is id :"+theStudent.getId());
			
			
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			Student newStudent=session.get(Student.class, theStudent.getId());
			System.out.println("total details are :"+ newStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done..!");
			
		}
		finally {
			factory.close();
		}
		
	}
}
