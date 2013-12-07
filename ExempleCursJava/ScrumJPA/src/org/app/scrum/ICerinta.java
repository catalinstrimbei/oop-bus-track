package org.app.scrum;



public interface ICerinta {
	 Integer getIdCerinta() ;
	 void setIdCerinta(Integer idCerinta);
	
	 String getDenumire();
	 void setDenumire(String denumire);
	
	 CategorieCerinta getCategorie();
	 void setCategorie(CategorieCerinta categorie);
	
	
	 static final Integer FUNCTIONALA = 1;
	 static final Integer TEHNICA = 1;	
}
