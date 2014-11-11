package cap3.ex2.org.app.scrum;


/*
 * Test supraincercare nume membri: categorie vs. descriere/descriereUseCase
 * Test invocare constructori: super vs. this
 */

public class Test32 {

	public static void main(String[] args) {
		
		CerintaFunctionala cf1 = new CerintaFunctionala(1, "CF1", "Descriere DF1", "CF:basic");
		CerintaFunctionala cf2 = new CerintaFunctionala(2, "CF2", "Descriere DF2",  "CF:improvement","Descriere UseCase2");
		
		System.out.println(cf1);
		System.out.println(cf2);
		
		//cf1.setCategorie(CategorieCerinta.TEHNICA);
		cf1.setCategorie("CF:minor improvement");
		
		cf1.setDescriere("Descriere UseCase1");
		cf1.setDescriere("Descriere UseCase2.1");
		
		System.out.println(cf1.getDenumire() + "-" + cf1.getCategorie() + "-" + cf1.getDescriereCompleta());
		System.out.println(cf2.getDenumire() + "-" + cf2.getCategorie() + "-" + cf2.getDescriereCompleta());	
		
		//
		Membru m1 = new Membru(1, "ION ION", Rol.DEVELOPER);
		m1.setCompetente("Java, JEE, SQL");
		
		ManagerProiect m2 = new ManagerProiect(1, "MARIN MARIN", 2, "agile, scrum, xp");
		m2.setCompetente("MSFT Project, Redmine, ScrumSoft");
		
		System.out.println("Competente m1: " + m1.getCompetente());
		System.out.println("Competente m2 (a): " + m2.getCompetente());
		System.out.println("Competente m2 (a-manageriale): " + m2.getCompetente(ManagerProiect.TipCompetenta.MANAGERIAL));
		System.out.println("Competente m2 (b-tehnice): " + m2.getCompetente(ManagerProiect.TipCompetenta.TEHNIC));		
	}

}
