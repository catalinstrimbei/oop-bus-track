package cap3.ex6.org.app.scrum;

import java.util.Date;

public class Release implements Comparable<Release>{
	private Integer idRelease;
	private String numeCod; // NEW born
	private String indicativ; // vers 1.1
	private String descriere;
	private Date dataPublicare; // dataEstimarePublicare
	
	// Added
	private Proiect proiect;
	
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
	
	/*
	public String getIndicativRelease() {
		return indicativ;
	}
	public void setIndicativRelease(String indicativRelease) {
		this.indicativ = indicativRelease;
	}
	*/
	
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
	/*
	public Release(Integer idRelease, String numeCod,
			String indicativRelease, String descriere, Date dataPublicare) {
		super();
		this.idRelease = idRelease;
		this.numeCod = numeCod;
		this.indicativ = indicativRelease;
		this.descriere = descriere;
		this.dataPublicare = dataPublicare;
	}
	*/
	
	// Added
	public String getIndicativ() {
		return indicativ;
	}
	public void setIndicativ(String indicativ) {
		this.indicativ = indicativ;
	}
	public Proiect getProiect() {
		return proiect;
	}
	public void setProiect(Proiect proiect) {
		this.proiect = proiect;
	}
	public Release() {
		super();
	}
	public Release(Integer idRelease, String numeCod, String indicativ,
			String descriere, Date dataPublicare, Proiect proiect) {
		super();
		this.idRelease = idRelease;
		this.numeCod = numeCod;
		this.indicativ = indicativ;
		this.descriere = descriere;
		this.dataPublicare = dataPublicare;
		this.proiect = proiect;
	}
	public Release(Integer idRelease, Date dataPublicare) {
		super();
		this.idRelease = idRelease;
		this.descriere = "Release_" + this.idRelease;
		this.dataPublicare = dataPublicare;
	}
	@Override
	public int compareTo(Release other) {
		return this.idRelease.compareTo(other.getIdRelease());
	}
	
}
