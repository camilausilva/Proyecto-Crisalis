package model;

import java.sql.Date;

public class Servicio extends Pedido {

	
	public static final double CARGO_SOPORTE = 0.05;
	Integer id,
			cantMeses;
	Boolean esEspecial;
	
	
	
	/*------------------------------------------------------------------*/
	/* GETTERS                                                          */
	/*------------------------------------------------------------------*/

	public Integer getIdServicio() {
		return id;
	}
	
	public Integer getCantMeses() {
		return cantMeses;
	}
	
	public Boolean getEsEspecial() {
		return esEspecial;
	}
	
	public Integer getIdPedido() {
		return super.getId();
	}
	
	/*------------------------------------------------------------------*/
	/* SETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public void setIdServicio(Integer id) {
		this.id = id;
	}
	
	public void setCantMeses(Integer cantMeses) {
		this.cantMeses = cantMeses;
	}
	
	public void setEsEspecial(Boolean esEspecial) {
		this.esEspecial = esEspecial;
	}
	
	public void setIdPedido(Integer id) {
		super.setId(id);
	}
	
	/*------------------------------------------------------------------*/
	/* CONSTRUCTOR                                                      */
	/*------------------------------------------------------------------*/
	
	public Servicio(Integer idPedido, Cliente cliente, Cliente solicitante, Double montoBase, Double costoAdicional,
			Boolean estado, Date fecha, Integer id, Integer cantMeses, Boolean esEspecial) {
		super(idPedido, cliente, solicitante, montoBase, costoAdicional, estado, fecha);
		this.id = id;
		this.cantMeses = cantMeses;
		this.esEspecial = esEspecial;
	}
	
	/*------------------------------------------------------------------*/
	/* MÉTODOS                                                          */
	/*------------------------------------------------------------------*/

	private Double getCargoSoporte(int cantMeses) {
		if(esEspecial)
			return (getMontoBase() * CARGO_SOPORTE) * cantMeses;
		return costoAdicional;
	}

	@SuppressWarnings("unused")
	private Double getMontoCargoSoporte() {
		return getCostoAdicional();
	}

}
