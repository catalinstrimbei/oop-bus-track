package org.app.scrum.test;

//import org.app.scrum.sprint.CategorieCerinta;
//import org.app.scrum.sprint.Cerinta;
//import org.app.scrum.sprint.CerintaT;

import org.app.scrum.CategorieCerinta;
import org.app.scrum.Cerinta;
import org.app.scrum.ICerinta;
import org.app.scrum.sprint.*;

public class Test1_UtilizareTipuri {

	public static void main(String[] args) {
		/* Ex. Tipizare*/
		// Tipizare/instantiere cerinta din clasa Cerinta avand atributul categorie tip String
		Cerinta cerinta1 = new Cerinta();
		cerinta1.setIdCerinta(1);
		cerinta1.setDenumire("c1");
		//cerinta1.setCategorie(CategorieCerinta.FUNCTIONALA);
		cerinta1.setCategorie(CategorieCerinta.FUNCTIONALA);
		
		// Tipizare cerinta din interfata ICerinta cu getteri/setteri
		ICerinta cerinta2 = new Cerinta();
		cerinta2.setIdCerinta(1);
		cerinta2.setDenumire("c1");
		
		// Tipizare categorie prin String
		cerinta2.setCategorie(CategorieCerinta.TEHNICA);		
		
		// Tipizare categorie prin enum CategoriCerinta
		// Tipizare categorie prin interfata ICategorieCerinta

	}

}
