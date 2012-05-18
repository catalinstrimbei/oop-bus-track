package org.comenzi.model;

public class Serviciu extends Produs {
	
	protected Integer durataMentenanta;
	protected String modFacturare; // modInregistrareConsum
	public Integer getDurataMentenanta() {
		return durataMentenanta;
	}
	public void setDurataMentenanta(Integer durataMentenanta) {
		this.durataMentenanta = durataMentenanta;
	}
	public String getModFacturare() {
		return modFacturare;
	}
	public void setModFacturare(String modFacturare) {
		this.modFacturare = modFacturare;
	}
	public Serviciu(Integer cod, String denumire, String um, Double pretUnitar,
			Integer durataMentenanta, String modFacturare) {
		super(cod, denumire, um, pretUnitar);
		this.durataMentenanta = durataMentenanta;
		this.modFacturare = modFacturare;
	}
	public Serviciu() {
		super();
	}
}
