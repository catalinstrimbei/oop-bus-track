/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model.contabilitate;

import app.model.contabilitate.conturi.ClasaConturi;
import app.model.contabilitate.conturi.Cont;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.EntityManager;

/**
 *
 * @author catalin
 */

// Registrul ar putea fi el insusi o tranzactie ? 
/*
	begin tranzactie in constructor
	commit in sincronizare urmat de re-begin
	rollback in sincronizare-refresh si descarcare-finalize
*/
public class RegistruConturi {
    private EntityManager entityManager;
    private String sqlDefaultText = "SELECT o FROM Cont o";

    public RegistruConturi(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Set<Cont> getConturi() {
        List<Cont> result = this.entityManager
                .createQuery(this.sqlDefaultText)
                .getResultList();

        TreeSet<Cont> conturiOrdonate = new TreeSet<Cont>();
        conturiOrdonate.addAll(result);

        return conturiOrdonate;
    }

    public Set<ClasaConturi> getClaseConturi() {
        List<ClasaConturi> result = this.entityManager
                .createQuery("SELECT c FROM ClasaConturi c")
                .getResultList();

        TreeSet<ClasaConturi> clase = new TreeSet<ClasaConturi>();
        clase.addAll(result);

        return clase;
    }    
    
    public void addCont(Cont cont){
        if (this.entityManager.contains(cont))
            this.entityManager.merge(cont);
        else
            this.entityManager.persist(cont);

        synchronize();
    }

    public void removeCont(Cont cont){
        if (!this.entityManager.contains(cont))
            return;
        this.entityManager.remove(cont);
        synchronize();
    }

    public Cont getCont(String codCont){
        //return this.entityManager.find(Cont.class, codCont);
    	Cont c = this.entityManager.find(Cont.class, codCont);
    	this.entityManager.refresh(c);
    	return c;
    }

    public void refreshCont(Cont cont){
    	this.entityManager.refresh(cont);
    }
    
    public Cont getContDupaDenumire(String denumire){
        return (Cont) this.entityManager
                .createQuery(sqlDefaultText + " WHERE o.denumire = :denumire")
                .setParameter("denumire", denumire)
                .getSingleResult();
    }

    public List<Cont> getConturiDupaClasa(ClasaConturi clasa){
        List<Cont> result = this.entityManager
                .createQuery(this.sqlDefaultText + " WHERE o.subClasaCont = :clasa")
                .setParameter("clasa", clasa)
                .getResultList();
        return result;
    }

    public List<Cont> getSubConturi(Cont cont){
        List<Cont> result = this.entityManager
                .createQuery(this.sqlDefaultText + " WHERE o.contParinte = :cont")
                .setParameter("cont", cont)
                .getResultList();
        return result;
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

	public Long getCountClase() {
        return (Long) this.entityManager
        .createQuery("SELECT COUNT(c) FROM ClasaConturi c WHERE c.clasaParinte is null")
        .getSingleResult();
	}
	
	public Long getCountSubClase(Integer codClasa) {
		
        return (Long) this.entityManager
        .createQuery("SELECT COUNT(c) FROM ClasaConturi c WHERE c.clasaParinte.cod = :codClasa")
        .setParameter("codClasa", codClasa.toString())
        .getSingleResult();
	}
	
	public Long getCountConturi(Integer codSubClasa) {
        return (Long) this.entityManager
        .createQuery("SELECT COUNT(c) FROM Cont c WHERE c.subClasaCont.cod = :codSubClasa")
        .setParameter("codSubClasa", codSubClasa.toString())
        .getSingleResult();
	}	
}
