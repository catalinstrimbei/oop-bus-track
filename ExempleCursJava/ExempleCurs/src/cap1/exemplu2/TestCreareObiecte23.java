package cap1.exemplu2;

import java.util.Date;
/*
 * 
 * Initializare tablou local v1 
 * 
 */

public class TestCreareObiecte23 {
	public static void main(String args[]){
        Cont.numeOrganizatie = "Gama SA";
        Cont c_411 = new Cont("411", "Clienti");
        Cont c_5121 = new Cont("5121", "Cont banca");

        // Declarare tablou
        InregistrareContabila[] inregistrariContabile;

        // Iniţializare tablou
        inregistrariContabile = new InregistrareContabila[2];

        // Iniţializare explicită a elementelor
        inregistrariContabile[0] = new InregistrareContabila(1, 1,
                "Debit", 120.0, c_411);
        inregistrariContabile[1] = new InregistrareContabila(1, 1,
                "Credit", 120.0, c_5121);

        OperatiuneContabila o = 
				new OperatiuneContabila(1, 
					new Date(), inregistrariContabile);

        System.out.println(o.getClass() + ": o [" +
				o.idOperatiune + ", " + o.dataContabilizare + ", " +
				o.inregistrari.length + "]");

	}
}
