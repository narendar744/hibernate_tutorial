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
			
		//Instructor_detail tempInstructor=session.get(Instructor_detail.class,5);
		Instructor instructor=session.get(Instructor.class,4);
		/*if(tempInstructor!=null) {
			session.delete(tempInstructor);
		}*/
		
		
		if(instructor!=null) {
			session.delete(instructor);
		}
			transaction.commit();
			System.out.println("done");
			
			
	}
	
		
		
		finally {
			
			System.out.println("completed");
			
			
		}}

}
