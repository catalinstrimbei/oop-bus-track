package example;


import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

//http://www.tutorialspoint.com/jdbc/jdbc-data-types.htm

public class TestJDBC {

	public static void main(String[] args) throws Exception{
		//java.util.Map map = con.getTypeMap();

		
		String URL = "jdbc:oracle:thin:@10.10.0.7:1521:ORCL";

		String USER = "scrum";

		String PASS = "scrum";

		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		java.util.Map map = conn.getTypeMap();
		
		System.out.println(map.size());
		
		ResultSet typeInfo = conn.getMetaData().getTypeInfo();
		// TYPE_NAME 
		// DATA_TYPE
		while(typeInfo.next()){
			System.out.println(typeInfo.getString("TYPE_NAME") + " - " + typeInfo.getString("DATA_TYPE"));
//			System.out.println("-------------------------------------------");
//			try{
//				for(int i=1; i<10; i++){
//					System.out.println(typeInfo.getString(i));
//				}
//			}catch(Exception ex){}
//			System.out.println("-------------------------------------------");
		}
		
		Map<Integer, String> typeName = getAllJdbcTypeNames();
	}
	
	public static Map<Integer, String> getAllJdbcTypeNames() throws Exception{

	    Map<Integer, String> result = new HashMap<Integer, String>();

	    for (Field field : Types.class.getFields()) {
	    	System.out.println((Integer)field.get(null) + " -> " + field.getName() + " -> " + field.getGenericType().getClass().getName());
	        result.put((Integer)field.get(null), field.getName());
	    }

	    return result;
	}	

}
