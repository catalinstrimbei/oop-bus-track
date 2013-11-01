package org.app.scrum;

import java.util.Date;

public class Release {
	private Integer idRelease;
	private String numeCod; // NEW born
	private String indicativ; // vers 1.1
	private String descriere;
	private Date dataPublicare; // dataEstimarePublicare
	
	public Integer getIdRelease() {
		return idRelease;
	}
	public void setIdRelease(Integer idRelease) {
		this.idRelease = idRelease;
	}
	public String getNumeCod() {
		return numeCod;
	}
	public void setNumeCod(String numeCod) {
		this.numeCod = numeCod;
	}
	public String getIndicativRelease() {
		return indicativ;
	}
	public void setIndicativRelease(String indicativRelease) {
		this.indicativ = indicativRelease;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public Date getDataPublicare() {
		return dataPublicare;
	}
	public void setDataPublicare(Date dataPublicare) {
		this.dataPublicare = dataPublicare;
	}
	public Release(Integer idRelease, String numeCod,
			String indicativRelease, String descriere, Date dataPublicare) {
		super();
		this.idRelease = idRelease;
		this.numeCod = numeCod;
		this.indicativ = indicativRelease;
		this.descriere = descriere;
		this.dataPublicare = dataPublicare;
	}
	
	
}
