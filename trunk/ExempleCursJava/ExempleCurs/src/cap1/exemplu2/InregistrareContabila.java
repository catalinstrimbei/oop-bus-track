package cap1.exemplu2;

public class InregistrareContabila {
    Integer id;
    Integer nrOrdine;
    String tip; // domeniu legal: debit, credit
    Double suma;
    
    // membru referinta
    Cont cont;

    public InregistrareContabila() {
    }

    public InregistrareContabila(Integer id, 
				Integer nrOrdine, String tip, 
				Double suma, Cont cont) {
        this.id = id;
        this.nrOrdine = nrOrdine;
        this.tip = tip;
        this.suma = suma;
        this.cont = cont;
    }

    public InregistrareContabila(Integer id, 
				Integer nrOrdine, String tip, 
				Float suma, Cont cont) {
        this.id = id;
        this.nrOrdine = nrOrdine;
        this.tip = tip;
        //this.suma = suma;
        this.cont = cont;
    }
    
}
