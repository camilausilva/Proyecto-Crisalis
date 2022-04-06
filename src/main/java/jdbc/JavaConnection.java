package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaConnection {
		
	private static final String url = "jdbc:sqlserver://DESKTOP-CU840LI:1433;"
								    + "database=db;"
								    + "user=sa;"
								    + "password=123a;"
								    + "TrustServerCertificate=True;"
								    + "loginTimeout=30;";
	private static Connection connection;
	
	
	
	public static void tryConnect() {
		
		try {	
			Connection c = getConnection();			
			System.out.println("Conectado.");
		} 
		catch (SQLException e)
		{
			System.out.println("Error.");
			e.printStackTrace();
		}
		
	}
	
	
	
	public static Connection getConnection() throws SQLException {
		
		if (connection == null) {
			connection = DriverManager.getConnection(url);
		}
		
		return connection;
		
	}
	
	
	
}
