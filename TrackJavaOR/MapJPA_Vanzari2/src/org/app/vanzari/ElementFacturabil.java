package org.app.vanzari;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import static javax.persistence.InheritanceType.SINGLE_TABLE;


/**
 * The persistent class for the ELEMENTE_FACTURABILE database table.
 * 
 */

@Entity
@Table(name="ELEMENTE_FACTURABILE")
@Inheritance(strategy = SINGLE_TABLE)
public class ElementFacturabil implements Serializable {
	protected static final long serialVersionUID = 1L;
	
	@Id
	private long cod;

	private String denumire;

	@Column(name="PROC_TVA_CRT")
	private BigDecimal procTvaCrt;

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

	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public BigDecimal getProcTvaCrt() {
		return this.procTvaCrt;
	}

	public void setProcTvaCrt(BigDecimal procTvaCrt) {
		this.procTvaCrt = procTvaCrt;
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

	public ElementFacturabil(long cod, String denumire, BigDecimal procTvaCrt) {
		super();
		this.cod = cod;
		this.denumire = denumire;
		this.procTvaCrt = procTvaCrt;
	}
	
	
}