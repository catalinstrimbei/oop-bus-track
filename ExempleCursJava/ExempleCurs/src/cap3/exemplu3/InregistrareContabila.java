package cap3.exemplu3;

//Superclasa InregistrareContabilă
public class InregistrareContabila {
    private Integer id;
    private Integer nrOrdine;
    protected String tip; // discriminator debit, credit
    protected Double suma;
    private Cont cont;
    private OperatiuneContabila operatiune;	
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    // constructori (nu se mostenesc)
	public InregistrareContabila() {
    }   
    public InregistrareContabila(Integer id, Cont cont) {
		this.id = id;
		this.cont = cont;
	}	
    public InregistrareContabila(Integer id, Cont cont, 
		Double suma){
        this(id, cont);
        this.suma = suma;
    }

    //--------------------------------------------
    
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

