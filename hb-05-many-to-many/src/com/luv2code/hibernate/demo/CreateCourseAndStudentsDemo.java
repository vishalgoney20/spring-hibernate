package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			Course theCourse1 = new Course("Machine Learning ");
			Course theCourse2 = new Course("Deep Learning ");
			
			session.save(theCourse1);
			session.save(theCourse2);
			System.out.println("saved the course1 :"+ theCourse1);
			System.out.println("saved the course2 :"+ theCourse2);
			
			Student theStudent1=new Student("a","A","a@gmail.com");
			Student theStudent2=new Student("b","B","b@gmail.com");
			Student theStudent3=new Student("c","C","c@gmail.com");
			Student theStudent4=new Student("d","D","d@gmail.com");
			
			theCourse1.addStudents(theStudent1);
			theCourse1.addStudents(theStudent2);
			theCourse2.addStudents(theStudent3);
			theCourse2.addStudents(theStudent4);
			
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);
			session.save(theStudent4);
			
				
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}





