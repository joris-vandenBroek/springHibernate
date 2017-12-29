package com.springMVC.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springMVC.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		System.out.println("Session created succesfully");
		try {
			Student student1 = new Student("Paul", "van den Hout4", "okmoy4@gmail.com");
			Student student2 = new Student("Paul", "van den Hout5", "okmoy5@gmail.com");
			Student student3 = new Student("Paul", "van den Hout6", "okmoy6@gmail.com");
			session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR: " + e);
			factory.close();
		}
		
	}

}
