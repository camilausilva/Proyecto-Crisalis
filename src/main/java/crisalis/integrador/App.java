package crisalis.integrador;

import java.sql.SQLException;

import jdbc.JavaConnection;

public class App {
	
	public static void main(String[] args) throws SQLException {
		
		JavaConnection.tryConnect();
		
	}
	
}