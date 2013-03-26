package org.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

public class TestPersistenta {
	private static EntityManager em = EMF.getEntityManager();
	public static String test() {
		StringBuilder out = new StringBuilder();
		try{
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			
			// clean up
			em.getTransaction().begin();
			em.createQuery("DELETE FROM Comanda c").executeUpdate();
			em.getTransaction().commit();
			em.getTransaction().begin();
			em.createQuery("DELETE FROM Client c").executeUpdate();
			em.getTransaction().commit();
			
			// repopulate
			em.getTransaction().begin();
			Client c1 = new Client(101l, "Client 101");
			Client c2 = new Client(102l, "Client 102");
			
			Comanda com1 = new Comanda(1001l, new Date(), c1);
			Comanda com2 = new Comanda(1002l, new Date(), c1);
			Comanda com3 = new Comanda(1003l, new Date(), c2);
			Comanda com4 = new Comanda(1004l, new Date(), c2);
			
			em.getTransaction().commit();
			
			List<Comanda> comenzi = em.createQuery("SELECT o FROM Comanda o").getResultList();
			for(Comanda com: comenzi)
				out.append(com);
		}catch(Exception ex){
			out.append(ex.getMessage());
			ex.printStackTrace();
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
		return out.toString();
	}
}
