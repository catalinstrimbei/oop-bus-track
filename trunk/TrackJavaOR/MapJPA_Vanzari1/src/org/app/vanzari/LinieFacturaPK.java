package org.app.vanzari;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the LINII_FACTURI database table.
 * 
 */
@Embeddable
public class LinieFacturaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private long linie;

	@Column(name="ID_FACT")
	private long idFact;

    public LinieFacturaPK() {
    }
	public long getLinie() {
		return this.linie;
	}
	public void setLinie(long linie) {
		this.linie = linie;
	}
	public long getIdFact() {
		return this.idFact;
	}
	public void setIdFact(long idFact) {
		this.idFact = idFact;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LinieFacturaPK)) {
			return false;
		}
		LinieFacturaPK castOther = (LinieFacturaPK)other;
		return 
			(this.linie == castOther.linie)
			&& (this.idFact == castOther.idFact);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.linie ^ (this.linie >>> 32)));
		hash = hash * prime + ((int) (this.idFact ^ (this.idFact >>> 32)));
		
		return hash;
    }
}