package produse.teste;

import java.util.ArrayList;
import java.util.List;

import produse.model.Produs;

public class TestProduse1 {
	public static void main(String[] args) {
		List<Produs> produse = new ArrayList<Produs>(10);
		produse.add(new Produs(1, "P1", "buc", 10.0));
		produse.add(new Produs(2, "P2", "buc", 12.0));
		produse.add(new Produs(3, "P3", "buc", 15.0));
		
		for(Produs p: produse){
			System.out.println(p);
		}
		
	}
}
