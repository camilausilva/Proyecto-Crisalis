<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<form class="form form-producto p-5">

    <h2>COMPLETE LOS CAMPOS DEL PRODUCTO</h2>

    <hr>

    <div class="row mb-4">

      <div class="col">

        <div class="form-outline form-cliente-persona">
          <input type="text" id="inputNombre" class="form-control" placeholder="Nombre" 
          onkeypress="return valideKeyString(event);"/>
        </div>

      </div>

      <div class="col">
        <div class="col">    
          <div class="form-outline form-cliente-persona">
            <input type="number" min="0" id="inputDni" class="form-control" placeholder="Precio"/>
          </div>
        </div> 


      </div>       


      <div class="col">

        <div class="input-group">

          <div class="input-group-text">
            �Tiene Garant&iacute;a? &nbsp;
            <input class="form-check-input mt-0" type="checkbox" value="" aria-label="Checkbox for following text input">
          </div>

          <input type="text" class="form-control" id="input-tiempo" aria-label="Text input with checkbox" placeholder="¿Cuántos años?" onkeypress="return valideKeyNumber(event);"/>

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
