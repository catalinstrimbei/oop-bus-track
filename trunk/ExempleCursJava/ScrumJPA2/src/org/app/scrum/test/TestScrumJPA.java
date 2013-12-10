package org.app.scrum.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

import org.app.scrum.Proiect;
import org.app.scrum.ProiectBuilder;

public class TestScrumJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ScrumJPA2");
		EntityManager em = emf.createEntityManager();
		
		Proiect proiect = new ProiectBuilder().buildProiect(1, "Proiect Test", 3);
		//proiect.setReleaseCurent(proiect.getReleases().get(0));
		try{
			em.getTransaction().begin();
			System.out.println("Saving proiect!");
			em.persist(proiect);
			em.getTransaction().commit();
		}catch(ConstraintViolationException e){
			System.out.println("Validation ex: " + e.getMessage());
		}
		System.out.println("End");
	}

}
