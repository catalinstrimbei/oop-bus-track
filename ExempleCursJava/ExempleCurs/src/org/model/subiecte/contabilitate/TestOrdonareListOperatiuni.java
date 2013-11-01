package org.model.subiecte.contabilitate;

import java.util.*;
import java.text.*;


//Listing 3.20: Test ordonare colecţii
public class TestOrdonareListOperatiuni {
    public static void main(String[] args) throws ParseException{
        SimpleDateFormat format = 
		new SimpleDateFormat("dd/MM/yyyy");

        List<OperatiuneContabila> operatiuni = 
		new ArrayList<OperatiuneContabila>();
        operatiuni.add(new OperatiuneContabila(1, 
		format.parse("01/06/2009")));
        operatiuni.add(new OperatiuneContabila(2, 
		format.parse("01/03/2009")));
        operatiuni.add(new OperatiuneContabila(3, 
		format.parse("01/02/2009")));
        operatiuni.add(new OperatiuneContabila(4, 
		format.parse("01/04/2009")));

        Collections.sort(operatiuni, 
		new ComparatorOperatiuniDupaData());
        System.out.println("Ordonare operatiuni dupa data :");
        for (OperatiuneContabila o : operatiuni)
            System.out.println(o.getIdOperatiune() + " -- " + 
                format.format(o.getDataContabilizare()));

        Collections.sort(operatiuni, 
		new ComparatorOperatiuniDupaId());
        System.out.println("Ordonare operatiuni dupa id :");
        for (OperatiuneContabila o : operatiuni)
            System.out.println(o.getIdOperatiune() + " -- " +
                format.format(o.getDataContabilizare()));

    }

    static class ComparatorOperatiuniDupaData
            implements Comparator<OperatiuneContabila>{
        public int compare(OperatiuneContabila o1, 
		OperatiuneContabila o2) {
            return o1.getDataContabilizare()
		.compareTo(o2.getDataContabilizare());
        }
    }

    static class ComparatorOperatiuniDupaId
            implements Comparator<OperatiuneContabila>{
        public int compare(OperatiuneContabila o1, 
		OperatiuneContabila o2) {
            return o1.getIdOperatiune()
		.compareTo(o2.getIdOperatiune());
        }
    }

}
