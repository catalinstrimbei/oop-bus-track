/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model.contabilitate.operatiuni;

import app.model.contabilitate.*;
import java.util.Date;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author catalin
 */
@MappedSuperclass
public class OperatiuneFinanciara extends OperatiuneContabila{
    private OperatiuneComerciala operatiuneCorespondenta;

    public OperatiuneComerciala getOperatiuneCorespondenta() {
        return operatiuneCorespondenta;
    }

    public void setOperatiuneCorespondenta(OperatiuneComerciala operatiuneCorespondenta) {
        this.operatiuneCorespondenta = operatiuneCorespondenta;
    }

    public OperatiuneFinanciara(Integer idOperatiune, Date dataContabilizare, OperatiuneComerciala operatiuneCorespondenta) {
        super(idOperatiune, dataContabilizare);
        this.operatiuneCorespondenta = operatiuneCorespondenta;
    }

    public OperatiuneFinanciara() {
    }
}
