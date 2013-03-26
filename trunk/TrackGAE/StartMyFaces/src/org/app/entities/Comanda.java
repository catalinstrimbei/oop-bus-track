package org.app.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Comanda implements Serializable{
	@Id
	private Long idComanda;
	
	@Temporal(TemporalType.DATE)
	private Date dataComanda;
	
	@ManyToOne
	private Client client;
	
	
	public Long getIdComanda() {
		return idComanda;
	}
	public void setIdComanda(Long idComanda) {
		this.idComanda = idComanda;
	}
	public Date getDataComanda() {
		return dataComanda;
	}
	public void setDataComanda(Date dataComanda) {
		this.dataComanda = dataComanda;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idComanda == null) ? 0 : idComanda.hashCode());
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
		if (idComanda == null) {
			if (other.idComanda != null)
				return false;
		} else if (!idComanda.equals(other.idComanda))
			return false;
		return true;
	}
	public Comanda() {
		super();
	}
	public Comanda(Long idComanda, Date dataComanda, Client client) {
		super();
		this.idComanda = idComanda;
		this.dataComanda = dataComanda;
		this.client = client;
	}
	@Override
	public String toString() {
		return "Comanda [idComanda=" + idComanda + ", dataComanda="
				+ dataComanda + ", client=" + client + "]";
	}
	
	
}
