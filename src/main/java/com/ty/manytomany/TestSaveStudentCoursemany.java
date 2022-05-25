package com.ty.manytomany;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCoursemany {

	public static void main(String[] args) {
		
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
				EntityManager entityManager = entityManagerFactory.createEntityManager();
				EntityTransaction entityTransaction = entityManager.getTransaction();

				Student student=new Student();
			    student.setName("sundeep");
			    student.setAge(25);
			   
			    Course course1=entityManager.find(Course.class, 2);
			    Course course2=entityManager.find(Course.class, 3);
//			    course2.setName("html");
//			    course2.setDuration(1);
//			    
//			    Course course3=new Course();
//			    course3.setName("css");
//			    course3.setDuration(2);
			    
			    List<Course>courses=new ArrayList<Course>();
			    courses.add(course1);
			    courses.add(course2);
			   
			    
			    student.setCourse(courses);
			    
				entityTransaction.begin();
				entityManager.persist(student);
				entityTransaction.commit();


			}


	}


