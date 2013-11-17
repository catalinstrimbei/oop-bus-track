package org.app.scrum.sprint;

import java.util.ArrayList;
import java.util.List;

import org.app.scrum.ICerinta;


public class Cerinta 
//implements ICerinta
{
	protected Integer idCerinta;
	private String denumire;
	private String descriere;
	private ECategorieCerinta categorie;
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
	public ECategorieCerinta getCategorie() {
		return categorie;
	}
	public void setCategorie(ECategorieCerinta categorie) {
		this.categorie = categorie;
	}

	public Cerinta() {
		super();
	}

	
	
	public Cerinta(Integer idCerinta, String denumire, String descriere) {
		super();
		this.idCerinta = idCerinta;
		this.denumire = denumire;
		this.descriere = descriere;
	}



	public enum ECategorieCerinta {
		FUNCTIONALA, TEHNICA;
	}
	
}
