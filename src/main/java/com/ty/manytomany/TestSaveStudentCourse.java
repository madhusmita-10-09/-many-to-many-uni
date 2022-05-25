package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourse {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student=new Student();
	    student.setName("madhusmita");
	    student.setAge(21);
	   
	    Course course1=new Course();
	    course1.setName("java");
	    course1.setDuration(2);
	    
	    Course course2=new Course();
	    course2.setName("html");
	    course2.setDuration(1);
	    
	    Course course3=new Course();
	    course3.setName("css");
	    course3.setDuration(2);
	    
	    List<Course>courses=new ArrayList<Course>();
	    courses.add(course1);
	    courses.add(course2);
	    courses.add(course3);
	    
	    student.setCourse(courses);
	    
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		
		entityTransaction.commit();


	}

}
