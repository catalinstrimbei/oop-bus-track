package cap3.ex6.org.app.scrum;

import java.util.*;
import java.text.*;

//Listing 3.22: Test ordonare chei în TreeMap

public class Test365_TreeMapMembri {
    public static void main(String[] args){

        Membru[] membri = {
                new Membru(301, "Developer 301"),
                new Membru(401, "Developer 401"),
                new Membru(101, "Developer 101"),
                new Membru(212, "Developer 212"),
                new Membru(531, "Developer 531")
            };

        Map<Integer, Membru> mapMembriOrdonatiDupaID  =
		new TreeMap<Integer, Membru>();
        for (Membru c : membri){
            mapMembriOrdonatiDupaID.put(c.getIdMembru(), c);
        }


        // Ordonare conturi dupa cod
        System.out.println("Ordonare membri dupa ID: ");
        for (Integer cod : mapMembriOrdonatiDupaID.keySet()){
           System.out.println(mapMembriOrdonatiDupaID.get(cod));
        }

        Map<String, Membru> mapMembriOrdonatiDupaNume = 
		new TreeMap<String, Membru>();
        for (Membru c : membri){
            mapMembriOrdonatiDupaNume
				.put(c.getNumePrenume(), c);
        }
        // Ordonare conturi dupa denumire
        System.out.println("Ordonare membri dupa nume: ");
        for (String nume : 
			mapMembriOrdonatiDupaNume.keySet()){
			System.out.println(mapMembriOrdonatiDupaNume
				.get(nume));
        }

    }
}
