package cap3.ex3.org.app.scrum;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Sprint implements BurnDownItem{
	private Integer idSprint;
	private String obiectiv;
	private List<Cerinta> cerinte = new ArrayList<>();
	
	public List<Cerinta> getCerinte() {
		return cerinte;
	}
	public void setCerinte(List<Cerinta> cerinte) {
		this.cerinte = cerinte;
	}
	/*******************************/
	private Date dataStart;
	// proprietatea dataStart
	public Date getDataStart() {
		return dataStart;
	}
	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}
	
	// --------------------------------------------------------------------- //
	private Long getDurataEstimataCerinta(Cerinta cerinta){
		Long durataEstimataCerinta = 0l; // 0 long
		for(Task t: cerinta.getTaskuri()){
			durataEstimataCerinta += t.getTimpEstimat() * 60 * 60 * 1000;
		}
		return durataEstimataCerinta;
	}
	
	private Long getDurataEstimataSprint() {
		Long durataEstimataSprint = 0l; // 0 long
		for (Cerinta c: this.cerinte){
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
	
	public void adaugaCerinta(Cerinta c){
		this.cerinte.add(c);
	}
	
	
	// --------------------------------------------------------------------- //
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

	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}

	public Sprint() {
		super();
	}
	
	@Override
	public String toString() {
		return "Sprint [idSprint=" + idSprint + ", obiectiv=" + obiectiv
				+ ", dataStart=" + dataStart
				+ ", review=" + review + "]";
	}
	/*------------------------------------------------------------------*/
	// implements BurnDownItem
	@Override
	public Map<Date, Integer> getBurnDownRecords() {
		// TODO from Tasks
		return null;
	}
	@Override
	public Integer getTimpEstimat() {
		// TODO from Tasks 
		return null;
	}
	@Override
	public Integer getTimpRamas() {
		// TODO from Tasks
		return null;
	}	
}


/*
Map<Date, Integer> burnDownRecords = new HashMap<>();
		Set<Date> recordDates = burnDownRecords.keySet();
		Map<Date, Integer> taskBurnDownRecords = null;
		for(Cerinta c: this.cerinte){
			for(Task t: c.getTaskuri()){
				taskBurnDownRecords= t.getBurnDownRecords();
				for(Date d: taskBurnDownRecords.keySet()){
					if(!recordDates.contains(d))
						burnDownRecords.put(d, 0);
					burnDownRecords.put(d, burnDownRecords.get(d) + taskBurnDownRecords.get(d));
				}
			}
		}

*/