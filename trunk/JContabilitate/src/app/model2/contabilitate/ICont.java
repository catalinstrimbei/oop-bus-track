/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.model2.contabilitate;

/**
 *
 * @author catalin
 */
public interface ICont {
    // proprietatea [cod]
    String getCod();
    // proprietatea [denumire] cu operator de modificare
    String getDenumire();
    void setDenumire(String denumire);
    // alte operatii
    String getCodContParinte();
}
