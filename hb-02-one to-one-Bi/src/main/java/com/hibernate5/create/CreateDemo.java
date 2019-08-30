package com.hibernate5.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.hibernate5.entity.Instructor;
import com.hibernate5.entity.Instructor_detail;

public class CreateDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Instructor_detail.class)
				.buildSessionFactory();
		Session session= factory.getCurrentSession();
		try {
			System.out.println("creating student object.....!");
			Instructor_detail instructor_detail=new Instructor_detail("http//localhost:9090", "coding");
			Instructor instructor= new Instructor("narendar", "naganolla", "nnaganolla@gmail.com", instructor_detail);
			Transaction transaction = session.beginTransaction();
			System.out.println("saving the student....!");
			session.save(instructor);
			transaction.commit();
			System.out.println("done..!");
			
		} finally {	
		}
	}
}
