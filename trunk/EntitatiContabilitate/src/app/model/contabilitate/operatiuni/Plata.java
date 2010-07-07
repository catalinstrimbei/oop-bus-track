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
public class Plata extends OperatiuneFinanciara{
    private Integer nrOrdinPlata;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataPlata;
    private String nrContBancarPlata;

    public Plata() {
    }

    public Date getDataPlata() {
        return dataPlata;
    }

    public void setDataPlata(Date dataPlata) {
        this.dataPlata = dataPlata;
    }

    public String getNrContBancarPlata() {
        return nrContBancarPlata;
    }

    public void setNrContBancarPlata(String nrContBancarPlata) {
        this.nrContBancarPlata = nrContBancarPlata;
    }

    public Integer getNrOrdinPlata() {
        return nrOrdinPlata;
    }

    public void setNrOrdinPlata(Integer nrOrdinPlata) {
        this.nrOrdinPlata = nrOrdinPlata;
    }

    public Plata(Integer idOperatiune, Date dataContabilizare,
            OperatiuneComerciala operatiuneCorespondenta, Integer nrOrdinPlata,
            Date dataPlata, String nrContBancarPlata) {
        super(idOperatiune, dataContabilizare, operatiuneCorespondenta);
        this.nrOrdinPlata = nrOrdinPlata;
        this.dataPlata = dataPlata;
        this.nrContBancarPlata = nrContBancarPlata;
    }


}
