package cap3.ex6.org.app.scrum;

public abstract class Cerinta implements Comparable<Cerinta>{
	
	protected Integer idCerinta;
	protected String denumire;
	protected String descriere;
	protected CategorieCerinta categorie;

	public Integer getIdCerinta() {
		return idCerinta;
	}
	public void setIdCerinta(Integer idCerinta) {
		this.idCerinta = idCerinta;
	}
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public CategorieCerinta getCategorie() {
		return categorie;
	}
	public void setCategorie(CategorieCerinta categorie) {
		this.categorie = categorie;
	}

	public Cerinta() {
		super();
	}

	public Cerinta(Integer idCerinta, String denumire) {
		super();
		this.idCerinta = idCerinta;
		this.denumire = denumire;
	}	
	
	public Cerinta(Integer idCerinta, String denumire, String descriere) {
		this(idCerinta, denumire);
		this.descriere = descriere;
	}
	
	public Cerinta(Integer idCerinta, String denumire, String descriere,
			CategorieCerinta categorie) {
		this(idCerinta, denumire, descriere);
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "Cerinta [idCerinta=" + idCerinta + ", denumire=" + denumire
				+ ", descriere=" + descriere + ", categorie=" + categorie + "]";
	}	
	
	// operatie abstracta
	public abstract String getDescriereCompleta();
	
	// implements Comparator
	@Override
	public int compareTo(Cerinta other) {
		if (this.equals(other))
			return 0;
		return this.getIdCerinta().compareTo(other.getIdCerinta());
	}	
}
