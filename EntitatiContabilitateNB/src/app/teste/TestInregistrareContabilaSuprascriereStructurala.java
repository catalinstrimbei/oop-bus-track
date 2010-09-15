/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.teste;

import app.model.contabilitate.InregistrareC;
import app.model.contabilitate.InregistrareContabila;
import app.model.contabilitate.InregistrareD;

/**
 *
 * @author catalin
 */
public class TestInregistrareContabilaSuprascriereStructurala {
    public static void main(String[] args){
        InregistrareContabila inregistrareDebit = new InregistrareContabila();
        //inregistrareDebit.setTip("Debit");
        inregistrareDebit.setNrOrdine(1);

        InregistrareD iDebit = new InregistrareD();
        InregistrareC iCredit = new InregistrareC();

        iDebit.setNrOrdineDebit(1);
        iCredit.setNrOrdineCredit(1);

        System.out.println("iDebit.nrOrdineDebit: " + iDebit.getNrOrdineDebit());
        System.out.println("iDebit.nrOrdine: " + iDebit.getNrOrdine());
    }
}
