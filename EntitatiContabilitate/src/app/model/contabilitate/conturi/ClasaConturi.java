/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model.contabilitate.conturi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author catalin
 */

@Entity
public class ClasaConturi implements Serializable{
    @Id
    private String cod;
    private String denumire;

    @ManyToOne(cascade=CascadeType.PERSIST) @JoinColumn(name = "id_clasa_parinte")
    private ClasaConturi clasaParinte;

    @OneToMany(mappedBy = "subClasaCont")
    private List<Cont> conturi;

    public boolean isClasaConturiRadacina(){
        return (clasaParinte==null) ? true : false;
    }

    public ClasaConturi getClasaParinte() {
        return clasaParinte;
    }

    public void setClasaParinte(ClasaConturi clasaParinte) {
        //if (clasaParinte.isClasaConturiRadacina())
        this.clasaParinte = clasaParinte;
        // else Exception
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public List<Cont> getConturi() {
        return conturi;
    }

    public void setConturi(List<Cont> conturi) {
        if (!isClasaConturiRadacina()){
            this.conturi = conturi;
        }
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        //new StringInitCapValidation(denumire,
        //        "Denumirea clasei trebuie scrisa cu  majuscula !").validate();
        this.denumire = denumire;
    }

    public ClasaConturi() {
    }

    public ClasaConturi(String cod, String denumire) {
        this.setCod(cod);
        this.setDenumire(denumire);
    }

    public void addCont(Cont cont){
        if (!isClasaConturiRadacina()){
            if (this.conturi == null)
                this.conturi = new ArrayList<Cont>();
            if (this.conturi.contains(cont))
                return;
            this.conturi.add(cont);
            cont.setSubClasaCont(this);
        }
    }

    public void removeCont(Cont cont){
        this.conturi.remove(cont);
    }
}
