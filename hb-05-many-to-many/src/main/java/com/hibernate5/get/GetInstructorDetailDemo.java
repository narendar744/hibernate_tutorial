package com.hibernate5.get;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate5.entity.Course;
import com.hibernate5.entity.Instructor;
import com.hibernate5.entity.Instructor_detail;
import com.hibernate5.entity.Review;
import com.hibernate5.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructor_detail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {

		session.beginTransaction();

			int tempId = 2;
			Student tempStudent = session.get(Student.class, tempId);
			System.out.println();
			System.out.println();
			System.out.println("Student :" + tempStudent);
			System.out.println();
			System.out.println();
			System.out.println( "student courses "+ tempStudent.getCourses());

			session.getTransaction().commit();

			System.out.println("Done!");
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			// handle connection leak issue
			session.close();
			factory.close();
		}
	}

}
