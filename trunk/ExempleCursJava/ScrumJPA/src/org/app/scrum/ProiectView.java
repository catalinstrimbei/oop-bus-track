package org.app.scrum;

public class ProiectView {
	private Integer nrProiect;
	private String numeProiect;
	
	public ProiectView() {
		super();
	}
	public ProiectView(Integer nrProiect, String numeProiect) {
		super();
		this.nrProiect = nrProiect;
		this.numeProiect = numeProiect;
	}
	public Integer getNrProiect() {
		return nrProiect;
	}
	public void setNrProiect(Integer nrProiect) {
		this.nrProiect = nrProiect;
	}
	public String getNumeProiect() {
		return numeProiect;
	}
	public void setNumeProiect(String numeProiect) {
		this.numeProiect = numeProiect;
	}
	@Override
	public String toString() {
		return "ProiectView [nrProiect=" + nrProiect + ", numeProiect="
				+ numeProiect + "]";
	}
	
	
}
