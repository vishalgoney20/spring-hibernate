package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2Code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			System.out.println("Creating new student object...");
			Student theStudent=new Student("a","A","a@gmail.com");
			Student theStudent1=new Student("b","B","b@gmail.com");
			Student theStudent2=new Student("c","C","c@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving the student details...");
			session.save(theStudent);
			session.save(theStudent1);
			session.save(theStudent2);
			
			session.getTransaction().commit();
			
			System.out.println("Done..!");
			
		}
		finally {
			factory.close();
		}

	}

}
