package com.hibernate5.delete;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate5.entity.Student;

public class DeleteObject {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session= factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			
			/*Student mystudent=session.get(Student.class, 4);
			session.delete(mystudent);*/
			
			// second approach...
			session.createQuery("delete from Student where lastname='tirumala8'").executeUpdate();
			transaction.commit();
			System.out.println("second approach working");
			
			
	}
	
		
		
		finally {
			
			System.out.println("completed");
			
			
		}}

}
