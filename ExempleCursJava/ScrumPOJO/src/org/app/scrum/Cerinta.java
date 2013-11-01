package org.app.scrum;


//public interface Cerinta
//public abstract class Cerinta

public class Cerinta {
	private Integer idCerinta;
	private String denumire;
	private String descriere;
	private CategorieCerinta categorie;
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
	public Cerinta(Integer idCerinta, String denumire, String descriere,
			CategorieCerinta categorie) {
		super();
		this.idCerinta = idCerinta;
		this.denumire = denumire;
		this.descriere = descriere;
		this.categorie = categorie;
	}
	public Cerinta() {
		super();
	}
	
	
	
}

enum CategorieCerinta{
	FUNCTIONALA, TEHNICA;
}

interface ICategorieCerinta{
	public final static Integer FUNCTIONALA = 1;
	public final static Integer TEHNICA = 2;
}
