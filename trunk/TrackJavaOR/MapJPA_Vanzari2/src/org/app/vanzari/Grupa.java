package org.app.vanzari;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the GRUPE database table.
 * 
 */
@Entity
@Table(name="GRUPE")
public class Grupa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String grupa;

	@Column(name="PROCENT_TVA_CRT")
	private BigDecimal procentTvaCrt;

	//bi-directional many-to-one association to ElementFacturabil
	@OneToMany(mappedBy="grupa")
	private List<ElementFacturabil> elementeFacturabile;

	//bi-directional many-to-one association to Grupa
    @ManyToOne
	@JoinColumn(name="GRUPA1")
	private Grupa superGrupa;

	//bi-directional many-to-one association to Grupa
	@OneToMany(mappedBy="superGrupa")
	private List<Grupa> subGrupe;

    public Grupa() {
    }

	public String getGrupa() {
		return this.grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	public BigDecimal getProcentTvaCrt() {
		return this.procentTvaCrt;
	}

	public void setProcentTvaCrt(BigDecimal procentTvaCrt) {
		this.procentTvaCrt = procentTvaCrt;
	}

	public List<ElementFacturabil> getElementeFacturabile() {
		return this.elementeFacturabile;
	}

	public void setElementeFacturabile(List<ElementFacturabil> elementeFacturabile) {
		this.elementeFacturabile = elementeFacturabile;
	}

	public Grupa getSuperGrupa() {
		return superGrupa;
	}

	public void setSuperGrupa(Grupa superGrupa) {
		this.superGrupa = superGrupa;
	}

	public List<Grupa> getSubGrupe() {
		return subGrupe;
	}

	public void setSubGrupe(List<Grupa> subGrupe) {
		this.subGrupe = subGrupe;
	}


	public Grupa(String grupa, BigDecimal procentTvaCrt) {
		super();
		this.grupa = grupa;
		this.procentTvaCrt = procentTvaCrt;
	}
	

	
}