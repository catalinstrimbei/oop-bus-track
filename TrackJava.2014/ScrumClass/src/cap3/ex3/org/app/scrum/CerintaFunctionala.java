package cap3.ex3.org.app.scrum;

import java.util.Date;
import java.util.Map;

public class CerintaFunctionala extends Cerinta {
	private String categorie; // basic, improvement
	private String descriereUseCase; // scenariu-flux dialog utilizator final - aplicatie
		
	public String getCategorieFunctionala() {
		return this.categorie;
	}
	// supraincarcare
	public void setCategorie(String categorieFunctionala) {
		this.categorie = categorieFunctionala;
	}
	// suprascriere
	public String getDescriere() {
		return this.descriereUseCase;
	}
	// supraincarcare
	public void setDescriere(String descriereUseCase) {
		this.descriereUseCase = descriereUseCase;
	}
	
	public CerintaFunctionala() {
		super();
		super.categorie = CategorieCerinta.FUNCTIONALA;
	}	
	
	public CerintaFunctionala(Integer idCerinta, String denumire,
			String descriere, String categorie) {
		super(idCerinta, denumire, descriere, CategorieCerinta.FUNCTIONALA);
		this.categorie = categorie;
	}	
	
	public CerintaFunctionala(Integer idCerinta, String denumire,
			String descriere, String categorie,
			String descriereUseCase) {
		this(idCerinta, denumire, descriere, categorie);
		this.descriereUseCase = descriereUseCase;
	}
	
	@Override
	public String toString() {
		return super.toString() + " CerintaFunctionala [categorie=" + categorie
				+ ", descriereUseCase=" + descriereUseCase + "]";
	}
	@Override
	public void setCategorie(CategorieCerinta categorie) {
		throw new Error("Proprietatea categorie nu poate fi schimbata!");
	}
	@Override
	public String getDescriereCompleta() {
		return super.getDescriere() + "&" + this.getDescriere();
	}

	
}
