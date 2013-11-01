package cap1.exemplu2;

import java.util.Date;

public class TestCreareObiecte22 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Cont.numeOrganizatie = "Gama SA";
        Cont c_411 = new Cont("411", "Clienti");
        System.out.println(c_411.getClass() + ": c_411 [" +
                c_411.cod + ", " + c_411.denumire
                + ", " + c_411.numeOrganizatie + "]");

        Cont c_5121 = new Cont("5121", "Cont banca");
        System.out.println(c_5121.getClass() + ": c_401 [" +
                c_5121.cod + ", " + c_5121.denumire
                + ", " + c_5121.numeOrganizatie + "]");

        InregistrareContabila i1 = new InregistrareContabila(1, 1,
                "Debit", 120.0, c_411);
        System.out.println(i1.getClass() + ": i1 [" +
                i1.id + ", " + i1.tip + ", " +
                i1.cont.cod + ", " + i1.suma + "]");

        InregistrareContabila i2 = new InregistrareContabila(1, 1,
                "Credit", 120.0, c_5121);
        System.out.println(i2.getClass() + ": i2 [" +
                i2.id + ", " + i2.tip + ", " +
                i2.cont.cod + ", "+ i2.suma + "]");

        OperatiuneContabila o = 
				new OperatiuneContabila(1, new Date(), null);
        System.out.println(o.getClass() + ": o [" +
				o.idOperatiune + ", " + o.dataContabilizare + "]");
	}

}
