package org.app.scrum.sprint;

public class CerintaTehnica extends Cerinta {
	
	private String nivelArhitectural; // prezentare (UI), model si/sau logica afacerii, persistenta, baza de date
	private String competenteTehniceNecesare; // LP: Java, C#, JavaScript, BD: SQL, MongoDB, FMks: EJB, JPA, JSF, Angular, JQuery
	private String descriereFluxArhitecural; // colaborare inter-niveluri: UI - catre - Fmk.Logica/Model - catre - Sistem BD
	
	public String getNivelArhitectural() {
		return nivelArhitectural;
	}
	public void setNivelArhitectural(String nivelArhitectural) {
		this.nivelArhitectural = nivelArhitectural;
	}
	public String getCompetenteTehniceNecesare() {
		return competenteTehniceNecesare;
	}
	public void setCompetenteTehniceNecesare(String competenteTehniceNecesare) {
		this.competenteTehniceNecesare = competenteTehniceNecesare;
	}
	public String getDescriereFluxArhitecural() {
		return descriereFluxArhitecural;
	}
	public void setDescriereFluxArhitecural(String descriereFluxArhitecural) {
		this.descriereFluxArhitecural = descriereFluxArhitecural;
	}
}
