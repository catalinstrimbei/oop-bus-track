package org.app.scrum.team;

public class Membru {
	private Integer idMembru;
	private Integer numePrenume;
	private Rol rol;
	public Integer getIdMembru() {
		return idMembru;
	}
	public void setIdMembru(Integer idMembru) {
		this.idMembru = idMembru;
	}
	public Integer getNumePrenume() {
		return numePrenume;
	}
	public void setNumePrenume(Integer numePrenume) {
		this.numePrenume = numePrenume;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Membru(Integer idMembru, Integer numePrenume, Rol rol) {
		super();
		this.idMembru = idMembru;
		this.numePrenume = numePrenume;
		this.rol = rol;
	}
	public Membru() {
		super();
	}
	
	
}

enum Rol{
	MANAGER, PRODUCT_OWNER, SCRUM_MASTER, DEVELOPER, ANALIST, TESTER;
}