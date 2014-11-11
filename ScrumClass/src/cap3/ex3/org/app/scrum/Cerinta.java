package cap3.ex3.org.app.scrum;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public abstract class Cerinta implements BurnDownItem{
	
	protected Integer idCerinta;
	protected String denumire;
	protected String descriere;
	protected CategorieCerinta categorie;
	private List<Task> taskuri = new ArrayList<>();
	
	public List<Task> getTaskuri() {
		return taskuri;
	}
	public void setTaskuri(List<Task> taskuri) {
		this.taskuri = taskuri;
	}
	public Integer getIdCerinta() {
		return idCerinta;
	}
	public void setIdCerinta(Integer idCerinta) {
		this.idCerinta = idCerinta;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public CategorieCerinta getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieCerinta categorie) {
		this.categorie = categorie;
	}

	public Cerinta() {
		super();
	}

	public Cerinta(Integer idCerinta, String denumire) {
		super();
		this.idCerinta = idCerinta;
		this.denumire = denumire;
	}	
	
	public Cerinta(Integer idCerinta, String denumire, String descriere) {
		this(idCerinta, denumire);
		this.descriere = descriere;
	}
	
	public Cerinta(Integer idCerinta, String denumire, String descriere,
			CategorieCerinta categorie) {
		this(idCerinta, denumire, descriere);
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "Cerinta [idCerinta=" + idCerinta + ", denumire=" + denumire
				+ ", descriere=" + descriere + ", categorie=" + categorie + "]";
	}	
	
	// operatie abstracta
	public abstract String getDescriereCompleta();
	
	// implements BurnDownItem
	@Override
	public Map<Date, Integer> getBurnDownRecords() {
		Map<Date, Integer> burnDownRecords = new HashMap<>();
		Set<Date> recordDates = burnDownRecords.keySet();
		Map<Date, Integer> taskBurnDownRecords = null;
		for(Task t: this.taskuri){
			taskBurnDownRecords= t.getBurnDownRecords();
			for(Date d: taskBurnDownRecords.keySet()){
				if(!recordDates.contains(d))
					burnDownRecords.put(d, 0);
				burnDownRecords.put(d, burnDownRecords.get(d) + taskBurnDownRecords.get(d));
			}
		}
		return burnDownRecords;
	}
	@Override
	public Integer getTimpEstimat() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer getTimpRamas() {
		// TODO Auto-generated method stub
		return null;
	}	
}
