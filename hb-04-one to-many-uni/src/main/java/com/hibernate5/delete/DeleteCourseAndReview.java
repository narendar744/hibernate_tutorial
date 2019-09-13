package com.hibernate5.delete;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate5.entity.Course;
import com.hibernate5.entity.Instructor;
import com.hibernate5.entity.Instructor_detail;
import com.hibernate5.entity.Review;

public class DeleteCourseAndReview {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructor_detail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session= factory.getCurrentSession();
		Transaction transaction = factory.getCurrentSession().beginTransaction();
		
		try {
			
			Course course=session.get(	Course.class,10);
		System.out.println(course.getReviews());
		
		
			session.delete(course);
		
			transaction.commit();
			System.out.println("done");
			
			
	}
	
		
		
		finally {
			
			System.out.println("completed");
			
			
		}}
	

}
