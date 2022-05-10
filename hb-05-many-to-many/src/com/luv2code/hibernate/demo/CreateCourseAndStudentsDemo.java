package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			Course course = new Course("Cool Course");
			
			System.out.println("Saving course: " + course);
			session.save(course);
			
			Student s1 = new Student("Bob", "Dole", "bdole@gmail.com");
			Student s2 = new Student("Bubba", "Chubba", "bchubba@msn.com");
			Student s3 = new Student("ManBear", "Pig", "mbp@mbp.net");
			
			course.addStudent(s1);
			course.addStudent(s2);
			course.addStudent(s3);
			
			System.out.println("Saving student: " + s1);
			session.save(s1);
			System.out.println("Saving student: " + s2);
			session.save(s2);
			System.out.println("Saving student: " + s3);
			session.save(s3);
			
			
			//session.save(course);

			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
