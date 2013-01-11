package org.app.vanzari;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Serviciu extends ElementFacturabil {
	@Column(name="DETALII_SERVICIU")
	private String detaliiServiciu;

	public String getDetaliiServiciu() {
		return detaliiServiciu;
	}

	public void setDetaliiServiciu(String detaliiServiciu) {
		this.detaliiServiciu = detaliiServiciu;
	}

	public Serviciu() {
		super();
	}

	public Serviciu(long cod, String denumire, BigDecimal procTvaCrt,
			String detaliiServiciu) {
		super(cod, denumire, procTvaCrt);
		this.detaliiServiciu = detaliiServiciu;
	}
	
	
	
}
