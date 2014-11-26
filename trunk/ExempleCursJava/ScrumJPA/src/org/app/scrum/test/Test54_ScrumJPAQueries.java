package org.app.scrum.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.myfaces.shared.util.ParametrizableFacesMessage;
import org.app.scrum.Proiect;
import org.app.scrum.ProiectBuilder;
import org.app.scrum.ProiectView;
/* Tutoriale:
 * ------------
 * https://docs.oracle.com/javaee/6/tutorial/doc/gjrij.html
 * http://www.objectdb.com/java/jpa/query/criteria
 * http://www.altuure.com/2010/09/23/jpa-criteria-api-by-samples-part-i/
 */
public class Test54_ScrumJPAQueries {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ScrumJPA");
		EntityManager em = emf.createEntityManager();
		
		/* Ex 1.1 */
		System.out.println("--------------------------------------------------------");
		List<Proiect> pListEntity = em.createNativeQuery("SELECT p.nrproiect AS nrProiect, p.numeproiect, p.datastart FROM proiect p", Proiect.class)
				.getResultList();
		for(Proiect p: pListEntity)
			System.out.println("Proiect: " + p);
				
		/* Ex 2.1 */
		System.out.println("--------------------------------------------------------");
		List<Object[]> pListArray = em.createNativeQuery("SELECT p.nrproiect, p.numeproiect FROM proiect p").getResultList();
		for(Object[] p: pListArray)
			System.out.println("Proiect: " + p[0] + " - " + p[1]);		

		/* Ex 3.1 */
		System.out.println("--------------------------------------------------------");
		Long nrProiecte = (Long) em.createNativeQuery("SELECT COUNT(*) FROM proiect p").getSingleResult();
		System.out.println("Nr proiecte: " + nrProiecte);
		
		/* Ex 4.1 */
		System.out.println("--------------------------------------------------------");
		List<ProiectView> pListView = em.createQuery("SELECT NEW org.app.scrum.ProiectView(p.nrProiect, p.numeProiect) FROM Proiect p").getResultList();
		for(ProiectView p: pListView)
			System.out.println("Proiect: " + p);		
		
		/* Ex 5.2 Parametri*/
		
		// TODO: Add exemple JPA2.1 Criteria API 
		CriteriaBuilder cb;
		CriteriaQuery<Proiect> cq;
		Root<Proiect> root;
		ParameterExpression<Integer> prm;
		Predicate predicate;
		
		TypedQuery<Proiect> typedQueryProiecte;
		List<Proiect> proiecte;
		
		/* Ex 1.2 */
		System.out.println("Ex1.2 --------------------------------------------------------");
		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Proiect.class);
		root = cq.from(Proiect.class);
		//
		cq.select(root);
		typedQueryProiecte = em.createQuery(cq);
		proiecte = typedQueryProiecte.getResultList();
		//
		for(Proiect p: proiecte)
			System.out.println("Proiect: " + p);		
		em.clear();
		
		/* Ex 2.2 */
		System.out.println("--------------------------------------------------------");
		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Proiect.class);
		root = cq.from(Proiect.class);
		prm = cb.parameter(Integer.class);
		predicate = cb.equal(root.get("nrProiect"), prm);
		//
		cq.select(root).where(predicate);		
		typedQueryProiecte = em.createQuery(cq);
		typedQueryProiecte.setParameter(prm, 1);
		proiecte = typedQueryProiecte.getResultList();
		//
		for(Proiect p: proiecte)
			System.out.println("Proiect: " + p);		
		
		/* Ex 3.2 */
		System.out.println("--------------------------------------------------------");
		cb = em.getCriteriaBuilder();
		cq = cb.createQuery(Proiect.class);
		root = cq.from(Proiect.class);
		prm = cb.parameter(Integer.class);
		predicate = cb.equal(root.get("nrProiect"), prm);
		//
		cq.select(root).where(predicate);		
		typedQueryProiecte = em.createQuery(cq);
		typedQueryProiecte.setParameter(prm, 1);
		proiecte = typedQueryProiecte.getResultList();
		

		/* Ex 4.2 */
		System.out.println("--------------------------------------------------------");
		
		System.out.println("End");
	}

}
