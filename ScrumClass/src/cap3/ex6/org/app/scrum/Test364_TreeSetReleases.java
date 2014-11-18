package cap3.ex6.org.app.scrum;

import java.util.*;
import java.text.*;

//Listing 3.21: Test ordonare în TreeSet
public class Test364_TreeSetReleases {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = 
		new SimpleDateFormat("dd/MM/yyyy");
        Collection<Release> releases = 
		new TreeSet<Release>();
        releases.add(new Release(1, 
        		format.parse("01/06/2009")));
        releases.add(new Release(2, 
        		format.parse("01/03/2009")));
        releases.add(new Release(3, 
        		format.parse("01/02/2009")));
        releases.add(new Release(4, 
        		format.parse("01/04/2009")));

        System.out.println("Ordonare release-uri dupa data :");
        for (Release o : releases) {
            System.out.println(o.getIdRelease() + " -- " +
                    format.format(o.getDataPublicare()));
        }
    }
}

