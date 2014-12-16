package cap3.ex1.org.app.scrum;

/*
 * Test supraincercare nume membri: categorie vs. descriere/descriereUseCase
 * Test invocare constructori: super vs. this
 */

public class Test31_Overloading_Atribute {

	public static void main(String[] args) {
		
		CerintaFunctionala cf1 = new CerintaFunctionala(1, "CF1", "Descriere DF1", "CF:basic");
		CerintaFunctionala cf2 = new CerintaFunctionala(2, "CF2", "Descriere DF2",  "CF:improvement","Descriere UseCase DF2");
		
		System.out.println(cf1);
		System.out.println(cf2);

	}

}
