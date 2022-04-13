package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import dao.ClienteDAO;
import jdbc.CRUD;
import model.Cliente;

public class ClienteDAOImp implements ClienteDAO {
	
	private static final List<String>  columnas = 	Collections.unmodifiableList(
												    new ArrayList<String>() {{
												        add("id");
												        add("tipo");
												    }});
	
	private static final List<String> tipos = 	Collections.unmodifiableList(
											    new ArrayList<String>() {{
											        add("Int");
											        add("Int");
											    }});

	List<String> values= new ArrayList<String> (); 
	
	
	
	@Override
	 public List<Cliente> findAll()  throws SQLException{
		return findAllBy("", "", "");
	}

	
	
	@Override
	public int countAll() throws SQLException {
		Integer contar = 0; 
		ResultSet rs = CRUD.select("cliente", "count(*)", "");
		contar = rs.getInt(1);
		return contar;
	}
	
	

	@Override
	public int insert(Cliente t) throws SQLException {
		
		values.clear();
		values.add(t.getId().toString());
		values.add(t.getTipo().toString());
	
		return CRUD.insert("cliente", columnas, tipos, values);
	}

	
	
	@Override
	public int update(Cliente t) throws SQLException {
		
		String condicion = " where id = " + t.getId();
		
		values.clear();
		values.add(t.getId().toString());
		values.add(t.getTipo().toString());
				
		return CRUD.update("cliente", columnas, tipos, values, condicion);
	}
	
	

	@Override
	public int delete(Cliente t) throws SQLException {
		return CRUD.delete("cliente", "id", t.getId().toString(), "int");
	}
	
	

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return delete(findBy(campo, operador, valor));
	}
	
	

	@Override
	public Cliente findBy(String campo, String operador, String valor) throws SQLException {
		String condicion = campo + " " + operador + " " + valor;
		Cliente Cliente = new Cliente(null, null);
		ResultSet rs = CRUD.select("cliente", "*", condicion);
		if(rs.next()) {
			Cliente.setId(rs.getInt("id"));
			Cliente.setTipo(rs.getInt("tipo"));
		}
		return Cliente;
	}
	
	

	@Override
	public Cliente findById(int id) throws SQLException {
		return this.findBy("id", "=", String.valueOf(id));
	}
	
	

	@Override
	public List<Cliente> findAllBy(String campo, String operador, String valor) throws SQLException {
		List<Cliente> listaDecliente = new ArrayList<Cliente>();
		String condicion = "";
		
		if(!campo.equals("") && !operador.equals("") && !valor.equals("")) 
			condicion = campo + " " + operador + " " + valor;
		
		ResultSet rs = CRUD.select("cliente", "*", condicion);
		
		while (rs.next())
			listaDecliente.add(new Cliente(	rs.getInt("id"),
											rs.getInt("tipo")));		
		
		return listaDecliente;
	}
	
	
	
	public int updateEstado(Integer id, Integer valor) throws SQLException {
		return CRUD.updateEstado("cliente", valor, "id", id);
	}



	public ArrayList<List<String>> getClientes() throws SQLException {
		
		ArrayList<List<String>> clientes = new ArrayList<List<String>>();
		String query =    "SELECT DISTINCT"
						+ "    c.id,"
						+ "    CASE WHEN (c.tipo = 0) THEN "
						+ "        'Persona'"
						+ "    ELSE "
						+ "        'Empresa'"
						+ "    END AS 'tipo',"
						+ "    ISNULL(p.nombre + ' ' + p.apellido, e.razon_social) AS 'nombre_razon',"
						+ "    ISNULL(p.DNI, e.CUIT) AS 'DNI_CUIT',"
						+ "    ISNULL(CONVERT(varchar,e.inicio_actividad,23), '') AS inicio_actividad,"
						+ "    ISNULL((SELECT razon_social"
						+ "     FROM empresa"
						+ "     INNER JOIN empresa_persona ON empresa_persona.idEmpresa = empresa.id"
						+ "     AND empresa_persona.idPersona = p.id), '') AS 'pertenece_a',"
						+ "     c.estado"
						+ " FROM"
						+ "    cliente c"
						+ " LEFT JOIN empresa e ON e.idCliente = c.id"
						+ " LEFT JOIN persona p ON p.idCliente = c.id";
		
		ResultSet rs = CRUD.executeQuery(query);
		
		while (rs.next())
			clientes.add(new ArrayList<String>(Arrays.asList(	String.valueOf(rs.getInt("id")),
																rs.getString("tipo"),
																rs.getString("nombre_razon"),
																rs.getString("DNI_CUIT"),
																rs.getString("inicio_actividad"),
																rs.getString("pertenece_a"),
																String.valueOf(rs.getInt("estado")))));
			
		
		return clientes;
	}
	
}
