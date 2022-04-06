package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;

import dao.ProductoDAO;
import jdbc.CRUD;
import model.Producto;

public class ProductoDAOImp implements ProductoDAO {
	
	ProductoDAOImp Producto = new ProductoDAOImp();
	PedidoDAOImp pedidoDAOImp = new PedidoDAOImp();
	ClienteDAOImp clienteDAOImp = new ClienteDAOImp();
	
	private static final List<String>  columnas = 	Collections.unmodifiableList(
												    new ArrayList<String>() {{
												    	add("idPedido");
												    	add("idCliente");
												    	add("idSolicitante");
												    	add("montoBase");
												    	add("costoAdicional");
												    	add("estado");
												    	add("fecha");
												    	add("id");
												    	add("cantAnios");
												    }});
	
	private static final List<String> tipos = 	Collections.unmodifiableList(
											    new ArrayList<String>() {{
											    	add("Int");
											    	add("Int");
											    	add("Int");
											    	add("Double");
											    	add("Double");
											    	add("Boolean");
											    	add("Date");
											    	add("Int");
											    	add("Int");
											    }});

	List<String> values= new ArrayList<String> (); 
	
	
	
	@Override
	 public List<Producto> findAll() throws SQLException{
		return findAllBy("", "", "");
	}

	
	
	@Override
	public int countAll() throws SQLException {
		Integer contar = 0; 
		ResultSet rs = CRUD.select("producto", "count(*)", "");
		contar = rs.getInt(1);
		return contar;
	}
	
	

	@Override
	public int insert(Producto t) throws SQLException {
	
		Integer insertPedido = pedidoDAOImp.insert(t);
		
		values.clear();

		values.add(t.getId().toString());
		values.add(t.getCantAnios().toString());
		
		return CRUD.insert("producto", columnas, tipos, values) + insertPedido;
	}

	
	
	@Override
	public int update(Producto t) throws SQLException {
		
		Integer updatePedido = pedidoDAOImp.update(t);
		
		String condicion = " where id = " + t.getId();
		
		values.clear();
		
		values.add(t.getId().toString());
		values.add(t.getCantAnios().toString());
				
		return CRUD.update("producto", columnas, tipos, values, condicion) + updatePedido;
	}
	
	

	@Override
	public int delete(Producto t) throws SQLException {
		return CRUD.delete("producto", "id", t.getId().toString(), "int");
	}
	
	

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return delete(findBy(campo, operador, valor));
	}
	
	

	@Override
	public Producto findBy(String campo, String operador, String valor) throws SQLException {
		String condicion = campo + " " + operador + " " + valor;
		Producto Producto = new Producto(null, null, null, null, null, null, null, null, null, null);
		ResultSet rs = CRUD.select("producto", "*", condicion);
		if(rs.next()) {
			
			Producto.setIdPedido(rs.getInt("idPedido"));
			Producto.setCliente(clienteDAOImp.findById(rs.getInt("idCliente")));
			Producto.setSolicitante(clienteDAOImp.findById(rs.getInt("idSolicitante")));
			Producto.setMontoBase(rs.getDouble("montoBase"));
			Producto.setCostoAdicional(rs.getDouble("costoAdicional"));
			Producto.setEstado(rs.getBoolean("estado"));
			Producto.setFecha(rs.getDate("fecha"));
			Producto.setId(rs.getInt("id"));
			Producto.setCantAnios(rs.getInt("cantAnios"));
			
		}
		
		return Producto;
		
	}
	
	

	@Override
	public Producto findById(int id) throws SQLException {
		return this.findBy("id", "=", String.valueOf(id));
	}
	
	

	@Override
	public List<Producto> findAllBy(String campo, String operador, String valor) throws SQLException {
		List<Producto> listaDeProducto = new ArrayList<Producto>();
		String condicion = "";
		
		if(!campo.equals("") && !operador.equals("") && !valor.equals("")) 
			condicion = campo + " " + operador + " " + valor;
		
		String query = "SELECT"
				+ "    ped.id idPedido,"
				+ "    ped.idCliente,"
				+ "    ped.idSolicitante,"
				+ "    ped.montoBase,"
				+ "    ped.costoAdicional,"
				+ "    ped.estado,"
				+ "    ped.fecha,"
				+ "    prod.id,"
				+ "    prod.cantAnios"
				+ "FROM producto prod"
				+ "INNER JOIN pedido_producto ped_prod ON ped_prod.idProducto = prod.id"
				+ "INNER JOIN pedido ped ON ped_prod.idPedido = ped.id";
		
		if(!condicion.equals(""))
			query += " WHERE " + condicion;
			
		ResultSet rs = CRUD.executeQuery(query);
		
		while (rs.next())
			listaDeProducto.add(new Producto(	rs.getInt("idPedido"),
												clienteDAOImp.findById(rs.getInt("idCliente")),
												clienteDAOImp.findById(rs.getInt("idSolicitante")),
												rs.getDouble("montoBase"),
												rs.getDouble("costoAdicional"),
												rs.getBoolean("estado"),
												rs.getDate("fecha"),
												rs.getInt("id"),
												rs.getInt("cantAnios"),
												(rs.getInt("cantAnios")<1)));
		return listaDeProducto;
	}
	
	
	
	public int updateEstado(Integer id, Integer valor) throws SQLException {
		return CRUD.updateEstado("producto", valor, "id", id);
	}
	
}
