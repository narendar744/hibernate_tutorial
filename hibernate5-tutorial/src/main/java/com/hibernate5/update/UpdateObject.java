package com.hibernate5.update;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate5.entity.Student;

public class UpdateObject {
		public static void main(String[] args) {
			SessionFactory factory = new Configuration().
					configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
			Session session= factory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			try {
				
				Student mystudent=session.get(Student.class, 1);
				mystudent.setFirstname("narendar");
				//transaction.commit();
				//session.getTransaction().commit();
				System.out.println("done");
				session.createQuery("update Student s set s.email='anu@gmail.com'").executeUpdate();
				transaction.commit();
	}
			finally {}}

}
