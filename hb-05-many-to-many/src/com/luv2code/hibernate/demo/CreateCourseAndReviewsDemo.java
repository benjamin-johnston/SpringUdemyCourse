package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
				
		//create session
		Session session = factory.getCurrentSession();
		
		try {	
			//start a transaction
			System.out.println("Starting transaction...");
			session.beginTransaction();
			
			Course course = new Course("Cool Course");
			
			course.addReview(new Review("This course sucks."));
			course.addReview(new Review("This is cooler than Penguin Toes."));
			course.addReview(new Review("What the fuck?"));
				
			System.out.println("Course: " + course);
			
			System.out.println("Course: " + course.getReviews());
			
			System.out.println("Saving the course...");
			session.save(course);

			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}