package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			//create a student object
			Student student = new Student("Bob", "Dole", "bdole@gmail.com");
			Student student2 = new Student("Bobby", "Buchay", "bbuchay@gmail.com");
			Student student3 = new Student("Bonita", "Applebum", "bapplebum@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			session.save(student);
			session.save(student2);
			session.save(student3);
			
			//commit transaction
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}

	}

}