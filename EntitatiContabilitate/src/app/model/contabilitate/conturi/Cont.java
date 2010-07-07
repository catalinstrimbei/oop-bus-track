/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model.contabilitate.conturi;

import app.exceptii.ExceptieValidare;
import app.model.validare.StringInitCapValidation;
import app.model.validare.Validatable;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author catalin
 */
@Entity
public class Cont implements Comparable, Serializable, Validatable{
    @Id
    private String cod;
    private String denumire;

    @ManyToOne(cascade=CascadeType.PERSIST) @JoinColumn(name = "id_sub_clasa")
    private ClasaConturi subClasaCont;

    @ManyToOne @JoinColumn(name = "id_cont_parinte")
    private Cont contParinte;
    
    private boolean sintetic;


    /*/-------------------------------------------------//
    @ManyToMany(mappedBy="operatiune")
    private List<OperatiuneContabila> operatiuni = new ArrayList<OperatiuneContabila>();
    //-------------------------------------------------/*/

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        if (cod == null)
            throw new ExceptieValidare("Codul contului nu poate fi null!");
        if (!Character.isDigit(cod.charAt(0)))
            throw new ExceptieValidare("Codul contului trebuie sa inceapa cu o cifra!");

        this.cod = cod;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        if (denumire == null)
            throw new ExceptieValidare("Denumirea contului nu poate fi null!");
        /*if (!denumire.substring(0, 1).toUpperCase()
                .concat(denumire.substring(1).toLowerCase()).equals(denumire))
            throw new ExceptieValidare("Denumirea contului trebuie scrisa incepind cu majuscula ci restul caracterelor mici!");*/

        new StringInitCapValidation("Denumirea contului trebuie scrisa cu  majuscula !").validate(denumire);
        
        this.denumire = denumire;
    }

    public ClasaConturi getSubClasaCont() {
        return subClasaCont;
    }

    public void setSubClasaCont(ClasaConturi clasaCont) {
        this.subClasaCont = clasaCont;
    }

    public Cont getContParinte() {
        return contParinte;
    }

    public void setContParinte(Cont contParinte) {
        this.contParinte = contParinte;
    }

    public boolean isSintetic() {
        return sintetic;
    }

    public void setSintetic(boolean sintetic) {
        this.sintetic = sintetic;
    }

    public Cont() {
    }

    public Cont(String cod, String denumire) {
        //this.cod = cod;
        this.setCod(cod);
        this.setDenumire(denumire);
    }

    /*public Cont(String cod, String denumire, ClasaConturi subClasaCont, Cont contParinte) {
        this.cod = cod;
        this.denumire = denumire;
        this.subClasaCont = subClasaCont;
        this.contParinte = contParinte;
    }*/

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cont other = (Cont) obj;
        if (
              (this.cod == null) ?
                  (other.cod != null) :
                  !this.cod.equals(other.cod)) {
            return false;
        }
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.cod != null ? this.cod.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Cont " + cod + " - " + denumire;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            throw new RuntimeException("Compare to null !!");
        }
        if (getClass() != obj.getClass()) {
            throw new RuntimeException("Incomparable types !!");
        }
        final Cont other = (Cont) obj;

        return this.getCod().compareTo(other.getCod());
    }

    public boolean isValid(){
        if (this.getContParinte()==null && this.getSubClasaCont()==null)
            throw new ExceptieValidare("Cont invalid: verificati ierarhia planului contabil !");
        return true;
    }

}
