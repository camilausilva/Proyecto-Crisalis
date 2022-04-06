package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.ClienteDAO;
import jdbc.CRUD;
import model.Cliente;

public class ClienteDAOImp implements ClienteDAO {
	
	ClienteDAOImp cliente = new ClienteDAOImp();
	
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
	
}
