package com.hibernate5.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate5.entity.Course;
import com.hibernate5.entity.Instructor;
import com.hibernate5.entity.Instructor_detail;

public class CreateCoursesDemo {
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
			int theId=2;
			Instructor tempInstructor= session.get(Instructor.class,theId);
			Course theCourse1= new Course("Spring-Course1");
			Course theCourse2= new Course("hibernate-course1 ");
			tempInstructor.add(theCourse1);
			tempInstructor.add(theCourse2);
			session.save(theCourse1);
			session.save(theCourse2);
			
		
			
			transaction.commit();
		
			
		} finally {	
			session.close();
			
		}
	}
}
