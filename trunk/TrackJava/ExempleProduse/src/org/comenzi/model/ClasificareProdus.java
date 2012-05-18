package org.comenzi.model;



public class ClasificareProdus {
	private Produs produs;
	private Categorie categorie;
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public ClasificareProdus() {
	}
	public ClasificareProdus(Produs produs, Categorie categorie) {
		this.produs = produs;
		this.categorie = categorie;
	}
}
