package cap3.exemplu18_19_20_21_22;

import java.util.*;
import java.text.*;

//Listing 3.22: Test ordonare chei în TreeMap

public class TestTreeMapConturi {
    public static void main(String[] args){

        Cont[] conturi = {
            new Cont("301", "Materii prime"),
            new Cont("401", "Furnizori"),
            new Cont("101", "Capital"),
            new Cont("212", "Constructii"),
            new Cont("531", "Casa")
        };

        Map<String, Cont> mapConturiOrdonateDupaCod  =
		new TreeMap<String, Cont>();
        for (Cont c : conturi){
            mapConturiOrdonateDupaCod.put(c.getCod(), c);
        }


        // Ordonare conturi dupa cod
        System.out.println("Ordonare conturi dupa cod: ");
        for (String cod : mapConturiOrdonateDupaCod.keySet()){
           System.out.println(mapConturiOrdonateDupaCod.get(cod));
        }

        Map<String, Cont> mapConturiOrdonateDupaDenumire = 
		new TreeMap<String, Cont>();
        for (Cont c : conturi){
            mapConturiOrdonateDupaDenumire
				.put(c.getDenumire(), c);
        }
        // Ordonare conturi dupa denumire
        System.out.println("Ordonare conturi dupa denumire: ");
        for (String denumire : 
			mapConturiOrdonateDupaDenumire.keySet()){
		System.out.println(mapConturiOrdonateDupaDenumire
			.get(denumire));
        }

    }
}
