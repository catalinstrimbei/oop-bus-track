package cap3.exemplu2;

public class InregistrareC extends InregistrareContabila {
	private Integer nrOrdine;
	public Integer getNrOrdineCredit() {
        return nrOrdine;
	}

	public InregistrareC(Integer id, Cont cont, 
									Double suma) {
        super(id, cont, suma);
        this.tip = "Credit";
	}

	public InregistrareC() {
	}

	public void setNrOrdineCredit(Integer nrOrdineCredit) {
		this.nrOrdine = nrOrdineCredit;
	}

}
