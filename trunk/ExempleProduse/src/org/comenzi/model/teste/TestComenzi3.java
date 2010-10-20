package org.comenzi.model.teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import produse.model.ArticolComanda;
import produse.model.Comanda;
import produse.model.Produs;

public class TestComenzi3 {
	/**
	 * Se face o comanda pentru un calculator in valoare de 1850 si doua imprimante in valoare de 450 fiecare.
	 * Care este valoare totala a comenzii ?
	 */
	public static void main(String[] args) {
		// Se face o comanda
		Comanda comanda = new Comanda(1, new Date());
		// un calculator in valoare de 1850
		comanda.adauga(new Produs(1, "Calculator", "buc", 1850.0), 1.0);
		// doua imprimante in valoare de 450 fiecare
		comanda.adauga(new Produs(2, "Imprimanta", "buc", 450.0), 2.0);
		// Care este valoare totala a comenzii ?
		System.out.println(comanda.getValoareComanda());
	}
}
