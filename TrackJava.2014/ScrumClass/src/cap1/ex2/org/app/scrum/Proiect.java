package cap1.ex2.org.app.scrum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Proiect {
	Integer nrProiect;	
	String numeProiect;
	Date dataStart = new Date();
	
	List<Release> releases = new ArrayList<>();
	
	/*------------------------------------------*/
	public Proiect() {
		
	}

	public Proiect(Integer nrProiect, String numeProiect, Date dataStart,
			List<Release> releases) {
		this.nrProiect = nrProiect;
		this.numeProiect = numeProiect;
		this.dataStart = dataStart;
		this.releases = releases;
	}
	
	public Proiect(Integer nrProiect, String numeProiect, Date dataStart) {
		this.nrProiect = nrProiect;
		this.numeProiect = numeProiect;
		this.dataStart = dataStart;
	}

	public Proiect(Integer nrProiect, String numeProiect) {
		super();
		this.nrProiect = nrProiect;
		this.numeProiect = numeProiect;
	}	
	
	
}
