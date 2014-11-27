package org.app.scrum.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CompoundSelection;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.app.scrum.Proiect;
import org.app.scrum.ProiectBuilder;
import org.app.scrum.ProiectView;
/* Tutoriale:
 * ------------
 * http://www.ibm.com/developerworks/library/j-typesafejpa/
 * http://www.objectdb.com/java/jpa/query/jpql/select
 * 
 * https://docs.oracle.com/javaee/6/tutorial/doc/gjrij.html
 * http://www.tutorialspoint.com/jpa/jpa_criteria_api.htm
 * 
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
		
		// JPA-QL Criteria API --------------------------------------------------------- //
		CriteriaBuilder criteriaBuilder;
		CriteriaQuery<Proiect> criteriaQuery;
		Root<Proiect> rootExpression;
		ParameterExpression<Integer> parameterExpression;
		Predicate predicateExpression;		
		TypedQuery<Proiect> typedQueryProiecte;
		
		System.out.println("Ex0 --------------------------------------------------------");
		criteriaBuilder = em.getCriteriaBuilder();
		criteriaQuery = criteriaBuilder.createQuery(Proiect.class);
		rootExpression = criteriaQuery.from(Proiect.class);
		criteriaQuery.select(rootExpression);
		typedQueryProiecte = em.createQuery(criteriaQuery);
		List<Proiect> proiecte = typedQueryProiecte.getResultList();
		//
		for(Proiect p: proiecte)
			System.out.println("Proiect: " + p);		
		em.clear();		
		System.out.println("-----------------------------------------------------------");
		
		/* Ex1.2
		* SELECT p.nrproiect AS nrProiect, p.numeproiect, p.dataStart FROM proiect p
		* Result: list of entities: List<Proiect>
		*/
		System.out.println("Ex1.2 --------------------------------------------------------");
		// Step_1: build query actors
		criteriaBuilder = em.getCriteriaBuilder();
		criteriaQuery = criteriaBuilder.createQuery(Proiect.class);
		// Step_2: prepare query expressions
		rootExpression = criteriaQuery.from(Proiect.class);		
		Selection<Proiect> selectionExpression = criteriaBuilder.construct(
				Proiect.class, 
				rootExpression.get("nrProiect"), 
				rootExpression.get("numeProiect"),
				rootExpression.get("dataStart"));
		Order orderExpression = criteriaBuilder.asc(rootExpression.get("nrProiect"));
		// Step_3: cast expressions within query
		criteriaQuery
			.select(selectionExpression)
			.orderBy(orderExpression);
		// Step_4: execute query
		typedQueryProiecte = em.createQuery(criteriaQuery);
		List<Proiect> proiecteLst = typedQueryProiecte.getResultList();
		for(Proiect p: proiecteLst)
			System.out.println("Proiect: " + p);		
		em.clear();
		System.out.println("-----------------------------------------------------------");
		
		/* Ex2.2
		* SELECT p.nrproiect, p.numeproiect FROM proiect p
		* Result: List of tuples as Arrays List<Object[]> 
		*/		
		System.out.println("Ex2.2 --------------------------------------------------------");
		// Step_1: build query actors
		criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> arrayTypedCriteriaQuery = criteriaBuilder.createQuery(Object[].class);
		// Step_2: prepare query expressions
		rootExpression = criteriaQuery.from(Proiect.class);	
		CompoundSelection<Object[]> compoundSelection = criteriaBuilder
				.array(rootExpression.get("nrProiect"), rootExpression.get("numeProiect"));
		// Step_3: cast expressions within query
		arrayTypedCriteriaQuery
			.select(compoundSelection);
		// Step_4: execute query
		TypedQuery<Object[]> arrayTypedQueryProiecte = em.createQuery(arrayTypedCriteriaQuery);
		List<Object[]> tblProiecte = arrayTypedQueryProiecte.getResultList();
		for(Object[] p: tblProiecte)
			System.out.println("tblProiecte: p[0]= " + p[0] + ", p[1]= " + p[1]);		
		em.clear();
		System.out.println("-----------------------------------------------------------");		
		
		
		/* Ex3.2
		* SELECT COUNT(*) FROM proiect p
		* Result: Long
		*/		
		System.out.println("Ex3.2 --------------------------------------------------------");
		// Step_1: build query actors
		criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Long> longTypedCriteriaQuery = criteriaBuilder.createQuery(Long.class);
		// Step_2: prepare query expressions
		rootExpression = criteriaQuery.from(Proiect.class);	
		Expression<Long> singleLongSelection = criteriaBuilder.count(rootExpression.get("nrProiect"));
		// Step_3: cast expressions within query
		longTypedCriteriaQuery
			.select(singleLongSelection);
		// Step_4: execute query
		TypedQuery<Long> longTypedQueryProiecte = em.createQuery(longTypedCriteriaQuery);
		Long countProiecte = longTypedQueryProiecte.getSingleResult();
		System.out.println("COUNT Proiecte:  " + countProiecte);		
		em.clear();
		System.out.println("-----------------------------------------------------------");		
		
		
		/* Ex4.2
		* SELECT SELECT NEW org.app.scrum.ProiectView(p.nrProiect, p.numeProiect) FROM Proiect p
		* Result: List of entity view instances: List<ProiectView> 
		*/		
		System.out.println("Ex4.2 --------------------------------------------------------");
		// Step_1: build query actors
		criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<ProiectView> criteriaQueryEntityView = criteriaBuilder.createQuery(ProiectView.class);
		// Step_2: prepare query expressions
		rootExpression = criteriaQueryEntityView.from(Proiect.class);		
		Selection<ProiectView> selectionExpressionEntityView = criteriaBuilder.construct(
				ProiectView.class, 
				rootExpression.get("nrProiect"), 
				rootExpression.get("numeProiect"));
		// Step_3: cast expressions within query
		criteriaQueryEntityView
			.select(selectionExpressionEntityView);
		// Step_4: execute query
		TypedQuery<ProiectView> typedQueryProiectView = em.createQuery(criteriaQueryEntityView);
		List<ProiectView> proiecteViewLst = typedQueryProiectView.getResultList();
		for(ProiectView p: proiecteViewLst)
			System.out.println("ProiectView: " + p);		
		em.clear();
		System.out.println("-----------------------------------------------------------");
		
		/* Ex 5.2 Parametri
		 * SELECT p FROM Proiect p WHERE p.nrProiect = 1
		 * 
		 * 
		*/
		System.out.println("-------------------------------------------------------- Ex5.2 ");
		criteriaBuilder = em.getCriteriaBuilder();
		criteriaQuery = criteriaBuilder.createQuery(Proiect.class);
		//
		rootExpression = criteriaQuery.from(Proiect.class);
		parameterExpression = criteriaBuilder.parameter(Integer.class);
		predicateExpression = criteriaBuilder.equal(rootExpression.get("nrProiect"), parameterExpression);
		//		
		criteriaQuery
			.select(rootExpression) // implied by default
			.where(predicateExpression);
		typedQueryProiecte = em.createQuery(criteriaQuery);
		//
		typedQueryProiecte.setParameter(parameterExpression, 1);
		Proiect proiect = typedQueryProiecte.getSingleResult();
		System.out.println("Proiect: " + proiect);		
		System.out.println("--------------------------------------------------------");
		
		
		
		/* TODO :
		 * 1. Query with JOIN expressions
		 * 2. Query with PATH joining expressions
		 * 3. Analytical Query with groupBy and having
		 * 4. Query with subQuery expression
		*/
		
		System.out.println("End");
	}

}

