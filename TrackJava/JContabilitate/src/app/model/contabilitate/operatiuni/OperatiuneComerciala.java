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
public abstract class OperatiuneComerciala extends OperatiuneContabila{
    private String partener;

    public String getPartener() {
        return partener;
    }

    public void setPartener(String partener) {
        this.partener = partener;
    }

    public OperatiuneComerciala() {
    }

    public OperatiuneComerciala(Integer idOperatiune, Date dataContabilizare, String partener) {
        super(idOperatiune, dataContabilizare);
        this.partener = partener;
    }

}
