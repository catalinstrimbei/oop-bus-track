package org.comenzi.model;

import java.util.List;

public class TestProduse1 {

	public static void main(String[] args) {
		
		Produs[] produse = new Produs[5];
		
		produse[0] = new ProdusFinit(1, "Computer", "Buc", 1550.0, 12, "Pachet sigilat", 6);
		produse[1] = new Serviciu(2, "Conexiune Internet", "GB", 20.5, 12, "Consum real");
		produse[2] = new Semifabricat(3, "SF 001", "kg", 20.5, "Pre-finalizat");
		produse[3] = new ProdusFinit(4, "Imprimanta", "Buc", 1550.0, 12, "Pachet sigilat", 6);
		produse[4] = new Serviciu(5, "Comunicatii eMail si mesagerie interna", "1000 Mesaje", 0.50, 36, "Abonament");
		
		for(Produs p: produse)
			System.out.println(p.getDenumire());
		
	}
}