package produse.teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import produse.model.ArticolComanda;
import produse.model.Comanda;
import produse.model.Produs;

public class TestComenzi2 {
	/**
	 * Se face o comanda pentru un calculator in valoare de 1850 si doua imprimante in valoare de 450 fiecare.
	 * Care este valoare totala a comenzii ?
	 */
	public static void main(String[] args) {
		Produs[] produse = new Produs[2];
		produse[0] = new Produs(1, "Calculator", "buc", 1850.0);
		produse[1] = new Produs(2, "Imprimanta", "buc", 450.0);
		
		Comanda comanda = new Comanda(1, new Date());
		comanda.adauga(produse[0], 1.0);
		comanda.adauga(produse[1], 2.0);
		
		System.out.println(comanda.getValoareComanda());
	}
}