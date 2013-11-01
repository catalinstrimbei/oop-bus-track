package cap3.exemplu2;

//Superclasa InregistrareContabilă
public class InregistrareContabila {
    private Integer id;
    private Integer nrOrdine;
    protected String tip; // discriminator debit, credit
    private Double suma;
    private Cont cont;
    private OperatiuneContabila operatiune;	
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    // constructori (nu se moştenesc)
    public InregistrareContabila(Integer id, Cont cont, 
		Double suma){
        this.id = id;
        this.tip = this.getClass().getSimpleName();
        this.suma = suma;
        this.cont = cont;
    }
    public InregistrareContabila() {
    }
	public Integer getNrOrdine() {
		return nrOrdine;
	}
	public void setNrOrdine(Integer nrOrdine) {
		this.nrOrdine = nrOrdine;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public Double getSuma() {
		return suma;
	}
	public void setSuma(Double suma) {
		this.suma = suma;
	}
	public Cont getCont() {
		return cont;
	}
	public void setCont(Cont cont) {
		this.cont = cont;
	}
	public OperatiuneContabila getOperatiune() {
		return operatiune;
	}
	public void setOperatiune(OperatiuneContabila operatiune) {
		this.operatiune = operatiune;
	}
    
    
}

