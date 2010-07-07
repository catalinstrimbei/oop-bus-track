/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.teste;

import app.model.contabilitate.InregistrareContabila;
import app.model.contabilitate.InregistrareCredit;
import app.model.contabilitate.InregistrareDebit;
import app.model.contabilitate.OperatiuneContabila;
import app.model.contabilitate.conturi.Cont;
import app.model.contabilitate.operatiuni.Vinzare;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author catalin
 */
public class TestColectii2 {
    public static void main(String[] args) {
        //new TestColectii2().testHashSetConturi();
        //new TestColectii2().testTreeSetConturi();
        //new TestColectii2().testHahMapConturi();
        new TestColectii2().testTreeMapInregistrariContabile();
    }

    void testHashSetConturi(){
        Set<Cont> conturi = new HashSet<Cont>();

        Cont c_101 = new Cont("101", "Capital");
        Cont c_1011 = new Cont("1011", "Capital subscris nevarsat");
        Cont c_1012 = new Cont("1012", "Capital subscris varsat");
        Cont c_104 = new Cont("104", "Prime de Capital");
        Cont c_1041 = new Cont("1041", "Prime de emisiune");
        Cont c_104_ = c_104;
        Cont c_1042 = new Cont("1042", "Prime de fuziune");
        Cont c_1043 = new Cont("1043", "Prime de aport");
        Cont c_1042_ = c_1042;

        System.out.println(c_101 + " este adaugat " + conturi.add(c_101));
        System.out.println(c_1011 + " este adaugat " + conturi.add(c_1011));
        System.out.println(c_1012 + " este adaugat " + conturi.add(c_1012));
        System.out.println(c_104 + " este adaugat " + conturi.add(c_104));
        System.out.println(c_1041 + " este adaugat " + conturi.add(c_1041));
        System.out.println(c_104_ + " este adaugat " + conturi.add(c_104_));
        System.out.println(c_1042 + " este adaugat " + conturi.add(c_1042));
        System.out.println(c_1043 + " este adaugat " + conturi.add(c_1043));
        System.out.println(c_1042_ + " este adaugat " + conturi.add(c_1042_));
        
    }

    void testTreeSetConturi(){
        Set<Cont> conturi = new TreeSet<Cont>();

        Cont c_1041 = new Cont("1041", "Prime de emisiune");
        Cont c_1042 = new Cont("1042", "Prime de fuziune");
        Cont c_101 = new Cont("101", "Capital");
        Cont c_104 = new Cont("104", "Prime de Capital");
        Cont c_1043 = new Cont("1043", "Prime de aport");
        Cont c_1011 = new Cont("1011", "Capital subscris nevarsat");
        Cont c_1012 = new Cont("1012", "Capital subscris varsat");

        conturi.add(c_1041);
        conturi.add(c_1042);
        conturi.add(c_101);
        conturi.add(c_104);
        conturi.add(c_1043);
        conturi.add(c_1011);
        conturi.add(c_1012);

        for(Cont c : conturi){
            System.out.println(c);
        }
    }

    void testHahMapConturi(){

        Map<String, Cont> conturi = new HashMap<String, Cont>();

        Cont c_1041 = new Cont("1041", "Prime de emisiune");
        Cont c_1042 = new Cont("1042", "Prime de fuziune");
        Cont c_101 = new Cont("101", "Capital");
        Cont c_104 = new Cont("104", "Prime de Capital");
        Cont c_1043 = new Cont("1043", "Prime de aport");
        Cont c_1011 = new Cont("1011", "Capital subscris nevarsat");
        Cont c_1012 = new Cont("1012", "Capital subscris varsat");

        conturi.put(c_1041.getCod(), c_1041);
        conturi.put(c_1042.getCod(), c_1042);
        conturi.put(c_101.getCod(), c_101);
        conturi.put(c_104.getCod(), c_104);
        conturi.put(c_1043.getCod(), c_1043);
        conturi.put(c_1011.getCod(), c_1011);
        conturi.put(c_1012.getCod(), c_1012);


        //dublicare
        Cont c_101_ = new Cont("101", "Capital_dublicat");
        Cont c_1041_ = new Cont("1041", "Prime de emisiune_dublicat");
        Cont c_1011_ = new Cont("1011", "Capital subscris nevarsat_dublicat");
        conturi.put(c_101_.getCod(), c_101_);
        conturi.put(c_1041_.getCod(), c_1041_);
        conturi.put(c_1011_.getCod(), c_1011_);

        for (Cont c : conturi.values())
            System.out.println(c);
    }

    void testTreeMapInregistrariContabile(){
        Map<String, Cont> conturi = new HashMap<String, Cont>();
        conturi.put("411.1", new Cont("411.1", "Client Alfa SRL"));
        conturi.put("411.2", new Cont("411.2", "Client Beta SRL"));
        conturi.put("371", new Cont("371", "Marfuri"));
        conturi.put("4427", new Cont("4427", "TVA colectata"));
        conturi.put("4426", new Cont("4426", "TVA deductibila"));

        OperatiuneContabila vinzare = new Vinzare();
        InregistrareDebit debit_1 = new InregistrareDebit(1, conturi.get("411.1"), 118.0);
        InregistrareCredit credit_1 = new InregistrareCredit(1, conturi.get("371"), 100.0);
        InregistrareCredit credit_2 = new InregistrareCredit(1, conturi.get("4427"), 18.0);
        vinzare.addInregistrareContabila(debit_1);
        vinzare.addInregistrareContabila(credit_1);
        vinzare.addInregistrareContabila(credit_2);

        for (InregistrareContabila i : vinzare.getInregistrari()){
            System.out.println(i);
            this.persist(i);
        }
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JContabilitate_02PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            //em.getTransaction().commit();
            em.getTransaction().rollback();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
