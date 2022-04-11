package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.PedidoDAO;
import jdbc.CRUD;
import model.Pedido;

public class PedidoDAOImp implements PedidoDAO {
	
	PedidoDAOImp Pedido = new PedidoDAOImp();
	ClienteDAOImp clienteDAOImp = new ClienteDAOImp();
	
	private static final List<String>  columnas = 	Collections.unmodifiableList(
												    new ArrayList<String>() {{
												        add("id");
												        add("idCliente");
												        add("monto");
												        add("estado");
												        add("fecha");
												    }});
	
	private static final List<String> tipos = 	Collections.unmodifiableList(
											    new ArrayList<String>() {{
											    	add("Int");
											        add("Int");
											        add("Double");
											        add("Boolean");
											        add("Date");
											    }});

	List<String> values= new ArrayList<String> (); 
	
	
	
	@Override
	 public List<Pedido> findAll() throws SQLException{
		return findAllBy("", "", "");
	}

	
	
	@Override
	public int countAll() throws SQLException {
		Integer contar = 0; 
		ResultSet rs = CRUD.select("pedido", "count(*)", "");
		contar = rs.getInt(1);
		return contar;
	}
	
	

	@Override
	public int insert(Pedido t) throws SQLException {
	
		values.clear();
		
		values.add(t.getId().toString());
		values.add(t.getIdCliente().toString());
		values.add(t.getMonto().toString());
		values.add(t.getEstado().toString());
		values.add(t.getFecha().toString());
	
		return CRUD.insert("pedido", columnas, tipos, values);
	}

	
	
	@Override
	public int update(Pedido t) throws SQLException {
	
		String condicion = " where id = " + t.getId();
		
		values.clear();
		
		values.add(t.getId().toString());
		values.add(t.getIdCliente().toString());
		values.add(t.getMonto().toString());
		values.add(t.getEstado().toString());
		values.add(t.getFecha().toString());
				
		return CRUD.update("pedido", columnas, tipos, values, condicion);
	}
	
	

	@Override
	public int delete(Pedido t) throws SQLException {
		return CRUD.delete("pedido", "id", t.getId().toString(), "int");
	}
	
	

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return delete(findBy(campo, operador, valor));
	}
	
	

	@Override
	public Pedido findBy(String campo, String operador, String valor) throws SQLException {
		String condicion = campo + " " + operador + " " + valor;
		Pedido Pedido = new Pedido(null, null, null, null, null, null);
		ResultSet rs = CRUD.select("pedido", "*", condicion);
		if(rs.next()) {
			Pedido.setId(rs.getInt("id"));
			Pedido.setCliente(clienteDAOImp.findById(rs.getInt("idCliente")));
			Pedido.setMonto(rs.getDouble("monto"));
			Pedido.setEstado(rs.getBoolean("estado"));
			Pedido.setFecha(rs.getDate("fecha"));
		}
		
		return Pedido;
	}
	
	

	@Override
	public Pedido findById(int id) throws SQLException {
		return this.findBy("id", "=", String.valueOf(id));
	}
	
	

	@Override
	public List<Pedido> findAllBy(String campo, String operador, String valor) throws SQLException {
		List<Pedido> listaDePedido = new ArrayList<Pedido>();
		String condicion = "";
		
		if(!campo.equals("") && !operador.equals("") && !valor.equals("")) 
			condicion = campo + " " + operador + " " + valor;
		
		ResultSet rs = CRUD.select("pedido", "*", condicion);
		
		while (rs.next())
			listaDePedido.add(new Pedido(	rs.getInt("id"),
											clienteDAOImp.findById(rs.getInt("idCliente")),
											rs.getDouble("monto"),
											rs.getDouble("costoAdicional"),
											rs.getBoolean("estado"),
											rs.getDate("fecha")));		
		return listaDePedido;
	}
	
	
	
	public int updateEstado(Integer id, Integer valor) throws SQLException {
		return CRUD.updateEstado("pedido", valor, "id", id);
	}
	
}
