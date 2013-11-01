package cap1.exemplu2;

import java.util.Date;

/*
 * 
 * Initializare tablou local v2
 * Parcurgere elemente tablou v1
 * 
 */


public class TestCreareObiecte24 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Cont.numeOrganizatie = "Gama SA";
        Cont c_411 = new Cont("411", "Clienti");
        Cont c_5121 = new Cont("5121", "Cont banca");

        InregistrareContabila[] inregistrariContabile =
			{
			  new InregistrareContabila(1, 1,"Debit", 120.0, c_411),
			  new InregistrareContabila(2, 1,"Credit", 120.0, c_5121)
			};

        OperatiuneContabila o = 
				new OperatiuneContabila(1, new Date(),
					inregistrariContabile);

        System.out.println(o.getClass() + ": o [" +
				o.idOperatiune + ", " + o.dataContabilizare + ", " +
				o.inregistrari.length + "]");

        // parcurgere elemente tablou 
		for (InregistrareContabila i : o.inregistrari){
            System.out.println(i.getClass() + ": i [" +
                    i.id + ", " + i.tip + ", " +
                    i.cont.cod + ", "+ i.suma + "]");
        }


	}

}
