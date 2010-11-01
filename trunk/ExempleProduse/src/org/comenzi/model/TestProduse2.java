package org.comenzi.model;

import java.util.List;

public class TestProduse2 {

	public static void main(String[] args) {
		
		Produs[] produse = new Produs[2];
		
		produse[0] = new ProdusFinit(1, "Computer", "Buc", 1550.0, 12, "Pachet sigilat", 6);
		produse[1] = new Serviciu(2, "Conexiune Internet", "GB", 20.5, 12, "Consum real");
		
		for(Produs p: produse)
			System.out.println(p.getDenumire());
		
	}
}
