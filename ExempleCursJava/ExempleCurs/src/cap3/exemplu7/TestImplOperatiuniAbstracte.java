package cap3.exemplu7;

import java.util.Date;

public class TestImplOperatiuniAbstracte {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Cont c_1 = new Cont("411.1", "Client Alfa SRL");
        Cont c_2 = new Cont("371", "Marfuri");

        OperatiuneContabila op_1 = new OperatiuneContabila(
				1,new Date());
        op_1.addInregistrareContabila(
				new InregistrareDebit(1, c_1, 100.0));
        op_1.addInregistrareContabila(
				new InregistrareCredit(2, c_2, 100.0));

        Vinzare op_2 = new Vinzare(2, new Date(),"Alfa SRL");
        op_2.addInregistrareContabila(
				new InregistrareDebit(3, c_1, 50.0));
        op_2.addInregistrareContabila(
				new InregistrareCredit(4, c_2, 50.0));

        // apel metoda getInregistrari 
		// din clasa OperatiuneContabila
        System.out.println("op_1: " 
				+ op_1.getInregistrari().size());
        
        // apel metoda getInregistrari 
		// supraîncărcată în clasa Vinzare
        System.out.println("op_2: " 
				+ op_2.getInregistrari("Debit").size());
	}

}
