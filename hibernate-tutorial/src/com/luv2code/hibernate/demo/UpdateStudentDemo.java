package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			//start a transaction
			session.beginTransaction();
			System.out.println("Starting transaction...");
			
			int studentId = 1;
			System.out.println("\n Getting student with id: " + studentId);
			Student student = session.get(Student.class, studentId);
			
			student.setFirstName("Jerry");
			student.setLastName("Garcia");
			//commit transaction
			
			System.out.println("Updating student...");
						
			session.getTransaction().commit();
			System.out.println("Done!");
			
			//bulk update
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Starting transaction...");
			
			System.out.println("Updating email for all students...");
			session.createQuery("update Student set email='test@gmail.com'")
				.executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
