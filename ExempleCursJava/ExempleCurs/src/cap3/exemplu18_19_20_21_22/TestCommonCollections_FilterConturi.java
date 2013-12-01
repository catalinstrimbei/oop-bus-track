package cap3.exemplu18_19_20_21_22;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

public class TestCommonCollections_FilterConturi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Creare lista conturi de filtrat
        Cont[] conturi = {
                new Cont("301", "Materii prime"),
                new Cont("401", "Furnizori"),
                new Cont("411", "Clienti"),
                new Cont("101", "Capital"),
                new Cont("212", "Constructii"),
                new Cont("531", "Casa")
            };
		List<Cont> listaConturiDeFiltrat = Arrays.asList(conturi);
		// Care este contul cu codul cel mai mare?
		Cont maxCont = Collections.max(listaConturiDeFiltrat, new ComparatorConturiCod());
		System.out.println("- Contul cu codul cel mai mare: " + maxCont);
		// Care este contul cu codul 301?
		Cont cont_301 = Collections.max(listaConturiDeFiltrat, new ComparatorConturi_301());
		System.out.println("- Contul cu codul 301: " + cont_301);
		// Care este contul cu codul 401? - var 1
		Cont cont_401 = Collections.max(listaConturiDeFiltrat, new ComparatorConturi_cod("401"));
		System.out.println("- Contul cu codul 401: " + cont_401);		
		// Care sunt conturile din clasa 4? - var 2
		cont_401 = Collections.max(listaConturiDeFiltrat, 
			new Comparator<Cont>(){
				String codComparator = "401";
				public int compare(Cont c1, Cont c2) {
					return (c2.getCod().equals(codComparator)?1:0);
				}				
			}
		);
		System.out.println("- Contul cu codul 401: " + cont_401);		
		
		// Care sunt conturile din clasa 4?
		FiltruConturi filtruConturi = new FiltruConturi();
		Collection<Cont> conturiFiltrate = CollectionUtils.select(listaConturiDeFiltrat, filtruConturi);
		for(Cont c: conturiFiltrate)
			System.out.println("Cont rezultat:" + c.getDenumire());
		
		
		
		
	}

}
/*-------------------------------------------------------------*/
// Comparator conturi pentru aflarea contului cu codul (numeric) cel mai mare
class ComparatorConturiCod implements Comparator<Cont>{
	@Override
	public int compare(Cont c1, Cont c2) {
		return Integer.valueOf(c1.getCod()).compareTo(Integer.valueOf(c2.getCod()));
	}
}
/*-------------------------------------------------------------*/
// Comparator conturi pentru aflarea contului cu codul 301
class ComparatorConturi_301 implements Comparator<Cont>{
	@Override
	public int compare(Cont c1, Cont c2) {
		return (c2.getCod().equals("301")?1:0);
	}
}
/*-------------------------------------------------------------*/
class ComparatorConturi_cod implements Comparator<Cont>{
	private String codCompartor;
	public ComparatorConturi_cod(String codCompartor){
		this.codCompartor = codCompartor;
	}
	@Override
	public int compare(Cont c1, Cont c2) {
		return (c2.getCod().equals(codCompartor)?1:0);
	}
	
}
/*-------------------------------------------------------------*/
class ComparatorConturi_clasa implements Comparator<Cont>{
	@Override
	public int compare(Cont c1, Cont c2) {
		return (c2.getCod().startsWith("4")?0:1);
	}	
}
/*-------------------------------------------------------------*/
class FiltruConturi implements Predicate{
	@Override
	public boolean evaluate(Object arg0) {
		Cont cont = (Cont) arg0;
		return cont.getCod().startsWith("4");
	}
}

