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
	private Map<String, Object> conturi = null;
	
	public FormConturi() {
        // creare entity manager
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("EntitatiContabilitate");
        EntityManager em = emf.createEntityManager();
        
        // initializare registru
        registruConturi = new RegistruConturi(em);
        
        // initializare conturi
        conturi = new LinkedHashMap<String, Object>();
        List<Cont> lstConturi = new ArrayList<Cont>(registruConturi.getConturi());
        if (lstConturi != null && !lstConturi.isEmpty()){
        	// initializare cont curent implicit
        	this.cont = lstConturi.get(0);
	        for (Cont c : lstConturi){
	        	conturi.put(c.getDenumire(), c);
	        	//System.out.println("Load Cont: " + c.getDenumire());
	        }
        }
	}
	
	
	public Map<String, Object> getConturi() {
		//System.out.println("Get conturi - count " + this.conturi.size());
		return this.conturi;
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
		return this.conturi.get(uiValue);
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value)
			throws ConverterException {
		// TODO: tb tratat cazul cind value este null
		return ((Cont)value).getDenumire();
	}	
	
	//------------------------------------------
	// Rol-Controller: actiuni formular
	
	// Actiuni de navigare
	public void previousClient(ActionEvent evt){
		System.out.println("Action previous");
		
		List<Cont> contList = new ArrayList(this.conturi.values());
		int currentIdx = contList.indexOf(this.cont);
		
		if (currentIdx > 0)
			this.cont = contList.get(currentIdx - 1);
	}
	
	public void nextClient(ActionEvent evt){
		System.out.println("Action next");
		
		List<Cont> contList = new ArrayList(this.conturi.values());
		int currentIdx = contList.indexOf(this.cont);
		
		if ((currentIdx + 1) < contList.size())
			this.cont = contList.get(currentIdx + 1);
		
	}
	
	// Actiuni tranzactionale
	
	//---------------------------------------------
	// TODO: rubrica cboSubClasaConturi - legare la sursa de date (fieldul formConturi.cont.subClasaConturi) si sincronizare
}