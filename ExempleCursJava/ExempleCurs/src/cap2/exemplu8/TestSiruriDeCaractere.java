package cap2.exemplu8;

import java.util.Date;

public class TestSiruriDeCaractere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TestSiruriDeCaractere().
		//1
//		testCharArrays();
//		testCharAsciiCode();
//		testCharacterInstance();
		//2
//		testStringInstance();
//		testStringImmutable();
//		testSubStrings_1();
//		testSubStrings_2();
		
		//3
//		multiply_StringBuffer("aaa", 10000);
//		multiply_OperatorConcatenare("aaa", 10000);
		multiply_OperatieConcat("aaa", 10000);

	}

	void testCharArrays() {
		//char[] char_seq = { 'P', 'R', 'O' };
		Character[] char_seq = { 'P', 'R', 'O' };
		for (Character c : char_seq) {
			System.out.print(c + ",");
		}
		System.out.println();
		String char_str = "PRO";
		for (int i = 0; i < char_str.length(); i++) {
			System.out.print(char_str.charAt(i) + "+");
		}
		System.out.println();
		char[] char_str_array = char_str.toCharArray();
		for (int i = 0; i < char_seq.length; i++) {
			System.out.println("char_seq[" + i + "] == " + "char_str_array["
					+ char_str.indexOf(char_seq[i]) + "] : "
					+ char_str.charAt(i) + " : "
					+ (char_seq[i] == char_str_array[i]));
		}
	}

	void testCharAsciiCode() {
		char c = 'a';
		int asciiCode = (int) c;
		System.out.println("char 'a' - ascii cod = " + asciiCode);
	}

	void testCharacterInstance() {
		Character c_a = new Character('a');
		Character c_A = 'a';
		// auto-boxing
		System.out.println("character a - ascii cod = "
				+ Character.getNumericValue('a'));
		System.out.println("character a - majuscula = "
				+ Character.toUpperCase('a'));
		System.out.println("character a este numeric: "
				+ Character.isDigit('a'));
		System.out.println("character a este literal: "
				+ Character.isLetter('a'));
		System.out.println("character a este spatiu: "
				+ Character.isSpaceChar('a'));
		System.out.println("character a este minuscula:"
				+ Character.isLowerCase('a'));
	}
	// 2
	void testStringInstance() {
		String str_1 = "pro";
		String str_2 = "pro";
		System.out.println("str_1 == str_2 :" + (str_1 == str_2)); // true
		String str_3 = new String("pro");
		System.out.println("str_1 == str_3 :" + (str_1 == str_3)); // false
		String str_4 = String.valueOf(true);
		System.out.println("true = " + str_4.equals("true")); // true
	}
	
	void testStringImmutable() {
		char[] char_seq = { 'i', 'm', 'm', 'u', 't', 'a', 'b', 'l', 'e' };
		String str_1 = new String(char_seq);
		String str_2 = new String("immutable");
		String str_3 = "immutable";
		String str_4 = str_3.replace("immu", "permu");
		System.out.println("Initial string state : " + str_3);
		System.out.println("Replace result : " + str_4);
		System.out.println("str_3 == str_4 : " + (str_3 == str_4));
		System.out.println("str_3 equals str_4 : " + (str_3.equals(str_4)));
	}
	
	void testSubStrings_1() {
		String str_1 = "SELECT o FROM Client c WHERE c.cod = 111";
		String s_str_1 = str_1.substring(0, 8);
		System.out.println("s_str_1: " + s_str_1);
		System.out.println("s_str_1 in str_1: " + str_1.indexOf(s_str_1));
		String s_str_2 = str_1.substring(s_str_1.length() + 1,
				(s_str_1.length() + 1) + 13);
		System.out.println("s_str_2: " + s_str_2);
		System.out.println("s_str_2 in str_1: " + str_1.indexOf(s_str_2));
		String s_str_3 = str_1.substring(s_str_1.length() + 1
				+ s_str_2.length() + 1);
		System.out.println("s_str_3: " + s_str_3);
		System.out.println("s_str_3 in str_1: " + str_1.indexOf(s_str_3));
		String sir_2 = s_str_1 + ' ' + s_str_2 + ' ' + s_str_3;
		System.out.println("sir_2 : " + sir_2);
	}

	void testSubStrings_2() {
		String str_1 = "SELECT o FROM Client c WHERE c.cod = 111";
		String s_str_1 = str_1.substring(0, 8);
		System.out.println("s_str_1: " + s_str_1);
		String s_str_2 = str_1.substring(
				str_1.indexOf(s_str_1) + s_str_1.length() + 1,
				(str_1.indexOf(s_str_1) + s_str_1.length() + 1) + 13);
		System.out.println("s_str_2: " + s_str_2);
		String s_str_3 = str_1.substring(str_1.indexOf(s_str_2)
				+ s_str_2.length() + 1);
		System.out.println("s_str_3: " + s_str_3);
		String str_2 = s_str_1.concat(" ").concat(s_str_2).concat(" ")
				.concat(s_str_3);
		System.out.println("str_2 : " + str_2);
		System.out.println("str_1.startsWith(s_str_1) :: "
				+ str_1.startsWith(s_str_1));
		System.out.println("str_1.contains(s_str_2) :: "
				+ str_1.contains(s_str_1));
		System.out.println("str_1.endsWith(s_str_3) :: "
				+ str_1.endsWith(s_str_3));
		System.out.println("str_1 == str_2 :" + (str_1 == str_2));
		System.out.println("str_1.equals(str_2) :" + (str_1.equals(str_2)));
		String str_3 = "SELECT o FROM Client c WHERE c.cod = 111";
		System.out.println("str_1 == str_3 :" + (str_1 == str_3));
		String str_4 = new String("SELECT o FROM Client c WHERE c.cod = 111");
		System.out.println("str_1 == str_4 :" + (str_1 == str_4));
		String x1 = "abcd";
		String x2 = "bdce";
		System.out.println("x1.compareTo(x2) = " + x1.compareTo(x2));
		// return -1, adica x1 se gaseste inainte de x2 }
	}
	// 2
	String multiply_StringBuffer(String str, Integer level) {
		Date startTime = new Date();
		StringBuffer strBuff = new StringBuffer();
		for (int i = 0; i <= level; i++) {
			strBuff.append(str);
		}
		String strFinal = strBuff.toString();
		System.out.println("Time multiply_StringBuffer: "
				+ (new Date().getTime() - startTime.getTime()));
		return strFinal;
	}

	String multiply_OperatorConcatenare(String str, Integer level) {
		Date startTime = new Date();
		String strBuff = ""; // şirul null
		for (int i = 0; i <= level; i++) {
			strBuff += str;
		}
		System.out.println("Time multiply_OperatorConcatenare: "
				+ (new Date().getTime() - startTime.getTime()));
		return strBuff;
	}

	String multiply_OperatieConcat(String str, Integer level) {
		Date startTime = new Date();
		String strBuff = "";
		for (int i = 0; i <= level; i++) {
			strBuff = strBuff.concat(str);
		}
		System.out.println("Time multiply_OperatieConcat: "
				+ (new Date().getTime() - startTime.getTime()));
		return strBuff.toString();
	}
}
