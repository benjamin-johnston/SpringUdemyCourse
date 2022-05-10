package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			System.out.println("Starting transaction...");
			session.beginTransaction();
			
			//Table name must be capatilized
			List<Student> students = session.createQuery("from Student").getResultList();
			
			//query students: lastName='Doe'
			students = session
					.createQuery("from Student where lastName='Dole'")
					.getResultList();
			
			System.out.println("\n\n Students who have a last name of Dole");
			displayStudents(students);
			
			students = session
					.createQuery("from Student where lastName='Dole'"
							+ "or firstName = 'Bubba'")
					.getResultList();
			
			System.out.println("\n\n Students who have a "
					+ "last name of Dole or first name of Bubba");
			displayStudents(students);
			
			students = session
					.createQuery("from Student where email LIKE '%gmail%'")
					.getResultList();
			
			System.out.println("\n\n Students who have a gmail address");
			displayStudents(students);
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students)
			System.out.println(student);
	}

}
