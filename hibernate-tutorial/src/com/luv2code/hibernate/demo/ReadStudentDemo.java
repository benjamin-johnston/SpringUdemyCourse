package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("Bubba", "Chubba", "bchubba@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			System.out.println("Starting transaction...");
			
			//save the student object
			System.out.println(student);
			
			
			session.save(student);

			Student savedStudent = session.get(Student.class, student.getId());
			//commit transaction
			System.out.println(savedStudent);
			System.out.println("Saved student. Generated id: " + savedStudent.getId());
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

}
