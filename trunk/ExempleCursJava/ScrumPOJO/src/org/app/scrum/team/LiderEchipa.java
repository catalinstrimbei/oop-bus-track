package org.app.scrum.team;

public class LiderEchipa {
	private Integer id;
	private String numePrenume;
	private String competenteTehnologice; // JEE, Spring, .NET, JS/Node.js, Ruby_Rails
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumePrenume() {
		return numePrenume;
	}
	public void setNumePrenume(String numePrenume) {
		this.numePrenume = numePrenume;
	}
	public String getCompetenteTehnologice() {
		return competenteTehnologice;
	}
	public void setCompetenteTehnologice(String competenteTehnologice) {
		this.competenteTehnologice = competenteTehnologice;
	}
	
	
}
