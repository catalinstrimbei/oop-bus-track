package org.comenzi.model;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
	private Integer id;
	private String denumire;
	private Categorie categorieParinte;
	
	public Categorie() {
	}

	public Categorie(Integer id, String denumire, Categorie categorieParinte) {
		this.id = id;
		this.denumire = denumire;
		this.categorieParinte = categorieParinte;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Categorie getCategorieParinte() {
		return categorieParinte;
	}
	public void setCategorieParinte(Categorie categorieParinte) {
		this.categorieParinte = categorieParinte;
	}
	
	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorie other = (Categorie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public List<Categorie> getSuperCategorii(){
		
		List<Categorie> superCategorii = new ArrayList<Categorie>();
		Categorie parinte = this.categorieParinte;
		
		if(parinte != null ){
			superCategorii.add(parinte);
			superCategorii.addAll(
					parinte.getSuperCategorii()
			);
		}
		
		return superCategorii;
	}	
	
}
