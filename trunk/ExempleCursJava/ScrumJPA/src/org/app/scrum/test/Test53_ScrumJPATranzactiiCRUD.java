package org.app.scrum.test;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.app.scrum.Proiect;
import org.app.scrum.ProiectBuilder;

/* In persistence.xml (JPA 2.1)
 * <property name="javax.persistence.schema-generation.database.action" value="none"/>
 * Tranzactia JPA va salva doar instantele-entitati in tabelele relationale.
 */
public class Test53_ScrumJPATranzactiiCRUD {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ScrumJPA");
		EntityManager em = emf.createEntityManager();
		List<Proiect> proiecte =  null; Proiect proiect = null;
		Query queryProiecte = em.createQuery("SELECT p FROM Proiect p");
		Query queryProiect = em.createQuery("SELECT p FROM Proiect p WHERE p.nrProiect = 1");
		
		/* TODO CRUD Transactions*/
		
		// DELETE: Stergere proiecte existente
		System.out.println("DELETE proiecte!");
		em.getTransaction().begin();
		proiecte = queryProiecte.getResultList();
		for(Proiect p: proiecte)
			em.remove(p);
		em.getTransaction().commit();
		proiecte =  null;
		em.clear();
		
		// CREATE: Salvare proiecte noi
		System.out.println("CREARE proiecte!");
		em.getTransaction().begin();
		for(int i=1; i <= 4; i++){
			proiect = new ProiectBuilder().buildProiect(i, "Proiect Test", i+2);
			em.persist(proiect);
		}
		proiecte =  null; proiect = null;
		em.getTransaction().commit();
		em.clear();
		
		// UPDATE: Interogare proiect, modificare proiect, salvare proiect existent
		System.out.println("UPDATE proiecte!");
		em.getTransaction().begin();
		proiect = (Proiect) queryProiect.getSingleResult();
		proiect.setNumeProiect(proiect.getNumeProiect() + " - MODIFICAT");
		// em.persist(proiect) // nu mai este necesar
		em.getTransaction().commit();
		proiecte =  null; proiect = null;
		em.clear();
		
		// READ: Afisare toate proiectele existente
		System.out.println("READ proiecte!");
		proiecte = queryProiecte.getResultList();
		for(Proiect p: proiecte){
			System.out.println("Proiect entitate persistenta: " + p);
		}
		
		System.out.println("End");
	}
}
