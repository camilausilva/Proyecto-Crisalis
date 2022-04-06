package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.PersonaDAO;
import jdbc.CRUD;
import model.Persona;

public class PersonaDAOImp implements PersonaDAO {
	
	PersonaDAOImp Persona = new PersonaDAOImp();
	ClienteDAOImp clienteDAOImp = new ClienteDAOImp();
	
	private static final List<String>  columnas = 	Collections.unmodifiableList(
												    new ArrayList<String>() {{
												    	add("idCliente");
												        add("id");
												        add("dni");
												        add("nombre");
												        add("apellido");
												    }});
	
	private static final List<String> tipos = 	Collections.unmodifiableList(
											    new ArrayList<String>() {{
											    	add("Int");
											        add("Int");
											        add("Int");
											        add("String");
											        add("String");
											    }});

	List<String> values= new ArrayList<String> (); 
	
	
	
	@Override
	 public List<Persona> findAll() throws SQLException{
		return findAllBy("", "", "");
	}

	
	
	@Override
	public int countAll() throws SQLException {
		Integer contar = 0; 
		ResultSet rs = CRUD.select("persona", "count(*)", "");
		contar = rs.getInt(1);
		return contar;
	}
	
	

	@Override
	public int insert(Persona t) throws SQLException {
	
		Integer insertCliente = clienteDAOImp.insert(t);
		
		values.clear();
		
		values.add(t.getIdCliente().toString());
		values.add(t.getId().toString());
		values.add(t.getDni().toString());
		values.add(t.getNombre());
		values.add(t.getApellido());
	
		return CRUD.insert("persona", columnas, tipos, values) + insertCliente;
	}

	
	
	@Override
	public int update(Persona t) throws SQLException {
		
		Integer updateCliente = clienteDAOImp.update(t);
		
		String condicion = " where id = " + t.getId();
		
		values.clear();
		
		values.add(t.getIdCliente().toString());
		values.add(t.getId().toString());
		values.add(t.getDni().toString());
		values.add(t.getNombre());
		values.add(t.getApellido());
				
		return CRUD.update("persona", columnas, tipos, values, condicion) + updateCliente;
	}
	
	

	@Override
	public int delete(Persona t) throws SQLException {
		return CRUD.delete("persona", "id", t.getId().toString(), "int");
	}
	
	

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return delete(findBy(campo, operador, valor));
	}
	
	

	@Override
	public Persona findBy(String campo, String operador, String valor) throws SQLException {
		String condicion = campo + " " + operador + " " + valor;
		Persona Persona = new Persona(null, null, null, null, null, null);
		ResultSet rs = CRUD.select("persona", "*", condicion);
		if(rs.next()) {
			Persona.setIdCliente(rs.getInt("idCliente"));
			Persona.setTipo(1);
			Persona.setId(rs.getInt("id"));
			Persona.setDni(rs.getInt("dni"));
			Persona.setNombre(rs.getString("nombre"));
			Persona.setApellido(rs.getString("apellido"));
		}	
		return Persona;
	}
	
	

	@Override
	public Persona findById(int id) throws SQLException {
		return this.findBy("id", "=", String.valueOf(id));
	}
	
	

	@Override
	public List<Persona> findAllBy(String campo, String operador, String valor) throws SQLException {
		List<Persona> listaDePersona = new ArrayList<Persona>();
		String condicion = "";
		
		if(!campo.equals("") && !operador.equals("") && !valor.equals("")) 
			condicion = campo + " " + operador + " " + valor;
		
		ResultSet rs = CRUD.select("persona", "*", condicion);
		
		while (rs.next())
			listaDePersona.add(new Persona(	rs.getInt("idCliente"),
											1,
											rs.getInt("id"),
											rs.getInt("dni"),
											rs.getString("nombre"),
											rs.getString("apellido")));	
		

		
		
		return listaDePersona;
	}
	
	
	
	public int updateEstado(Integer id, Integer valor) throws SQLException {
		return CRUD.updateEstado("persona", valor, "id", id);
	}
	
}
