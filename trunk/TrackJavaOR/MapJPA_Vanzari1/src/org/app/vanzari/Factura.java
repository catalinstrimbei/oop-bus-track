package org.app.vanzari;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the FACTURI database table.
 * 
 */
@Entity
@Table(name="FACTURI")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FACT")
	private long idFact;

	private String client;

    @Temporal( TemporalType.DATE)
	@Column(name="DATA_FACT")
	private Date dataFact;

	@Column(name="NR_FACT")
	private String nrFact;

	private String obs;

	//bi-directional many-to-one association to LinieFactura
	@OneToMany(mappedBy="factura")
	private List<LinieFactura> liniiFacturi;

    public Factura() {
    }

	public long getIdFact() {
		return this.idFact;
	}

	public void setIdFact(long idFact) {
		this.idFact = idFact;
	}

	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getDataFact() {
		return this.dataFact;
	}

	public void setDataFact(Date dataFact) {
		this.dataFact = dataFact;
	}

	public String getNrFact() {
		return this.nrFact;
	}

	public void setNrFact(String nrFact) {
		this.nrFact = nrFact;
	}

	public String getObs() {
		return this.obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public List<LinieFactura> getLiniiFacturi() {
		return this.liniiFacturi;
	}

	public void setLiniiFacturi(List<LinieFactura> liniiFacturi) {
		this.liniiFacturi = liniiFacturi;
	}
	
}