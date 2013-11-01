package cap3.exemplu11;

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
    public InregistrareContabila(Integer id, Cont cont, 
		Double suma){
        this.id = id;
        this.tip = this.getClass().getSimpleName();
        this.suma = suma;
        this.cont = cont;
    }
    public InregistrareContabila(Integer id, Cont cont) {
		this.id = id;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InregistrareContabila other = (InregistrareContabila) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
}
