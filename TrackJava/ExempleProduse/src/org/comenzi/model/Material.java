package org.comenzi.model;

public class Material extends Produs {
	
	protected Integer durataGarantie;
	protected String modPrezentare;
	public Integer getDurataGarantie() {
		return durataGarantie;
	}
	public void setDurataGarantie(Integer durataGarantie) {
		this.durataGarantie = durataGarantie;
	}
	public String getModPrezentare() {
		return modPrezentare;
	}
	public void setModPrezentare(String modPrezentare) {
		this.modPrezentare = modPrezentare;
	}
	public Material(Integer cod, String denumire, String um, Double pretUnitar,
			Integer durataGarantie, String modPrezentare) {
		super(cod, denumire, um, pretUnitar);
		this.durataGarantie = durataGarantie;
		this.modPrezentare = modPrezentare;
	}
	public Material() {
		super();
	}
}
