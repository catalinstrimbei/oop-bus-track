package org.app.scrum.test;

import org.app.scrum.Proiect;
import org.app.scrum.validare.ExceptieValidare;

public class Test51_ScrumValidare {

	public static void main(String[] args) {
		try{
			Proiect p1 = new Proiect(50001, "Proiect 50001");
		}catch(ExceptieValidare ex){
			System.out.println("EROARE VALIDARE: " + ex.getMessage());
		}
		
		try{
			Proiect p2 = new Proiect(2, "proiect 2");
		}catch(ExceptieValidare ex){
			System.out.println("EROARE VALIDARE: " + ex.getMessage());
		}
		
		try{
			Proiect p3 = new Proiect(3, "Proiect 3");
			p3.isValid();
		}catch(ExceptieValidare ex){
			System.out.println("EROARE VALIDARE: " + ex.getMessage());
		}

	}

}
