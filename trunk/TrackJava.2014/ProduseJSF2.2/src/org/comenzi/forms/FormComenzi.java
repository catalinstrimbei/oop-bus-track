package org.comenzi.forms;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.comenzi.model.ArticolComanda;
import org.comenzi.model.Comanda;
import org.comenzi.model.Produs;

public class FormComenzi implements Converter{
	// ... ... ... //	
	public void adaugaArticol(ActionEvent evt){
		// Trebuie determinata o secventa temporara pentru idul articolului
		ArticolComanda articolNou = new ArticolComanda(null, this.produse.get(0), 0.0);
		this.comanda.getArticole().add(articolNou);
		articolNou.setComanda(this.comanda);
	}
	
	public void stergeArticol(ActionEvent evt){
		Integer selectedId = Integer.valueOf(evt.getComponent().getAttributes().get("selectedId").toString());
		ArticolComanda articolSablon = new ArticolComanda();
		articolSablon.setId(selectedId);
		this.comanda.getArticole().remove(articolSablon);
	}	
	
	// Modelul de date
	private List<Comanda> comenzi = new ArrayList<Comanda>();
	private Comanda comanda;
	private List<Produs> produse = new ArrayList<Produs>();
	
	public List<Comanda> getComenziList() {
		return comenzi;
	}
	public Map<String, Comanda> getComenzi(){
		Map<String, Comanda> comenziMap = new HashMap<String, Comanda>();
		for (Comanda c: this.comenzi)
			comenziMap.put(c.getId().toString(), c);
		return comenziMap;
	}
	public Comanda getComanda() {
		return comanda;
	}
	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
	public List<Produs> getProduseList() {
		return produse;
	}
	public Map<String, Produs> getProduse(){
		Map<String, Produs> produseMap = new HashMap<String, Produs>();
		for (Produs p: this.produse)
			produseMap.put(p.getDenumire().toString(), p);
		return produseMap;
	}	
	
	
	// Actiuni tranzactionale
	public void adaugareComanda(ActionEvent evt){
		Comanda comandaNoua = new Comanda(999, new Date());
		this.comenzi.add(comandaNoua);
		this.comanda = comandaNoua;
	}
	
	public void stergereComanda(ActionEvent evt){
		if (this.em.contains(this.comanda)){
			this.em.getTransaction().begin();
			this.em.remove(this.comanda);
			this.em.getTransaction().commit();
			this.comenzi.remove(this.comanda);
		}
		if (this.comenzi.size() > 0)
			this.comanda = this.comenzi.get(0);
		else
			this.comanda = null;
	}
	
	public void salvareComanda(ActionEvent evt){
		System.out.println("Salvare");
		try{
			this.em.getTransaction().begin();
			this.em.merge(this.comanda);
			this.em.getTransaction().commit();
		}catch(Exception ex){
			// Cocepere mesaj
			FacesMessage facesMsg = 
		            new FacesMessage(FacesMessage.SEVERITY_ERROR, "EROARE SALVARE: " + ex.getMessage(), null);			
			FacesContext fc = FacesContext.getCurrentInstance();
			
			// Anulare
			if (this.em.getTransaction().isActive()){
				this.em.getTransaction().rollback();
				System.out.println("Tranzactie anulata!");
			}
			
			// Afisare mesaj
			fc.addMessage(null, facesMsg);
			fc.renderResponse();
		}
	}
	
	public void abandon(ActionEvent evt){
		if (this.em.contains(this.comanda)){
			this.em.getTransaction().begin();
			this.em.refresh(this.comanda);
			this.em.getTransaction().commit();
		}else{
			//if (this.comenzi.size() > 0)
			//	this.comanda = this.comenzi.get(0);
			initComenzi();
		}
	}
	
	private void initComenzi() {
		this.comenzi = em.createQuery("SELECT o FROM Comanda o").getResultList();
		if (!this.comenzi.isEmpty()){
			this.comanda = this.comenzi.get(0);
		}else{
			adaugareComanda(null);
		}	
	}


