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
@DiscriminatorValue(value="Credit")
public class InregistrareCredit extends InregistrareContabila{
    private Integer nrOrdineCredit;

    public Integer getNrOrdineCredit() {
        return nrOrdineCredit;
    }

    public void setNrOrdineCredit(Integer nrOrdineCredit) {
        this.nrOrdineCredit = nrOrdineCredit;
    }

    public InregistrareCredit() {
    }

    public InregistrareCredit(Integer id, Cont cont) {
        super(id, cont);
    }
    public InregistrareCredit(Integer id, Cont cont, Double suma) {
        this(id, cont);
        this.suma = suma;
    }
    
    public InregistrareCredit(Cont cont, Double suma) {
        super(cont, suma);

    }
}
