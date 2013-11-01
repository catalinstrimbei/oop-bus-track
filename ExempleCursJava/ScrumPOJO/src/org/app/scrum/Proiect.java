package org.app.scrum;

import java.util.Date;

public class Proiect {
	private Integer nrProiect;
	private String numeProiect;
	private Date dataStart;
	private String releaseCurent;
	
	
	public Integer getNrProiect() {
		return nrProiect;
	}
	public void setNrProiect(Integer nrProiect) {
		this.nrProiect = nrProiect;
	}
	public String getNumeProiect() {
		return numeProiect;
	}
	public void setNumeProiect(String numeProiect) {
		this.numeProiect = numeProiect;
	}
	public Date getDataStart() {
		return dataStart;
	}
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	public String getReleaseCurent() {
		return releaseCurent;
	}
	public void setReleaseCurent(String releaseCurent) {
		this.releaseCurent = releaseCurent;
	}
	public Proiect(Integer nrProiect, String numeProiect, Date dataStart) {
		super();
		this.nrProiect = nrProiect;
		this.numeProiect = numeProiect;
		this.dataStart = dataStart;
	}
	public Proiect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void start() {
		// TODO Auto-generated method stub
		
	}
	
	
}
