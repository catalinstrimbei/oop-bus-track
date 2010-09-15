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
public class Incasare extends OperatiuneFinanciara{
    private Integer nrDocIncasare;
    private String tipDocIncasare;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataIncasare;

    public Incasare() {
    }

    public Date getDataIncasare() {
        return dataIncasare;
    }

    public void setDataIncasare(Date dataIncasare) {
        this.dataIncasare = dataIncasare;
    }

    public Integer getNrDocIncasare() {
        return nrDocIncasare;
    }

    public void setNrDocIncasare(Integer nrDocIncasare) {
        this.nrDocIncasare = nrDocIncasare;
    }

    public String getTipDocIncasare() {
        return tipDocIncasare;
    }

    public void setTipDocIncasare(String tipDocIncasare) {
        this.tipDocIncasare = tipDocIncasare;
    }

    

    public Incasare(Integer idOperatiune, Date dataContabilizare,
            OperatiuneComerciala operatiuneCorespondenta, Integer nrDocIncasare,
            String tipDocIncasare, Date dataIncasare) {
        super(idOperatiune, dataContabilizare, operatiuneCorespondenta);
        this.nrDocIncasare = nrDocIncasare;
        this.tipDocIncasare = tipDocIncasare;
        this.dataIncasare = dataIncasare;
    }


}
