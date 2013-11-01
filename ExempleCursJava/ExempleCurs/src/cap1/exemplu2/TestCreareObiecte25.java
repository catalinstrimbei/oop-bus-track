package cap1.exemplu2;

import java.util.Date;

/*
 * 
 * Initializare tablou-variabila de instanta
 * Parcurgere elemente tablou v2
 * 
 */
public class TestCreareObiecte25 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Cont.numeOrganizatie = "Gama SA";
        Cont c_411 = new Cont("411", "Clienti");
        Cont c_5121 = new Cont("5121", "Cont banca");

        OperatiuneContabila o = 
				new OperatiuneContabila(1, new Date(),
				new InregistrareContabila[]{
					new InregistrareContabila(1, 1,"Debit", 
						120.0, c_411),
                    new InregistrareContabila(2, 1,
						"Credit", 120.0, c_5121)
                }
               );

        System.out.println(o.getClass() + ": o [" +
				o.idOperatiune + ", " + o.dataContabilizare + ", " +
				o.inregistrari.length + "]");
        // parcurgere elemente tablou
        for (int i = 0; i < o.inregistrari.length; i++){
            System.out.println(o.inregistrari[i].getClass() +
					": i" + i + " [" + o.inregistrari[i].id + 
					", " + o.inregistrari[i].tip + ", " +
                    o.inregistrari[i].cont.cod + 
					", "+ o.inregistrari[i].suma + "]");
        }
  

	}

}
