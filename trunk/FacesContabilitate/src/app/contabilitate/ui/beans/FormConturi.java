package app.contabilitate.ui.beans;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import app.model.contabilitate.RegistruConturi;
import app.model.contabilitate.conturi.Cont;

//@ManagedBean
//@SessionScoped
public class FormConturi {
	
	private RegistruConturi registruConturi;
	private List<Cont> conturi;
	private Cont cont = null;
	private Map<String, Object> conturiSE = null;
	
	public FormConturi() {
        // creare entity manager
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("EntitatiContabilitate");
        EntityManager em = emf.createEntityManager();
        // initializare registru
        registruConturi = new RegistruConturi(em);
        this.conturi = new ArrayList<Cont>(registruConturi.getConturi());
        
        // initializare conturi
        if (this.conturi != null && !this.conturi.isEmpty()){
        	this.cont = this.conturi.get(0);
        	this.selectedCont = this.cont;
        }
        
        // initializare conturi
        conturiSE = new LinkedHashMap<String, Object>();
        for (Cont c : this.conturi){
        	conturiSE.put(c.getDenumire(), c);
        }
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
	
	public Map<String, Object> getConturiSE(){
		return this.conturiSE;
	}
	
	//------------------------------------
	private Cont selectedCont;

	public Cont getSelectedCont() {
		System.out.println("Get Selected: " + this.selectedCont.getDenumire());
		return selectedCont;
	}

	public void setSelectedCont(Cont selectedCont) {
		this.selectedCont = selectedCont;
		System.out.println("Selected: " + this.selectedCont.getDenumire());
	}
	
	
}
