package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		//create session
		Session session = factory.getCurrentSession();
		
		try {	
			//start a transaction
			System.out.println("Starting transaction...");
			session.beginTransaction();
				
			System.out.println("Retrieving student: " + 1);
			Student student = session.get(Student.class, 1);
			
			System.out.println("Adding new courses...");
			
			Course course1 = new Course("Stump Removal");
			course1.addStudent(student);
			Course course2 = new Course("Model Train Setup");
			course2.addStudent(student);
			Course course3 = new Course("Game Development");
			course3.addStudent(student);
			
			
			System.out.println("Saving the courses... ");
			session.save(course1);
			session.save(course2);
			session.save(course3);
				
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
