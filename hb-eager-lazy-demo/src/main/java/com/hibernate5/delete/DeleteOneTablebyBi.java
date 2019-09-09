package com.hibernate5.delete;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate5.entity.Instructor;
import com.hibernate5.entity.Instructor_detail;

public class DeleteOneTablebyBi {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructor_detail.class)
				.buildSessionFactory();
		Session session= factory.getCurrentSession();
		Transaction transaction = factory.getCurrentSession().beginTransaction();
		
		try {
			
			Instructor_detail instructor=session.get(	Instructor_detail.class,7);
		
		instructor.getInstructor().setInstructor_detail(null);
		
		
			session.delete(instructor);
		
			transaction.commit();
			System.out.println("done");
			
			
	}
	
		
		
		finally {
			
			System.out.println("completed");
			
			
		}}
	

}
