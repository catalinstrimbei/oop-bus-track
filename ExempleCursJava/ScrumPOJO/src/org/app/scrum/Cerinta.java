package org.app.scrum;

import java.util.ArrayList;
import java.util.List;

import org.app.scrum.sprint.Task;
import org.app.scrum.team.Membru;


public abstract class Cerinta 
implements ICerinta, Comparable<Cerinta>
{
	protected Integer idCerinta;
	private String denumire;
	private String descriere;
//	private ECategorieCerinta categorie;
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

	public Cerinta(Integer idCerinta, String denumire, String descriere) {
		super();
		this.idCerinta = idCerinta;
		this.denumire = denumire;
		this.descriere = descriere;
	}
	
	public enum ECategorieCerinta {
		FUNCTIONALA, TEHNICA;
	}

	@Override
	public String toString() {
		return "Cerinta [idCerinta=" + idCerinta + ", denumire=" + denumire
				+ ", descriere=" + descriere + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result
				+ ((idCerinta == null) ? 0 : idCerinta.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
//		if (getClass() != obj.getClass())
//			return false;
		Cerinta other = (Cerinta) obj;
		if (categorie != other.categorie)
			return false;
		if (idCerinta == null) {
			if (other.idCerinta != null)
				return false;
		} else if (!idCerinta.equals(other.idCerinta))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Cerinta other) {
		if (this.equals(other))
			return 0;
		return this.getDenumire().compareTo(other.getDenumire());
	}	
		
	
	
}
