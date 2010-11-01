package org.comenzi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author catalin.strimbei
 *
 */
public class Semifabricat {
	protected String fazaPrelucrare;
	protected List<ProdusFinit> pfCompatibile = new ArrayList<ProdusFinit>();
	public String getFazaPrelucrare() {
		return fazaPrelucrare;
	}
	public void setFazaPrelucrare(String fazaPrelucrare) {
		this.fazaPrelucrare = fazaPrelucrare;
	}
	public List<ProdusFinit> getPfCompatibile() {
		return pfCompatibile;
	}
	public void setPfCompatibile(List<ProdusFinit> pfCompatibile) {
		this.pfCompatibile = pfCompatibile;
	}
	public Semifabricat() {
		super();
	}
}
