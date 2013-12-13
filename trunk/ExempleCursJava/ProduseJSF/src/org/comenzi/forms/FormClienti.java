package org.comenzi.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.el.ELContext;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.comenzi.model.Client;

public class FormClienti implements Converter
//, Validator 
{
	private List<Client> clienti = new ArrayList<Client>();
	private Client client;
	private EntityManager em;

	/*
	 * public List<Client> getClienti() { return clienti; } public void
	 * setClienti(List<Client> clienti) { this.clienti = clienti; }
	 */

	/* Implementare suport pentru navigare-selectie lista combinata */
	public Map<String, Client> getClienti() {
		Map<String, Client> mapClienti = new HashMap<String, Client>();
		for (Client c : clienti) {
			mapClienti.put(c.getNume(), c);
		}
		return mapClienti;
	}

	public List<Client> getClientiList() {
		return this.clienti;
	}

	@Override
	// operatie invocata la selectie din lista, dar inainte de setClient
	public Object getAsObject(FacesContext arg0, UIComponent uic, String uiValue)
			throws ConverterException {
		Client uiClientTemplate = new Client(Integer.valueOf(uiValue), null);
		int idx = this.clienti.indexOf(uiClientTemplate);
		return this.clienti.get(idx);
	}

	@Override
	// operatie invocata la generare elemente pentru lista,
	// dupa getClienti, dar inainte de popularea listei
	public String getAsString(FacesContext arg0, UIComponent uic, Object uiValue)
			throws ConverterException {
		Client uiClient = (Client) uiValue;
		return uiClient.getId().toString();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		System.out.println("Client set!");
		this.client = client;
	}

	public FormClienti() {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ProduseJPA");
		em = emf.createEntityManager();
		
		init();
		
	}

	/* Implementare navigare */
	public void previousClient(ActionEvent evt) {
		Integer idxCurent = this.clienti.indexOf(client);
		if (idxCurent > 0)
			this.client = this.clienti.get(idxCurent - 1);
	}

	public void nextClient(ActionEvent evt) {
		Integer idxCurent = this.clienti.indexOf(client);
		if ((idxCurent + 1) < this.clienti.size())
			this.client = this.clienti.get(idxCurent + 1);
		
		System.out.println(getBeanPropStringValue("formClienti.client.nume", String.class));
		UIComponent uiComponent = evt.getComponent();
		System.out.println("uiComponent.id: " + uiComponent.getId() + "-" + uiComponent.getClientId());
		System.out.println("uiComponent.id: nume"  + "- " + getUIComponentValue("nume"));
		System.out.println("uiInput.id: nume"  + "- new value" + getUIInputValue("nume"));
		System.out.println("uiInput.id: nume"  + "- old value" + getUIInputOldValue("nume"));
		
	}


	public void selectClient(ActionEvent evt) {
		System.out.println("Curent client ... " + this.client.getNume());
		System.out.println("SelectedId ... "
				+ evt.getComponent().getAttributes().get("selectedId"));
		Integer selectedId = Integer.valueOf(evt.getComponent().getAttributes()
				.get("selectedId").toString());
		Integer selectedIdx = this.clienti
				.indexOf(new Client(selectedId, null));
		this.client = this.clienti.get(selectedIdx);
	}

	public void radioSelectClient(AjaxBehaviorEvent evt) {
		System.out.println("Curent client (R) ... " + this.client.getNume());
		// value="#{(formClienti.client.id == clientRow.id) ? 'selected' : ''}"
		// rowClasses="#{(formClienti.client.id == clientRow.id) ? rowHighlighted : rowSimple"
		System.out.println("RadioSelectedId ... "
				+ evt.getComponent().getAttributes().get("selectedId"));
		Integer selectedId = Integer.valueOf(evt.getComponent().getAttributes()
				.get("selectedId").toString());
		Integer selectedIdx = this.clienti
				.indexOf(new Client(selectedId, null));
		this.client = this.clienti.get(selectedIdx);
		System.out.println("Selected client ... " + this.client.getNume());
	}

	public String getSelected() {
		return "selected";
	}

	public void setSelected(String value) {

	}

	/* Implementare operatii CRUD */
	public void adaugareClient(ActionEvent evt) {
		this.client = new Client();
		this.client.setId(999);
		this.client.setNume("Client Nou");
		this.clienti.add(this.client);
	}

	public void stergereClient(ActionEvent evt) {
		this.clienti.remove(this.client);
		if (this.em.contains(this.client)) {
			this.em.getTransaction().begin();
			this.em.remove(this.client);
			this.em.getTransaction().commit();
		}

		if (!this.clienti.isEmpty())
			this.client = this.clienti.get(0);
		else
			this.client = null;
	}

	public void salvareClient(ActionEvent evt) {
		System.out.println("Salvare");
		try{
			this.em.getTransaction().begin();
			this.em.merge(this.client);
			this.em.getTransaction().commit();
		}catch(Exception ex){
			this.ridicaEroare(ex.getMessage(), true);
		}
	}

	public void abandonClient(ActionEvent evt) {
		System.out.println("Abandon client !");
		init();
//		FacesContext.getCurrentInstance().renderResponse();
	}
	
	private void init(){
		System.out.println("Init !");
		this.clienti = em.createQuery("SELECT c FROM Client c ORDER BY c.id")
				.getResultList();
		if (!clienti.isEmpty()){
			this.setClient(clienti.get(0));
			System.out.println("Nume client: " + client.getNume());
		}
	}

	//@Override
	public void validate(FacesContext arg0, UIComponent uiComponent, Object uiValue)
			throws ValidatorException {
		if ("nume".equals(uiComponent.getId())){
			System.out.println("Validare nume client");
			String nume = uiValue.toString();
			FacesMessage mesaj = null;
			if (nume == null || nume.isEmpty()){
				mesaj = new FacesMessage("Numele clientului trebuie completat!");
			}
			System.out.println("Nume: " + nume + ": " + nume.substring(0, 1));
			if (!nume.substring(0,1).equals(nume.substring(0, 1).toUpperCase())){
				mesaj = new FacesMessage("Numele clientului trebuie scris cu majuscula!");
			}
			
			if (mesaj != null){
				throw new ValidatorException(mesaj);
			}
		}
		
	}

	/* Faces Logic - procesare erori business*/
	private void ridicaEroare(String mesaj, Boolean anulareTranzactie){
		// Cocepere mesaj
		FacesMessage facesMsg = 
	            new FacesMessage(FacesMessage.SEVERITY_ERROR, "EROARE SALVARE: " + mesaj, null);			
		FacesContext fc = FacesContext.getCurrentInstance();
		
		// Anulare tranzactie
		if (anulareTranzactie && this.em.getTransaction().isActive()){
			this.em.getTransaction().rollback();
			System.out.println("Tranzactie anulata!");
		}
		
		// Afisare mesaj
		fc.addMessage(null, facesMsg);
		fc.renderResponse();
		
	}
	
	
	/* Faces Logic - interpretare stare managed-beans*/
	
	/* Faces Logic - interpretare UI Tree*/
	public Object getItemValue(String itemID) {
		FacesContext context = FacesContext.getCurrentInstance();
		UIViewRoot view = context.getViewRoot();
		String viewId = view.getViewId();
		System.out.println("viewId = " + viewId);

		return null;
	}

	public Object getBeanPropStringValue(String beanPropName,
			Class beanPropClass) {
		return getValue("#{sessionScope." + beanPropName + "}", beanPropClass);
	}

	// read bean values
	protected static final Object getValue(String elExpression, Class classType) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Application app = fc.getApplication();
		Object obj = null;
		try {
			obj = app.evaluateExpressionGet(fc, elExpression, Object.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classType.cast(obj);
	}

	protected static final void setValue(String elKey, Object value) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Application app = fc.getApplication();
		ELContext elCtx = fc.getELContext();
		try {
			app.getExpressionFactory()
					.createValueExpression(fc.getELContext(), elKey,
							Object.class).setValue(elCtx, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//
	protected static final Object getUIComponentValue(String uiComponentID) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Application app = fc.getApplication();
		ELContext elCtx = fc.getELContext();
		
		UIComponent uiComponent = findComponentInRoot(uiComponentID);
		System.out.println("Founded: " + uiComponent.getId());
		
		return uiComponent.getValueExpression("value").getValue(elCtx);
	}

	protected static final Object getUIInputValue(String uiComponentID) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Application app = fc.getApplication();
		ELContext elCtx = fc.getELContext();
		
		UIComponent uiComponent = findComponentInRoot(uiComponentID);
		System.out.println("Founded: " + uiComponent.getId());
		if (uiComponent instanceof UIInput)
			return ((UIInput)uiComponent).getValue();
		else
			return "NON UIInput conform";
	}	

	private Object getUIInputOldValue(String uiComponentID) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Application app = fc.getApplication();
		ELContext elCtx = fc.getELContext();
		
		UIComponent uiComponent = findComponentInRoot(uiComponentID);
		System.out.println("Founded: " + uiComponent.getId());
		if (uiComponent instanceof UIInput)
			return ((UIInput)uiComponent).getSubmittedValue();
		else
			return "NON UIInput conform";
	}
	
	public static UIComponent findComponentInRoot(String id) {
		UIComponent component = null;

		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (facesContext != null) {
			UIComponent root = facesContext.getViewRoot();
			component = findComponent(root, id);
		}

		return component;
	}

	public static UIComponent findComponent(UIComponent base, String id) {
		if (id.equals(base.getId()))
			return base;

		UIComponent kid = null;
		UIComponent result = null;
		Iterator<UIComponent> kids = base.getFacetsAndChildren();
		while (kids.hasNext() && (result == null)) {
			kid = kids.next();
			if (id.equals(kid.getId())) {
				result = kid;
				break;
			}
			result = findComponent(kid, id);
			if (result != null) {
				break;
			}
		}
		return result;
	}
}