	// Conversii model pentru interfata grafica
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComponent, String uiValue)
			throws ConverterException {
		
		if (uiComponent.getId().equals("cboComenzi")){
			Comanda comandaSablon = new Comanda(Integer.valueOf(uiValue), null);
			return this.comenzi.get(this.comenzi.indexOf(comandaSablon));
		}

		if (uiComponent.getId().equals("cboProdus")){
			Produs produsSablon = new Produs();
			produsSablon.setCod(Integer.valueOf(uiValue));
			return this.produse.get(this.produse.indexOf(produsSablon));
		}
		
		return null;
	}
	
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComponent, Object modelObject)
			throws ConverterException {
		if (uiComponent.getId().equals("cboComenzi")){
			return ((Comanda)modelObject).getId().toString();
		}
		if (uiComponent.getId().equals("cboProdus")){
			if (modelObject != null)
				return ((Produs)modelObject).getCod().toString();
		}
		return null;
	}

	// Initializare model
	private EntityManager em;
	public FormComenzi() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProduseJPA");
		em = emf.createEntityManager();
		
		this.comenzi = em.createQuery("SELECT o FROM Comanda o").getResultList();
		if (!this.comenzi.isEmpty()){
			this.comanda = this.comenzi.get(0);
		}else{
			adaugareComanda(null);
		}
		
		this.produse = em.createQuery("SELECT o FROM Produs o").getResultList();
		
		System.out.println("FormComenzi inited !");
	}

	public void previousComanda(ActionEvent evt){
		Integer idxCurent = this.comenzi.indexOf(this.comanda);
		if (idxCurent - 1 >= 0)
			this.comanda = this.comenzi.get(idxCurent - 1);
	}
	
	public void nextComanda(ActionEvent evt){
		Integer idxCurent = this.comenzi.indexOf(this.comanda);
		if (idxCurent + 1 < this.comenzi.size())
			this.comanda = this.comenzi.get(idxCurent + 1);
	}
	
	
	public String afiseazaClienti(){
		/*
		FormClienti formClienti = (FormClienti) FacesContext.getCurrentInstance().
			getApplication().getELResolver().getValue(
				FacesContext.getCurrentInstance().getELContext(), 
				null, 
				"formClienti");
		*/
		/*
		FormClienti formClienti = (FormClienti) FacesContext.getCurrentInstance().getExternalContext().
			getSessionMap().get("formClienti");
		if (formClienti == null){
			formClienti = new FormClienti();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("formClienti", formClienti);
		}
		*/
		FormClienti formClienti = FacesContext.getCurrentInstance().getApplication()
        	.evaluateExpressionGet(FacesContext.getCurrentInstance(), "#{formClienti}", FormClienti.class);
		formClienti.setClient(this.comanda.getClient());
		return "FormClienti";
	}
}

/*
- Daca se modifica doar proiectul JSF - serverul Tomcat nu trebuie restartat! (daca param facelets.REFRESH_PERIOD este 1)
Adauga in web.xml
	<context-param>
	    <param-name>facelets.DEVELOPMENT</param-name>
	    <param-value>true</param-value>
	</context-param>
- Lansarea formularului prima oara
		se poate face 
			prin apelarea caii implicite direct in browser, de ex http://localhost:8080/ProduseJSF/faces/FormComenzi.xhtml
			sau prin executarea fisierului Form.xhtml cu Run-Run on server
- Refacerea formularului (lansat anterior)
		se poate face printr-un refresh in browser (care inca afiseaza formularul din cache...)
			daca in setarile eclipse ale serverului politica de Publishing este Auto
		se poate face prin "re-xecutarea" (re-run) a formularului
			daca in setarile eclipse ale serverului politica de Publishing este Never publish auto
	
- Daca se modifica JPA - serverul Tomcat trebuie restartat!
 */

/*

<!-- JSF 2: use pages named .xhtml instead of .jsp. -->
	<context-param>
	   <param-name>javax.faces.DEFAULT_SUFFIX</param-name>
	   <param-value>.xhtml</param-value>
	</context-param>
	<context-param>
	    <param-name>javax.faces.FACELETS_REFRESH_PERIOD</param-name>
	    <param-value>1</param-value>
	</context-param>
	<context-param>
	    <param-name>facelets.REFRESH_PERIOD</param-name>
	    <param-value>1</param-value>
	</context-param>
	<context-param>
	    <param-name>facelets.DEVELOPMENT</param-name>
	    <param-value>true</param-value>
	</context-param>
	
*/


