package cap3.ex6.org.app.scrum;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

public class TestCommonCollections_FilterMembri {

	public static void main(String[] args) {
		// TODO Creare lista Membruuri de filtrat
        Membru[] membri = {
                new Membru(301, "Developer 301"),
                new Membru(401, "Developer 401"),
                new Membru(101, "Developer 101"),
                new Membru(212, "Developer 212"),
                new Membru(531, "Developer 531")
            };
		
		List<Membru> listaMembriDeFiltrat = Arrays.asList(membri);
		// Care este membrul cu id-ul cel mai mare?
		Membru maxMembru = Collections.max(listaMembriDeFiltrat, new ComparatorMembriID());
		System.out.println("- membrul cu id-ul cel mai mare: " + maxMembru);
		// Care este membrul cu id-ul 301?
		Membru Membru_301 = Collections.max(listaMembriDeFiltrat, new ComparatorMembri_301());
		System.out.println("- membrul cu id-ul 301: " + Membru_301);
		// Care este membrul cu id-ul 401? - var 1
		Membru Membru_401 = Collections.max(listaMembriDeFiltrat, new ComparatorMembri_ID("401"));
		System.out.println("- membrul cu id-ul 401: " + Membru_401);		
		// Care sunt membrii cu id-ul 401 ? - var 2
		Membru_401 = Collections.max(listaMembriDeFiltrat, 
			new Comparator<Membru>(){
				String idStringComparator = "401";
				public int compare(Membru c1, Membru c2) {
					return (c2.getIdMembru().equals(idStringComparator)?1:-1);
				}				
			}
		);
		System.out.println("- membrul cu id-ul 401: " + Membru_401);		
		
		// Care sunt membri cu id-uri de forma 4** ?
		FiltruMembri filtruMembri = new FiltruMembri();
		Collection<Membru> membriFiltrati = CollectionUtils.select(listaMembriDeFiltrat, filtruMembri);
		for(Membru c: membriFiltrati)
			System.out.println("Membru rezultat:" + c.getNumePrenume());
		
	}

}
/*-------------------------------------------------------------*/
// Comparator pentru aflarea membrului cu id-ul (numeric) cel mai mare
class ComparatorMembriID implements Comparator<Membru>{
	@Override
	public int compare(Membru c1, Membru c2) {
		return c1.getIdMembru().compareTo(c2.getIdMembru());
	}
}
/*-------------------------------------------------------------*/
// Comparator pentru aflarea membrului cu id-ul 301
class ComparatorMembri_301 implements Comparator<Membru>{
	@Override
	public int compare(Membru c1, Membru c2) {
		return (c2.getIdMembru().equals(301)?1:-1);
	}
}
/*-------------------------------------------------------------*/
class ComparatorMembri_ID implements Comparator<Membru>{
	private String IDCompartor;
	public ComparatorMembri_ID(String codCompartor){
		this.IDCompartor = codCompartor;
	}
	@Override
	public int compare(Membru c1, Membru c2) {
		return (c2.getIdMembru().equals(IDCompartor)?1:0);
	}
	
}
/*-------------------------------------------------------------*/
class ComparatorMembri_StartWith implements Comparator<Membru>{
	@Override
	public int compare(Membru c1, Membru c2) {
		String idString1 = String.valueOf(c1.getIdMembru());
		String idString2 = String.valueOf(c2.getIdMembru());
		return (idString2.startsWith("4")?0:1);
	}	
}
/*-------------------------------------------------------------*/
class FiltruMembri implements Predicate{
	@Override
	public boolean evaluate(Object obj) {
		Membru membru = (Membru) obj;
		String idString = String.valueOf(membru.getIdMembru());
		return idString.startsWith("4");
	}
}


