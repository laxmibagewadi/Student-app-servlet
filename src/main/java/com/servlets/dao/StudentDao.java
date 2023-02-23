package com.servlets.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.servlets.dto.Student;

public class StudentDao {
		
		public static void savestudent(Student s){
        EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory("madhu");
        EntityManager entitymanager=entitymanagerfactory.createEntityManager();
        EntityTransaction entitytransaction=entitymanager.getTransaction();
        
        entitytransaction.begin();
        entitymanager.persist(s);
        entitytransaction.commit();
		}
		
		
		public static Student getStudent(String email,String password){
			 EntityManagerFactory entitymanagerfactory=Persistence.createEntityManagerFactory("madhu");
		        EntityManager entitymanager=entitymanagerfactory.createEntityManager();
		        Query q=entitymanager.createQuery("select  s from Student s where email=?1 and password=?2",Student.class);
		        		q.setParameter(1, email);
		        		q.setParameter(2, password);
		        		List<Student>listofStudent=q.getResultList();
		        		if(listofStudent.size()==1){
		        			return(Student)listofStudent.get(0);
		        		}
		        		return null;
		        		
		}
	}

