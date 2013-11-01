package cap3.exemplu18_19_20_21_22;

public class InregistrareDebit extends InregistrareContabila{
	private Integer nrOrdine;
	public int getNrOrdineDebit() {
        return nrOrdine;
	}

	// constructori -------------------------------------------------
	public InregistrareDebit() {
	}	
	public InregistrareDebit(Integer id, Cont cont) {
		super(id, cont);
		this.tip = "Debit";
	}
	
	public InregistrareDebit(Integer id, Cont cont, 
								Double suma) {
        this(id, cont);
        this.suma = suma;
        this.tip = "Debit";
	}
	//-----------------------------------------------------------------
	
	public InregistrareDebit(Integer nrOrdineDebit) {
		this.nrOrdine = nrOrdineDebit;
	}



	public void setNrOrdineDebit(Integer nrOrdineDebit) {
		this.nrOrdine = nrOrdineDebit;
	}

}
