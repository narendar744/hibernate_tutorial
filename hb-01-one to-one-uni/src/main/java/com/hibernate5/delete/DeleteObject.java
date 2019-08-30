package com.hibernate5.delete;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.hibernate5.entity.Instructor;
import com.hibernate5.entity.Instructor_detail;

public class DeleteObject {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructor_detail.class)
				.buildSessionFactory();
		Session session= factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			
		Instructor tempInstructor=session.get(Instructor.class,3);
		if(tempInstructor!=null) {
			session.delete(tempInstructor);
		}
			transaction.commit();
			System.out.println("done");
			
			
	}
	
		
		
		finally {
			
			System.out.println("completed");
			
			
		}}

}
