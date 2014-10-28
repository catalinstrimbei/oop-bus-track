package cap1.ex1.org.app.scrum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Release {
	Integer idRelease;
	String numeCod;
	String indicativ; // vers 1.1
	String descriere;
	Date dataPublicare;
	
	List<Cerinta> cerinte = new ArrayList<>();
}
