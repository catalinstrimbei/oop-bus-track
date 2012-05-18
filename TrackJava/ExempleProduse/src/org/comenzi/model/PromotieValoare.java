package org.comenzi.model;

public class PromotieValoare extends Promotie {
	private Double pragValoare;
	private Double procentReducere;
	
	public Double getPragValoare() {
		return pragValoare;
	}

	public void setPragValoare(Double pragValoare) {
		this.pragValoare = pragValoare;
	}

	public Double getProcentReducere() {
		return procentReducere;
	}

	public void setProcentReducere(Double procentReducere) {
		this.procentReducere = procentReducere;
	}

	@Override
	public Double getValoareDiscount(Double cantitate) {
		Double valoareAchizitie = cantitate * this.produs.getPretUnitar(); 
		if (valoareAchizitie > pragValoare)
			return valoareAchizitie * procentReducere/100;
		return 0.0;
	}

	public PromotieValoare(Integer id, Produs produs, Double pragValoare,
			Double procentReducere) {
		super(id, produs);
		this.pragValoare = pragValoare;
		this.procentReducere = procentReducere;
	}

	public PromotieValoare() {
		super();
	}

}
