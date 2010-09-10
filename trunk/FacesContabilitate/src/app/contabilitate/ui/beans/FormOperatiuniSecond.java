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
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import app.model.contabilitate.InregistrareContabila;
import app.model.contabilitate.OperatiuneContabila;
import app.model.contabilitate.RegistruConturi;
import app.model.contabilitate.RegistruOperatiuni;
import app.model.contabilitate.conturi.Cont;

public class FormOperatiuniSecond implements Converter{
	private RegistruOperatiuni registruOperatiuni;
	private List<OperatiuneContabila> operatiuni = new ArrayList<OperatiuneContabila>();
	private OperatiuneContabila operatiuneContabila;
	private List<Cont> conturi = new ArrayList<Cont>();
	
	public OperatiuneContabila getOperatiuneContabila() {
		return operatiuneContabila;
	}

	public void setOperatiuneContabila(OperatiuneContabila operatiuneContabila) {
		this.operatiuneContabila = operatiuneContabila;
		System.out.println("Operatiune selectata: " + this.operatiuneContabila.getIdOperatiune());
		this.modelGridDetalii.setWrappedData(this.operatiuneContabila.getInregistrari());
	}

	public Map<String, Object> getOperatiuni() {
		Map<String, Object> operatiuniMap = new LinkedHashMap<String, Object>();
		
		for (OperatiuneContabila o: this.operatiuni)
			operatiuniMap.put(o.getIdOperatiune().toString(), o);
		
		return operatiuniMap;
	}

	public Map<String, Object> getConturi() {
		Map<String, Object> conturiMap = new LinkedHashMap<String, Object>();
		
		for (Cont o: this.conturi)
			conturiMap.put(o.getDenumire().toString(), o);
		
		return conturiMap;
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
	
	public FormOperatiuniSecond() {
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
		this.conturi.addAll(this.registruOperatiuni.getConturi());
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
		
		if ("cboCont".equals(uiComponent.getId())){
			for (Cont o: this.conturi){
				if (o.getDenumire().equals(uiValue))
					return o;
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
		
		if ("cboCont".equals(uiComponent.getId())){
			if (value != null)
				return ((Cont)value).getDenumire().toString();
		}
		
		return null;
	}
	//-------------------------------------------------------
	// Suport grid detalii
	private DataModel<InregistrareContabila> modelGridDetalii;
	//private List<InregistrareContabila> inregistrariSelectate = new ArrayList<InregistrareContabila>();
	private InregistrareContabila inregistrareContabila;
	
	public DataModel<InregistrareContabila> getModelGridDetalii() {
		if (modelGridDetalii == null && this.operatiuneContabila != null){
			this.modelGridDetalii = new ListDataModel<InregistrareContabila>();
			this.modelGridDetalii.setWrappedData(this.operatiuneContabila.getInregistrari());
		}
		return modelGridDetalii;
	}

	public void setSelectedInregistrare(ValueChangeEvent event) {
		System.out.println("Inregistrare selectata: ");
		inregistrareContabila = this.modelGridDetalii.getRowData();
		System.out.println(inregistrareContabila.getNrOrdine());
    }
	
	//--------------------------------------------------------
	// Actiuni grid-detalii
	public void stergeInregistrareContabila(ActionEvent evt){
		inregistrareContabila = this.modelGridDetalii.getRowData();
		this.operatiuneContabila.removeInregistrareContabila(inregistrareContabila);
		this.modelGridDetalii.setWrappedData(this.operatiuneContabila.getInregistrari());
	}
	
//  <f:convertDateTime  datestyle="short" />
}
