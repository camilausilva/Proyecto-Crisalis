package service;

import java.sql.SQLException;
import java.util.List;

import dao.imp.ServicioDAOImp;
import model.Servicio;

public class ServicioService extends ServicioDAOImp {
	@Override
	public List<Servicio> findAll()  throws SQLException {
		return super.findAll();
	}
	
	@Override	
	public int countAll() throws SQLException {
		 return super.countAll();	
	}
	
	@Override	
	public int insert(Servicio t) throws SQLException {
		return super.insert(t);
	}

	@Override
	public int update(Servicio t) throws SQLException {
		return super.update(t);
	}
	
	@Override
	public int delete(Servicio t) throws SQLException {
		return super.delete(t);
	}

	@Override
	public int deleteBy(String campo, String operador, String valor) throws SQLException {
		return super.deleteBy(campo, operador, valor);
	}
	
	@Override
	public Servicio findBy(String campo, String operador, String valor) throws SQLException {
		return super.findBy(campo, operador, valor);
	}

	@Override
	public Servicio findById(int id) throws SQLException {
		return super.findById(id);
	}
	
	@Override
	public List<Servicio> findAllBy(String campo, String operador, String valor)  throws SQLException{
		return super.findAllBy(campo, operador, valor);
	}
	
	@Override
	public int updateEstado(Integer id, Integer valor) throws SQLException {
		return super.updateEstado(id, valor);
	}
}
