package example;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class Test_JDBC_Map {
	public static void main(String[] argv) throws Exception {
//	    String driverName = "com.jnetdirect.jsql.JSQLDriver";
//	    Class.forName(driverName);
//
//	    String serverName = "10.10.0.7";
//	    String portNumber = "1521";
//	    String mydatabase = serverName + ":" + portNumber;
//	    String url = "jdbc:JSQLConnect://" + mydatabase;
//	    String username = "username";
//	    String password = "password";
//		Connection connection = DriverManager.getConnection(url, username, password);
		
		String URL = "jdbc:oracle:thin:@10.10.0.7:1521:ORCL";

		String USER = "scrum";

		String PASS = "scrum";

		Connection connection = DriverManager.getConnection(URL, USER, PASS);
		
	    
	    DatabaseMetaData dbmd = connection.getMetaData();
	    ResultSet resultSet = dbmd.getTypeInfo();

	    while (resultSet.next()) {
	      String typeName = resultSet.getString("TYPE_NAME");

	      short dataType = resultSet.getShort("DATA_TYPE");
	      getJdbcTypeName(dataType);
	    }
	  }

	  public static void getJdbcTypeName(int jdbcType) {
	    Map map = new HashMap();

	    // Get all field in java.sql.Types
	    Field[] fields = java.sql.Types.class.getFields();
	    for (int i = 0; i < fields.length; i++) {
	      try {
	        String name = fields[i].getName();
	        Integer value = (Integer) fields[i].get(null);
	        map.put(value, name);
	      } catch (IllegalAccessException e) {
	      }
	    }
	    System.out.println(map);
	  }


}
