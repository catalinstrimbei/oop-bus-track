package cap3.exemplu1;

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
}

