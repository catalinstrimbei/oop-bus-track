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
public class InregistrareC extends InregistrareContabila{
    private Integer nrOrdine;

    public Integer getNrOrdineCredit() {
        return this.nrOrdine;
    }

    public void setNrOrdineCredit(Integer nrOrdineCredit) {
        this.nrOrdine = nrOrdineCredit;
    }

    public InregistrareC() {
    }

    public InregistrareC(Integer id, Cont cont, Double suma) {
        super(id, cont, suma);
    }
}
