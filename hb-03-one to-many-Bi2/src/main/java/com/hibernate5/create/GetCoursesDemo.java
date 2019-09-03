package com.hibernate5.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate5.entity.Course;
import com.hibernate5.entity.Instructor;
import com.hibernate5.entity.Instructor_detail;

public class GetCoursesDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructor_detail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session= factory.getCurrentSession();
		try {
			
			Transaction transaction = session.beginTransaction();
			int theId=1;
			Instructor tempInstructor= session.get(Instructor.class,theId);
			System.out.println(tempInstructor.getEmail());
			System.out.println(tempInstructor.getCourse());
			
		
			session.getTransaction();
			transaction.commit();
		
			
		} finally {	
			session.close();
			
		}
	}
}
