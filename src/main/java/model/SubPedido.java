package model;

public class SubPedido {

	
	public static final double GARANTIA = 0.02;
	public static final double CARGO_SOPORTE = 0.05;
	Integer id,
			tipo,
			tiempo;
	String	nombre,
			descripcion;
	Double	precio,
			costoAdicional;
	Boolean estado;

	
	/*------------------------------------------------------------------*/
	/* GETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public Boolean getEstado() {
		return estado;
	}
	public Integer getId() {
		return id;
	}
	public Integer getTipo() {
		return tipo;
	}
	public Integer getTiempo() {
		return tiempo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Double getPrecio() {
		return precio;
	}
	
	/*------------------------------------------------------------------*/
	/* SETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}
	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	/*------------------------------------------------------------------*/
	/* CONSTRUCTOR                                                      */
	/*------------------------------------------------------------------*/
	
	public SubPedido(Integer id, Integer tipo, String nombre, Double precio, Integer tiempo, String descripcion, Boolean estado) {
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.precio = precio;
		this.tiempo = tiempo;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	
	/*------------------------------------------------------------------*/
	/* METODOS                                                          */
	/*------------------------------------------------------------------*/
	
	private Double getCostoAdicional(int tiempo) {
		if(tiempo>0)
			return (getPrecio() * CARGO_SOPORTE) * tiempo;
		return costoAdicional;
	}

	private Double getCostoAdicional() {
		return getCostoAdicional();
	}
	
}
