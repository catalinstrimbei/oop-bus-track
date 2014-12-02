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
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.persistence.criteria.Subquery;

import org.app.scrum.*;
import org.eclipse.persistence.jpa.JpaQuery;

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
 * http://www.altuure.com/2010/09/23/jpa-criteria-api-by-samples-%E2%80%93-part-ii/
 */
public class Test55_ScrumJPAQueries {

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
		
		
		/*Ex 5.1 Parametri*/
		/*Ex 6.1 INNER JOIN */
		System.out.println("----------------------------------------------------- Ex 6.1: INNER JOIN");
		List<Release> releases = em.createQuery(
					"SELECT r FROM Proiect p INNER JOIN p.releases r" 
					// + " JOIN p.releases r"
					+ " WHERE p.nrProiect = :nrProiect "
					, Release.class)
				.setParameter("nrProiect", 1)
				.getResultList();
		for(Release r: releases)
			System.out.println("Release: of " + r.getProiect().getNumeProiect() + ": " + r);		
		System.out.println("-----------------------------------------------------------");
		
		/*Ex 7.1 FETCH JOIN */
		System.out.println("----------------------------------------------------- Ex 7.1: JOIN FETCH");
		List<Proiect> proiectReleases = em.createQuery(
					"SELECT DISTINCT p FROM Proiect p JOIN FETCH p.releases r" 
					, Proiect.class)
				.getResultList();
		for(Proiect p: proiectReleases){
			System.out.println("+ Proiect: " + p + " -> releases:");
			for(Release r: p.getReleases())
				System.out.println("	- Release: " + r);				
		}
			
		System.out.println("-----------------------------------------------------------");		
		/*Ex 8.1 GROUP BY HAVING */
		System.out.println("----------------------------------------------------- Ex 8.1: GROUP BY HAVING");
		List<Object[]> proiectReleasesCount = em.createQuery(
					  "SELECT p, COUNT(r) as releasesCount FROM Proiect p INNER JOIN p.releases r " 
					+ "GROUP BY p HAVING COUNT(r) >= :cnt" )
				.setParameter("cnt", 5)
				.getResultList();
		for(Object[] record: proiectReleasesCount){
			Proiect p = (Proiect)record[0];
			System.out.println("+ Proiect: " + p + " -> releases count :" + record[1]);
			for(Release r: p.getReleases())
				System.out.println("	- Release: " + r);				
		}
		System.out.println("-----------------------------------------------------------");		
		/*Ex 9.1 SUB/NESTED QUERY */
		System.out.println("----------------------------------------------------- Ex 9.1: SUB/NESTED QUERY");
		List<Release> releasesProiect = em.createQuery(
					"SELECT r FROM Release r WHERE r.proiect IN " 
					+ "(SELECT p FROM Proiect p WHERE p.nrProiect = :nrProiect)"
					, Release.class)
				.setParameter("nrProiect", 1)
				.getResultList();
		for(Release r: releasesProiect)
			System.out.println("Release ::: of " + r.getProiect().getNumeProiect() + ": " + r);		
		System.out.println("-----------------------------------------------------------");		
		
		
		// JPA-QL Criteria API ------------------------------------------------------------------------------------------------------------------------- //
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
		
		/*Ex 6.2 INNER JOIN 
		 * SELECT r FROM Proiect p INNER JOIN p.releases r WHERE p.nrProiect = :nrProiect
		 * */
		System.out.println("----------------------------------------------------- Ex 6.2: INNER JOIN");
		criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Release> releaseCriteriaQuery = criteriaBuilder.createQuery(Release.class);
		// FROM Proiect p
		rootExpression = criteriaQuery.from(Proiect.class); 
		// INNER JOIN p.releases
		Join<Proiect, Release> joinExpression = rootExpression.join("releases", JoinType.INNER); 
		// Predicat: p.nrProiect = :nrProiect
		parameterExpression = criteriaBuilder.parameter(Integer.class);
		predicateExpression = criteriaBuilder.equal(rootExpression.get("nrProiect"), parameterExpression); 
		// Build query-phrase		
		releaseCriteriaQuery
			.select(joinExpression) // SELECT r // var.2: multiselect(rootExpression.get("releases")) // SELECT p.releases
			.where(predicateExpression); // WHERE p.nrProiect = :nrProiect
		TypedQuery<Release> typedQueryReleases = em.createQuery(releaseCriteriaQuery);
		// set parameter and execute
		typedQueryReleases.setParameter(parameterExpression, 1);
		releases = typedQueryReleases.getResultList();		
		for(Release r: releases)
			System.out.println("Release: of " + r.getProiect().getNumeProiect() + ": " + r);		
		System.out.println("-----------------------------------------------------------");
		
