package org.comenzi.model;

public class PromotieCantitate extends Promotie {
	private Integer pragCantitate;
	private Integer cantitateGratuitati;

	public Integer getPragCantitate() {
		return pragCantitate;
	}

	public void setPragCantitate(Integer pragCantitate) {
		this.pragCantitate = pragCantitate;
	}

	public Integer getCantitateGratuitati() {
		return cantitateGratuitati;
	}

	public void setCantitateGratuitati(Integer cantitateGratuitati) {
		this.cantitateGratuitati = cantitateGratuitati;
	}

	@Override
	public Double getValoareDiscount(Double cantitate) {
		if (cantitate > pragCantitate)
			return cantitateGratuitati * this.produs.getPretUnitar();
		return 0.0;
	}
	
	public PromotieCantitate(Integer id, Produs produs, Integer pragCantitate,
			Integer cantitateGratuitati) {
		super(id, produs);
		this.pragCantitate = pragCantitate;
		this.cantitateGratuitati = cantitateGratuitati;
	}

	public PromotieCantitate() {
	}	
}