/*
 * CriteriaQuery formalize syntax for Query objects (TypedQuery objects) in 2-phase process:
 * -> CriteriaQuery.from() that will return a Expression from witch to derive other entity-based expressions;
 * -> CriteriaQuery
 * 		.select(selection-Expression)
 * 		.where(predicate-Expression)
 * 		.orderBy(orderBy-Expression)
 * 		.groupBy(property-Expression)
 * 		.having(predicate-expression);
 * 
 * CriteriaBuilder 
 * -> build/create CriteriaQuery
 * -> generate expression to formalize criteria-queries: 
 * 	 selectExpression, predicateExpression, orderByExpression, groupByExpression
 * 
 * Selection-Expressions could be:
 * -> Root expression generated by criteriaQuery.from(...)
 * -> Selection, related with Entity or EntityView types, generated by criteriaBuilder().construct(...) 
 * -> CompoundSelection, as enumerative array, generated by criteriaBuilder().array(...)
 * -> Number, as Long, or other single-value expressions generated by 
 * 	  criteriaBuilder.count(...), criteriaBuilder.avg(), criteriaBuilder.max(), criteriaBuilder.min()
 *    criteriaBuilder.sum(), etc.
 * 
 * Predicate-Expression could be generate by criteriaBuilder with:
 * -> .equals(expression, expression), .notEquals()
 * -> .greaterThen(), .lessThan(), .between() 
 * -> .like(), substring()
 * -> .or(), .and(), .not()
 * 
 * OrderBy-Expression could be generate by criteriaBuilder with:
 * -> .asc(expression), .desc(expression)
 * 
 * GroupBy-Expression could be generate by Root expression with:
 * -> .get(<propertyName>)
 * 
 * 
 */