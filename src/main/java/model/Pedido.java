package model;

import java.sql.Date;

public class Pedido {

	
	public static final double 	IVA = 0.21, 
								IIBB = 0.035, 
								DESCUENTO = 0.10;
	Integer id;
	Cliente cliente;
	Cliente solicitante;
	Double 	montoBase, 
			costoAdicional;
	Boolean estado;
	Date fecha;
	
	
	/*------------------------------------------------------------------*/
	/* GETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public Double getMontoBase() {
		return montoBase;
	}
	public Boolean getEstado() {
		return estado;
	}
	public Date getFecha() {
		return fecha;
	}
	public Double getCostoAdicional() {
		return costoAdicional;
	}
	public Integer getId() {
		return id;
	}
	public Cliente getIdCliente() {
		return cliente;
	}
	public Cliente getIdSolicitante() {
		return solicitante;
	}
	
	/*------------------------------------------------------------------*/
	/* SETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setMontoBase(Double montoBase) {
		this.montoBase = montoBase;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setCostoAdicional(Double costoAdicional) {
		this.costoAdicional = costoAdicional;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setSolicitante(Cliente solicitante) {
		this.solicitante = solicitante;
	}
	
	/*------------------------------------------------------------------*/
	/* CONSTRUCTOR                                                      */
	/*------------------------------------------------------------------*/

	public Pedido(Integer id, Cliente cliente, Cliente solicitante, Double montoBase, Double costoAdicional,
			Boolean estado, Date fecha) {
		this.id = id;
		this.cliente = cliente;
		this.solicitante = solicitante;
		this.montoBase = montoBase;
		this.costoAdicional = costoAdicional;
		this.estado = estado;
		this.fecha = fecha;
	}
	
	/*------------------------------------------------------------------*/
	/* MÉTODOS                                                          */
	/*------------------------------------------------------------------*/


	
}
