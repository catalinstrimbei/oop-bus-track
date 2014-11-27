package org.app.scrum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.app.scrum.team.ManagerProiect;
import org.app.scrum.validare.ExceptieValidare;
import org.app.scrum.validare.IntegerIntervalValidation;
import org.app.scrum.validare.StringInitCapValidation;
import org.app.scrum.validare.Validatable;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Entity
public class Proiect implements Validatable{
	@Id
	private Integer nrProiect;
	
	@NotNull
	private String numeProiect;
	
	@Temporal(TemporalType.DATE)
	private Date dataStart;
	
	@Transient
	private ManagerProiect managerProiect;
	
	// Added
	@OneToMany(mappedBy="proiect", cascade = ALL, fetch = LAZY)
	private List<Release> releases = new ArrayList<>();
	
	@OneToOne(cascade = ALL)
	private Release releaseCurent;
	
	public ManagerProiect getManagerProiect() {
		return managerProiect;
	}
	public void setManagerProiect(ManagerProiect managerProiect) {
		this.managerProiect = managerProiect;
	}
	public Integer getNrProiect() {
		return nrProiect;
	}
	public void setNrProiect(Integer nrProiect) {
		new IntegerIntervalValidation("Nr.proiect interval valid: 1..9999", 1, 9).validate(nrProiect);
		
		this.nrProiect = nrProiect;
	}
	public String getNumeProiect() {
		return numeProiect;
	}
	public void setNumeProiect(String numeProiect) {
		new StringInitCapValidation("Nume proiectului trebuie scris cu majuscula!").validate(numeProiect);
		
		this.numeProiect = numeProiect;
	}
	public Date getDataStart() {
		return dataStart;
	}
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	
	public Proiect(Integer nrProiect, String numeProiect, Date dataStart) {
		super();
		this.nrProiect = nrProiect;
		this.numeProiect = numeProiect;
		this.dataStart = dataStart;
	}
	public Proiect() {
		super();
		// TODO Auto-generated constructor stub
	}
	// Added
	public List<Release> getReleases() {
		return releases;
	}
	public void setReleases(List<Release> releases) {
		this.releases = releases;
	}
	public Release getReleaseCurent() {
		return releaseCurent;
	}
	public void setReleaseCurent(Release releaseCurent) {
		this.releaseCurent = releaseCurent;
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
	public Proiect(Integer nrProiect, String numeProiect) {
		super();
		this.setNrProiect(nrProiect);
		this.setNumeProiect(numeProiect);
	}
	@Override
	public String toString() {
		return "Proiect [nrProiect=" + nrProiect + ", numeProiect="
				+ numeProiect + ", dataStart=" + dataStart + "]";
	}
	@Override
	public boolean isValid() {
		if(this.releases == null || this.releases.isEmpty())
			throw new ExceptieValidare("Proiectul trebuie sa aiba cel putin un release!");
		
		return true;
	}
	
	
	
}
