package model;

import java.sql.Date;

public class Producto extends Pedido {

	
	public static final double GARANTIA = 0.02;
	Integer id,
			cantAnios;
	Boolean tieneGarantia;
	
	
	/*------------------------------------------------------------------*/
	/* GETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public Integer getId() {
		return id;
	}
	
	public Integer getCantAnios() {
		return cantAnios;
	}
	
	public Integer getIdPedido() {
		return super.getId();
	}
	
	/*------------------------------------------------------------------*/
	/* SETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setCantAnios(Integer cantAnios) {
		this.cantAnios = cantAnios;
	}
	
	public void setIdPedido(Integer id) {
		super.setId(id);
	}
	
	/*------------------------------------------------------------------*/
	/* CONSTRUCTOR                                                      */
	/*------------------------------------------------------------------*/
	
	public Producto(Integer idPedido, Cliente cliente, Cliente solicitante, Double montoBase, Double costoAdicional,
			Boolean estado, Date fecha, Integer id, Integer cantAnios, Boolean tieneGarantia) {
		super(idPedido, cliente, solicitante, montoBase, costoAdicional, estado, fecha);
		this.id = id;
		this.cantAnios = cantAnios;
		this.tieneGarantia = tieneGarantia;
	}

	/*------------------------------------------------------------------*/
	/* MÉTODOS                                                          */
	/*------------------------------------------------------------------*/
	
	private Double getGarantia(int cantAnios) {
		return (getMontoBase() * GARANTIA) * cantAnios;
	}

	@SuppressWarnings("unused")
	private Double getMontoGarantia() {
		return getCostoAdicional();
	}

	
}
