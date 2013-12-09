package org.app.scrum.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.app.scrum.Proiect;
import org.app.scrum.ProiectBuilder;

public class TestScrumJPA {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ScrumJPA");
		EntityManager em = emf.createEntityManager();
		
		Proiect proiect = new ProiectBuilder().buildProiect(1, "Proiect Test", 3);
		
		em.getTransaction().begin();
		System.out.println("Saving proiect!");
		em.persist(proiect);
		em.getTransaction().commit();
		
		System.out.println("End");
	}

}
