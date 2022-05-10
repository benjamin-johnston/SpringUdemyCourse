package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
				
		//create session
		Session session = factory.getCurrentSession();
		
		try {			
			//start a transaction
			System.out.println("Starting transaction...");
			session.beginTransaction();
			
			//get instructor by primary key
			int id = 1;
			
			Instructor instructor =
				session.get(Instructor.class, id);
			
			
			//delete instructor
			if (instructor != null) {
				System.out.println("Found instructor: " + instructor);
				System.out.println("Deleting: " + instructor);
				
				//will also delete instructor detail
				//because of CascadeType.ALL
				session.delete(instructor);
			}
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
