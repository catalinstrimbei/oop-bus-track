package org.comenzi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestClienti1 {
	public static void main(String[] args){
			List<Client> clienti = new ArrayList<Client>();
			clienti.add(new Client(101, "Alfa SRL"));
			clienti.add(new Client(102, "Beta SRL"));
			clienti.add(new Client(103, "Gama SRL"));
			clienti.add(new Client(104, "Delta SRL"));

			EntityManagerFactory emf = Persistence.
				createEntityManagerFactory("ProduseJPA");
			EntityManager em = emf.createEntityManager();
			
			
			// Create
			em.getTransaction().begin();
			em.persist(clienti.get(0));
			em.persist(clienti.get(1));
			em.persist(clienti.get(2));
			em.persist(clienti.get(3));
			em.getTransaction().commit();
			// Read after create
			List<Client> lstClientiPersistenti = em.
				createQuery("SELECT c FROM Client c").getResultList();
			System.out.println("Lista clienti persistenti/salvati in baza de date");
			for (Client c: lstClientiPersistenti)
				System.out.println("Id: " + c.getId() + ", nume: " + c.getNume());
			
			// Tranzactie ce va cumula operatiile Update-Remove
			em.getTransaction().begin();
			// Read-Update
			Client c102 = em.find(Client.class, 101);
			if (c102 != null){
				c102.setNume("Teta SRL");
				em.persist(c102);
			}
			// Read-Remove
			Client c103 = (Client) em.
				createQuery("SELECT o FROM Client o WHERE o.id = 103").
				getSingleResult(); 
			if (c103 != null){
				em.remove(c103);
			}
			// Realizare tranzactie - sincronizare cu baza de date
			em.getTransaction().commit();
			
			lstClientiPersistenti = em.
				createQuery("SELECT c FROM Client c").getResultList();
			System.out.println("Lista finala clienti persistenti/salvati in baza de date");
			for (Client c: lstClientiPersistenti)
				System.out.println("Id: " + c.getId() + ", nume: " + c.getNume());
		}
		
}
