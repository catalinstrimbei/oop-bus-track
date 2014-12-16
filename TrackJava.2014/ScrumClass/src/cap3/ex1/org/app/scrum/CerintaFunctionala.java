package cap3.ex1.org.app.scrum;

public class CerintaFunctionala extends Cerinta {
	private String categorie; // basic, improvement
	private String descriereUseCase; // scenariu-flux dialog utilizator final - aplicatie
		
	public String getCategorieFunctionala() {
		return categorie;
	}
	public void setCategorieFunctionala(String categorieFunctionala) {
		this.categorie = categorieFunctionala;
	}
	public String getDescriereUseCase() {
		return descriereUseCase;
	}
	public void setDescriereUseCase(String descriereUseCase) {
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
	
}
