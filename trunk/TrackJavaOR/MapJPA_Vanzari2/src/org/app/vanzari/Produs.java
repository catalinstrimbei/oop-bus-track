package org.app.vanzari;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Produs extends ElementFacturabil {
	private String um;
	
	@Column(name="CANTIT_UNITARA")
	private BigDecimal cantitUnitara;
	
	@Column(name="UM_CANTIT_UNIT")
	private String umCantitUnit;

	public String getUm() {
		return um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	public BigDecimal getCantitUnitara() {
		return cantitUnitara;
	}

	public void setCantitUnitara(BigDecimal cantitUnitara) {
		this.cantitUnitara = cantitUnitara;
	}

	public String getUmCantitUnit() {
		return umCantitUnit;
	}

	public void setUmCantitUnit(String umCantitUnit) {
		this.umCantitUnit = umCantitUnit;
	}

	public Produs() {
		super();
	}

	public Produs(long cod, String denumire, BigDecimal procTvaCrt, String um,
			BigDecimal cantitUnitara, String umCantitUnit) {
		super(cod, denumire, procTvaCrt);
		this.um = um;
		this.cantitUnitara = cantitUnitara;
		this.umCantitUnit = umCantitUnit;
	}
	
	
	
}
