package org.model.subiecte.contabilitate;

import java.util.*;
import java.text.*;

//Listing 3.21: Test ordonare în TreeSet
public class TestTreeSetOperatiuni {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = 
		new SimpleDateFormat("dd/MM/yyyy");
        Collection<OperatiuneContabila> operatiuni = 
		new TreeSet<OperatiuneContabila>();
        operatiuni.add(new OperatiuneContabila(1, 
		format.parse("01/06/2009")));
        operatiuni.add(new OperatiuneContabila(2, 
		format.parse("01/03/2009")));
        operatiuni.add(new OperatiuneContabila(3, 
		format.parse("01/02/2009")));
        operatiuni.add(new OperatiuneContabila(4, 
		format.parse("01/04/2009")));

        System.out.println("Ordonare operatiuni dupa data :");
        for (OperatiuneContabila o : operatiuni) {
            System.out.println(o.getIdOperatiune() + " -- " +
                    format.format(o.getDataContabilizare()));
        }
    }
}

