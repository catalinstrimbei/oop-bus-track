package org.app.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Entity
public class Client implements Serializable{
	@Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key clientKey;	
	
	
	//@Id //@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String denumire;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
		System.out.println("this.id.toString() = " + this.id.toString());
		Key key = KeyFactory.createKey(Client.class.getSimpleName(), this.id.toString());
		System.out.println("key = " + key);
		this.clientKey = key;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public Client(Long id, String denumire) {
		super();
		this.setId(id);
		this.denumire = denumire;
		
	}
	public Client() {
		super();
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", denumire=" + denumire + "]";
	}
	
	
}
