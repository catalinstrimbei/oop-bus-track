/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model.contabilitate;

import app.model.contabilitate.conturi.ClasaConturi;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.EntityManager;

/**
 *
 * @author catalin.strimbei
 */
public class RegistruClaseConturi {
    private EntityManager entityManager;
    private String sqlDefaultText = "SELECT o FROM Cont o";

    public RegistruClaseConturi(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Set<ClasaConturi> getConturi() {
        List<ClasaConturi> result = this.entityManager
                .createQuery(this.sqlDefaultText)
                .getResultList();

        TreeSet<ClasaConturi> conturiOrdonate = new TreeSet<ClasaConturi>();
        conturiOrdonate.addAll(result);

        return conturiOrdonate;
    }

    public void addClasaConturi(ClasaConturi clasaConturi){
        if (this.entityManager.contains(clasaConturi))
            this.entityManager.merge(clasaConturi);
        else
            this.entityManager.persist(clasaConturi);

        synchronize();
    }

    public void removeClasaConturi(ClasaConturi clasaConturi){
        if (!this.entityManager.contains(clasaConturi))
            return;
        this.entityManager.remove(clasaConturi);
        synchronize();
    }

    public ClasaConturi getClasaConturi(Integer codClasaConturi){
        return this.entityManager.find(ClasaConturi.class, codClasaConturi);
    }

    public ClasaConturi getClasaConturiDupaDenumire(String denumire){
        return (ClasaConturi) this.entityManager
                .createQuery(sqlDefaultText + " WHERE o.denumire = :denumire")
                .setParameter("denumire", denumire)
                .getSingleResult();
    }

    /*public List<ClasaConturi> getConturiDupaClasa(ClasaConturi clasa){
        List<ClasaConturi> result = this.entityManager
                .createQuery(this.sqlDefaultText + " WHERE o.subClasaCont = :clasa")
                .setParameter("clasa", clasa)
                .getResultList();
        return result;
    }

    public List<ClasaConturi> getSubConturi(Cont ClasaConturi){
        List<ClasaConturi> result = this.entityManager
                .createQuery(this.sqlDefaultText + " WHERE o.contParinte = :cont")
                .setParameter("cont", cont)
                .getResultList();
        return result;
    }*/

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
