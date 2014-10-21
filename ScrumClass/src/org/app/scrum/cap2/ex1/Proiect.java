package org.app.scrum.cap2.ex1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proiect {
	Integer nrProiect;	
	String numeProiect;
	Date dataStart;
	
	List<Release> releases = new ArrayList<>();
	
	/*------------------------------------------*/
	public Proiect() {
		
	}

	public Proiect(Integer nrProiect, String numeProiect, Date dataStart,
			List<Release> releases) {
		this.nrProiect = nrProiect;
		this.numeProiect = numeProiect;
		this.dataStart = dataStart;
		this.releases = releases;
	}
	
	public Proiect(Integer nrProiect, String numeProiect, Date dataStart) {
		this.nrProiect = nrProiect;
		this.numeProiect = numeProiect;
		this.dataStart = dataStart;
	}	
	
}
