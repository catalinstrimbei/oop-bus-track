package org.app.scrum.cap21;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Release {
	Integer idRelease;
	String numeCod;
	String indicativ; // vers 1.1
	String descriere;
	Date dataPublicare;
	
	List<Cerinta> cerinte = new ArrayList<>();
	
	/*------------------------------------------*/
	public Release() {
		
	}

	public Release(Integer idRelease, String numeCod, String indicativ,
			String descriere, Date dataPublicare, List<Cerinta> cerinte) {
		super();
		this.idRelease = idRelease;
		this.numeCod = numeCod;
		this.indicativ = indicativ;
		this.descriere = descriere;
		this.dataPublicare = dataPublicare;
		this.cerinte = cerinte;
	}

	public Release(Integer idRelease, String numeCod, String indicativ) {
		super();
		this.idRelease = idRelease;
		this.numeCod = numeCod;
		this.indicativ = indicativ;
	}
	
}
