package model;

public class Cliente {

	
	Integer id,
			tipo;

	
	/*------------------------------------------------------------------*/
	/* GETTERS                                                          */
	/*------------------------------------------------------------------*/
	
	public Integer getId() {
		return id;
	}
	public Integer getTipo() {
		return tipo;
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

	/*------------------------------------------------------------------*/
	/* CONSTRUCTOR                                                      */
	/*------------------------------------------------------------------*/
	
	public Cliente(Integer id, Integer tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	
}
