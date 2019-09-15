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

public class CreateCoursesAndReviewDemo {
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
		Course course= new Course("music- how to edit music");
		
			session.save(course);
			Student s1= new Student("narendar", "naganolla", "nnr@gmail.com");
			Student s2= new Student("abhi", "kkkkr", "abhi@gmail.com");
			Student s3= new Student("srinish", "mmmmr", "srnish@gmail.com");
			course.addStudent(s1);
			course.addStudent(s2);
			course.addStudent(s3);
		session.save(s1);
		session.save(s2);
		session.save(s3);
			
			transaction.commit();
		
			
		} finally {	
			session.close();
			
		}
	}
}
