package org.app.scrum.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.app.scrum.Proiect;
import org.app.scrum.ProiectBuilder;

public class Test55_ScrumJPARegistruProiecte {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ScrumJPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		/* TODO CRUD Transactions*/
		
		
		System.out.println("End");
	}
}
