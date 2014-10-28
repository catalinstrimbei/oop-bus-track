package cap2.ex3.org.app.scrum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Release {
	private Integer idRelease;
	private String numeCod;
	private String indicativ; // vers 1.1
	private String descriere;
	private Date dataPublicare;
	
	private List<Cerinta> cerinte = new ArrayList<>();
	
	/*------------------------------------------*/
	public Release() {
		
	}

	public Release(Integer idRelease, String numeCod, String indicativ,
			String descriere, Date dataPublicare, List<Cerinta> cerinte) {
		super();
		this.idRelease = idRelease;
		this.numeCod = numeCod;
		this.indicativ = indicativ;
		this.descriere = descriere;
		this.dataPublicare = dataPublicare;
		this.cerinte = cerinte;
	}

	public Release(Integer idRelease, String numeCod, String indicativ) {
		super();
		this.idRelease = idRelease;
		this.numeCod = numeCod;
		this.indicativ = indicativ;
	}

	public Integer getIdRelease() {
		return idRelease;
	}

	public void setIdRelease(Integer idRelease) {
		this.idRelease = idRelease;
	}

	public String getNumeCod() {
		return numeCod;
	}

	public void setNumeCod(String numeCod) {
		this.numeCod = numeCod;
	}

	public String getIndicativ() {
		return indicativ;
	}

	public void setIndicativ(String indicativ) {
		this.indicativ = indicativ;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	public Date getDataPublicare() {
		return dataPublicare;
	}

	public void setDataPublicare(Date dataPublicare) {
		this.dataPublicare = dataPublicare;
	}

	public List<Cerinta> getCerinte() {
		return cerinte;
	}

	public void setCerinte(List<Cerinta> cerinte) {
		this.cerinte = cerinte;
	}
	
	/*------------------------------------------*/
	
	
}