		/*Ex 7.2 FETCH JOIN 
		 * SELECT DISTINCT p FROM Proiect p JOIN FETCH p.releases r
		 * */
		System.out.println("----------------------------------------------------- Ex 7.2: JOIN FETCH");
		criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Proiect> proiectCriteriaQuery = criteriaBuilder.createQuery(Proiect.class);
		// FROM Proiect p
		rootExpression = criteriaQuery.from(Proiect.class); 
		// JOIN FETCH p.releases r
		Fetch<Proiect, Release> fetchExpression = rootExpression.fetch("releases");
		// Build query-phrase	
		proiectCriteriaQuery
			.select(rootExpression).distinct(true); // SELECT DISTINCT p
		// Create query and execute
		TypedQuery<Proiect> typedQueryProiectReleases = em.createQuery(proiectCriteriaQuery);
		proiectReleases = typedQueryProiectReleases.getResultList();	
		for(Proiect p: proiectReleases){
			System.out.println("+ Proiect: " + p + " -> releases:");
			for(Release r: p.getReleases())
				System.out.println("	- Release: " + r);				
		}
		System.out.println("-----------------------------------------------------------");		
		
		/*Ex 8.2 GROUP BY HAVING 
		 * SELECT p, COUNT(r) as releasesCount FROM Proiect p INNER JOIN p.releases r
		 * GROUP BY p HAVING COUNT(r) >= :cnt
		 * */
		System.out.println("----------------------------------------------------- Ex 8.2: GROUP BY HAVING");
		criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> proiectReleaseCountCriteriaQuery = criteriaBuilder.createQuery(Object[].class);
		// FROM Proiect p
		rootExpression = proiectReleaseCountCriteriaQuery.from(Proiect.class);  
		// INNER JOIN p.releases r
		Join<Proiect, Release> joinReleaseExpression = rootExpression.join("releases", JoinType.INNER);	
		// SELECT p, COUNT(r)
		Expression<Long> countExpression = criteriaBuilder.count(joinReleaseExpression);
		CompoundSelection<Object[]> compoundProiectCountReleaseSelection = criteriaBuilder
				.array(rootExpression, countExpression);	
		// Predicate: COUNT(r) >= :cnt
		ParameterExpression<Integer> parameterCntExpression = criteriaBuilder.parameter(Integer.class, "cnt");
		Predicate predicateCountExpression = criteriaBuilder
				.ge(countExpression, parameterCntExpression);
				//.greaterThanOrEqualTo(countExpression, parameterExpression);
		// Build query-phrase	
		proiectReleaseCountCriteriaQuery
			.select(compoundProiectCountReleaseSelection)
			.groupBy(rootExpression)
			.having(predicateCountExpression)
			;		
		// Create query and execute
		TypedQuery<Object[]> typedQueryProiectReleasesCount = em.createQuery(proiectReleaseCountCriteriaQuery);
		typedQueryProiectReleasesCount.setParameter("cnt", 3); 
		// Bug: // typedQueryProiectReleasesCount.setParameter(parameterCntExpression, 3);
		proiectReleasesCount = typedQueryProiectReleasesCount.getResultList();
		for(Object[] record: proiectReleasesCount){
			Proiect p = (Proiect)record[0];
			System.out.println("+ Proiect :: " + p + " -> releases count :" + record[1]);
			for(Release r: p.getReleases())
				System.out.println("	- Release: " + r);				
		}
		
		System.out.println("-----------------------------------------------------------");		
		/*Ex 9.2 SUB/NESTED QUERY 
		 * SELECT r FROM Release r WHERE r.proiect.nrProiect IN 
		 * 		(SELECT p.nrProiect FROM Proiect p WHERE p.nrProiect = 1)
		 * */
		System.out.println("----------------------------------------------------- Ex 9.1: SUB/NESTED QUERY");
		CriteriaBuilder criteriaBuilderReleaseQuery = em.getCriteriaBuilder();
		CriteriaQuery<Release> releaseCriteriaMainQuery = criteriaBuilderReleaseQuery.createQuery(Release.class);
		// FROM Release r
		Root<Release> mainQueryRootExpression = releaseCriteriaMainQuery.from(Release.class);
		// <Sub-query> 
		Subquery<Proiect> subQuery = releaseCriteriaMainQuery.subquery(Proiect.class);
		// FROM Proiect p 
		Root subQueryRootExpression = subQuery.from(Proiect.class);
		subQuery
			// SELECT p.nrProiect
			.select(subQueryRootExpression.get("nrProiect"))
			// WHERE p.nrProiect = :nrProiect
			.where(criteriaBuilderReleaseQuery.equal(subQueryRootExpression.get("nrProiect"), 1))
			;
		// </Sub-query>
		// Main Query predicate 
		// Expression: r.proiect.nrProiect
		Path pathIdProiect = mainQueryRootExpression.join("proiect", JoinType.INNER).get("nrProiect");
		// WHERE r.proiect.nrProiect IN (subquery)
		Predicate mainQuerypredicateExpression = criteriaBuilderReleaseQuery.in(pathIdProiect).value(subQuery);
		// Build query-phrase		
		releaseCriteriaMainQuery
			.select(mainQueryRootExpression) // SELECT r
			.where(mainQuerypredicateExpression) // r.proiect.nrProiect IN (subquery)
			; 
		TypedQuery<Release> typedCompositQueryReleases = em.createQuery(releaseCriteriaMainQuery);		
		// execute
		List<Release> releasesList = typedCompositQueryReleases.getResultList();		
		for(Release r: releasesList)
			System.out.println("Release: of " + r.getProiect().getNumeProiect() + " --> " + r);		

