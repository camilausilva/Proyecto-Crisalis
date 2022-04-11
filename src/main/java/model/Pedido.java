package model;

import java.sql.Date;

public class Pedido {

	
	public static final double 	IVA = 0.21, 
								IIBB = 0.035, 
								DESCUENTO = 0.10;
	Integer id;
	Cliente cliente;
	Double 	monto;
	Boolean estado;
	Date fecha;
	
	
	/*------------------------------------------------------------------*/
	/* GETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public Integer getId() {
		return id;
	}
	public Cliente getIdCliente() {
		return cliente;
	}
	public Double getMonto() {
		return monto;
	}
	public Boolean getEstado() {
		return estado;
	}
	public Date getFecha() {
		return fecha;
	}

	
	/*------------------------------------------------------------------*/
	/* SETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	/*------------------------------------------------------------------*/
	/* CONSTRUCTOR                                                      */
	/*------------------------------------------------------------------*/

	public Pedido(Integer id, Cliente cliente, Double monto, Double costoAdicional,
			Boolean estado, Date fecha) {
		this.id = id;
		this.cliente = cliente;
		this.monto = monto;
		this.estado = estado;
		this.fecha = fecha;
	}
	
}
