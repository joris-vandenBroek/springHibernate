package com.springMVC.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springMVC.entity.Student;

public class QueryStudent {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		System.out.println("Session created succesfully");

		try {

			session.beginTransaction();

			System.out.println("All");
			List<Student> students = session.createQuery("from Student").list();
			displayStudents(students);

			System.out.println("Firstname Jobber");
			students = session.createQuery("from Student s where s.firstName = 'Jobber'").list();
			displayStudents(students);

			System.out.println("Email starts with okmoy");
			students = session.createQuery("from Student s where s.email LIKE 'okmoy%'").list();
			displayStudents(students);

			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
