package com.luv2Code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2Code.hibernate.demo.entity.Student;

public class QueryStudentDemo2 {

	public static void main(String[] args)
	{
		SessionFactory factory=new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
		
			List<Student> theStudents=session.createQuery("from Student").list();
			for(Student tempStudent: theStudents)
			{
				System.out.println(tempStudent);
			}
			
			System.out.println("\n\n");
			theStudents=session.createQuery("from Student where firstName='a'").list();
			for(Student tempStudent: theStudents)
			{
				System.out.println(tempStudent);
			}
			
			System.out.println("\n\n");
			theStudents=session.createQuery("from Student where firstName='a' or lastname='B'").list();
			for(Student tempStudent: theStudents)
			{
				System.out.println(tempStudent);
			}
			
			System.out.println("\n\n");			
			theStudents=session.createQuery("from Student where email like '%.com'").list();	
			for(Student tempStudent: theStudents)
			{
				System.out.println(tempStudent);
			}
			
			
			session.getTransaction().commit();
						
			System.out.println("Done..!");
			
		}
		finally {
			factory.close();
		}
		
	}
}
