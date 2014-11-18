package cap3.ex6.org.app.scrum;

import java.text.ParseException;

public class Test36x_GenericsManipulareTablou {
	public static void main(String[] args) throws ParseException{
		Box<Integer> b1;
		b1 = new Box<Integer>();
//		b1 = new Box<Double>();
		
		Box<? extends Number> b2;
		b2 = new Box<Integer>();
		b2 = new Box<Double>();
		
		
	}
}

class ManipulareTablou<E> {
	private E[] tablou;

	public E[] sortareTablou() {
		return tablou;
	};

	public E nextElementTablou(E element) {
		return null;
	};

	public ManipulareTablou(E[] t) {
		this.tablou = t;
	}
}

class Box<E extends Number>{ }
