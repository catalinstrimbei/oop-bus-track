package org.app.vanzari;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ELEMENTE_FACTURABILE database table.
 * 
 */
@Entity
@Table(name="ELEMENTE_FACTURABILE")
public class ElementFacturabil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long cod;

	@Column(name="BAZA_CALCUL")
	private String bazaCalcul;

	@Column(name="CANTIT_UNITARA")
	private BigDecimal cantitUnitara;

	private String denumire;

	@Column(name="DETALII_SERVICIU")
	private String detaliiServiciu;

	@Column(name="PROC_TVA_CRT")
	private BigDecimal procTvaCrt;

	@Column(name="TARIF_UNIC")
	private BigDecimal tarifUnic;

	@Column(name="TARIF_UNITAR")
	private BigDecimal tarifUnitar;

	private String um;

	@Column(name="UM_CANTIT_UNIT")
	private String umCantitUnit;

	//bi-directional many-to-one association to Grupa
    @ManyToOne
	@JoinColumn(name="GRUPA")
	private Grupa grupa;

	//bi-directional many-to-one association to LinieFactura
	@OneToMany(mappedBy="elementFacturabil")
	private List<LinieFactura> liniiFacturi;

    public ElementFacturabil() {
    }

	public long getCod() {
		return this.cod;
	}

	public void setCod(long cod) {
		this.cod = cod;
	}

	public String getBazaCalcul() {
		return this.bazaCalcul;
	}

	public void setBazaCalcul(String bazaCalcul) {
		this.bazaCalcul = bazaCalcul;
	}

	public BigDecimal getCantitUnitara() {
		return this.cantitUnitara;
	}

	public void setCantitUnitara(BigDecimal cantitUnitara) {
		this.cantitUnitara = cantitUnitara;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getDetaliiServiciu() {
		return this.detaliiServiciu;
	}

	public void setDetaliiServiciu(String detaliiServiciu) {
		this.detaliiServiciu = detaliiServiciu;
	}

	public BigDecimal getProcTvaCrt() {
		return this.procTvaCrt;
	}

	public void setProcTvaCrt(BigDecimal procTvaCrt) {
		this.procTvaCrt = procTvaCrt;
	}

	public BigDecimal getTarifUnic() {
		return this.tarifUnic;
	}

	public void setTarifUnic(BigDecimal tarifUnic) {
		this.tarifUnic = tarifUnic;
	}

	public BigDecimal getTarifUnitar() {
		return this.tarifUnitar;
	}

	public void setTarifUnitar(BigDecimal tarifUnitar) {
		this.tarifUnitar = tarifUnitar;
	}

	public String getUm() {
		return this.um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	public String getUmCantitUnit() {
		return this.umCantitUnit;
	}

	public void setUmCantitUnit(String umCantitUnit) {
		this.umCantitUnit = umCantitUnit;
	}

	public Grupa getGrupa() {
		return this.grupa;
	}

	public void setGrupa(Grupa grupa) {
		this.grupa = grupa;
	}
	
	public List<LinieFactura> getLiniiFacturi() {
		return this.liniiFacturi;
	}

	public void setLiniiFacturi(List<LinieFactura> liniiFacturi) {
		this.liniiFacturi = liniiFacturi;
	}
	
}