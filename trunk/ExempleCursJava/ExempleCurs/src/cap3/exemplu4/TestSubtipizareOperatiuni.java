package cap3.exemplu4;

import java.util.Date;

public class TestSubtipizareOperatiuni {
    public static void main(String[] args){
        OperatiuneContabila op_1 = 
				new OperatiuneContabila(1,new Date());
        Vinzare op_2 = new Vinzare(2, new Date(),"Alfa SRL");
        // apel metoda proprie getSold()
        System.out.println("" + op_1.getSold());
        // apel metoda mostenita getSold()
        System.out.println("" + op_2.getSold());
    }
}
