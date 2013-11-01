package org.app.scrum;

import java.util.Date;

public class Sprint {
	private Integer idSprint;
	private String obiectiv;
	private Date dataStart;
	private Date durataEstimata;
	private Date dataFinalizare; // setDataFinalizare, getDataFinalizareEstmata()
	private String review;
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
	public Date getDurataEstimata() {
		return durataEstimata;
	}
	public void setDurataEstimata(Date durataEstimata) {
		this.durataEstimata = durataEstimata;
	}
	public Date getDataFinalizare() {
		return dataFinalizare;
	}
	public void setDataFinalizare(Date dataFinalizare) {
		this.dataFinalizare = dataFinalizare;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Sprint(Integer idSprint, String obiectiv, Date dataStart,
			Date durataEstimata) {
		super();
		this.idSprint = idSprint;
		this.obiectiv = obiectiv;
		this.dataStart = dataStart;
		this.durataEstimata = durataEstimata;
	}
	public Sprint() {
		super();
	}
	
	
	
}
