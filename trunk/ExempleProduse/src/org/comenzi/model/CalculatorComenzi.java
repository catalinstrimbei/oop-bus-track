package org.comenzi.model;

import java.util.ArrayList;
import java.util.List;

public abstract class CalculatorComenzi {
	
	public Double getValoareCuDiscount(Comanda comanda){
		return comanda.getValoareComanda() - getValoareCuDiscount(comanda);
	}
	
	protected abstract Double getValoareDiscount(Comanda comanda);
	
	
}
