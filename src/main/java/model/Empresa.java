package model;

import java.sql.Date;

public class Empresa extends Cliente {

	
	Integer id,
			cuit;
	String 	razonSocial;
	Date 	inicioActividad;
	
	
	/*------------------------------------------------------------------*/
	/* GETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public Integer getId() {
		return id;
	}
	public Integer getCuit() {
		return cuit;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public Date getInicioActividad() {
		return inicioActividad;
	}
	public Integer getIdCliente() {
		return super.getId();
	}
	
	/*------------------------------------------------------------------*/
	/* SETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCuit(Integer cuit) {
		this.cuit = cuit;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public void setInicioActividad(Date inicioActividad) {
		this.inicioActividad = inicioActividad;
	}
	public void setIdCliente(Integer id) {
		super.setId(id);
	}
	
	/*------------------------------------------------------------------*/
	/* CONSTRUCTOR                                                      */
	/*------------------------------------------------------------------*/
	
	public Empresa(Integer idCliente, Integer tipo, Integer id, Integer cuit, String razonSocial,
			Date inicioActividad) {
		super(idCliente, tipo);
		this.id = id;
		this.cuit = cuit;
		this.razonSocial = razonSocial;
		this.inicioActividad = inicioActividad;
	}
	
	
	
}
