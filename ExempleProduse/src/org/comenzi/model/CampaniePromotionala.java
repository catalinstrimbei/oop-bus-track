package org.comenzi.model;

import java.util.ArrayList;
import java.util.List;

public class CampaniePromotionala {
	private Integer id;
	private List<Promotie> promotii = new ArrayList<Promotie>(); 
	
	public Double getValoareComandaCuDiscount(Comanda comanda){
		Double valoareCuDiscount = 0.0;
		for (Promotie d: promotii){
			valoareCuDiscount += d.getValoareDiscountComanda(comanda);
		}
		return comanda.getValoareComanda() - valoareCuDiscount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Promotie> getPromotii() {
		return promotii;
	}

	public void setPromotii(List<Promotie> promotii) {
		this.promotii = promotii;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((promotii == null) ? 0 : promotii.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CampaniePromotionala other = (CampaniePromotionala) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (promotii == null) {
			if (other.promotii != null)
				return false;
		} else if (!promotii.equals(other.promotii))
			return false;
		return true;
	}

	public CampaniePromotionala(Integer id, List<Promotie> promotii) {
		super();
		this.id = id;
		this.promotii = promotii;
	}

	public CampaniePromotionala() {
		super();
	}
	
	
}
