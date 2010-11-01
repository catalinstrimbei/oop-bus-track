package org.comenzi.model;

import java.util.ArrayList;
import java.util.List;

public class TestCategorii1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Categorie[] categorii = new Categorie[5];
		categorii[0] = new Categorie(1, "Produse IT", null);
		categorii[1] = new Categorie(11, "Hardware", categorii[0]);
		categorii[2] = new Categorie(111, "Calculatoare", categorii[1]);
		categorii[3] = new Categorie(112, "Imprimante", categorii[1]);
		categorii[4] = new Categorie(1121, "ImprimanteLaser", categorii[3]);
		
		//Catalog catalog = new Catalog();
		
		//List<Categorie> superCategorii = catalog.getSuperCategorii(categorii[3]);
		List<Categorie> superCategorii = categorii[4].getSuperCategorii();
		for (Categorie c: superCategorii)
			System.out.println(c.getDenumire());

	}

}
