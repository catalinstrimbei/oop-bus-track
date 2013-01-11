package org.app.vanzari;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("MapJPA");
		EntityManager em = emf.createEntityManager();
		
		List<ElementFacturabil> elementFacturabile = em.createQuery("SELECT e FROM ElementFacturabil e").getResultList();
		
		for (ElementFacturabil element: elementFacturabile)
			System.out.println(element.getDenumire());

	}

	private static void generareElementeFacturabile(){
		Grupa grp = new Grupa("GRP", new BigDecimal(.24));
		Grupa grs = new Grupa("GRS", new BigDecimal(.24));
		Grupa grp1 = new Grupa("GRP1", new BigDecimal(.24));
		grp1.setSuperGrupa(grp);
		Grupa grs1 = new Grupa("GRS1", new BigDecimal(.24));
		grs1.setSuperGrupa(grs);
		
		ServiciuTarifFix stf1 = new ServiciuTarifFix(111, "SrvTF1", new BigDecimal(.24), null, new BigDecimal(150));
		stf1.setGrupa(grs1);
		ServiciuTarifFix stf2 = new ServiciuTarifFix(112, "SrvTF2", new BigDecimal(.24), null, new BigDecimal(175));
		stf2.setGrupa(grs1);
		
		ServiciuTarifVariabil stv1 = new ServiciuTarifVariabil(121, "SrvTV1", new BigDecimal(.24), null, "ora", new BigDecimal(15));
		stv1.setGrupa(grs1);
		ServiciuTarifVariabil stv2 = new ServiciuTarifVariabil(122, "SrvTV2", new BigDecimal(.24), null, "ora", new BigDecimal(25));
		stv2.setGrupa(grs1);
		
		Produs pr1 = new Produs(211, "Produs 1", new BigDecimal(.24), "cutia", new BigDecimal(10), "buc");
		pr1.setGrupa(grp1);
		Produs pr2 = new Produs(212, "Produs 2", new BigDecimal(.24), "bid", new BigDecimal(2), "l");
		pr1.setGrupa(grp1);
		
		Factura f1 = new Factura(1, "1111", "C1", new Date(), null);
		LinieFactura lf11 = new LinieFactura(new LinieFacturaPK(), stf1, new BigDecimal(1), new BigDecimal(150), null, null);
		LinieFactura lf12 = new LinieFactura(new LinieFacturaPK(), stv2, new BigDecimal(1), new BigDecimal(175), null, null);
		

		Factura f2 = new Factura(2, "2222", "C2", new Date(), null);
		LinieFactura lf21 = new LinieFactura(new LinieFacturaPK(), pr1, new BigDecimal(10), new BigDecimal(15), null, null);
		LinieFactura lf22 = new LinieFactura(new LinieFacturaPK(), pr2, new BigDecimal(20), new BigDecimal(17.5), null, null);
		
		
	}
	
	
}