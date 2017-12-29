package com.springMVC.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springMVC.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		System.out.println("Session created succesfully");
		try {
			
			Student student = new Student("Jobber", "van den Broek", "jobbertje@gmail.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			session.close();

			System.out.println("Saved id: " + student.getId());
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student myStudent = session.get(Student.class, student.getId());
			if (myStudent == null) {
				System.out.println("Student not found!");
			}
			System.out.println(myStudent.toString());
			session.getTransaction().commit();
		} catch (Exception e){
			factory.close();
		}
		
	}

}
