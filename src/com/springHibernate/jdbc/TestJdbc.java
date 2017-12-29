package com.springHibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springMVC.entity.Student;

public class TestJdbc {

	public static void main(String[] args) {
/*		String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String userId = "hbstudent";
		String password = "hbstudent";
		
		try {
			Connection myConn = DriverManager.getConnection(jdbcURL, userId, password);
			System.out.println("Sucesfull connection!!");
		} catch (Exception e) {
			e.printStackTrace();
		} */
		
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
			factory.close();
		}
		
	}

}
