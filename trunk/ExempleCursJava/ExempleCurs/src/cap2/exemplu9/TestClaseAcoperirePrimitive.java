package cap2.exemplu9;
import java.text.DecimalFormat; 
import java.text.DecimalFormatSymbols; 
import java.text.NumberFormat;
import java.text.ParseException;

public class TestClaseAcoperirePrimitive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Double x1 = 10.50;
		Double x2 = 10.50;
		Double x3 = 10.51;
		System.out.println("x1 == x2: " + (x1 == x2));
		System.out.println("x1 < x3: " + (x1 < x3) );
		System.out.println("x1 == x2: " + (x1.doubleValue() == x2.doubleValue()));
		
		
		System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);		
		
		//1) Autoboxing initializare
		Integer a = 7;
		Double b = 7.0;
		Integer c = 2;
		System.out.println("1) a = " + a + ", "
				+ "b = " + b + ", "
				+ "c = " + c);
		
		//2) Autoboxing expresie matematica
		Number r1 = a/c;
		Number r2 = b/c;
		Number r3 = a + c;
		Number r4 = b + c;
		System.out.println("2) r1 = a/c = " + r1 + ", \n"
				+ "r2 = b/c = " + r2 + ", \n"
				+ "r3 = a+c = " + r3 + ", \n"
				+ "r4 = b+c = " + r4);
		//3) Pastrarea tipului rezultatului dupa operatii
		// cu primitive numerice de acelasi tip
		System.out.println("3.1) r1 este de tip: " 
				+ r1.getClass().getName());
		System.out.println("3.2) r3 este de tip: " 
				+ r1.getClass().getName());
		
		//4) Promovarea tipului rezultatului dupa operatii
		// cu primitive numerice de tipuri diferite
		System.out.println("4.1) r2 este de tip: " 
				+ r2.getClass().getName());
		System.out.println("4.2) r4 este de tip: " 
				+ r2.getClass().getName());
		
		//5) Comparare primitive numerice de tipuri diferite
		System.out.println("5.1) a > b? " + (a>b));
		System.out.println("5.2) a [egal] b? " + (a.equals(b)) );
		System.out.println("5.3) a [compareTo] c?"
				+ (a.compareTo(c)) );
		
		//6) Conversie intre valori numerice
		Integer b_parteIntreaga = new Integer(b.intValue());
		//Integer b_parteIntreaga = b.intValue();
		System.out.println("6.1) a == b_parteIntreaga? " 
				+ (a == b_parteIntreaga) );
		System.out.println("6.2) a [egal] b_parteIntreaga? " 
				+ (a.equals(b_parteIntreaga)) );
		
		//7) Conversie cu format default
		// din siruri de caractere in valori numerice
		String d = "7.5";
		String e = "2";
		Object r5 = Double.valueOf(d)/Integer.valueOf(e);
		System.out.println("7.1) 7.5/2 = " + r5 + "\n"
				+ "tip rezultat conversie default: " 
				+ r5.getClass().getName());
		String f = "725256.856";
		// format default, ne-explicitat
		DecimalFormat fn1 = new DecimalFormat();
		try {
			Object r6 = fn1.parseObject(f);
			System.out.println("7.2) string -> double: \n" 
					+ f + " -> " + r6 + "\n"
					+ "tip rez conversie default: "
					+ r6.getClass().getName());		
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		//8) Conversie cu format explicit 
		// din siruri de caractere in valori numerice
		String g = "725.256,856";
		// format pe un grup de setari zecimale
		DecimalFormat fn2 = new DecimalFormat();
		DecimalFormatSymbols dfs1 = new DecimalFormatSymbols();
		dfs1.setGroupingSeparator('.');
		dfs1.setDecimalSeparator(',');
		fn2.setMaximumIntegerDigits(6);
		fn2.setMaximumFractionDigits(3);
		fn2.setDecimalFormatSymbols(dfs1);
		try {
			Object r7 = fn2.parseObject(g);
			System.out.println("8) string -> double: \n" 
					+ g + " -> " + r7 + "\n"
					+ "tip rez conversie: "
					+ r7.getClass().getName());
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		//9) Conversie cu format default
		// din valori numerice in siruri de caractere
		Double h = 877411.99;
		System.out.println("9.1) double -> string: " 
				+ h.toString());
		// format pe un grup de setari zecimale
		DecimalFormat fn3 = new DecimalFormat();	
		String r8 = fn3.format(h);
		System.out.println("9.2) double -> string: " + r8);
		
		//10) Conversie cu format explicit
		// din valori numerice in siruri de caractere		
		Double i = 877411.99;
		// format pe un grup de setari zecimale
		DecimalFormat fn4 = new DecimalFormat();
		DecimalFormatSymbols dfs2 = new DecimalFormatSymbols();
		dfs2.setGroupingSeparator('.');
		dfs2.setDecimalSeparator(',');
		fn4.setMaximumIntegerDigits(6);
		fn4.setMaximumFractionDigits(3);
		fn4.setDecimalFormatSymbols(dfs2);
		String r9 = fn4.format(i);
		System.out.println("10) double -> string: " + r9);	

	}
}
