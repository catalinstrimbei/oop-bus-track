package org.comenzi.model;

public class Produs {
	private Integer cod;
	private String denumire;
	private String um;
	private Double pretUnitar;

	public Produs(){}
	
	public Produs(Integer cod, String denumire, String um, Double pretUnitar) {
		super();
		this.cod = cod;
		this.denumire = denumire;
		this.um = um;
		this.pretUnitar = pretUnitar;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getUm() {
		return um;
	}

	public void setUm(String um) {
		this.um = um;
	}

	public Double getPretUnitar() {
		return pretUnitar;
	}

	public void setPretUnitar(Double pretUnitar) {
		this.pretUnitar = pretUnitar;
	}

	public String toString(){
		return this.denumire + "[" + this.cod + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produs other = (Produs) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}
	
	
}