package org.app.vanzari;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the LINII_FACTURI database table.
 * 
 */
@Entity
@Table(name="LINII_FACTURI")
public class LinieFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LinieFacturaPK id;

	private BigDecimal cantitate;

	private String obs;

	@Column(name="PRET_UNIT")
	private BigDecimal pretUnit;

	@Column(name="TVA_LINIE")
	private BigDecimal tvaLinie;

	//bi-directional many-to-one association to ElementFacturabil
    @ManyToOne
	@JoinColumn(name="COD")
	private ElementFacturabil elementFacturabil;

	//bi-directional many-to-one association to Factura
    @ManyToOne
	@JoinColumn(name="ID_FACT")
	private Factura factura;

    public LinieFactura() {
    }

	public LinieFacturaPK getId() {
		return this.id;
	}

	public void setId(LinieFacturaPK id) {
		this.id = id;
	}
	
	public BigDecimal getCantitate() {
		return this.cantitate;
	}

	public void setCantitate(BigDecimal cantitate) {
		this.cantitate = cantitate;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public BigDecimal getPretUnit() {
		return this.pretUnit;
	}

	public void setPretUnit(BigDecimal pretUnit) {
		this.pretUnit = pretUnit;
	}

	public BigDecimal getTvaLinie() {
		return this.tvaLinie;
	}

	public void setTvaLinie(BigDecimal tvaLinie) {
		this.tvaLinie = tvaLinie;
	}

	public ElementFacturabil getElementFacturabil() {
		return this.elementFacturabil;
	}

	public void setElementFacturabil(ElementFacturabil elementFacturabil) {
		this.elementFacturabil = elementFacturabil;
	}
	
	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public LinieFactura(LinieFacturaPK id, ElementFacturabil elementFacturabil,
			BigDecimal cantitate, BigDecimal pretUnit, BigDecimal tvaLinie,
			String obs) {
		super();
		this.id = id;
		this.elementFacturabil = elementFacturabil;
		this.cantitate = cantitate;
		this.pretUnit = pretUnit;
		this.tvaLinie = tvaLinie;
		this.obs = obs;
	}
	
	
}