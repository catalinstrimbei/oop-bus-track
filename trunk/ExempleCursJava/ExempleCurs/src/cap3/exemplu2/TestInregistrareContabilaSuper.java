package cap3.exemplu2;

public class TestInregistrareContabilaSuper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        InregistrareContabila inregistrareDebit = 
			new InregistrareContabila();
    inregistrareDebit.setTip("Debit");
    inregistrareDebit.setNrOrdine(1);

    InregistrareD iDebit = new InregistrareD();
    InregistrareC iCredit = new InregistrareC();

    iDebit.setNrOrdineDebit(1);
    iCredit.setNrOrdineCredit(1);

    System.out.println("iDebit.nrOrdineDebit: " 
			+ iDebit.getNrOrdineDebit());
    System.out.println("iDebit.nrOrdine: " 
			+ iDebit.getNrOrdine());
	}

}
