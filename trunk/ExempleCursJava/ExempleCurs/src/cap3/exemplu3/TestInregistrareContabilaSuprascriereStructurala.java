package cap3.exemplu3;

public class TestInregistrareContabilaSuprascriereStructurala {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        InregistrareContabila inregistrareDebit = 
			new InregistrareContabila();
    inregistrareDebit.setTip("Debit");
    inregistrareDebit.setNrOrdine(1);

    InregistrareDebit iDebit = new InregistrareDebit();
    InregistrareCredit iCredit = new InregistrareCredit();

    iDebit.setNrOrdineDebit(1);
    iCredit.setNrOrdineCredit(1);

    System.out.println("iDebit.nrOrdineDebit: " 
			+ iDebit.getNrOrdineDebit());
    System.out.println("iDebit.nrOrdine: " 
			+ iDebit.getNrOrdine());
	}

}
