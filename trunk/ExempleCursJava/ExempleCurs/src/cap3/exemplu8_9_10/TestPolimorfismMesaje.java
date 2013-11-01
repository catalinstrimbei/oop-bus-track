package cap3.exemplu8_9_10;

import java.util.Date;

public class TestPolimorfismMesaje {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cont c_1 = new Cont("411.1", "Client Alfa SRL");
		Cont c_2 = new Cont("401.1", "Furnizor Beta SRL");
		// definire variabilă polimorfă
		OperatiuneContabila op;
		// prima iniţializare variabilă polimorfă
		op = new Cumparare(1,new Date());
		op.addInregistrareContabila(
			new InregistrareDebit(1, c_2, 100.0));
		// invocare prima instanţă OperatiuneContabila 
		//prin referinţa stocată în var. polimorfă
		System.out.println("i. cont op 1: " 
			+ op.getInregistrari().get(0).getCont().getCod());
		// a doua iniţializare variabilă polimorfă
		op = new Vinzare(2, new Date(),"Alfa SRL");
		op.addInregistrareContabila(
			new InregistrareDebit(3, c_1, 50.0));
		// invocarea celei de a doua instanţe OperatiuneContabila 
		// prin referinţa stocată în var. polimorfă
		System.out.println("ii. cont op 2: " 
			+ op.getInregistrari().get(0).getCont().getCod());
	}

}
