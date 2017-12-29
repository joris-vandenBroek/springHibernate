package com.springMVC.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springMVC.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		System.out.println("Session created succesfully");
		try {
			Student student = new Student("Paul", "van den Hout", "okmoy@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
			factory.close();
		}
		
	}

}
