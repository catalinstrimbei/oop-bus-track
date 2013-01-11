package org.app.vanzari;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestMapJDBC {
	public static void main(String[] args) throws Exception {
		ElementFacturabilDAO dao = new ElementFacturabilDAO();
		List<ElementFacturabil> elementFacturabile = dao.getElementeFacturabile();
		for (ElementFacturabil element: elementFacturabile)
			System.out.println(element.getDenumire());
	}
}

class ElementFacturabilDAO{
	static String INSERT = "INSERT INTO ELEMENTE_FACTURABILE VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	static String UPDATE = "UPDATE ELEMENTE_FACTURABILE SET " +
			" cod = ? " +
			" BAZA_CALCUL = ?" +
			" CANTIT_UNITARA = ?" +
			" denumire = ?" +
			" DETALII_SERVICIU = ?" +
			" PROC_TVA_CRT = ?" +
			" TARIF_UNIC = ?" +
			" TARIF_UNITAR = ?" +
			" um = ?" +
			" UM_CANTIT_UNIT = ?" +
			" GRUPA = ?" +
			" WHERE cod = ?";
	static String DELETE = "DELETE ELEMENTE_FACTURABILE  WHERE cod = ?";
	static String SELECT_ELEMENTE_FACTURABILE = "SELECT * FROM ELEMENTE_FACTURABILE";
	static String SELECT_GRUPA = "SELECT * FROM ELEMENTE_FACTURABILE";
	static String SELECT_LINII_FACTURI = "SELECT * FROM LINII_FACTURI";
	
	private Connection connection;
	
	public ElementFacturabilDAO() throws Exception {
		getJDBCConnection();
	}	
	private void getJDBCConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		connection = DriverManager.getConnection
			     ("jdbc:oracle:thin:@//10.10.0.7:1521/orcl", "vanzari", "vanzari");
	}
	
	
	public List<ElementFacturabil> getElementeFacturabile() throws Exception{
		List<ElementFacturabil> elemente = new ArrayList<>();
		ElementFacturabil element;
		Grupa grupa;
		
		PreparedStatement pStatement = connection.prepareStatement(SELECT_ELEMENTE_FACTURABILE);
		PreparedStatement pStatementGrupa = connection.prepareStatement(SELECT_GRUPA + " WHERE grupa = ?");
		ResultSet rSet = pStatement.executeQuery();
		ResultSet rSetGrupa;
		
		while(rSet.next()){
			element = new ElementFacturabil();
			element.setCod(rSet.getLong("COD"));
			element.setBazaCalcul(rSet.getString("BAZA_CALCUL"));
			element.setCantitUnitara(rSet.getBigDecimal("CANTIT_UNITARA"));
			element.setDenumire(rSet.getString("DENUMIRE"));
			element.setDetaliiServiciu(rSet.getString("DETALII_SERVICIU"));
			element.setProcTvaCrt(rSet.getBigDecimal("PROC_TVA_CRT"));
			element.setTarifUnic(rSet.getBigDecimal("TARIF_UNIC"));
			element.setTarifUnitar(rSet.getBigDecimal("TARIF_UNITAR"));
			element.setUm(rSet.getString("UM"));
			element.setUmCantitUnit(rSet.getString("UM_CANTIT_UNIT"));
			
			pStatementGrupa.setString(0, rSet.getString("GRUPA"));
			rSetGrupa = pStatementGrupa.executeQuery();
			while(rSet.next()){
				grupa = new Grupa();
				grupa.setGrupa(rSetGrupa.getString("GRUPA"));
				grupa.setProcentTvaCrt(rSetGrupa.getBigDecimal("PROCENT_TVA_CRT"));
				element.setGrupa(grupa);
			}
			
			elemente.add(element);
		}
		
		return elemente;
	}
	
	public void createElementFacturabil(ElementFacturabil element){
		
	}

	public ElementFacturabil readElementFacturabil(Long cod){
		return null;
	}	
	
	public void updateElementFacturabil(ElementFacturabil element){
		
	}
	
	public void deleteElementFacturabil(ElementFacturabil element){
		
	}
	
}