/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model.contabilitate;

import app.model.contabilitate.conturi.Cont;
import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 *
 * @author catalin
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tip")
public class InregistrareContabila implements Comparable, Serializable{
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    protected Integer nrOrdine;
    //private String tip; // debit, credit
    protected Double suma;

    @ManyToOne @JoinColumn(name = "id_cont")
    private Cont cont;

    @ManyToOne @JoinColumn(name = "id_operatiune")
    private OperatiuneContabila operatiune;

    public Cont getCont() {
        return cont;
    }

    public void setCont(Cont cont) {
        this.cont = cont;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNrOrdine() {
        return nrOrdine;
    }

    public void setNrOrdine(Integer nrOrdine) {
        this.nrOrdine = nrOrdine;
    }

    public OperatiuneContabila getOperatiune() {
        return operatiune;
    }

    public void setOperatiune(OperatiuneContabila operatiune) {
        this.operatiune = operatiune;
    }

    public Double getSuma() {
        return suma;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }

    /*public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }*/

    public InregistrareContabila(Integer id, Cont cont){
        this.id = id;
        //this.tip = this.getClass().getSimpleName();
        this.cont = cont;
    }
    public InregistrareContabila(Integer id, Cont cont, Double suma){
        this(id, cont);
        this.suma = suma;
    }

    public InregistrareContabila(Cont cont, Double suma){
        this.cont = cont;
        this.suma = suma;
    }

    public InregistrareContabila() {
    }

    @Override
    public String toString() {
        return this.nrOrdine + " - " + this.getClass().getSimpleName() + " - "
                + this.cont.getCod() + " - " + this.cont.getDenumire()
                + "- " + this.suma;
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            throw new RuntimeException("Compare to null !!");
        }
        if (getClass() != obj.getClass()) {
            throw new RuntimeException("Incomparable types !!");
        }
        final InregistrareContabila other = (InregistrareContabila) obj;

        return this.nrOrdine.compareTo(other.getNrOrdine());
    }


    
}
