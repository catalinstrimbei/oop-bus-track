package org.comenzi.model;

import java.util.ArrayList;
import java.util.List;

public class TestCategorii1 {

	/**
	 * Se concepe un catalog in care produsele vor fi clasificate in mai multe categorii astfel:
	 * categoria Produse IT va fi impartita in Hardware si software,
	 * categoria Hardware va fi impartita in Calculatoare si Imprimante,
	 * categoria Software va fi impartita in Sisteme de operare si Aplicatii Office.
	 * Produsele vor fi repartizate astfel:
	 * - HP 2001 si Lenovo 5001 vor face parte din categoria Calculatoare,
	 * - Xerox PH201 si Canon 5801 vor face parte din categoria Imprimante
	 * - Windows 7 si Apple OS X vor face parte din categoria sisteme de operare
	 * - MS Office 2007 si MS Office 2010 vor face parte din categoria aplicatii Office
	 * 
	 * Afisati pentru fiecare produs in parte toate categoriile din care fac parte (in ordine ierarhica).
	 */
	public static void main(String[] args) {
		
		Categorie[] categorii = new Categorie[7];
		categorii[0] = new Categorie(1, "Produse IT", null);
		categorii[1] = new Categorie(11, "Hardware", categorii[0]);
		categorii[2] = new Categorie(111, "Calculatoare", categorii[1]);
		categorii[3] = new Categorie(112, "Imprimante", categorii[1]);
		categorii[4] = new Categorie(12, "Software", categorii[0]);
		categorii[5] = new Categorie(121, "Sisteme de operare", categorii[4]);
		categorii[6] = new Categorie(122, "Aplicatii Office", categorii[4]);
		
		Produs[] produse = new Produs[8];
		produse[0] = new Produs(1, "HP 2001", "buc", 1850.0);
		produse[1] = new Produs(2, "Lenovo 5001", "buc", 2220.0);
		produse[2] = new Produs(3, "Xerox PH201", "buc", 850.0);
		produse[3] = new Produs(4, "Canon 5801", "buc", 1050.0);
		produse[4] = new Produs(5, "Windows 7", "buc", 1500.0);
		produse[5] = new Produs(6, "Apple OS X", "buc", 2200.0);
		produse[6] = new Produs(7, "MS Office 2007", "buc", 550.0);
		produse[7] = new Produs(8, "MS Office 2010", "buc", 750.0);
		
		Catalog catalog = new Catalog();
		List<ClasificareProdus> categoriiProduse = new ArrayList<ClasificareProdus>();
		categoriiProduse.add(new ClasificareProdus(produse[0], categorii[2]));
		categoriiProduse.add(new ClasificareProdus(produse[1], categorii[2]));
		categoriiProduse.add(new ClasificareProdus(produse[2], categorii[3]));
		categoriiProduse.add(new ClasificareProdus(produse[3], categorii[3]));
		categoriiProduse.add(new ClasificareProdus(produse[4], categorii[5]));
		categoriiProduse.add(new ClasificareProdus(produse[5], categorii[5]));
		categoriiProduse.add(new ClasificareProdus(produse[6], categorii[5]));
		categoriiProduse.add(new ClasificareProdus(produse[7], categorii[6]));
		catalog.setCategoriiProduse(categoriiProduse);
		
		for(Produs produs: produse){
			System.out.println();
			System.out.print("--> Produs: " + produs.getDenumire() + " - categorii: ");
			for (Categorie categorie: catalog.getCategoriiDupaProdus(produs))
				System.out.print(categorie.getDenumire() + "/");
		}
	}

}
