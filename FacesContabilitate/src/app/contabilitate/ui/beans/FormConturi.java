package app.contabilitate.ui.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import app.model.contabilitate.RegistruConturi;
import app.model.contabilitate.conturi.Cont;

@ManagedBean
@SessionScoped
public class FormConturi {
	
	private RegistruConturi registruConturi;
	private List<Cont> conturi;
	private Cont cont = null;

	public FormConturi() {
        // creare entity manager
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("EntitatiContabilitate");
        EntityManager em = emf.createEntityManager();
        // initializare registru
        registruConturi = new RegistruConturi(em);
        this.conturi = new ArrayList<Cont>(registruConturi.getConturi());
        
        if (this.conturi != null && !this.conturi.isEmpty())
        	this.cont = this.conturi.get(0);
	}
	
	public List<Cont> getConturi() {
		return conturi;
	}
	
	/*
	public void setConturi(List<Cont> conturi) {
		this.conturi = conturi;
	}
	*/

	public Integer getConturiCount(){
		return conturi.size();
	}	
	
	
	public Cont getCont() {
		return cont;
	}

	public void setCont(Cont cont) {
		this.cont = cont;
	}	
}
