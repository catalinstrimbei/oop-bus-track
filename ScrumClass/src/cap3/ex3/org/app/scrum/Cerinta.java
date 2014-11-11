package cap3.ex3.org.app.scrum;

import java.util.ArrayList;
import java.util.List;


public abstract class Cerinta {
	
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
	
	public void adaugaTask(Task t){
		this.taskuri.add(t);
	}
}
