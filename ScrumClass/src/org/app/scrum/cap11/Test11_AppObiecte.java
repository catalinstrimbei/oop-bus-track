package org.app.scrum.cap11;

import java.util.Date;

/* Obtinere obiecte */
public class Test11_AppObiecte {

	public static void main(String[] args) {
		Proiect p = new Proiect();
		p.nrProiect = 1;
		p.numeProiect = "SRUM Agile App";
		p.dataStart = new Date();
		
		Release r1 = new Release();
		r1.idRelease = 1;
		r1.numeCod = "START";
		r1.indicativ = "0.0.1";
		
		Release r2 = new Release();
		r2.idRelease = 2;
		r2.numeCod = "FURTHER";
		r2.indicativ = "0.0.2";
		
		p.releases.add(r1);
		p.releases.add(r2);
		
		System.out.println(p.numeProiect + " are " + p.releases.size() + " planificate.");
		
	}

}
