package org.comenzi.model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorPromotieValoare extends CalculatorComenzi {
	protected List<PromotieValoare> promotii = new ArrayList<PromotieValoare>();

	public CalculatorPromotieValoare(List<PromotieValoare> promotii) {
		super();
		this.promotii = promotii;
	}

	@Override
	protected Double getValoareDiscount(Comanda comanda) {
		// TODO Auto-generated method stub
		return null;
	}

}
