package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
				
		//create session
		Session session = factory.getCurrentSession();
		
		try {						
			Instructor instructor = 
				new Instructor("Not", "Sure", "nsure@gmail.com");
				
			InstructorDetail instructorDetail =
				new InstructorDetail("http://www.youtube.com", "Not Sure");
				
			//associate the objects
			instructor.setInstructorDetail(instructorDetail);
					
			//start a transaction
			System.out.println("Starting transaction...");
			session.beginTransaction();
			
			//save the instructor
			//will also save instructor detail 
			//because of CascadeType.ALL
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);

			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
