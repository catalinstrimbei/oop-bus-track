/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model.contabilitate;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.EntityManager;

public class RegistruOperatiuni {
    private EntityManager entityManager;
    private String sqlDefaultText = "SELECT o FROM OperatiuneContabila o";

    private ComparatorOperatiuneContabila comparator = new ComparatorOperatiuneContabila();

    public RegistruOperatiuni(EntityManager em) {
        this.entityManager = em;
    }

    public Set<OperatiuneContabila> getOperatiuni() {
        List<OperatiuneContabila> result = this.entityManager
                .createQuery(this.sqlDefaultText)
                .getResultList();

        TreeSet<OperatiuneContabila> operatiuniOrdonate = new TreeSet<OperatiuneContabila>();
        operatiuniOrdonate.addAll(result);

        return operatiuniOrdonate;
    }
    
    public void addOperatiuneContabila(OperatiuneContabila operatiune){
        if (this.entityManager.contains(operatiune))
            this.entityManager.merge(operatiune);
        else
            this.entityManager.persist(operatiune);

        synchronize();
    }

    public void removeOperatiuneContabila(OperatiuneContabila cont){
        if (!this.entityManager.contains(cont))
            return;
        this.entityManager.remove(cont);
        synchronize();
    }

    public OperatiuneContabila getOperatiuneContabila(Integer codOperatiuneContabila){
        return this.entityManager.find(OperatiuneContabila.class, codOperatiuneContabila);
    }

    private class ComparatorOperatiuneContabila implements Comparator<OperatiuneContabila> {

        public int compare(OperatiuneContabila o1, OperatiuneContabila o2) {
            if (o1.getDataContabilizare().before(o2.getDataContabilizare()))
                return -1;
            else if (o1.getDataContabilizare().after(o2.getDataContabilizare()))
                return 1;
            else
                return 1;
        }

    }

    private void synchronize(){
        // sincronizare cu baza de date
        entityManager.getTransaction().begin();
        try {
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
