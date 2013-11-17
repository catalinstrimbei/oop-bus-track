package org.app.scrum.sprint;

public class CerintaFunctionala extends Cerinta {
	private String categorieFunctionala; // basic, improvement
	private String descriereUseCase; // scenariu-flux dialog utilizator final - aplicatie
	
	public String getCategorieFunctionala() {
		return categorieFunctionala;
	}
	public void setCategorieFunctionala(String categorieFunctionala) {
		this.categorieFunctionala = categorieFunctionala;
	}
	public String getDescriereUseCase() {
		return descriereUseCase;
	}
	public void setDescriereUseCase(String descriereUseCase) {
		this.descriereUseCase = descriereUseCase;
	}
	
	public CerintaFunctionala(Integer idCerinta, String denumire,
			String descriere, String categorieFunctionala,
			String descriereUseCase) {
		super(idCerinta, denumire, descriere);
		this.idCerinta = idCerinta;
		this.categorieFunctionala = categorieFunctionala;
		this.descriereUseCase = descriereUseCase;
	}
	
	
}
