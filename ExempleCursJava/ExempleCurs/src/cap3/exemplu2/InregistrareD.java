package cap3.exemplu2;

public class InregistrareD extends InregistrareContabila {
	private Integer nrOrdine;
	public int getNrOrdineDebit() {
        return nrOrdine;
	}

	// invocare constructor părinte – super
	// acces (prin protected) la membru moştenit
	public InregistrareD(Integer id, Cont cont, 
								Double suma) {
        super(id, cont, suma);
        this.tip = "Debit";
	}

	public InregistrareD(Integer nrOrdineDebit) {
		this.nrOrdine = nrOrdineDebit;
	}

	public InregistrareD() {
	}

	public void setNrOrdineDebit(Integer nrOrdineDebit) {
		this.nrOrdine = nrOrdineDebit;
	}

	
}
