package cap3.exemplu12;

import java.util.Date;

public class TestPolimorfismVariabileDeInstanta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Cont c_1 = new Cont("411.1", "Client Alfa SRL");
        Cont c_2 = new Cont("371", "Marfuri");
        // definire variabilă polimorfă
        OperatiuneContabila op;
        // prima iniţializare variabilă polimorfă
        op = new OperatiuneContabila(1,new Date());
        op.addInregistrareContabila(
				new InregistrareDebit(1, c_1, 100.0));
        op.addInregistrareContabila(
				new InregistrareCredit(2, c_2, 100.0));
        // invocare prima instanţă OperatiuneContabila 
			// prin referinţa stocată în var. polimorfă
        System.out.println("i.ID op: " + op.getIdOperatiune());
        // a doua iniţializare variabilă polimorfă
        op = new Vinzare(2, new Date(),"Alfa SRL");
        op.addInregistrareContabila(
				new InregistrareDebit(3, c_1, 50.0));
        op.addInregistrareContabila(
				new InregistrareCredit(4, c_2, 50.0));
        // invocarea celei de a doua instanţe OperatiuneContabila 
			// prin referinţa stocată în var. polimorfă
        System.out.println("ii.ID op: " + op.getIdOperatiune());
	}

}
