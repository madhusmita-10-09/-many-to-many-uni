package com.ty.manytomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetStudentById {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Student student=entityManager.find(Student.class, 2);
		
		if(student!=null)
		{
		List<Course> courses=student.getCourse();
		
		System.out.println("------------------------------");
		System.out.println("student name  is : "+student.getName());
		System.out.println("Student age  is : "+student.getAge());
		System.out.println("------course------------------");
		
		for(Course course:courses)
		{
			System.out.println("Course name is: "+course.getName());
			System.out.println("Course duration is: "+course.getDuration());
			System.out.println("---------------------------------");
		}
		
	}
		else
		{
			System.out.println("Sorry no student");
		}
	}
}
