package org.app.scrum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.app.scrum.team.ManagerProiect;

public class Proiect {
	private Integer nrProiect;
	private String numeProiect;
	private Date dataStart;
	//private String releaseCurent;
	private ManagerProiect managerProiect;
	
	// Added
	private List<Release> releases = new ArrayList<>(); 
	private Release releaseCurent;
	
	public ManagerProiect getManagerProiect() {
		return managerProiect;
	}
	public void setManagerProiect(ManagerProiect managerProiect) {
		this.managerProiect = managerProiect;
	}
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
	
	/*
	public String getReleaseCurent() {
		return releaseCurent;
	}
	public void setReleaseCurent(String releaseCurent) {
		this.releaseCurent = releaseCurent;
	}
	*/
	
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
	
	// Added
	public List<Release> getReleases() {
		return releases;
	}
	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}
	public Release getReleaseCurent() {
		return releaseCurent;
	}
	public void setReleaseCurent(Release releaseCurent) {
		this.releaseCurent = releaseCurent;
	}
	
	
}
