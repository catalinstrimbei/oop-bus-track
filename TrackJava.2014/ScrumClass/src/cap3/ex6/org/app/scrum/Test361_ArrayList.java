package cap3.ex6.org.app.scrum;

import java.util.*;

//Listing 3.18: Test colectii instantiate din ArrayList

public class Test361_ArrayList {
    public static void main(String[] args) {
	List<String> list = new ArrayList<String>(2);
	list.add("primul");
	list.add("al doilea");
	list.add("al treilea"); 
	// s-a depasit deja capacitatea initiala, asa ca
	// lista va final obligata sa-si redefineasca 
	// automat dimensiunea

	list.add(3, "al patrulea"); 
	// operatie validata fiindca urmeaza indexul 3

	// list.add(5, "primul"); 
	// operatie invalidata fiindca urmeaza indexul 4

	list.add(4, "al cincilea");
	list.add(2,  "ultimul");
        
	// Se parcurge lista in stil „clasic":
	System.out.println("Iteratie clasica folosind for()");
	for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));
        
	// Se parcurge lista prin interator in ordinea indexarii:
	System.out.println(
		"Iteratie cu iterator in ordinea indexarii");
	// Se Obtine un iterator care porneste de la primul index
	Iterator<String> iterator = list.listIterator();
	while(iterator.hasNext())
            System.out.println(iterator.next());
	// sau
	for(String e: list)
            System.out.println(e);        
	
	// Parcurgem lista prin interator in ordine inversa:
	System.out.println("Iteratie cu iterator in "
		+ "ordinea inversa indexarii");
        
	// Se Reconsidera iteratorul anterior ca ListIterator, si care
	// in iteratia de mai jos va porni de la ultimul element,
	// la care a ajuns prin iteratia de msi sus
	ListIterator<String> listIterator = 
				 (ListIterator<String>)iterator;
	while(listIterator.hasPrevious())
		System.out.println(listIterator.previous());   
    }
}

