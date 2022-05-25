package com.ty.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonCab {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Cab cab=new Cab();
		cab.setDrivername("nitish");
		cab.setCost(500);
		
		
	    Person person1=new Person();
	    person1.setName("rashmi");
	    person1.setAge(23);
	    
	    Person person2=new Person();
	    person2.setName("soumya");
	    person2.setAge(23);
	    
	    Person person3=new Person();
	    person3.setName("madhu");
	    person3.setAge(21);
	    
	    
	    
	    List<Person>persons=new ArrayList<Person>();
	    persons.add(person1);
	    persons.add(person2);
	    persons.add(person3);
	    
	    cab.setPerson(persons);
	    
		entityTransaction.begin();
		entityManager.persist(cab);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(person3);
		entityTransaction.commit();
		
		
		
	}

}
