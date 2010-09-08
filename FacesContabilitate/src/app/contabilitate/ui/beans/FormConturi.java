package app.contabilitate.ui.beans;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import app.model.contabilitate.RegistruConturi;
import app.model.contabilitate.conturi.Cont;

//@ManagedBean
//@SessionScoped
public class FormConturi implements Converter{
	
	private RegistruConturi registruConturi;
	private Cont cont = null;
	//private Map<String, Object> conturi = null;
	private List<Cont> conturi = new ArrayList<Cont>();
	
	public FormConturi() {
        // creare entity manager
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("EntitatiContabilitate");
        EntityManager em = emf.createEntityManager();
        
        // initializare registru
        registruConturi = new RegistruConturi(em);
        
        // initializare conturi
        /*conturi = new LinkedHashMap<String, Object>();
        List<Cont> lstConturi = new ArrayList<Cont>(registruConturi.getConturi());
        if (lstConturi != null && !lstConturi.isEmpty()){
        	// initializare cont curent implicit
        	this.cont = lstConturi.get(0);
	        for (Cont c : lstConturi){
	        	conturi.put(c.getDenumire(), c);
	        	//System.out.println("Load Cont: " + c.getDenumire());
	        }
        }*/
        initForm();
	}
	private void initForm(){
        this.conturi = new ArrayList<Cont>(registruConturi.getConturi());
        if (this.conturi != null && !this.conturi.isEmpty()){
        	// initializare cont curent implicit
        	this.cont = this.conturi.get(0);
        }		
	}
	
	public Map<String, Object> getConturi() {
		//System.out.println("Get conturi - count " + this.conturi.size());
		//return this.conturi;
		Map<String, Object> conturiMap = new LinkedHashMap<String, Object>();
		if (this.conturi != null && !this.conturi.isEmpty()){
	        for (Cont c : this.conturi){
	        	conturiMap.put(c.getDenumire(), c);
	        }
        }		
		return conturiMap;
	}

	public Integer getConturiCount(){
		return conturi.size();
	}	
	
	
	public Cont getCont() {
		return cont;
	}

	public void setCont(Cont cont) {
		this.cont = cont;
		System.out.println("Selected: " + this.cont.getDenumire());
	}	
	
	//---------------------------------------
	// Converter pt cboClienti - componenta de navigare
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String uiValue)
			throws ConverterException {
		//return this.conturi.get(uiValue);
		for (Cont c: this.conturi){
			if (uiValue.equals(c.getDenumire()))
				return c;
		}
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value)
			throws ConverterException {
		// TODO: tb tratat cazul cind value este null
		return ((Cont)value).getDenumire();
	}	
	
	//------------------------------------------
	// Rol-Controller: actiuni formular
	
	// Actiuni de navigare
	public void previousCont(ActionEvent evt){
		System.out.println("Action previous");
		
		/*List<Cont> contList = new ArrayList(this.conturi.values());
		int currentIdx = contList.indexOf(this.cont);
		
		if (currentIdx > 0)
			this.cont = contList.get(currentIdx - 1);*/
		
		int currentIdx = this.conturi.indexOf(this.cont);
		if (currentIdx > 0)
			this.cont = this.conturi.get(currentIdx - 1);
		
	}
	
	public void nextCont(ActionEvent evt){
		System.out.println("Action next");
		/*
		List<Cont> contList = new ArrayList(this.conturi.values());
		int currentIdx = contList.indexOf(this.cont);
		
		if ((currentIdx + 1) < contList.size())
			this.cont = contList.get(currentIdx + 1);
		*/
		int currentIdx = this.conturi.indexOf(this.cont);
		
		if ((currentIdx + 1) < this.conturi.size())
			this.cont = this.conturi.get(currentIdx + 1);		
		
	}
	
	// Actiuni tranzactionale
	// 1. Adaugare
	public void adaugaCont(ActionEvent evt){
        this.cont = new Cont();
        this.cont.setCod("999.999");
        this.cont.setDenumire("Cont nou 999.999");
        //this.conturi.put(this.cont.getDenumire(), this.cont);
        this.conturi.add(this.cont);
	}
	// 2. Salvare
	public void salvare(ActionEvent evt){
		this.registruConturi.addCont(this.cont);
	}
	// 3. Stergere
	public void stergere(ActionEvent evt){
		this.conturi.remove(this.cont);
		this.registruConturi.removeCont(this.cont);
        if (!this.conturi.isEmpty()){
        	// re-initializare cont curent implicit
        	this.cont = this.conturi.get(0);
        }
	}
	// 3. Abandon
	public void abandon(ActionEvent evt){
		/*int currentIdx = this.conturi.indexOf(this.cont);
		initForm();
		if (!this.conturi.isEmpty() && currentIdx > 0 && this.conturi.size() > currentIdx)
			this.cont = this.conturi.get(currentIdx);*/
		//this.cont = this.registruConturi.getCont(this.cont.getCod());
		System.out.println("Abandon before: " + this.cont.getDenumire());
		this.registruConturi.refreshCont(this.cont);
		System.out.println("Abandon after: " + this.cont.getDenumire());
		
	}
	//---------------------------------------------
	// TODO: rubrica cboSubClasaConturi - legare la sursa de date (fieldul formConturi.cont.subClasaConturi) si sincronizare
}