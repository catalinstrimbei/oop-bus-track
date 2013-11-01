package cap1.exemplu3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
 * 
 * Initializare colectie-variabila de instanta
 * Parcurgere elemente colectie
 * 
 */
public class TestCreareObiecte36 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO: Auto-generated method stub        
        Cont.numeOrganizatie = "Gama SA";
        Cont c_411 = new Cont("411", "Clienti");
        Cont c_5121 = new Cont("5121", "Cont banca");

        List<InregistrareContabila> inregistratiContabile =
                new ArrayList<InregistrareContabila>();
        inregistratiContabile.add(new InregistrareContabila(1, 
				1,"Debit", 120.0, c_411));
        inregistratiContabile.add(new InregistrareContabila(2, 
				1,"Credit", 120.0, c_5121));

        OperatiuneContabila o = 
				new OperatiuneContabila(1, 
					new Date(),inregistratiContabile);

        System.out.println(o.getClass() + ": o [" +
             o.idOperatiune + ", " + o.dataContabilizare + 
				", " + o.inregistrari.size() + "]");
        for (InregistrareContabila i : o.inregistrari){
            System.out.println(i.getClass() + ": i [" +
                    i.id + ", " + i.tip + ", " +
                    i.cont.cod + ", "+ i.suma + "]");
        }		
    }

}
