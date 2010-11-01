package org.comenzi.model;

public class ProdusFinit extends Material {
	protected Integer durataContractService;

	public Integer getDurataContractService() {
		return durataContractService;
	}

	public void setDurataContractService(Integer durataContractService) {
		this.durataContractService = durataContractService;
	}

	public ProdusFinit(Integer cod, String denumire, String um,
			Double pretUnitar, Integer durataGarantie, String modPrezentare,
			Integer durataContractService) {
		super(cod, denumire, um, pretUnitar, durataGarantie, modPrezentare);
		this.durataContractService = durataContractService;
	}

	public ProdusFinit() {
		super();
	}
}
