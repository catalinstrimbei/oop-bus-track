package cap2.ex1.org.app.scrum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sprint {
	Integer idSprint;
	String obiectiv;
	Date dataStart;
	String review;
	
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
	
}
