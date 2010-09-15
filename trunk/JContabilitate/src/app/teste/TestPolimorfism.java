/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.teste;

import app.model.contabilitate.IServiciuOperatiuni;
import app.model.contabilitate.OperatiuneContabila;
import app.model.contabilitate.conturi.Cont;

/**
 *
 * @author catalin.strimbei
 */
public class TestPolimorfism {
    public static void main(String[] args){
        creareConturi();
        creareOperatiuniFinanciare();
        verificareRulaje();

    }

    static Cont[] conturi;
    private static void creareConturi() {
        /* TODO Creati 6 conturi din 3 clase de conturi diferite*/
    }

    static OperatiuneContabila[] operatiuni;
    private static void creareOperatiuniFinanciare() {
        /* TODO Creati 10 incasari si 10 plati
         * - manipulati intern operatiunile create
         *   doar prin variabile de tip OperatiuneContabila
         * - manipulati intern inregistrarile operatiunilor
         *   doar prin variabile de tip InregistrareContabila
         * - depozitati operatiunile intr-o variabila de clasa
         *   de tip Array cu elemente de tip OperatiuneContabila
         */
    }

    private static void verificareRulaje() {
        IServiciuOperatiuni serviciuOperatiuni;
        /* TODO Calculati rulajele din operatiunile contabile create
         * - instantiati clasa ServiciuOperatiuniImpl_1
         *   intr-o variabila de tip IServiciuOperatiuni, calculati rulajele
         *   si memorati rezultatele intr-un set de variabile locale
         * - instantiati clasa ServiciuOperatiuniImpl_2
         *   in aceeasi variabila de tip IServiciuOperatiuni, calculati rulajele
         *   si memorati rezultatele intr-un al doilea set de variabile locale
         * - comparati rezultatele memorate in cele doua seturi de variabile
         */
    }
}
