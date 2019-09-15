package com.hibernate5.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate5.entity.Course;
import com.hibernate5.entity.Instructor;
import com.hibernate5.entity.Instructor_detail;
import com.hibernate5.entity.Review;
import com.hibernate5.entity.Student;

public class CreateCoursesAndReviewDemo2 {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructor_detail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session= factory.getCurrentSession();
		try {
			
			Transaction transaction = session.beginTransaction();
		int theId=2;
		Student tempStudent= session.get(Student.class, theId);
		System.out.println(tempStudent);
		System.out.println(" cousese " +tempStudent.getCourses());
		Course c1= new Course("chess ..learning chess");
		Course c2= new Course("cricket.. learning cricket");
		c1.addStudent(tempStudent);
		c2.addStudent(tempStudent);
		session.save(c1);
		session.save(c2);
		
			
		transaction.commit();
		
			
		} finally {	
			session.close();
			
		}
	}
}
