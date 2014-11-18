package cap3.ex6.org.app.scrum;

import java.text.ParseException;
import java.util.Arrays;

public class Test360_GenericsManipulareTablou {
	public static void main(String[] args) throws ParseException{
		
		Integer[] serieNumereIntregi = {50, 75, 25};
		sortareSerie(serieNumereIntregi);
		afisareSerie(serieNumereIntregi);
		
		System.out.println("Element max: " + maxElementSerie(serieNumereIntregi));
		
		exempluGenericsPolimorfism();
		
	}
	
	public static <E> void afisareSerie(E[] tablouSerie) {
		System.out.print("[");
		for(E element: tablouSerie){
			System.out.print(element + ",");
		}
		System.out.println("]");
	}
	
	public static <E> E[] sortareSerie(E[] tablouSerie) {
		Arrays.sort(tablouSerie);
		return tablouSerie;
	};

	public static <E> E nextElementSerie(E[] tablouSerie, E element) {
		Integer poz = Arrays.binarySearch(tablouSerie, element);
		if (poz+1 < tablouSerie.length)
			return tablouSerie[poz+1];
		return null;
	};		
	
	public static <E> E maxElementSerie(E[] tablouSerie) { 
		sortareSerie(tablouSerie);
		return tablouSerie[tablouSerie.length - 1];
	}
	
	static void exempluGenericsPolimorfism(){
		SerieNumerica<Integer> serieNumereIntregi;
		serieNumereIntregi = new SerieNumerica<Integer>(new Integer[]{50, 75, 25});		
//		serieNumereIntregi = new SerieNumerica<Double>(new Double[]{50.0, 75.0, 25.0});
		
		SerieNumerica<? extends Number> serieNumere;
		serieNumere = new SerieNumerica<Integer>(new Integer[]{50, 75, 25});		
		serieNumere = new SerieNumerica<Double>(new Double[]{50.0, 75.0, 25.0});
	}
	
	
}

class SerieNumerica<E extends Number>{
	E[] tablouSerie;
	
	public SerieNumerica(E[] serie){
		this.tablouSerie = serie;
	}
	
	public E[] sortareSerie() {
		Arrays.sort(tablouSerie);
		return tablouSerie;
	};

	public E nextElementSerie(E element) {
		Integer poz = Arrays.binarySearch(this.tablouSerie, element);
		if (poz+1 < this.tablouSerie.length)
			return this.tablouSerie[poz+1];
		return null;
	};	
}
