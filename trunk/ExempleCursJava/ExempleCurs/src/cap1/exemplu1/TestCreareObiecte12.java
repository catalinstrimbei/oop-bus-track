package cap1.exemplu1;

public class TestCreareObiecte12 {

	/**
	 * @param args
	 * 
	 * Initializare variabile de clasa (membri statici).
	 * Initializare variabile interne.
	 * Initializare variabile de instanta.
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

        Cont c_401 = new Cont();
        c_401.cod = "401";
        c_401.denumire = "Furnizori";
        System.out.println(c_401.getClass() + ": c_401 [" +
                c_401.cod + ", " + c_401.denumire
                + ", " + c_401.numeOrganizatie + "]");

        InregistrareContabila i1 = new InregistrareContabila();
        i1.id = 1;
        i1.nrOrdine = 1;
        i1.tip = "Debit";
        i1.suma = 120.0;
        System.out.println(i1.getClass() + ": i1 [" +
                i1.id + ", " + i1.tip + ", " + i1.suma + "]");

        InregistrareContabila i2 = new InregistrareContabila();
        i2.id = 2;
        i2.nrOrdine = 1;
        i2.tip = "Credit";
        i2.suma = 120.0;
        System.out.println(i2.getClass() + ": i2 [" +
                i2.id + ", " + i2.tip + ", " + i2.suma + "]");

        OperatiuneContabila o = new OperatiuneContabila();
        o.idOperatiune = 1;
        o.dataContabilizare = new java.util.Date(); // data curenta
        System.out.println(o.getClass() + ": o [" +
				o.idOperatiune + ", " + 
				o.dataContabilizare + "]");
		
    }

}
