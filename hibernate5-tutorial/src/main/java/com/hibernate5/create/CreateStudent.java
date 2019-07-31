package com.hibernate5.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate5.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session= factory.getCurrentSession();
		try {
			System.out.println("creating student object.....!");
			Student s= new  Student("xxx", "yyyy", "xxx.yyy@gmail.com");
			
			
			Transaction transaction = session.beginTransaction();
			System.out.println("saving the student....!");
		
			session.save(s);
			
			transaction.commit();
			System.out.println("done..!");
			
		} finally {

			
		}
			
			
			
		

	}

}
