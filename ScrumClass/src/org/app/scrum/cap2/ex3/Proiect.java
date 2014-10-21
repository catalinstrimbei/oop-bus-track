package org.app.scrum.cap2.ex3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proiect implements IProiect {
	private Integer nrProiect;	
	private String numeProiect;
	private Date dataStart;
	
	private List<Release> releases = new ArrayList<>();
	
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
	
	/*------------------------------------------*/
	public Integer getReleaseCount(){
		return this.releases.size();
	}

	@Override
	public Integer getNrProiect() {
		return nrProiect;
	}

	@Override
	public void setNrProiect(Integer nrProiect) {
		if (nrProiect > 0)
			this.nrProiect = nrProiect;
		// else return exception
	}

	@Override
	public String getNumeProiect() {
		return numeProiect;
	}

	@Override
	public void setNumeProiect(String numeProiect) {
		this.numeProiect = numeProiect;
	}

	@Override
	public Date getDataStart() {
		return dataStart;
	}

	@Override
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}

	@Override
	public List<Release> getReleases() {
		return releases;
	}

	@Override
	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}
	
	/*------------------------------------------*/
	
	
}
