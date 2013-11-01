package cap2.exemplu3;

public class ContImpl implements ICont{
    // reprezentare proprietati [cod] si [denumire]
    private String cod;
    private String denumire;

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

    // constructor pentru obtinere valoare
    public ContImpl(String cod, String denumire) {
        this.cod = cod;
        this.denumire = denumire;
    }
}
