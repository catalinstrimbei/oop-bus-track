package org.app.scrum.test;

import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.app.scrum.Proiect;
import org.app.scrum.ProiectBuilder;

public class Test54_ScrumJPAValidator {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ScrumJPA");
		EntityManager em = emf.createEntityManager();
		
		Proiect proiect = new Proiect(101, null, new Date());
		try{
			System.out.println("--------------- JPA Validator: Invocare directa");
			/* Invocare directa*/
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<Proiect>> constraintViolations = validator.validate(proiect);
			handleValidation(constraintViolations);
			
		}catch(ConstraintViolationException e){
			System.out.println("Validator ex: " + e.getMessage());
			for (ConstraintViolation cv : e.getConstraintViolations()){
				System.out.println("ConstraintViolation: " + cv.getMessage());
				System.out.println("Invalid bean: " + cv.getRootBean());
			}	
		}
		
		try{
			System.out.println("--------------- JPA Validator: Invocare directa-TRANZACTIONALA!");
			/* Invocare indirecta prin EntityManager*/
			em.getTransaction().begin();			
			em.persist(proiect);
//			em.getTransaction().commit();
			em.getTransaction().rollback();
			
		}catch(ConstraintViolationException e){
			System.out.println("EntityManager Validation ex: " + e.getMessage());
			for (ConstraintViolation cv : e.getConstraintViolations()){
				System.out.println("ConstraintViolation: " + cv.getMessage());
				System.out.println("Invalid bean: " + cv.getRootBean());
			}	
		}		
		System.out.println("End");
	}

	
	static void handleValidation(Set<ConstraintViolation<Proiect>> cvs){
		for (ConstraintViolation cv : cvs){
			System.out.println("ConstraintViolation: " + cv.getMessage());
			System.out.println("Invalid bean: " + cv.getRootBean());
//			System.out.println("Invalid bean: " + cv.getLeafBean());
		}		
	}
}
