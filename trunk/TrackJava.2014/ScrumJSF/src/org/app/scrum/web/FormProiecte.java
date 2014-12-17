package org.app.scrum.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.app.scrum.Proiect;

public class FormProiecte {
	private List<Proiect> proiecte = new ArrayList<>();
	private Proiect proiect = null;
	private EntityManager em;
	
	public FormProiecte() {
		super();
		init();
	}
	
	private void init(){
		System.out.println("DEBUG START FORM ...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ScrumJPA");
		em = emf.createEntityManager();
		
		List<Proiect> lst = em.createQuery("SELECT p FROM Proiect p ORDER BY p.nrProiect").getResultList();
		proiecte.addAll(lst);
		System.out.println("DEBUG: proiecte.size - " + proiecte.size());
		
		if (lst != null){
			this.proiect = proiecte.get(0);
			System.out.println("DEBUG: proiect init - " + proiect.getNrProiect());
			
		}
	}
	
	public Proiect getProiect() {
		return proiect;
	}
	
	public void setProiect(Proiect proiect) {
		this.proiect = proiect;
	}
	public List<Proiect> getProiecte() {
		return proiecte;
	}	
	
	public Integer getNrProiect(){
		System.out.println("DEBUG getNrProiect: " + this.proiect.getNrProiect());
		return this.proiect.getNrProiect();
	}
	
	public void setNrProiect(Integer nrProiect){
		System.out.println("DEBUG getNrProiect: " + nrProiect);
		Integer idx = this.proiecte.indexOf(new Proiect(nrProiect, null, null));
		this.proiect = this.proiecte.get(idx);
	}
	
	// pentru selectie din grid
	public void selectProiect(ActionEvent evt){
		Integer selectedId = Integer.valueOf(evt.getComponent().getAttributes().get("selectedId").toString());
		this.setNrProiect(selectedId);
	}
}
