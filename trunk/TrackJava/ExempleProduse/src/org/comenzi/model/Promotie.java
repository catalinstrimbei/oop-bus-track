package org.comenzi.model;

public abstract class Promotie {
	protected Integer id;
	protected Produs produs;
	
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
	
	public Double getValoareDiscountComanda(Comanda comanda){
		Double valoareDiscountComanda = 0.0;
		for(ArticolComanda articol: comanda.getArticole()){
			if (produs.equals(articol.getProdus()))
				valoareDiscountComanda += getValoareDiscount(articol.getCantitate());
		}
		return valoareDiscountComanda;
	}
	
	public abstract Double getValoareDiscount(Double cantitate);
	
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
		Promotie other = (Promotie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Promotie(Integer id, Produs produs) {
		super();
		this.id = id;
		this.produs = produs;
	}
	public Promotie() {
		super();
	}
	
}
