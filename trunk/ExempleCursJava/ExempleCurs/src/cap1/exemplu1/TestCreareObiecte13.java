package cap1.exemplu1;

public class TestCreareObiecte13 {

	/**
	 * @param args
	 * 
	 * Initializare explicita variabile de intanta referinte
	 * Initializare implicita variabile de intanta referinte
	 * 
	 */
	public static void main(String[] args) {
        Cont.numeOrganizatie = "Gama SA";
        Cont c_411 = new Cont();
        c_411.cod = "411";
        c_411.denumire = "Clienti";
        System.out.println(c_411.getClass() + ": c_411 [" +
                c_411.cod + ", " + c_411.denumire
                + ", " + c_411.numeOrganizatie + "]");

        Cont c_5121 = new Cont();
        c_5121.cod = "5121";
        c_5121.denumire = "Cont banca";
        System.out.println(c_5121.getClass() + ": c_401 [" +
                c_5121.cod + ", " + c_5121.denumire
                + ", " + c_5121.numeOrganizatie + "]");

        InregistrareContabila i1 = new InregistrareContabila();
        i1.id = 1;
        i1.nrOrdine = 1;
        i1.tip = "Debit";
        i1.suma = 120.0;
        System.out.println(i1.getClass() + ": i1 inainte [" +
                i1.id + ", " + i1.tip + ", " +
                i1.cont + ", " + i1.suma + "]");
        i1.cont = c_411;
        System.out.println(i1.getClass() + ": i1 dupa [" +
                i1.id + ", " + i1.tip + ", " +
                i1.cont.cod + ", " + i1.suma + "]");

        InregistrareContabila i2 = new InregistrareContabila();
        i2.id = 2;
        i2.nrOrdine = 1;
        i2.tip = "Credit";
        i2.suma = 120.0;
        System.out.println(i2.getClass() + ": i2 inainte [" +
                i2.id + ", " + i2.tip + ", " +
                i2.cont + ", "+ i2.suma + "]");
        i2.cont = c_5121;
        System.out.println(i2.getClass() + ": i2 dupa [" +
                i2.id + ", " + i2.tip + ", " +
                i2.cont.cod + ", "+ i2.suma + "]");

        OperatiuneContabila o = new OperatiuneContabila();
        o.idOperatiune = 1;
        o.dataContabilizare = new java.util.Date();// data curenta
        System.out.println(o.getClass() + ": o ["
				+ o.idOperatiune + ", " 
				+ o.dataContabilizare + "]");
		
    }

}
