package org.comenzi.model;

public class PromotieValoare extends Promotie{

	private Double valoare;
	
	private Double procent;

	public Double getProcent() {
		return procent;
	}

	public void setProcent(Double procent) {
		this.procent = procent;
	}

	public Double getValoare() {
		return valoare;
	}

	public void setValoare(Double valoare) {
		this.valoare = valoare;
	}

	public PromotieValoare() {
		super();
	}

	public PromotieValoare(Integer id, Produs produs, Double valoare,
			Double procent) {
		super(id, produs);
		this.valoare = valoare;
		this.procent = procent;
	}


}
