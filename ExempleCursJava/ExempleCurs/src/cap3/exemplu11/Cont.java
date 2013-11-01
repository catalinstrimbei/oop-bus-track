package cap3.exemplu11;

public class Cont {
    // reprezentare proprietati [cod] si [denumire]
    private String cod, denumire;
    private Cont contParinte;
    private Double sold = 0.0;
    // implementare conventie
    //  - incapsulare reprezentare interna
    //  - reprezentare externa prin proprietati JavaBean
    public String getCod() {
        return cod;
    }
    public String getDenumire() {
        return denumire;
    }
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }
    public Double getSold() {
        return sold;
    }
    public void setSold(Double sold) {
        this.sold = sold;
    }
    public Cont getContParinte() {
        return contParinte;
    }
    public void setContParinte(Cont cont) {
        this.contParinte = cont;
    }
    public String getCodContParinte(){
        // desi cod este private 
			// el este accesebil in contextul clasei
        return this.contParinte.cod;
    }
    // constructor pentru obtinere valoare
    public Cont(String cod, String denumire) {
        this.cod = cod;
        this.denumire = denumire;
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
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
		Cont other = (Cont) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}
    
    
}