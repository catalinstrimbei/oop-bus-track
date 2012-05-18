package org.comenzi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestComenzi2 {

	/**
	 * P1. Se lanseaza o campanie de promovare in care
	 * pentru calculatoare, cu pret standard 1850: la cel putin 5 calculatoare achizitionate 1 este gratuit,
	 * pentru imprimante, cu pret standard 450: la cel putin 6 imprimante achizitionate 2 sunt gratuite.
	 * Se face o comanda de 10 calculatoare si 8 imprimante. Se cere valoare cu discount a comenzii.
	 * 
	 * P2. Se lanseaza o campanie de promovare in care
	 * pentru calculatoare, cu pret standard 1850: la o valoare de cel putin 3000 se da o reducere de 20 procente,
	 * pentru imprimante, cu pret standard 450: la o valoare de cel putin 2000 se da o reducere de 33 procente.
	 * Se face o comanda de 10 calculatoare si 8 imprimante. Se cere valoare cu discount a comenzii. 
	 */
	public static void main(String[] args) {
		// produse
		Produs[] produse = new Produs[2];
		produse[0] = new Produs(1, "Calculator", "buc", 1850.0);
		produse[1] = new Produs(2, "Imprimanta", "buc", 450.0);
		
		// comanda
		Comanda comanda = new Comanda(1, new Date());
		
		List<ArticolComanda> articole = new ArrayList<ArticolComanda>();
		articole.add(new ArticolComanda(1, produse[0], 10.0));
		articole.add(new ArticolComanda(2, produse[1], 8.0));
		
		comanda.setArticole(articole);
		
		System.out.println("Valoare comanda: " + comanda.getValoareComanda());

		// reduceri promotii
		List<Promotie> promotiiCantitate = new ArrayList<Promotie>();
		promotiiCantitate.add(new PromotieCantitate(1, produse[0], 5, 1));
		promotiiCantitate.add(new PromotieCantitate(2, produse[1], 6, 2));
		CampaniePromotionala c1 = new CampaniePromotionala(1, promotiiCantitate);
		
		System.out.println("Valoare cu discount cantitate: " + c1.getValoareComandaCuDiscount(comanda));
		
		
		List<Promotie> promotiiValoare = new ArrayList<Promotie>();
		promotiiValoare.add(new PromotieValoare(3, produse[0], 3000.0, 20.0));
		promotiiValoare.add(new PromotieValoare(4, produse[1], 2000.0, 33.0));
		CampaniePromotionala c2 = new CampaniePromotionala(2, promotiiValoare);
		
		System.out.println("Valoare cu discount valoare: " + c2.getValoareComandaCuDiscount(comanda));
		
		
	}

}
