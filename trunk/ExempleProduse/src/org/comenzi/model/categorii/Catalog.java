package org.comenzi.model.categorii;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import produse.model.Produs;

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
}
