package app.contabilitate.ui.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectBoolean;
import javax.faces.component.html.HtmlSelectOneRadio;
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
import app.model.contabilitate.InregistrareCredit;
import app.model.contabilitate.InregistrareDebit;
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
		
		for (OperatiuneContabila o: this.operatiuni){
			if (o.getIdOperatiune() == null){
				// operatiune noua
				operatiuniMap.put("Noua", o);
			}else
				operatiuniMap.put(o.getIdOperatiune().toString(), o);
		}
		
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
        
        initFormDataModel();
		
	}
	
	private void initFormDataModel(){
		this.operatiuni.addAll(this.registruOperatiuni.getOperatiuni());
		
		if (!this.operatiuni.isEmpty()){
			Collections.sort(this.operatiuni);
			this.operatiuneContabila = this.operatiuni.get(0);
			
		}
		this.conturi.addAll(this.registruOperatiuni.getConturi());
	}

	//--------------------------------------------------------------------------
	public Object getAsObject(FacesContext arg0, UIComponent uiComponent, String uiValue)
			throws ConverterException {
		
		if ("cboOperatiuni".equals(uiComponent.getId())){
			for (OperatiuneContabila o: this.operatiuni){
				if ("Noua".equals(uiValue)) {
					if (o.getIdOperatiune() == null)
						return o;
					else
						continue;
				}
					

				if (o.getIdOperatiune().equals(Integer.valueOf(uiValue)))
					return o;
			}
		}
		
		if ("txtData".equals(uiComponent.getId())){
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			try {
				return format.parse(uiValue);
			} catch (ParseException e) {
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
			if (value != null){
				if (((OperatiuneContabila)value).getIdOperatiune() == null){
					return "Noua";
				}else
					return ((OperatiuneContabila)value).getIdOperatiune().toString();
			}
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
	// Suport model date - grid detalii
	private DataModel<InregistrareContabila> modelGridDetalii;
	private InregistrareContabila inregistrareContabila;
	
	public DataModel<InregistrareContabila> getModelGridDetalii() {
		if (modelGridDetalii == null && this.operatiuneContabila != null){
			this.modelGridDetalii = new ListDataModel<InregistrareContabila>();
			List<InregistrareContabila> inregistrariLst =  this.operatiuneContabila.getInregistrari();
			Collections.sort(inregistrariLst);
			this.modelGridDetalii.setWrappedData(inregistrariLst);
		}
		return modelGridDetalii;
	}
	
	public Integer getCurrentDetailRow(){
		if (this.inregistrareContabila == null)
			return -1;
		return this.inregistrareContabila.getNrOrdine();
	}
	
	//--------------------------------------------------------
	// Actiuni grid-detalii
	/*
	public void stergeInregistrareContabila(ActionEvent evt){
		inregistrareContabila = this.modelGridDetalii.getRowData();
		this.operatiuneContabila.removeInregistrareContabila(inregistrareContabila);
		this.modelGridDetalii.setWrappedData(this.operatiuneContabila.getInregistrari());
	}
	*/
	public void setSelectedInregistrare(ValueChangeEvent event) {
		/*
		System.out.println("Inregistrare selectata: " + event.getNewValue() + "/" + event.getOldValue());
		
		System.out.println(event.getComponent().getClass() 
				+ "/"+ ((HtmlSelectOneRadio)event.getComponent()).getValue());
		
		for (UIComponent c: ((HtmlSelectOneRadio)event.getComponent()).getChildren()){
			System.out.println("Component class: " + c.getClass());
		}
		*/
		this.inregistrareContabila = this.modelGridDetalii.getRowData();
		System.out.println(inregistrareContabila.getNrOrdine());
    }	
	
	public void selectInregistrareContabila(ActionEvent evt){
		this.inregistrareContabila = this.modelGridDetalii.getRowData();
		System.out.println("Select " + inregistrareContabila.getNrOrdine());		
	}	
	//-------------------------------------------------------
	// Suport actiuni tranzactionale
	// Obs: Actiunile tranz comunica cu registrul si actualizeaza modelul
	// <f:ajax render> actualizeaza (refresh) componentele grafice
	// principiu MVC - de urmat si pentru Swing-based APP 
	public void salveaza(ActionEvent evt){
		// preconditii
		if (this.operatiuneContabila == null)
			return;
		
		// tranzactia cu suportul de persistenta
		this.registruOperatiuni.addOperatiuneContabila(this.operatiuneContabila);
		
		// actualizare model
		this.registruOperatiuni.refreshOperatiune(this.operatiuneContabila);
	}
	public void stergeOperatiune(ActionEvent evt){
		// preconditii
		if (this.operatiuneContabila == null)
			return;
		// tranzactia cu suportul de persistenta
		this.registruOperatiuni.removeOperatiuneContabila(this.operatiuneContabila);
		
		// actualizare model
		this.operatiuni.remove(this.operatiuneContabila);
		this.operatiuneContabila = this.operatiuni.get(0);
		this.modelGridDetalii = null;
		this.inregistrareContabila = null;
		
	}
	public void adaugaOperatiune(ActionEvent evt){
		// preconditii
		// - fara (deocamdata)
		
		// tranzactia cu suportul de persistenta
		// - nu e necesara
		
		// actualizare model
		this.operatiuneContabila = new OperatiuneContabila();
		this.operatiuneContabila.setIdOperatiune(9999);
		this.operatiuneContabila.setDataContabilizare(new Date());
		this.operatiuni.add(this.operatiuneContabila);
		this.modelGridDetalii = null;
		this.inregistrareContabila = null;		
	}
	public void stergeInregistrare(ActionEvent evt){
		// preconditii
		if (this.operatiuneContabila == null)
			return;
		if (this.inregistrareContabila == null)
			return;		
		
		// tranzactia cu suportul de persistenta
		// -- nu e necesar
		
		// actualizare model
		this.operatiuneContabila.removeInregistrareContabila(this.inregistrareContabila);
		this.modelGridDetalii = null;
		this.inregistrareContabila = null;
	
	}
	public void adaugaInregistrare(ActionEvent evt){
		// preconditii
		if (this.operatiuneContabila == null)
			return;	
		
		// tranzactia cu suportul de persistenta
		// -- nu e necesar
		
		// actualizare model
		this.inregistrareContabila = new InregistrareContabila(this.conturi.get(0), 0.0);
		this.operatiuneContabila.addInregistrareContabila(this.inregistrareContabila);
		this.modelGridDetalii = null;
		this.inregistrareContabila = null;
	}
	public void abandon(ActionEvent evt){
		// preconditii
		if (this.operatiuneContabila == null)
			return;		
		
		// tranzactia cu suportul de persistenta
		this.registruOperatiuni.refreshOperatiune(this.operatiuneContabila);
		
		// actualizare model
		this.modelGridDetalii = null;	
		this.inregistrareContabila = null;
		
	}
	
	public void adaugaInregistrareDebit(ActionEvent evt){
		// preconditii
		if (this.operatiuneContabila == null)
			return;	
		
		// tranzactia cu suportul de persistenta
		// -- nu e necesar
		
		// actualizare model
		this.inregistrareContabila = new InregistrareDebit(this.conturi.get(0), 0.0);
		this.operatiuneContabila.addInregistrareContabila(this.inregistrareContabila);
		this.modelGridDetalii = null;
		this.inregistrareContabila = null;
	}	
	public void adaugaInregistrareCredit(ActionEvent evt){
		// preconditii
		if (this.operatiuneContabila == null)
			return;	
		
		// tranzactia cu suportul de persistenta
		// -- nu e necesar
		
		// actualizare model
		this.inregistrareContabila = new InregistrareCredit(this.conturi.get(0), 0.0);
		this.operatiuneContabila.addInregistrareContabila(this.inregistrareContabila);
		this.modelGridDetalii = null;
		this.inregistrareContabila = null;
	}	
	public void previousOperatiune(ActionEvent evt){
		if (this.operatiuni == null)
			return;
		if (this.operatiuni.isEmpty())
			return;
		if (this.operatiuneContabila == null);
			this.operatiuneContabila = this.operatiuni.get(0);
			
		Integer currentIdx = this.operatiuni.indexOf(this.operatiuneContabila);
		if (currentIdx > 0){
			this.operatiuneContabila = this.operatiuni.get(currentIdx - 1);
			this.modelGridDetalii = null;
			this.inregistrareContabila = null;			
		}
	}
	public void nextOperatiune(ActionEvent evt){
		if (this.operatiuni == null)
			return;
		if (this.operatiuni.isEmpty())
			return;
		if (this.operatiuneContabila == null);
			this.operatiuneContabila = this.operatiuni.get(0);
			
		Integer currentIdx = this.operatiuni.indexOf(this.operatiuneContabila);
		
		System.out.println("Current indx: " + currentIdx + "/" + (currentIdx + 1));
		
		if ((currentIdx+1) < this.operatiuni.size()){
			System.out.println("Next indx: " + (currentIdx + 1));
			this.operatiuneContabila = this.operatiuni.get(currentIdx + 1);
			this.modelGridDetalii = null;
			this.inregistrareContabila = null;
		}
	}	
}
	







	//----------------------------------------------------------------------------------------
//  <f:convertDateTime  datestyle="short" />
	//http://balusc.blogspot.com/2006/06/using-datatables.html
	//http://www.ibm.com/developerworks/rational/library/05/1213_he/
	
	/*
	
<link rel="stylesheet" type="text/css" href="./resources/styles/style.css" /> 
<script language="JavaScript" src="./resources/javascript/util.js"></script>

	sau 
	
<link rel="stylesheet" type="text/css" href="/FacesContabilitate/.../style.css" /> 
<script language="JavaScript" src="/FacesContabilitate/.../util.js"></script>

sau

<f:verbatim>  
<script type="text/javascript">  
      
    function onClickHere( )  
    {  
          
    }  
</script>  
</f:verbatim> 
	
	
		            <h:selectOneRadio 
		            	valueChangeListener="#{formOperatiuniSecond.setSelectedInregistrare}"
		            	onclick="dataTableSelectRow(this)">
		                <f:selectItem itemLabel="  " itemValue="0"/>
		                <!-- f:ajax render="txtNrInregCurenta" execute="tblInregistrari"/ -->
		            </h:selectOneRadio>
		            	
	 */
