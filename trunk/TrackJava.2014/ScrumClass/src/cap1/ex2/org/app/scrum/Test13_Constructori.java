package cap1.ex2.org.app.scrum;

import java.util.ArrayList;

public class Test13_Constructori {

	public static void main(String[] args) {
		exempluInitializareArrayProiecte();
		exempluArrayListProiecte();
		exempluInitializareArrayProiecte2();
	}
	
	static void exempluInitializareArrayProiecte(){
		// initializare tablou
		Proiect[] proiecte = new Proiect[4];
		
		proiecte[0] = new Proiect(1, "SRUM Proiect 1");
		
		proiecte[1] = new Proiect(2, "SRUM Proiect 2");
		
		proiecte[2] = new Proiect(3, "SRUM Proiect 3");

		proiecte[3] = new Proiect(4, "SRUM Proiect 4");
		
		// prelucrare tablou
		for(int i=0; i < proiecte.length; i++)
			System.out.println("Proiect nr: " + proiecte[i].nrProiect);
		
		for(Proiect p: proiecte)
			System.out.println("Proiect nume: " + p.numeProiect);
	}
	
	static void exempluInitializareArrayProiecte2(){
		// initializare tablou
		Proiect[] proiecte = {new Proiect(), new Proiect(), new Proiect(), new Proiect()};
		
		proiecte[0] = new Proiect(1, "SRUM Proiect 1");
		
		proiecte[1] = new Proiect(2, "SRUM Proiect 2");
		
		proiecte[2] = new Proiect(3, "SRUM Proiect 3");

		proiecte[3] = new Proiect(4, "SRUM Proiect 4");
		
		// prelucrare tablou
		for(int i=0; i < proiecte.length; i++)
			System.out.println("Proiect nr: " + proiecte[i].nrProiect);
		
		for(Proiect p: proiecte)
			System.out.println("Proiect nume: " + p.numeProiect);
	}	
	
	static void exempluArrayListProiecte(){
		// initializare tablou
		ArrayList<Proiect> proiecte = new ArrayList<>();
		
		Proiect proiect = new Proiect(1, "SRUM Proiect 1"); 
		proiecte.add(proiect);
		
		proiecte.add(new Proiect());
		proiecte.get(1).nrProiect = 2;
		proiecte.get(1).numeProiect = "SRUM Proiect 2";		
		
		proiecte.add(new Proiect(3, "SRUM Proiect 3"));

		proiecte.add(new Proiect(4, "SRUM Proiect 4"));
		
		// prelucrare tablou
		for(int i=0; i < proiecte.size(); i++)
			System.out.println("Proiect nr: " + proiecte.get(i).nrProiect);
		
		for(Proiect p: proiecte)
			System.out.println("Proiect nume: " + p.numeProiect);
	}	
}
