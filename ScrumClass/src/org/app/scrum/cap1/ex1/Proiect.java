package org.app.scrum.cap1.ex1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proiect {
	Integer nrProiect;	
	String numeProiect;
	Date dataStart;
	
	List<Release> releases = new ArrayList<>();

	public Integer getNrProiect() {
		return nrProiect;
	}

	public void setNrProiect(Integer nr) {
		if (nr > 0)
			this.nrProiect = nr;
		else
			throw new RuntimeException("Valoarea nrProiect tb sa fie pozitiva!");
	}

	public String getNumeProiect() {
		return numeProiect;
	}

	public void setNumeProiect(String numeProiect) {
		this.numeProiect = numeProiect;
	}

	public Date getDataStart() {
		return dataStart;
	}

	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}

	public List<Release> getReleases() {
		return releases;
	}

	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nrProiect == null) ? 0 : nrProiect.hashCode());
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
		Proiect other = (Proiect) obj;
		if (nrProiect == null) {
			if (other.nrProiect != null)
				return false;
		} else if (!nrProiect.equals(other.nrProiect))
			return false;
		return true;
	}	
	
	
	
}
