package org.comenzi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comanda {
	private Integer id;
	private Date dataComanda;
	private List<ArticolComanda> articole = new ArrayList<ArticolComanda>();
	
	public Comanda(Integer id, Date dataComanda) {
		this.id = id;
		this.dataComanda = dataComanda;
	}
	public Comanda() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataComanda() {
		return dataComanda;
	}
	public void setDataComanda(Date dataComanda) {
		this.dataComanda = dataComanda;
	}
	public List<ArticolComanda> getArticole() {
		return articole;
	}
	public void setArticole(List<ArticolComanda> articole) {
		this.articole = articole;
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
		Comanda other = (Comanda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Double getValoareComanda(){
		if (articole.isEmpty())
			return null;
		
		Double valoare = 0.0;
		for (ArticolComanda articol: articole){
			valoare = valoare + articol.getValoareArticol();
		}
		
		return valoare;
	}
	
	public void adauga(Produs produs, Double cantitate){
		ArticolComanda articol = new ArticolComanda();
		articol.setProdus(produs);
		articol.setCantitate(cantitate);
		this.articole.add(articol);
	}
	
	public Boolean verificaProdus(Produs produs){
		return null;
	}
	
	public ArticolComanda getArticolComanda(Produs produs){
		return null;
	}
	
	public Double getValoareComandataProdus(Produs produs){
		return null;
	}
}
