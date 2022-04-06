package model;

public class Persona extends Cliente {


	Integer id,
			dni;
	String 	nombre, 
			apellido;
	
	
	/*------------------------------------------------------------------*/
	/* GETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public Integer getIdPersona() {
		return id;
	}
	public Integer getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public Integer getIdCliente() {
		return super.getId();
	}

	/*------------------------------------------------------------------*/
	/* SETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public void setIdPersona(Integer id) {
		this.id = id;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}	
	public void setIdCliente(Integer id) {
		super.setId(id);
	}
	
	/*------------------------------------------------------------------*/
	/* CONSTRUCTOR                                                      */
	/*------------------------------------------------------------------*/

	public Persona(Integer idCliente, Integer tipo, Integer id, Integer dni, String nombre, String apellido) {
		super(idCliente, tipo);
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	
	
	
	
}
