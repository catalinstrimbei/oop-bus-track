package org.app.scrum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ProiectBuilder implements EntityFactory{
	public Proiect buildProiect(Integer idProiect, String denumire, Integer nrReleases){
		Proiect proiect = new Proiect(idProiect, denumire, new Date());
		List<Release> releasesProiect = new ArrayList<>();
		
		Date dataPublicare = new Date();
		Long interval =  30l /*zile*/ * 24 /*ore*/ * 60 /*min*/ * 60 /*sec*/ * 1000 /*milisec*/;
		
		for (int i=1; i<=nrReleases; i++){
			releasesProiect.add(new Release(i, "R:" + i, 
					new Date(dataPublicare.getTime() + i * interval), proiect));
		}
		
		proiect.setReleases(releasesProiect);
		
		return proiect;
	}
}
