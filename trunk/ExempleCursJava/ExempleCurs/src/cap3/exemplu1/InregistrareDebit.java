package cap3.exemplu1;

public class InregistrareDebit extends InregistrareContabila {
	private Integer nrOrdineDebit;
	public int getNrOrdineDebit() {
        return nrOrdineDebit;
	}

	// invocare constructor părinte – super
	// acces (prin protected) la membru moştenit
	public InregistrareDebit(Integer id, Cont cont, 
								Double suma) {
        super(id, cont, suma);
        this.tip = "Debit";
	}

}
