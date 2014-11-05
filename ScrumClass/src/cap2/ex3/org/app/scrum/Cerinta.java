package cap2.ex3.org.app.scrum;

import java.util.ArrayList;
import java.util.List;

public class Cerinta{
	protected Integer idCerinta;
	protected String denumire;
	protected String descriere;
	protected CategorieCerinta categorie;
	
	private List<Task> taskuri = new ArrayList<>();
	
	/*------------------------------------------*/
	public Cerinta() {
		
	}
	public Cerinta(Integer idCerinta, String denumire, String descriere) {
		super();
		this.idCerinta = idCerinta;
		this.denumire = denumire;
		this.descriere = descriere;
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
	public List<Task> getTaskuri() {
		return taskuri;
	}
	public void setTaskuri(List<Task> taskuri) {
		this.taskuri = taskuri;
	}
	public CategorieCerinta getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieCerinta categorie) {
		this.categorie = categorie;
	}
	
	/*------------------------------------------*/
	
	
}
