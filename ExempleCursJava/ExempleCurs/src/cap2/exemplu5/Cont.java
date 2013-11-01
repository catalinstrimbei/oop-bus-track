package cap2.exemplu5;

public class Cont implements ICont{
    // reprezentare proprietati [cod] si [denumire]
    private String cod, denumire;
    private Cont contParinte;
    private Double sold = 0.0;
    
    private CategorieCont categorie = CategorieCont.ACTIV;
    
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
}

