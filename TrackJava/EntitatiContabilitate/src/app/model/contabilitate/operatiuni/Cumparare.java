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
public class Cumparare extends OperatiuneComerciala{
    private Integer nrFacturaPrimita;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataFacturaPrimita;

    public Cumparare() {
    }

    public Cumparare(Integer idOperatiune, Date dataContabilizare, String partener,
            Integer nrFactura, Date dataFactura) {
        super(idOperatiune, dataContabilizare, partener);
        this.nrFacturaPrimita = nrFactura;
        this.dataFacturaPrimita = dataFactura;
    }

    public Date getDataFacturaPrimita() {
        return dataFacturaPrimita;
    }

    public void setDataFacturaPrimita(Date dataFactura) {
        this.dataFacturaPrimita = dataFactura;
    }

    public Integer getNrFacturaPrimita() {
        return nrFacturaPrimita;
    }

    public void setNrFacturaPrimita(Integer nrFactura) {
        this.nrFacturaPrimita = nrFactura;
    }


}
