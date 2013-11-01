package cap3.exemplu1;

public class InregistrareCredit extends InregistrareContabila {
	private Integer nrOrdineCredit;
	public Integer getNrOrdineCredit() {
        return nrOrdineCredit;
	}

	public InregistrareCredit(Integer id, Cont cont, 
									Double suma) {
        super(id, cont, suma);
        this.tip = "Credit";
	}

}
