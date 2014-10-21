package org.app.scrum.cap2.ex3;

import java.util.ArrayList;
import java.util.List;

public class Echipa {
	private Integer idEchipa;
	private Specializare specializare; // ENum
	private String competente;
	private List<Membru> membri = new ArrayList<Membru>();
	
	/*------------------------------------------*/
	public Integer getIdEchipa() {
		return idEchipa;
	}
	public void setIdEchipa(Integer idEchipa) {
		this.idEchipa = idEchipa;
	}
	public Specializare getSpecializare() {
		return specializare;
	}
	public void setSpecializare(Specializare specializare) {
		this.specializare = specializare;
	}
	public String getCompetente() {
		return competente;
	}
	public void setCompetente(String competente) {
		this.competente = competente;
	}
	public List<Membru> getMembri() {
		return membri;
	}
	public void setMembri(List<Membru> membri) {
		this.membri = membri;
	}
	
	
	
}

