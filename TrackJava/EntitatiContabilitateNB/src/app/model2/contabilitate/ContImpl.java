/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model2.contabilitate;

/**
 *
 * @author catalin
 */
public class ContImpl implements ICont{
    // reprezentare proprietati [cod] si [denumire]
    private String cod;
    private String denumire;
    private ContImpl contParinte;
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
    public ContImpl getContParinte() {
        return contParinte;
    }
    public void setContParinte(ContImpl cont) {
        this.contParinte = cont;
    }
    // alte operatii publice
    public String getCodContParinte(){
        // desi cod este private el este accesebil in contextul clasei
        return this.contParinte.cod;
    }
    // constructor pentru obtinere valoare
    public ContImpl(String cod, String denumire) {
        this.cod = cod;
        this.denumire = denumire;
    }
}
