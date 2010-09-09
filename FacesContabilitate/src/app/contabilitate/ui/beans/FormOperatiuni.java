package app.contabilitate.ui.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import app.model.contabilitate.OperatiuneContabila;
import app.model.contabilitate.RegistruConturi;
import app.model.contabilitate.RegistruOperatiuni;
import app.model.contabilitate.conturi.Cont;

public class FormOperatiuni implements Converter{
	private RegistruOperatiuni registruOperatiuni;
	private List<OperatiuneContabila> operatiuni = new ArrayList<OperatiuneContabila>();
	private OperatiuneContabila operatiuneContabila;
	
	public OperatiuneContabila getOperatiuneContabila() {
		return operatiuneContabila;
	}

	public void setOperatiuneContabila(OperatiuneContabila operatiuneContabila) {
		this.operatiuneContabila = operatiuneContabila;
		System.out.println("Operatiune selectata: " + this.operatiuneContabila);
	}

	public Map<String, Object> getOperatiuni() {
		Map<String, Object> operatiuniMap = new LinkedHashMap<String, Object>();
		
		for (OperatiuneContabila o: this.operatiuni)
			operatiuniMap.put(o.getIdOperatiune().toString(), o);
		
		return operatiuniMap;
	}

	public Integer getOperatiuniCount(){
		if (this.operatiuni == null)
			return -1;
		return this.operatiuni.size();
	}
	
	public Integer getInregistrariCount(){
		if (this.operatiuni == null)
			return -1;
		if (this.operatiuneContabila.getInregistrari() == null)
			return -1;
		
		System.out.println("getInregistrariCount = " + this.operatiuneContabila.getInregistrari().size());
		
		return this.operatiuneContabila.getInregistrari().size();
	}
	
	public FormOperatiuni() {
        // creare entity manager
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("EntitatiContabilitate");
        EntityManager em = emf.createEntityManager();
        
        // initializare registru
        registruOperatiuni = new RegistruOperatiuni(em);
        
        initFormModel();
		
	}
	
	private void initFormModel(){
		this.operatiuni.addAll(this.registruOperatiuni.getOperatiuni());
		if (!this.operatiuni.isEmpty())
			this.operatiuneContabila = this.operatiuni.get(0);
	}

	//--------------------------------------------------------------------------
	public Object getAsObject(FacesContext arg0, UIComponent uiComponent, String uiValue)
			throws ConverterException {
		
		System.out.println("Component id " + uiComponent.getId());
		
		if ("cboOperatiuni".equals(uiComponent.getId())){
			for (OperatiuneContabila o: this.operatiuni){
				if (o.getIdOperatiune().equals(Integer.valueOf(uiValue)))
					return o;
			}
		}
		
		if ("txtData".equals(uiComponent.getId())){
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			try {
				return format.parse(uiValue);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	public String getAsString(FacesContext arg0, UIComponent uiComponent, Object value)
			throws ConverterException {
		if ("cboOperatiuni".equals(uiComponent.getId())){
			if (value != null)
				return ((OperatiuneContabila)value).getIdOperatiune().toString();
		}
		
		if ("txtData".equals(uiComponent.getId())){
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			return format.format(value);
		}
		
		
		return null;
	}

}
