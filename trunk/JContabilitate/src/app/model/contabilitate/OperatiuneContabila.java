/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model.contabilitate;

import app.exceptii.ExceptieValidare;
import app.model.validare.Validatable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author catalin
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class OperatiuneContabila implements Comparable, Serializable, Validatable{
    @Id
    private Integer idOperatiune;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataContabilizare;

    /*/--------------------------------------------------//
    @ManyToMany
    @JoinTable(joinColumns=@JoinColumn(name="id_operatiune"),
        inverseJoinColumns=@JoinColumn(name="cod_cont"))
    private List<Cont> conturi = new ArrayList<Cont>();
    //--------------------------------------------------/*/


    public OperatiuneContabila() {
    }

    public OperatiuneContabila(Integer idOperatiune, Date dataContabilizare) {
        this.idOperatiune = idOperatiune;
        this.dataContabilizare = dataContabilizare;
    }

    @OneToMany(mappedBy = "operatiune", cascade=CascadeType.ALL) @MapKey(name = "id")
    private Map<Integer, InregistrareContabila> inregistrari =
            new TreeMap<Integer, InregistrareContabila>();

    public Date getDataContabilizare() {
        return dataContabilizare;
    }

    public void setDataContabilizare(Date dataContabilizare) {
        this.dataContabilizare = dataContabilizare;
    }

    public List<InregistrareContabila> getInregistrari() {
        List<InregistrareContabila> result = new ArrayList<InregistrareContabila>();
        result.addAll(inregistrari.values());
        return result;
    }

    public Integer getIdOperatiune() {
        return idOperatiune;
    }

    public void setIdOperatiune(Integer idOperatiune) {
        this.idOperatiune = idOperatiune;
    }

    public void addInregistrareContabila(InregistrareContabila inregistrare){
        TreeSet<Integer> cheiInregistrari = new TreeSet<Integer>();
        cheiInregistrari.addAll(inregistrari.keySet());
        if (cheiInregistrari.size() > 0)
            inregistrare.setNrOrdine(cheiInregistrari.last() + 1);
        else
            inregistrare.setNrOrdine(1);

        inregistrare.setOperatiune(this);
        this.inregistrari.put(inregistrare.getNrOrdine(), inregistrare);
    }

    public void removeInregistrareContabila(InregistrareContabila inregistrare){
        // TODO: re-numerotare linii
        this.inregistrari.remove(inregistrare.getNrOrdine());
    }

    public int compareTo(Object o) {
        // TODO: check instanceof exception
        OperatiuneContabila op = (OperatiuneContabila) o;

        if (this.getDataContabilizare().after(op.getDataContabilizare()))
            return 1;
        if (this.getDataContabilizare().before(op.getDataContabilizare()))
            return -1;

        return 0;
    }

    // apel de regula din repositories
    public boolean isValid(){
        if (getDebit().equals(getCredit()))
            return true;
        throw new ExceptieValidare("Operatiune dezechilibrata: debit # credit !!");
    }

    public Double getSold(){
        return getDebit() - getCredit();
    }

    public Double getDebit(){
        Double debit = 0.0;
        for (InregistrareContabila i: this.getInregistrari()){
            if (i instanceof InregistrareDebit)
                debit += i.getSuma();
        }
        return debit;
    }

    public Double getCredit(){
        Double credit = 0.0;
        for (InregistrareContabila i: this.getInregistrari()){
            if (i instanceof InregistrareCredit)
                credit += i.getSuma();
        }
        return credit;
    }
}
