/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model.contabilitate.operatiuni;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author catalin
 */
@Entity
public class Vinzare extends OperatiuneComerciala{
    private Integer nrFacturaEmisa;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFacturaEmisa;

    public Vinzare() {
    }

    public Vinzare(Integer idOperatiune, Date dataContabilizare, String partener,
            Integer nrFacturaEmisa, Date dataFacturaEmisa) {
        super(idOperatiune, dataContabilizare, partener);
        this.nrFacturaEmisa = nrFacturaEmisa;
        this.dataFacturaEmisa = dataFacturaEmisa;
    }


    public Date getDataFacturaEmisa() {
        return dataFacturaEmisa;
    }

    public void setDataFacturaEmisa(Date dataFacturaEmisa) {
        this.dataFacturaEmisa = dataFacturaEmisa;
    }

    public Integer getNrFacturaEmisa() {
        return nrFacturaEmisa;
    }

    public void setNrFacturaEmisa(Integer nrFacturaEmisa) {
        this.nrFacturaEmisa = nrFacturaEmisa;
    }

    
}
