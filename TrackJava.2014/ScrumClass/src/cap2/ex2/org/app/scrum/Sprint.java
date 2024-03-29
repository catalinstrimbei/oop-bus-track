package cap2.ex2.org.app.scrum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sprint {
	private Integer idSprint;
	private String obiectiv;
	private Date dataStart;
	private String review;

	List<Cerinta> cerinte = new ArrayList<>();

	/*------------------------------------------*/
	public Sprint() {

	}

	public Sprint(Integer idSprint, String obiectiv, Date dataStart,
			String review, List<Cerinta> cerinte) {
		super();
		this.idSprint = idSprint;
		this.obiectiv = obiectiv;
		this.dataStart = dataStart;
		this.review = review;
		this.cerinte = cerinte;
	}

	public Sprint(Integer idSprint, String obiectiv, Date dataStart) {
		super();
		this.idSprint = idSprint;
		this.obiectiv = obiectiv;
		this.dataStart = dataStart;
	}

	public Integer getIdSprint() {
		return idSprint;
	}

	public void setIdSprint(Integer idSprint) {
		this.idSprint = idSprint;
	}

	public String getObiectiv() {
		return obiectiv;
	}

	public void setObiectiv(String obiectiv) {
		this.obiectiv = obiectiv;
	}

	public Date getDataStart() {
		return dataStart;
	}

	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public List<Cerinta> getCerinte() {
		return cerinte;
	}

	public void setCerinte(List<Cerinta> cerinte) {
		this.cerinte = cerinte;
	}

	// --------------------------------------------------------------------- //
	private Long getDurataEstimataCerinta(Cerinta cerinta) {
		Long durataEstimataCerinta = 0l; // 0 long
		for (Task t : cerinta.getTaskuri()) {
			durataEstimataCerinta += t.getTimpEstimat() * 60 * 60 * 1000;
		}
		return durataEstimataCerinta;
	}

	private Long getDurataEstimataSprint() {
		Long durataEstimataSprint = 0l; // 0 long
		for (Cerinta c : this.cerinte) {
			durataEstimataSprint += getDurataEstimataCerinta(c);
		}

		return durataEstimataSprint;
	}

	// prop dataFinalizare
	public Date getDataFinalizare() {
		Long t1 = this.dataStart.getTime() + this.getDurataEstimataSprint();

		Date dataFinalizare = new Date(t1);

		return dataFinalizare;
	}
	// --------------------------------------------------------------------- //	
}
