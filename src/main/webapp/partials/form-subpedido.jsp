<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<form class="form form-subpedido p-5" method="post" action="#">

    <h2>COMPLETE LOS CAMPOS DEL PRODUCTO O SERVICIO</h2>

    <div class="div-dropdown d-flex justify-content-end">
        <div class="dropdown">
			<label>¿Producto o Servicio?</label>
			&nbsp;
			<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2" data-bs-toggle="dropdown" aria-expanded="false">
			  Producto
			</button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton2" >
			  <li><a class="dropdown-item" href="#" id="dropdown-producto">Producto</a></li>
			  <li><a class="dropdown-item" href="#" id="dropdown-servicio">Servicio</a></li>
			</ul>
		</div>
    </div>

    <hr>

	<div class="row mb-4">
	
	    <div class="col">
	        <div class="form-outline">
	            <input type="text" id="inputNombre" class="form-control" placeholder="Nombre" 
	            onkeypress="return valideKeyString(event);"/>
	        </div>
	    </div>
	
	    <div class="col">
	        <div class="col">    
	            <div class="form-outline">
	                <input type="number" min="0" id="inputPrecio" class="form-control" placeholder="Precio"/>
	            </div>
	        </div> 
	    </div>       
	
		<div class="col">
					
			<!--INPUT PRODUCTO-->
			<div class="form-outline form-subpedido-producto">
				<div class="d-flex">
					<div class="input-group-text">
					  ¿Tiene Garant&iacute;a? &nbsp;
					  <input class="form-check-input mt-0" type="checkbox" value="" aria-label="Checkbox for following text input">
					</div>
				  	<input type="text" class="form-control" id="input-tiempo" aria-label="Text input with checkbox" placeholder="¿Cuantos años?" onkeypress="return valideKeyNumber(event);"/>  
				</div>
			</div>
			  
			<!--INPUT SERVICIO-->
			<div class="form-outline form-subpedido-servicio">
				<div class="d-flex">
					<div class="input-group-text">
					  ¿Servicio Especial? &nbsp;
					  <input class="form-check-input mt-0" type="checkbox" value="" aria-label="Checkbox for following text input">
					</div>
				 	<input type="text" class="form-control" id="input-tiempo" aria-label="Text input with checkbox" placeholder="¿Cuantos meses?" onkeypress="return valideKeyNumber(event);"/>
				</div>
			</div>
						    
		</div>
		      
	</div>
		
		    <div class="row mb-4">
		
		      <div class="col">
		        
		        <div class="input-group">
		          <span class="input-group-text">Descripci&oacute;n</span>
		          <textarea class="form-control" aria-label="With textarea"></textarea>
		        </div>
		
		      </div>       
		      
	    </div>
    
	<button type="submit" class="btn btn-dark btn-block mb-3 text-white">ACTUALIZAR DATOS</button>            

</form>