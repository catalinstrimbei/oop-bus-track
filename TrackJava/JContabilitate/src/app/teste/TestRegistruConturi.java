/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.teste;

import app.model.contabilitate.RegistruConturi;
import app.model.contabilitate.conturi.ClasaConturi;
import app.model.contabilitate.conturi.Cont;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author catalin
 */
public class TestRegistruConturi {

    public static void main(String[] args) {
        test();
        
    }

    private static void test() {
        // creare entity manager
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("JContabilitate_PU");
        EntityManager em = emf.createEntityManager();

        // initializare registru
        RegistruConturi registruConturi = new RegistruConturi(em);

        // creare conturi libere
        ClasaConturi c_4 = new ClasaConturi("4", "CLASA 4 - CONTURI DE TERTI");
        ClasaConturi c_41 = new ClasaConturi("41", "CLIENTI SI CONTURI ASIMILATE");
        c_41.setClasaParinte(c_4);
        Cont c_411 = new Cont("411", "Clienti");
        c_411.setSubClasaCont(c_41);
        Cont c_411_1 = new Cont("411.1", "Alfa SRL");
        c_411_1.setContParinte(c_411);
        Cont c_411_2 = new Cont("411.2", "Beta SRL");
        c_411_2.setContParinte(c_411);

        //EntityTransaction transaction = em.getTransaction();
        try {
            // salvare conturi
            registruConturi.addCont(c_411);
            registruConturi.addCont(c_411_1);
            registruConturi.addCont(c_411_2);

            for(Cont c : registruConturi.getConturi())
                System.out.println(c);

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
