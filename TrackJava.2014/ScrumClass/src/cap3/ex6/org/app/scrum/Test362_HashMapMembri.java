package cap3.ex6.org.app.scrum;

//Listing 3.19: Test HashMap

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Test362_HashMapMembri {
    public static void main(String[] args){

        Integer[] ids = {301, 401, 101, 212, 531};
        Membru[] membri = {
            new Membru(301, "Developer 301"),
            new Membru(401, "Developer 401"),
            new Membru(101, "Developer 101"),
            new Membru(212, "Developer 212"),
            new Membru(531, "Developer 531")
        };
        Map<Integer, Membru> mapMembri = 
        		new HashMap<Integer, Membru>();

        // populez indicative
        for (int i=0; i<ids.length; i++)
            mapMembri.put(ids[i], membri[i]);
       // parcurg cele trei perspective ale containerului
       // mai intai cheile
       Set<Integer> chei = mapMembri.keySet();
       Iterator<Integer> iteratorChei = chei.iterator();
       System.out.println("Cheile:");
       while(iteratorChei.hasNext())
           System.out.println(iteratorChei.next());

       // apoi valorile
       Collection<Membru> valori = mapMembri.values();
       Iterator<Membru> iteratorValori = valori.iterator();
       System.out.println("Valorile:");
       while(iteratorValori.hasNext())
           System.out.println(iteratorValori.next());
       // sau
       System.out.println("Valorile din nou:");
       for(Membru v: valori)
             System.out.println(v);
       // in fine setul de perechi chei-valoare
       Set<Entry<Integer, Membru>> intrari = mapMembri.entrySet();
       Iterator<Entry<Integer, Membru>> iteratorIntrari =
		 intrari.iterator();
       System.out.println("Perechile cheie-valoare:");
       while(iteratorIntrari.hasNext()){
           java.util.Map.Entry<Integer, Membru> intrare =
                iteratorIntrari.next();
           System.out.println(intrare.getKey() + " -- " 
			+ intrare.getValue());
       }
       // sau
       System.out.println("Perechile cheie-valoare din nou:");
       for(java.util.Map.Entry<Integer, Membru> intrare: intrari)
           System.out.println(intrare.getKey() + "-" 
		+ intrare.getValue());


       // extrag o valoare cunoscindu-i cheia
       Integer id = 401;

       System.out.println("IDul " + id +
			" corespunde membrului " + mapMembri.get(id));
       
       //
       System.out.println("-------- Parcurgere prin chei");
       Set<Integer> keys = mapMembri.keySet();
       for(Integer i: keys){
    	   System.out.println("k=" + i + " -> " + mapMembri.get(i));
       }
    }
}

