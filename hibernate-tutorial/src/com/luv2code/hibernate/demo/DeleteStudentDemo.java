package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
//			session.beginTransaction();
//			System.out.println("Starting transaction...");
//			
//			int studentId = 1;
//			System.out.println("\n Getting student with id: " + studentId);
//			Student student = session.get(Student.class, studentId);
//			
//			//Delete a single student by primary key
//			System.out.println("Deleting student with id: " + studentId);
//			session.delete(student);
//			
//			session.getTransaction().commit();
//			System.out.println("Done!");
			
			//start a transaction
			session.beginTransaction();
			System.out.println("Starting transaction...");
						
			//Delete a single student by primary key
			System.out.println("Deleting student with id 5");
			session.createQuery("delete from Student where id = 5")
				.executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
