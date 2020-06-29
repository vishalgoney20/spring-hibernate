package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2Code.hibernate.demo.entity.Student;

public class DeleteStudentDemo2 {

	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Student myStudent=session.get(Student.class, 2);
			session.delete(myStudent);
			session.getTransaction().commit();
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete Student where firstName='c'").executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("Done..!");
			
		}
		finally {
			factory.close();
		}
		
	}
}
