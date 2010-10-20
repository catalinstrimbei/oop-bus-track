package org.comenzi.model;

public class PromotieCantitate extends Promotie {
	private Double cantitate;
	private Double gratuitati;
	
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setGratuitati(Double gratuitati) {
		this.gratuitati = gratuitati;
	}
	public Double getGratuitati() {
		return gratuitati;
	}
	public PromotieCantitate(Integer id, Produs produs, Double cantitate,
			Double gratuitati) {
		super(id, produs);
		this.cantitate = cantitate;
		this.gratuitati = gratuitati;
	}
}
