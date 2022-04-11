package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.SubPedidoDAO;
import jdbc.CRUD;
import model.SubPedido;

public class SubPedidoDAOImp implements SubPedidoDAO {
	
	private static final List<String>  columnas = 	Collections.unmodifiableList(
												    new ArrayList<String>() {{
												    	add("id");
												    	add("tipo");
												    	add("nombre");
												    	add("precio");
												    	add("tiempo");
												    	add("descripcion");
												    	add("estado");
												    }});
	
	private static final List<String> tipos = 	Collections.unmodifiableList(
											    new ArrayList<String>() {{
											    	add("Int");
											    	add("Int");
											    	add("String");
											    	add("Double");
											    	add("Int");
											    	add("String");
											    	add("Boolean");
											    }});

	List<String> values= new ArrayList<String> (); 
	
	
	
	@Override
	 public List<SubPedido> findAll() throws SQLException{
		return findAllBy("", "", "");
	}

	
	
	@Override
	public int countAll() throws SQLException {
		Integer contar = 0; 
		ResultSet rs = CRUD.select("sub_pedido", "count(*)", "");
		contar = rs.getInt(1);
		return contar;
	}
	
	

	@Override
	public int insert(SubPedido t) throws SQLException {
	
		values.clear();

		values.add(t.getId().toString());
		values.add(t.getTipo().toString());
		values.add(t.getNombre().toString());
		values.add(t.getPrecio().toString());
		values.add(t.getTiempo().toString());
		values.add(t.getDescripcion().toString());
		values.add(t.getEstado().toString());
		
		return CRUD.insert("sub_pedido", columnas, tipos, values);
	}

	
	
	@Override
	public int update(SubPedido t) throws SQLException {
		
		String condicion = " where id = " + t.getId();
		
		values.clear();
		
		values.add(t.getId().toString());
		values.add(t.getTipo().toString());
		values.add(t.getNombre().toString());
		values.add(t.getPrecio().toString());
		values.add(t.getTiempo().toString());
		values.add(t.getDescripcion().toString());
		values.add(t.getEstado().toString());
				
		return CRUD.update("sub_pedido", columnas, tipos, values, condicion);
	}
	
	

	@Override
	public int delete(SubPedido t) throws SQLException {
		return CRUD.delete("sub_pedido", "id", t.getId().toString(), "int");
	}
	
	

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return delete(findBy(campo, operador, valor));
	}
	
	

	@Override
	public SubPedido findBy(String campo, String operador, String valor) throws SQLException {
		String condicion = campo + " " + operador + " " + valor;
		SubPedido SubPedido = new SubPedido(null, null, null, null, null, null, null);
		ResultSet rs = CRUD.select("sub_pedido", "*", condicion);
		if(rs.next()) {
			
			SubPedido.setId(rs.getInt("id"));
			SubPedido.setTipo(rs.getInt("tipo"));
			SubPedido.setNombre(rs.getString("nombre"));
			SubPedido.setPrecio(rs.getDouble("precio"));
			SubPedido.setTiempo(rs.getInt("tiempo"));
			SubPedido.setDescripcion(rs.getString("descripcion"));
			SubPedido.setEstado(rs.getBoolean("estado"));
			
		}
		
		return SubPedido;
		
	}
	
	

	@Override
	public SubPedido findById(int id) throws SQLException {
		return this.findBy("id", "=", String.valueOf(id));
	}
	
	

	@Override
	public List<SubPedido> findAllBy(String campo, String operador, String valor) throws SQLException {
		List<SubPedido> listaDeSubPedido = new ArrayList<SubPedido>();
		String condicion = "";
		
		if(!campo.equals("") && !operador.equals("") && !valor.equals("")) 
			condicion = campo + " " + operador + " " + valor;
		
		String query = "SELECT"
					+ "    ped.id idPedido,"
					+ "    ped.idCliente,"
					+ "    ped.idSolicitante,"
					+ "    ped.precio,"
					+ "    ped.costoAdicional,"
					+ "    ped.estado,"
					+ "    ped.fecha,"
					+ "    prod.id,"
					+ "    prod.cantAnios"
					+ "FROM sub_pedido prod"
					+ "INNER JOIN pedido_sub_pedido ped_prod ON ped_prod.idSubPedido = prod.id"
					+ "INNER JOIN pedido ped ON ped_prod.idPedido = ped.id";
		
		if(!condicion.equals(""))
			query += " WHERE " + condicion;
			
		ResultSet rs = CRUD.executeQuery(query);
		
		while (rs.next())
			listaDeSubPedido.add(new SubPedido(	rs.getInt("id"),
												rs.getInt("tipo"),
												rs.getString("nombre"),
												rs.getDouble("precio"),
												rs.getInt("tiempo"),
												rs.getString("descripcion"),
												rs.getBoolean("estado")));
		return listaDeSubPedido;
	}
	
	
	
	public int updateEstado(Integer id, Integer valor) throws SQLException {
		return CRUD.updateEstado("sub_pedido", valor, "id", id);
	}
	
}
