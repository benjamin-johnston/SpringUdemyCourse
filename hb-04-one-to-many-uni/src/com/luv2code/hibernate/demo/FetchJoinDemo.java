package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			//start a transaction
			System.out.println("Starting transaction...");
			session.beginTransaction();
			
			Query<Instructor> query = session.createQuery("select i from Instructor i"
					+ " JOIN FETCH i.courses"
					+ " where i.id=:instructorId"
					, Instructor.class);
			
			query.setParameter("instructorId", 1);
			 
			Instructor instructor = query.getSingleResult();
			
			System.out.println("Instructor: " + instructor);
			

			//commit transaction
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("Courses: " + instructor.getCourses());
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
