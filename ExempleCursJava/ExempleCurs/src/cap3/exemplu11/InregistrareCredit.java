package cap3.exemplu11;

public class InregistrareCredit extends InregistrareContabila {
	private Integer nrOrdine;
	public Integer getNrOrdineCredit() {
        return nrOrdine;
	}

	// constructori -------------------------------------------------
	public InregistrareCredit() {
	}	
	public InregistrareCredit(Integer id, Cont cont) {
		super(id, cont);
		this.tip = "Debit";
	}
	
	public InregistrareCredit(Integer id, Cont cont, 
								Double suma) {
        this(id, cont);
        this.suma = suma;
        this.tip = "Debit";
	}
	//-----------------------------------------------------------------

	public void setNrOrdineCredit(Integer nrOrdineCredit) {
		this.nrOrdine = nrOrdineCredit;
	}
}
