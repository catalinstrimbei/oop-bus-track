package org.comenzi.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



/*
 * Problema manipulare ierarhii cu subiecti
 * - modalitate stocare relatii subiect- elem. ierarhie (Map)
 * - modalitate reprezentare ierarhie elem.comp.-elem.comp.parinte recursiv
 * - operatii pentru
 * 	- interpretare ierarhie pornind de la subiect
 * 		- return categorii (de la subiect)
 * 		- return subiect (de la categorie frunza sau parinte)
 * 	- interpretare navigare in ierarhie:
 * 		- return categorii parinte (de la sub-categorie)
 * 		- return sub categorii (de la categorie parinte)
 */
public class Catalog {
	private Integer id;
	private List<ClasificareProdus> categoriiProduse = new ArrayList<ClasificareProdus>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<ClasificareProdus> getCategoriiProduse() {
		return categoriiProduse;
	}
	public void setCategoriiProduse(List<ClasificareProdus> categoriiProduse) {
		this.categoriiProduse = categoriiProduse;
	}
	public Catalog(Integer id, List<ClasificareProdus> categoriiProduse) {
		super();
		this.id = id;
		this.categoriiProduse = categoriiProduse;
	}
	public Catalog() {
		super();
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
		Catalog other = (Catalog) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public List<Categorie> getCategoriiDupaProdus(Produs produs){
		List<Categorie> categorii = new ArrayList<Categorie>();
		
		for (ClasificareProdus c: this.categoriiProduse){
			if (produs.equals(c.getProdus())){
				categorii.addAll(c.getCategorie().getSuperCategorii());
			}
		}
		
		return categorii;
	}
	
	
	/*

	public List<Categorie> getSuperCategorii(Categorie categorie){
		
		List<Categorie> superCategorii = new ArrayList<Categorie>();
		Categorie parinte = categorie.getCategorieParinte();
		
		if(parinte != null ){
			superCategorii.add(parinte);
			superCategorii.addAll(getSuperCategorii(categorie.getCategorieParinte()));
		}
		
		return superCategorii;
	}	
	
	private Map<Produs, Categorie> produseInCategorii = new HashMap<Produs, Categorie>();
	
	public void addProdusCategorie(Produs produs, Categorie categorie){
		produseInCategorii.put(produs, categorie);
	}
	
	List<Produs> getProduseDinCategorie(Categorie categorie){
		if (produseInCategorii.isEmpty())
			return null;
		
		List<Categorie> categorii = new ArrayList<Categorie>();
		
		return null;
	}
	
	public Set<Categorie> getCategoriiProdus(Produs produs){
		if (produseInCategorii.isEmpty())
			return null;
		
		Categorie categorie = produseInCategorii.get(produs);
		if (categorie == null)
			return null;
		
		Set<Categorie> categorii = new HashSet<Categorie>();
		categorii.add(categorie);
		Set<Categorie> categoriiParinte = getCategoriiParinte(categorie);
		if (categoriiParinte != null)
			categorii.addAll(categoriiParinte);
		
		return categorii;
	}
	
	public Set<Categorie> getCategoriiParinte(Categorie categorie){
		if (produseInCategorii.isEmpty())
			return null;

		Set<Categorie> categorii = new HashSet<Categorie>();
		while(categorie.getCategorieParinte() != null){
			categorie = categorie.getCategorieParinte();
			categorii.add(categorie);
		}
		
		if (categorii.isEmpty())
			return null;
		
		return categorii;
		
	}
	
	// tema pentru acasa ?
	public Set<Categorie> getSubCategorii(Categorie categorie){
		if (produseInCategorii.isEmpty())
			return null;		

		Set<Categorie> categoriiFrunza = getCategoriiFrunze();
		Set<Categorie> subCategorii = new HashSet<Categorie>();
		
		Set<Categorie> categoriiParinte = new HashSet<Categorie>();
		for(Categorie c: categoriiFrunza){
			categoriiParinte = getCategoriiParinte(c);
			
			if (categoriiParinte != null && categoriiParinte.contains(categorie)){
				subCategorii.add(c);
				categoriiParinte.remove(categorie);
				categoriiParinte.removeAll(getCategoriiParinte(categorie));
				subCategorii.addAll(categoriiParinte);
			}
			
		}
		
		return subCategorii;
		
	}
	
	public Set<Categorie> getCategoriiFrunze(){
		if (produseInCategorii.isEmpty())
			return null;		
		
		Collection<Categorie> categoriiFrunzeCuDuplicate = this.produseInCategorii.values();
		Set<Categorie> categorii = new HashSet<Categorie>();
		
		for (Categorie c: categoriiFrunzeCuDuplicate)
			categorii.add(c);
		
		return categorii;
		
	}
	
	public Boolean verificaProdusInCategorie(Produs produs, Categorie categorie){
		Set<Categorie> categorii = getCategoriiProdus(produs);
		
		if (categorii != null && !categorii.isEmpty())
			return true;
		
		return false;
	}
	*/
}
