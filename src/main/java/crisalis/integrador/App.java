package crisalis.integrador;

import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JavaConnection;
import model.Cliente;
import model.Pedido;

public class App {
	
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	public static void main(String[] args) throws SQLException {
		
		JavaConnection.tryConnect();
		
	}
	
}
