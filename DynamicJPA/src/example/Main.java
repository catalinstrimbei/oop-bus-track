/*******************************************************************************
 * Copyright (c) 1998, 2008 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     dclarke - Dynamic Persistence INCUBATION - Enhancement 200045
 *               http://wiki.eclipse.org/EclipseLink/Development/JPA/Dynamic
 *     
 * This code is being developed under INCUBATION and is not currently included 
 * in the automated EclipseLink build. The API in this code may change, or 
 * may never be included in the product. Please provide feedback through mailing 
 * lists or the bug database.
 ******************************************************************************/
package example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.dynamic.DynamicClassLoader;
import org.eclipse.persistence.dynamic.DynamicType;
import org.eclipse.persistence.jpa.JpaHelper;
import org.eclipse.persistence.jpa.dynamic.JPADynamicHelper;
import org.eclipse.persistence.tools.schemaframework.SchemaManager;

import example.util.ExamplePropertiesLoader;

public class Main {

    public static void main(String[] args) throws Exception {
        // Test 1 - using dynamic API directly.
        runDynamicAPITest();
        
        // Test 2 - using only JPA.
        runDynamicJPATest();
    }
    
    public static void runDynamicAPITest() {
        // Create a dynamic class loader and create the types.
        DynamicClassLoader dcl = new DynamicClassLoader(Thread.currentThread().getContextClassLoader());
//        List<DynamicType> types = EmployeeDynamicMappings.createTypes(dcl, "example.jpa.dynamic.model.employee");
        List<DynamicType> types = EmployeeDynamicMappings.createTypes(dcl, "example.entities");   
        for(DynamicType dt: types){
        	System.out.println("Dynamic type: " + dt.getName());
        }
        
        // Create an entity manager factory.
        EntityManagerFactory emf = createEntityManagerFactory(dcl, "default");
//        EntityManagerFactory emf = createEntityManagerFactory(dcl, "ScrumJPA");
       
        // Create JPA Dynamic Helper (with the emf above) and after the types
        // have been created and add the types through the helper.
        JPADynamicHelper helper = new JPADynamicHelper(emf);
//        helper.addTypes(true, true, types);
        for(DynamicType dt: types)
        	helper.addTypes(true, true, dt);
        
        // Create database and populate
        new SchemaManager(helper.getSession()).replaceDefaultTables();

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        new Samples(emf).persistAll(em);
        em.getTransaction().commit();
        em.clear();

        // Run Queries
        Queries queries = new Queries();

        queries.minEmployeeWithManagerWithAddress(em);
        queries.findEmployeesUsingGenderIn(em);

        // Example transactions
        Transactions txn = new Transactions();

        em.getTransaction().begin();
        
        txn.createUsingPersist(em);

        em.getTransaction().rollback();
        
        em.close();
        emf.close();
    }
    
    public static void runDynamicJPATest() {
        // Create an entity manager factory with a dynamic class loader.
        EntityManagerFactory emf = createEntityManagerFactory(new DynamicClassLoader(Thread.currentThread().getContextClassLoader()), "employee");

        new SchemaManager(JpaHelper.getServerSession(emf)).replaceDefaultTables();
        
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        new Samples(emf).persistAll(em);
        em.getTransaction().commit();
        em.clear();

        // Run Queries
        Queries queries = new Queries();

        queries.minEmployeeWithManagerWithAddress(em);
        queries.findEmployeesUsingGenderIn(em);

        // Example transactions
        Transactions txn = new Transactions();

        em.getTransaction().begin();
        
        txn.createUsingPersist(em);

        em.getTransaction().rollback();
        
        em.close();
        emf.close();
    }
    
    public static EntityManagerFactory createEntityManagerFactory(DynamicClassLoader dcl, String persistenceUnit) {
        Map<Object, Object> properties = new HashMap<Object, Object>();
        ExamplePropertiesLoader.loadProperties(properties);
        properties.put(PersistenceUnitProperties.CLASSLOADER, dcl);
        properties.put(PersistenceUnitProperties.WEAVING, "static");
        return Persistence.createEntityManagerFactory(persistenceUnit, properties);
    }
}