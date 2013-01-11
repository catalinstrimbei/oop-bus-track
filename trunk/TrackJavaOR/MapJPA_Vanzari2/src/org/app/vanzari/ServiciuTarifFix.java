package org.app.vanzari;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ServiciuTarifFix extends Serviciu {
	@Column(name="TARIF_UNIC")
	private BigDecimal tarifUnic;

	public BigDecimal getTarifUnic() {
		return tarifUnic;
	}

	public void setTarifUnic(BigDecimal tarifUnic) {
		this.tarifUnic = tarifUnic;
	}

	public ServiciuTarifFix() {
		super();
	}

	public ServiciuTarifFix(long cod, String denumire, BigDecimal procTvaCrt,
			String detaliiServiciu, BigDecimal tarifUnic) {
		super(cod, denumire, procTvaCrt, detaliiServiciu);
		this.tarifUnic = tarifUnic;
	}
	
	
	
}
