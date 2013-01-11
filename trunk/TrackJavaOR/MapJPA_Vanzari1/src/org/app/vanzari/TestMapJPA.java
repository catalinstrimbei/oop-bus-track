package org.app.vanzari;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestMapJPA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MapJPA");
		EntityManager em = emf.createEntityManager();
		
		List<ElementFacturabil> elementFacturabile = em.createQuery("SELECT e FROM ElementFacturabil e").getResultList();
		
		for (ElementFacturabil element: elementFacturabile)
			System.out.println(element.getDenumire());
		
		
	}

}