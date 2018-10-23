package commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class OraConn {

	public static Connection connect() throws SQLException, ClassNotFoundException{
		Connection conn = null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = OraConn.buildUrl("localhost", "1521");
		conn = DriverManager.getConnection(url,"juan","123");
		return conn;
	}
	
	private static  String buildUrl(String host, String port) {
		//jdbc:oracle:thin:@myhost:1521:orcl
		return "jdbc:oracle:thin:@"+host+":"+port+":xe";	
	}
}
