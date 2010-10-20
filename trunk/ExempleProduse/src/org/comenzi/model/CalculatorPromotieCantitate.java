package org.comenzi.model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPromotieCantitate extends CalculatorComenzi {
	protected List<PromotieCantitate> promotii = new ArrayList<PromotieCantitate>();

	public CalculatorPromotieCantitate(List<PromotieCantitate> promotii) {
		this.promotii = promotii;
	}

	@Override
	protected Double getValoareDiscount(Comanda comanda) {
		// TODO Auto-generated method stub
		return null;
	}

}
