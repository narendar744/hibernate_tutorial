package com.hibernate5.read;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate5.entity.Student;

public class ReadObjectFromDb {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session= factory.getCurrentSession();
		try {
			//session=factory.getCurrentSession();
			Transaction transaction = session.beginTransaction();
			/*
			 * read particular single object
			 */
			System.out.println("****************************************************");
			Student readStudent=session.get(Student.class,13);
			System.out.println(readStudent);
			
			
			System.out.println("****************************************************");
			List<Student> students;
			students=session.createQuery("from Student").list();
			
			//System.out.println(readStudent);
			transaction.commit();
			for (Student allstudent : students) {
				System.out.println(allstudent);
				
			}
			
		}
		finally {
			
		}

	}

}
