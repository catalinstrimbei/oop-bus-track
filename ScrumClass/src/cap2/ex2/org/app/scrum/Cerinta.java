package cap2.ex2.org.app.scrum;

import java.util.ArrayList;
import java.util.List;

public class Cerinta{
	private Integer idCerinta;
	private String denumire;
	private String descriere;
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
	/*------------------------------------------*/
	
	
}
