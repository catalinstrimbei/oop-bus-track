package org.app.scrum.team;

public class Membru {
	private Integer idMembru;
	private String numePrenume;
	private Rol rol;

	public Integer getIdMembru() {
		return idMembru;
	}
	public void setIdMembru(Integer idMembru) {
		this.idMembru = idMembru;
	}
	public String getNumePrenume() {
		return numePrenume;
	}
	public void setNumePrenume(String numePrenume) {
		this.numePrenume = numePrenume;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Membru(Integer idMembru, String numePrenume, Rol rol) {
		super();
		this.idMembru = idMembru;
		this.numePrenume = numePrenume;
		this.rol = rol;
	}
	public Membru() {
		super();
	}
	
	// caz supra-incarcare
	private String competente;
	
	public String getCompetente() {
		return competente;
	}
	public void setCompetente(String competente) {
		this.competente = competente;
	}	
	
}