		System.out.println("-----------------------------------------------------------");					
		
		/* TODO :
		 * 1. Query with JOIN expressions
		 * 2. Query with PATH joining expressions
		 * 3. Analytical Query with groupBy and having
		 * 4. Query with subQuery expression
		 * 8. Test-class short version
		 * 9. Test-class detailed version
		*/
		
		System.out.println("End");
	}
	
	static void nestedQueryCriteriaAPI(EntityManager em){
		
	}

	static void nestedQueryCriteriaAPI2(EntityManager em){
		/*Ex 9.2 SUB/NESTED QUERY 
		 * SELECT r FROM Release r WHERE r.proiect IN 
		 * (SELECT p FROM Proiect p WHERE p.nrProiect = :nrProiect)
		 * */
		System.out.println("----------------------------------------------------- Ex 9.1: SUB/NESTED QUERY");
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Release> releaseCriteriaMainQuery = criteriaBuilder.createQuery(Release.class);
		// FROM Proiect p
		Root<Release> mainQueryRootExpression = releaseCriteriaMainQuery.from(Release.class);
		
		// Sub-query: FROM Proiect p 
		Subquery<Proiect> subQuery = releaseCriteriaMainQuery.subquery(Proiect.class);
		//Subquery<Integer> subQuery = releaseCriteriaMainQuery.subquery(Integer.class);
		Root subQueryRootExpression = subQuery.from(Proiect.class);
		subQuery
			//.select(subQueryRootExpression.get("nrProiect"))
		    //.select(subQueryRootExpression)
			.where(criteriaBuilder.equal(subQueryRootExpression.get("nrProiect"), 1))
			;
		
		// Main Query predicate WHERE r.proiect IN (...) BUG!!!
		Join<Release, Proiect> joinProiectExpression = mainQueryRootExpression.join("proiect", JoinType.INNER);
		Path pathIdProiect = joinProiectExpression.get("nrProiect");
		Predicate mainQuerypredicateExpression = criteriaBuilder.in(pathIdProiect).value(subQuery);
		//Predicate mainQuerypredicateExpression = criteriaBuilder.in(mainQueryRootExpression.get("proiect")).value(subQuery);
		
		// Build query-phrase		
		releaseCriteriaMainQuery
			.select(mainQueryRootExpression) // SELECT r // var.2: multiselect(rootExpression.get("releases")) // SELECT p.releases
			.where(mainQuerypredicateExpression) // WHERE p.nrProiect = :nrProiect
			; 
		TypedQuery<Release> typedCompositQueryReleases = em.createQuery(releaseCriteriaMainQuery);
		// DEBUG
		System.out.println("JPQL: " + typedCompositQueryReleases.unwrap(JpaQuery.class).getDatabaseQuery().getJPQLString());
		System.out.println("SQL: " + typedCompositQueryReleases.unwrap(JpaQuery.class).getDatabaseQuery().getSQLString());
		
		// execute
		List<Release> releases = typedCompositQueryReleases.getResultList();		
		for(Release r: releases)
			System.out.println("Release: of " + r.getProiect().getNumeProiect() + " --> " + r);		

		System.out.println("-----------------------------------------------------------");			
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
 * -> Root expression generated by criteriaQuery.from(Entity-type-class)
 * -> Selection, related with Entity or EntityView types, generated by criteriaBuilder().construct(Path-expressions) 
 * -> CompoundSelection, as enumerative array, generated by criteriaBuilder().array(Path-expressions)
 * -> Number, as Long, or other single-value expressions generated by 
 * 	  criteriaBuilder.count(Path-expression), criteriaBuilder.avg(), criteriaBuilder.max(), criteriaBuilder.min()
 *    criteriaBuilder.sum(), etc.
 * 
 * Predicate-Expression could be generate by criteriaBuilder with:
 * -> .equals(Path-expressions, expression), .notEquals()
 * -> .greaterThen(), .lessThan(), .between() 
 * -> .like(), substring()
 * -> .or(Predicate-Expressions), .and(), .not()
 * 
 * OrderBy-Expression could be generate by criteriaBuilder with:
 * -> .asc(Path-expressions), .desc()
 * 
 * GroupBy-Expression 
 * 		could be generate as Path-expression
 * 		by Root expression with:
 * -> .get(<propertyName>)
 * 
 * -----------------------------------
 * Expression types:
 * - from expressions: Root, Join, Fetch
 * - path expressions
 * ------------------------------------
 * 
 * 
 * CriteriaQuery
 * 		.select(selection-Expression)
 * 
 * CriteriaQuery
 * 		.multiselect(selection-Expression)
 * 
 */