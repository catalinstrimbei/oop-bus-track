/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model.contabilitate;

import app.model.contabilitate.conturi.Cont;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author catalin
 */
@Entity
@DiscriminatorValue(value="Debit")
public class InregistrareDebit extends InregistrareContabila{
    private Integer nrOrdineDebit;

    public int getNrOrdineDebit() {
        return nrOrdineDebit;
    }

    public void setNrOrdineDebit(Integer nrOrdineDebit) {
        this.nrOrdineDebit = nrOrdineDebit;
    }

    public InregistrareDebit() {
    }

    public InregistrareDebit(Integer id, Cont cont, Double suma) {
        super(id, cont, suma);
    }

    public InregistrareDebit(Cont cont, Double suma) {
        super(cont, suma);
    }
}
