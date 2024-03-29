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

public class Test52_ScrumJPACreareEntitati {

	/* In persistence.xml (JPA 2.1)
	 * <property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
	 * Tranzactia JPA va genera tabelele-entitati in baza de date.
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ScrumJPA");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		// clear
		em.createQuery("DELETE FROM Release r").executeUpdate();
		em.createQuery("DELETE FROM Proiect p").executeUpdate();

		Proiect proiect;
		for(int i=1; i <= 4; i++){
			proiect = new ProiectBuilder().buildProiect(i, "Proiect Test", i+2);
			em.persist(proiect);
		}
		
		System.out.println("Salvare proiecte!");
		em.getTransaction().commit();
		
		List<Proiect> proiecte;
		
		// JPQL Text SELECT phrase (as in SQL)
		proiecte = em
				.createQuery("SELECT p FROM Proiect p")
				.getResultList();		


		for(Proiect p: proiecte){
			System.out.println("Proiect entitate persistenta: " + p);
		}
		
		// JPQL Criteria API (object-oriented query build)
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Proiect> cq = cb.createQuery(Proiect.class);
		Root<Proiect> root = cq.from(Proiect.class);
		cq.select(root);
		TypedQuery<Proiect> q = em.createQuery(cq);
		proiecte = q.getResultList();

		for(Proiect p: proiecte){
			System.out.println("[JPQL Criteria API] Proiect entitate persistenta: " + p);
		}
				
		
		System.out.println("End");
	}

}