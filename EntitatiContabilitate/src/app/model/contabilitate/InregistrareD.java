/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model.contabilitate;

import app.model.contabilitate.conturi.Cont;
import javax.persistence.Entity;

/**
 *
 * @author catalin
 */
//@Entity
public class InregistrareD extends InregistrareContabila{
    private Integer nrOrdine;

    public int getNrOrdineDebit() {
        return this.nrOrdine;
    }

    public void setNrOrdineDebit(Integer nrOrdineDebit) {
        this.nrOrdine = nrOrdineDebit;
    }

    public InregistrareD() {
    }

    public InregistrareD(Integer id, Cont cont, Double suma) {
        super(id, cont, suma);
    }

    
}
