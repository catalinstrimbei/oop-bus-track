package cap1.exemplu1;

public class TestCreareObiecte11 {

	/**
	 * @param args
	 * 
	 * Creare obiecte prin instructiunea new
	 */
	public static void main(String[] args) {
        Cont c_411 = new Cont();
        System.out.println(c_411.getClass() + ": c_411 [" +
                c_411.cod + ", " + c_411.denumire
                + ", " + c_411.numeOrganizatie + "]");        

        Cont c_401 = new Cont();

        InregistrareContabila i1 = new InregistrareContabila();

        InregistrareContabila i2 = new InregistrareContabila();

        OperatiuneContabila o = new OperatiuneContabila();
    }

}
