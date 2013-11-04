package org.app.scrum;

import java.util.Date;

public class Test3_IncapsulareOperatii {
	
	public static void main(String[] args) {
		// Clasa Sprint: implementare operatie private getDurataEstimata()		
		// Clasa Sprint: implementare proprietate dataFinalizare prin op. publica getDataFinalizare()
		
		// Instantiere Sprint
		// Adaugare task1
		// Adaugare task12
		
		// Access proprietate (get)dataFinalizare
		
		
		Date d1 = new Date();
		Long interval1 = 4l * 60 * 60 * 1000;
		
		Long df = d1.getTime() + interval1;
		
		Date d2 = new Date();
		d2.setTime(df);
		
		System.out.println(d1);
		System.out.println(d2);
		
		
		
	}
}
