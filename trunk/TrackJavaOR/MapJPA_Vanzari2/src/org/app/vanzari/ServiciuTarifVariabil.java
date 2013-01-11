package org.app.vanzari;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ServiciuTarifVariabil extends Serviciu {
	@Column(name="BAZA_CALCUL")
	private String bazaCalcul;

	@Column(name="TARIF_UNITAR")
	private BigDecimal tarifUnitar;

	public String getBazaCalcul() {
		return bazaCalcul;
	}

	public void setBazaCalcul(String bazaCalcul) {
		this.bazaCalcul = bazaCalcul;
	}

	public BigDecimal getTarifUnitar() {
		return tarifUnitar;
	}

	public void setTarifUnitar(BigDecimal tarifUnitar) {
		this.tarifUnitar = tarifUnitar;
	}

	public ServiciuTarifVariabil() {
		super();
	}

	public ServiciuTarifVariabil(long cod, String denumire,
			BigDecimal procTvaCrt, String detaliiServiciu, String bazaCalcul,
			BigDecimal tarifUnitar) {
		super(cod, denumire, procTvaCrt, detaliiServiciu);
		this.bazaCalcul = bazaCalcul;
		this.tarifUnitar = tarifUnitar;
	}	
	
	
	
}
