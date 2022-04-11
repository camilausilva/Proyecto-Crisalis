<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<form class="form form-cliente p-5">

    <h2>COMPLETE LOS CAMPOS DEL CLIENTE</h2>

    <div class="div-dropdown d-flex justify-content-end">
        <div class="dropdown">
          <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
            Tipo de Cliente: Persona
          </button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1" >
            <li><a class="dropdown-item" href="#" id="dropdown-cliente-persona">Persona</a></li>
            <li><a class="dropdown-item" href="#" id="dropdown-cliente-empresa">Empresa</a></li>
          </ul>
        </div>
    </div>

    <hr>

    <div class="row mb-4">

      <div class="col">
        <!--PERSONA-->
        <div class="form-outline form-cliente-persona">
          <input type="text" id="inputNombre" class="form-control" 
          onkeypress="return valideKeyString(event);"/>
          <label class="form-label" for="inputNombre">Nombre</label>
        </div>
        <!--EMPRESA-->
        <div class="form-outline form-cliente-empresa">
          <input type="text" id="inputRazonSocial" class="form-control" 
          onkeypress="return valideKeyString(event);"/>
          <label class="form-label" for="inputRazonSocial">Raz&oacute;n Social</label> 
        </div>
      </div>

      <div class="col">
        <!--PERSONA-->
        <div class="form-outline form-cliente-persona">
          <input type="text" id="inputApellido" class="form-control" 
          onkeypress="return valideKeyString(event);"/>
          <label class="form-label" for="inputApellido">Apellido</label>
        </div>
        <!--EMPRESA-->
        <div class="input-group date form-cliente-empresa" id="datepicker">
          <input type="text" class="form-control" id="date"/>
          <span class="input-group-append">
            <span class="input-group-text bg-light d-block">
              <i class="fa fa-calendar"></i>
            </span>
          </span>
        </div>
        <label class="form-label form-cliente-empresa" for="date">Inicio de Actividades</label>
      </div>

      <div class="col">    
        <!--PERSONA-->
        <div class="form-outline form-cliente-persona">
          <input type="number" min="0" id="inputDni" class="form-control" onkeypress="return valideKeyNumber(event);"/>
          <label class="form-label" for="inputDni">DNI</label>
        </div>

          <!--EMPRESA-->
        <div class="form-outline form-cliente-empresa">
          <input type="number" min="0" id="inputCuit" class="form-control" onkeypress="return valideKeyNumber(event);"/>
          <label class="form-label" for="inputCuit">CUIT</label>
        </div>
      </div>                 
      
    </div>
    
    <select class="form-select " aria-label="Default select example">
      <option selected>¿Pertenece a una Empresa?</option>
      <option value="0">Ninguna</option>
      <option value="1">One</option>
      <option value="2">Two</option>
      <option value="3">Three</option>
    </select>

    <button type="submit" class="btn btn-dark btn-block mt-5 mb-3 text-white">ACTUALIZAR DATOS</button>

</form>