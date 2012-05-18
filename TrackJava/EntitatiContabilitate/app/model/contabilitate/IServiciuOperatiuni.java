/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model.contabilitate;

/**
 *
 * @author catalin
 */
public interface IServiciuOperatiuni {

    Double getCredit(OperatiuneContabila o);

    Double getDebit(OperatiuneContabila o);

    Double getSold(OperatiuneContabila o);

}
