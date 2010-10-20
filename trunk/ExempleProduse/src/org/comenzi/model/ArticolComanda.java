package org.comenzi.model;

public class ArticolComanda {
	private Integer id;
	private Produs produs;
	private Double cantitate;
	
	public ArticolComanda(){}
	public ArticolComanda(Integer id, Produs produs, Double cantitate) {
		this.id = id;
		this.produs = produs;
		this.cantitate = cantitate;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Produs getProdus() {
		return produs;
	}
	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	public Double getCantitate() {
		return cantitate;
	}
	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ArticolComanda other = (ArticolComanda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Double getValoareArticol(){
		if (produs == null || cantitate == null)
			return null;
		
		return produs.getPretUnitar() * cantitate;
	}
	
}
