package cap3.ex6.org.app.scrum;

import java.util.*;
import java.text.*;


//Listing 3.20: Test ordonare colectii: Releases
public class Test363_OrdonareListReleases {
    public static void main(String[] args) throws ParseException{
        SimpleDateFormat format = 
		new SimpleDateFormat("dd/MM/yyyy");

        List<Release> releases = 
		new ArrayList<Release>();
        releases.add(new Release(1, 
        		format.parse("01/06/2009")));
        releases.add(new Release(2, 
        		format.parse("01/03/2009")));
        releases.add(new Release(3, 
        		format.parse("01/02/2009")));
        releases.add(new Release(4, 
        		format.parse("01/04/2009")));

        Collections.sort(releases, 
		new ComparatorReleasesDupaData());
        System.out.println("Ordonare release-uri dupa data :");
        for (Release o : releases)
            System.out.println(o.getIdRelease() + " -- " + 
                format.format(o.getDataPublicare()));

        Collections.sort(releases, 
		new ComparatorReleasesDupaId());
        System.out.println("Ordonare release-uri dupa id :");
        for (Release o : releases)
            System.out.println(o.getIdRelease() + " -- " +
                format.format(o.getDataPublicare()));

    }

    static class ComparatorReleasesDupaData
            implements Comparator<Release>{
        public int compare(Release o1, 
        		Release o2) {
            return o1.getDataPublicare()
		.compareTo(o2.getDataPublicare());
        }
    }

    static class ComparatorReleasesDupaId
            implements Comparator<Release>{
        public int compare(Release o1, 
        		Release o2) {
            return o1.getIdRelease()
		.compareTo(o2.getIdRelease());
        }
    }

}
