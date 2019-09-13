package com.hibernate5.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate5.entity.Course;
import com.hibernate5.entity.Instructor;
import com.hibernate5.entity.Instructor_detail;
import com.hibernate5.entity.Review;

public class CreateCoursesAndReviewDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructor_detail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		Session session= factory.getCurrentSession();
		try {
			
			Transaction transaction = session.beginTransaction();
		Course course= new Course("music- how to edit music");
		course.addReview(new Review("nice.."));
		course.addReview(new Review("money worth.."));
		course.addReview(new Review("Very bad.."));
		
			session.save(course);
			
		
			
			transaction.commit();
		
			
		} finally {	
			session.close();
			
		}
	}
}
