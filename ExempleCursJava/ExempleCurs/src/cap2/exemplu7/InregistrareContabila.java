package cap2.exemplu7;

public class InregistrareContabila {
	// variabile de instanţă moştenite
	private Integer id;
	private Integer nrOrdine;
	private String tip; // discriminator debit, credit
	private Double suma;
	// referenţiere (compunere) instanţă Cont
	private Cont cont;
	// referenţiere (compunere) instanţă operaţiune
	private OperatiuneContabila operatiune;

	// proprietate Id – care va fi moştenită
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// constructori (nu se moştenesc)
	public InregistrareContabila(Integer id, Cont cont, Double suma) {
		this.id = id;
		this.tip = this.getClass().getSimpleName();
		this.suma = suma;
		this.cont = cont;
	}

	public InregistrareContabila() {
	}

	public Double getSuma() {
		// TODO Auto-generated method stub
		return null;
	}

}
