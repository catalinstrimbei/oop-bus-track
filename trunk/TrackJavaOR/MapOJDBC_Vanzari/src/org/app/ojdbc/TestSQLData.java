package org.app.ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSQLData {

	static Connection connection;

	static void getJDBCConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		connection = DriverManager
				.getConnection("jdbc:oracle:thin:@//10.10.0.7:1521/orcl",
						"vanzari", "vanzari");
	}

	public static void main(String[] args) throws Exception {
		getJDBCConnection();
		Statement stat = connection.createStatement();

		// obtains the connection typemap
		java.util.Map map = connection.getTypeMap();

		// populate the type map
		map.put("VANZARI.ELEMENTFACTURABIL_TYPE", ElementFacturabil.class);
		map.put("VANZARI.PRODUS_TYPE", Produs.class);

		//
		ResultSet rset = stat
				.executeQuery("select VALUE(p) from elementfacturabil_table p");
		ElementFacturabil e;
		Produs p;
		while (rset.next()) {
			Object s = rset.getObject(1);
			if (s != null) {
				if (s instanceof Produs){
					p = (Produs) s;
					System.out.println("Instanta - Produs: " + p.getDenumire() + " " + p.getUm());
				} else if (s instanceof ElementFacturabil) {
					e = (ElementFacturabil) s;
					System.out.println("Instanta - ElementFacturabil: " + e.getSQLTypeName());
					System.out.println("Instanta - ElementFacturabil: " + e.getDenumire());
				}else
					System.out.println("Unknown type");
			}
		}

		connection.close();
	}

}
