package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.ServicioDAO;
import jdbc.CRUD;
import model.Servicio;

public class ServicioDAOImp implements ServicioDAO {
	
	ServicioDAOImp Servicio = new ServicioDAOImp();
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
												    	add("cantMeses");
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
	 public List<Servicio> findAll() throws SQLException{
		return findAllBy("", "", "");
	}

	
	
	@Override
	public int countAll() throws SQLException {
		Integer contar = 0; 
		ResultSet rs = CRUD.select("servicio", "count(*)", "");
		contar = rs.getInt(1);
		return contar;
	}
	
	

	@Override
	public int insert(Servicio t) throws SQLException {
	
		Integer insertPedido = pedidoDAOImp.insert(t);
		
		values.clear();
		
		values.add(t.getIdPedido().toString());
		values.add(t.getIdCliente().toString());
		values.add(t.getIdSolicitante().toString());
		values.add(t.getMontoBase().toString());
		values.add(t.getCostoAdicional().toString());
		values.add(t.getEstado().toString());
		values.add(t.getFecha().toString());
		values.add(t.getId().toString());
		values.add(t.getCantMeses().toString());
		
		return CRUD.insert("servicio", columnas, tipos, values) + insertPedido;
	}

	
	
	@Override
	public int update(Servicio t) throws SQLException {
		
		Integer updatePedido = pedidoDAOImp.update(t);
		
		String condicion = " where id = " + t.getId();
		
		values.add(t.getIdPedido().toString());
		values.add(t.getIdCliente().toString());
		values.add(t.getIdSolicitante().toString());
		values.add(t.getMontoBase().toString());
		values.add(t.getCostoAdicional().toString());
		values.add(t.getEstado().toString());
		values.add(t.getFecha().toString());
		values.add(t.getId().toString());
		values.add(t.getCantMeses().toString());
				
		return CRUD.update("servicio", columnas, tipos, values, condicion) + updatePedido;
	}
	
	

	@Override
	public int delete(Servicio t) throws SQLException {
		return CRUD.delete("servicio", "id", t.getId().toString(), "int");
	}
	
	

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return delete(findBy(campo, operador, valor));
	}
	
	

	@Override
	public Servicio findBy(String campo, String operador, String valor) throws SQLException {
		String condicion = campo + " " + operador + " " + valor;
		Servicio Servicio = new Servicio(null, null, null, null, null, null, null, null, null, null);
		ResultSet rs = CRUD.select("servicio", "*", condicion);
		if(rs.next()) {
			
			Servicio.setIdPedido(rs.getInt("idPedido"));
			Servicio.setCliente(clienteDAOImp.findById(rs.getInt("idCliente")));
			Servicio.setSolicitante(clienteDAOImp.findById(rs.getInt("idSolicitante")));
			Servicio.setMontoBase(rs.getDouble("montoBase"));
			Servicio.setCostoAdicional(rs.getDouble("costoAdicional"));
			Servicio.setEstado(rs.getBoolean("estado"));
			Servicio.setFecha(rs.getDate("fecha"));
			Servicio.setId(rs.getInt("id"));
			Servicio.setCantMeses(rs.getInt("cantMeses"));
			
		}
		
		return Servicio;
		
	}
	
	

	@Override
	public Servicio findById(int id) throws SQLException {
		return this.findBy("id", "=", String.valueOf(id));
	}
	
	

	@Override
	public List<Servicio> findAllBy(String campo, String operador, String valor) throws SQLException {
		List<Servicio> listaDeServicio = new ArrayList<Servicio>();
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
				+ "    serv.id,"
				+ "    serv.cantMeses"
				+ "FROM servicio serv"
				+ "INNER JOIN pedido_servicio ped_serv ON ped_serv.idServicio = serv.id"
				+ "INNER JOIN pedido ped ON ped_serv.idPedido = ped.id";
		
		if(!condicion.equals(""))
			query += " WHERE " + condicion;
		
		ResultSet rs = CRUD.executeQuery(query);
		
		while (rs.next())
			listaDeServicio.add(new Servicio(	rs.getInt("idPedido"),
												clienteDAOImp.findById(rs.getInt("idCliente")),
												clienteDAOImp.findById(rs.getInt("idSolicitante")),
												rs.getDouble("montoBase"),
												rs.getDouble("costoAdicional"),
												rs.getBoolean("estado"),
												rs.getDate("fecha"),
												rs.getInt("id"),
												rs.getInt("cantMeses"),
												(rs.getInt("cantMeses")<1)));
		return listaDeServicio;
	}
	
	
	
	public int updateEstado(Integer id, Integer valor) throws SQLException {
		return CRUD.updateEstado("servicio", valor, "id", id);
	}
	
}
