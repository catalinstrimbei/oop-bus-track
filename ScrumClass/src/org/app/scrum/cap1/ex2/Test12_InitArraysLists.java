package org.app.scrum.cap1.ex2;

import java.util.ArrayList;

/* Aplicatii cu obiecte */
public class Test12_InitArraysLists {

	public static void main(String[] args) {
		exempluInitializareArrayProiecte();
		exempluArrayListProiecte();
		exempluInitializareArrayProiecte2();
	}
	
	static void exempluInitializareArrayProiecte(){
		// initializare tablou
		Proiect[] proiecte = new Proiect[4];
		
		proiecte[0] = new Proiect();
		proiecte[0].nrProiect = 1;
		proiecte[0].numeProiect = "SRUM Proiect 1";		
		
		proiecte[1] = new Proiect();
		proiecte[1].nrProiect = 2;
		proiecte[1].numeProiect = "SRUM Proiect 2";		
		
		proiecte[2] = new Proiect();
		proiecte[2].nrProiect = 3;
		proiecte[2].numeProiect = "SRUM Proiect 3";		

		proiecte[3] = new Proiect();
		proiecte[3].nrProiect = 4;
		proiecte[3].numeProiect = "SRUM Proiect 4";		
		
		// prelucrare tablou
		for(int i=0; i < proiecte.length; i++)
			System.out.println("Proiect nr: " + proiecte[i].nrProiect);
		
		for(Proiect p: proiecte)
			System.out.println("Proiect nume: " + p.numeProiect);
	}
	
	static void exempluInitializareArrayProiecte2(){
		// initializare tablou
		Proiect[] proiecte = {new Proiect(), new Proiect(), new Proiect(), new Proiect()};
		
		proiecte[0].nrProiect = 1;
		proiecte[0].numeProiect = "SRUM Proiect 1";		
		
		proiecte[1].nrProiect = 2;
		proiecte[1].numeProiect = "SRUM Proiect 2";		
		
		proiecte[2].nrProiect = 3;
		proiecte[2].numeProiect = "SRUM Proiect 3";		

		proiecte[3].nrProiect = 4;
		proiecte[3].numeProiect = "SRUM Proiect 4";		
		
		// prelucrare tablou
		for(int i=0; i < proiecte.length; i++)
			System.out.println("Proiect nr: " + proiecte[i].nrProiect);
		
		for(Proiect p: proiecte)
			System.out.println("Proiect nume: " + p.numeProiect);
	}	
	
	static void exempluArrayListProiecte(){
		// initializare tablou
		ArrayList<Proiect> proiecte = new ArrayList<>();
		
		Proiect proiect = new Proiect(); 
		proiect.nrProiect = 1;
		proiect.numeProiect = "SRUM Proiect 1";
		proiecte.add(proiect);
		
		proiecte.add(new Proiect());
		proiecte.get(1).nrProiect = 2;
		proiecte.get(1).numeProiect = "SRUM Proiect 2";		
		
		proiecte.add(new Proiect());
		proiecte.get(2).nrProiect = 3;
		proiecte.get(2).numeProiect = "SRUM Proiect 3";		

		proiecte.add(new Proiect());
		proiecte.get(3).nrProiect = 4;
		proiecte.get(3).numeProiect = "SRUM Proiect 4";		
		
		// prelucrare tablou
		for(int i=0; i < proiecte.size(); i++)
			System.out.println("Proiect nr: " + proiecte.get(i).nrProiect);
		
		for(Proiect p: proiecte)
			System.out.println("Proiect nume: " + p.numeProiect);
	}	
}
