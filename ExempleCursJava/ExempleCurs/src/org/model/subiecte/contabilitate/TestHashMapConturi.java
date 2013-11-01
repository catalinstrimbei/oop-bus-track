package org.model.subiecte.contabilitate;

//Listing 3.19: Test HashMap

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestHashMapConturi {
    public static void main(String[] args){

        String[] coduri = {"301", "401", "101", "212", "531"};
        Cont[] conturi = {
            new Cont("301", "Materii prime"),
            new Cont("401", "Furnizori"),
            new Cont("101", "Capital"),
            new Cont("212", "Constructii"),
            new Cont("531", "Casa")
        };
        Map<String, Cont> mapConturi = 
		new HashMap<String, Cont>();

        // populez indicative
        for (int i=0; i<coduri.length; i++)
            mapConturi.put(coduri[i], conturi[i]);
       // parcurg cele trei perspective ale containerului
       // mai intai cheile
       Set<String> chei = mapConturi.keySet();
       Iterator<String> iteratorChei = chei.iterator();
       System.out.println("Cheile:");
       while(iteratorChei.hasNext())
           System.out.println(iteratorChei.next());

       // apoi valorile
       Collection<Cont> valori = mapConturi.values();
       Iterator<Cont> iteratorValori = valori.iterator();
       System.out.println("Valorile:");
       while(iteratorValori.hasNext())
           System.out.println(iteratorValori.next());
       // sau
       System.out.println("Valorile din nou:");
       for(Cont v: valori)
             System.out.println(v);
       // in fine setul de perechi chei-valoare
       Set<Entry<String, Cont>> intrari = mapConturi.entrySet();
       Iterator<Entry<String, Cont>> iteratorIntrari =
		 intrari.iterator();
       System.out.println("Perechile cheie-valoare:");
       while(iteratorIntrari.hasNext()){
           java.util.Map.Entry<String, Cont> intrare =
                iteratorIntrari.next();
           System.out.println(intrare.getKey() + " -- " 
			+ intrare.getValue());
       }
       // sau
       System.out.println("Perechile cheie-valoare din nou:");
       for(java.util.Map.Entry<String, Cont> intrare: intrari)
           System.out.println(intrare.getKey() + "-" 
		+ intrare.getValue());


       // extrag o valoare cunoscindu-i cheia
       String id = "401";

       System.out.println("Codul " + id +
			" corespunde contului " + mapConturi.get(id));
    }
}

