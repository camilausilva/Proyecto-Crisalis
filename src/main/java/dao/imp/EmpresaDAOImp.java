package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import dao.EmpresaDAO;
import jdbc.CRUD;
import jdbc.JavaConnection;
import model.Empresa;

public class EmpresaDAOImp implements EmpresaDAO {
	
	ClienteDAOImp clienteDAOImp = new ClienteDAOImp();
	
	private static final List<String>  columnas = 	Collections.unmodifiableList(
												    new ArrayList<String>() {{
												    	add("idCliente");
												        add("id");
												        add("cuit");
												        add("razon_social");
												        add("inicio_actividad");
												    }});
	
	private static final List<String> tipos = 	Collections.unmodifiableList(
											    new ArrayList<String>() {{
											    	add("Int");
											        add("Int");
											        add("Int");
											        add("String");
											        add("Date");
											    }});

	List<String> values= new ArrayList<String> (); 
	
	
	
	@Override
	 public List<Empresa> findAll() throws SQLException{
		return findAllBy("", "", "");
	}

	
	
	@Override
	public int countAll() throws SQLException {
		Integer contar = 0; 
		ResultSet rs = CRUD.select("empresa", "count(*)", "");
		contar = rs.getInt(1);
		return contar;
	}
	
	

	@Override
	public int insert(Empresa t) throws SQLException {
	
		Integer insertCliente = clienteDAOImp.insert(t);
		
		values.clear();
		
		values.add(t.getIdCliente().toString());
		values.add(t.getId().toString());
		values.add(t.getCuit().toString());
		values.add(t.getRazonSocial());
		values.add(t.getInicioActividad().toString());
	
		return CRUD.insert("empresa", columnas, tipos, values) + insertCliente;
	}

	
	
	@Override
	public int update(Empresa t) throws SQLException {
		
		Integer updateCliente = clienteDAOImp.update(t);
		
		String condicion = " where id = " + t.getId();
		
		values.clear();
		values.add(t.getIdCliente().toString());
		values.add(t.getId().toString());
		values.add(t.getCuit().toString());
		values.add(t.getRazonSocial());
		values.add(t.getInicioActividad().toString());
				
		return CRUD.update("empresa", columnas, tipos, values, condicion) + updateCliente;
	}
	
	

	@Override
	public int delete(Empresa t) throws SQLException {
		return CRUD.delete("empresa", "id", t.getId().toString(), "int");
	}
	
	

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return delete(findBy(campo, operador, valor));
	}
	
	

	@Override
	public Empresa findBy(String campo, String operador, String valor) throws SQLException {
		String condicion = campo + " " + operador + " " + valor;
		Empresa Empresa = new Empresa(null, null, null, null, null, null);
		ResultSet rs = CRUD.select("empresa", "*", condicion);
		if(rs.next()) {
			Empresa.setIdCliente(rs.getInt("idCliente"));
			Empresa.setTipo(1);
			Empresa.setId(rs.getInt("id"));
			Empresa.setCuit(rs.getInt("cuit"));
			Empresa.setRazonSocial(rs.getString("razon_social"));
			Empresa.setInicioActividad(rs.getDate("inicio_actividad"));
		}
		
//		String call = "{call ADDFACULTYDEPTSAL(?,?,?)}";
//		
//		try (CallableStatement stmt = Connection.prepareCall(call)) {
//		stmt.setInt(1, Integer.parseInt(fid.getText()));
//		stmt.setString(2, fname.getText());
//		stmt.setInt(3, Integer.parseInt(did.getText()));
//		stmt.execute();
//		}
		
		
		return Empresa;
	}
	
	

	@Override
	public Empresa findById(int id) throws SQLException {
		return this.findBy("id", "=", String.valueOf(id));
	}
	
	

	@Override
	public List<Empresa> findAllBy(String campo, String operador, String valor) throws SQLException {
		List<Empresa> listaDeEmpresa = new ArrayList<Empresa>();
		String condicion = "";
		
		if(!campo.equals("") && !operador.equals("") && !valor.equals("")) 
			condicion = campo + " " + operador + " " + valor;
		
		ResultSet rs = CRUD.select("empresa", "*", condicion);
		
		while (rs.next())
			listaDeEmpresa.add(new Empresa(	rs.getInt("idCliente"),
											1,
											rs.getInt("id"),
											rs.getInt("cuit"),
											rs.getString("razon_social"),
											rs.getDate("inicio_actividad")));		
		
		return listaDeEmpresa;
	}
	
	
	
	public int updateEstado(Integer id, Integer valor) throws SQLException {
		return CRUD.updateEstado("Empresa", valor, "id", id);
	}
	
	public int addEmpresa(String razonSocial, String inicioActividades, String CUIT) throws SQLException {
		String query = "insert into empresa (idCliente, razon_social, inicio_actividad, CUIT)"
				+ " values (" 
					+ getIdCliente() + ", " 
					+ "'" + razonSocial + "', "
					+ "'" + inicioActividades + "', "
					+ "'" + CUIT + "')";
		
		Connection connection = JavaConnection.getConnection();
		PreparedStatement datos = connection.prepareStatement(query);
		
		return datos.executeUpdate();
	}
	
	private int getIdCliente() throws SQLException {
		String query = "select ISNULL((select top 1 id"
					 + "    from cliente "
				     + "    order by id desc), 1) as 'idCliente'";
		ResultSet rs = CRUD.executeQuery(query);
		Integer idCliente = 1;
		if(rs.next())
			idCliente = rs.getInt("idCliente");
		return idCliente;
	} 
	
	public ArrayList<List<String>> getEmpresas() throws SQLException {
		
		ArrayList<List<String>> empresas = new ArrayList<List<String>>();
		String query = "SELECT id, razon_social FROM empresa";
		
		ResultSet rs = CRUD.executeQuery(query);
		
		while (rs.next())
			empresas.add(new ArrayList<String>(Arrays.asList(	String.valueOf(rs.getInt("id")),
																rs.getString("razon_social"))));
			
		
		return empresas;
	}
	
}
