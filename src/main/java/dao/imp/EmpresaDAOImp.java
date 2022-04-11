package dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.EmpresaDAO;
import jdbc.CRUD;
import model.Empresa;

public class EmpresaDAOImp implements EmpresaDAO {
	
	EmpresaDAOImp Empresa = new EmpresaDAOImp();
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
	
}
