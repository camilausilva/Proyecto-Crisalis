<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%@page import="dao.imp.ClienteDAOImp" %>
<%@page import="dao.imp.PersonaDAOImp" %>
<%@page import="dao.imp.EmpresaDAOImp" %>

<%@page import="service.ClienteService" %>
<%@page import="service.PersonaService" %>
<%@page import="service.EmpresaService" %>

<%@page import="java.util.List"%>

<% 

String rsTipo = request.getParameter("input-dropdown");
String rsNombre = request.getParameter("nombre-persona");
String rsApellido = request.getParameter("apellido-persona");
String rsRazon = request.getParameter("nombre-empresa");
String rsActividad = request.getParameter("actividades-empresa");
String rsDNI = request.getParameter("documento-persona");
String rsCUIT = request.getParameter("documento-empresa");
String rsPertenece = request.getParameter("select-cliente");

ClienteService cliS;
cliS = new ClienteService();
PersonaService perS;
perS = new PersonaService();
EmpresaService empS;
empS = new EmpresaService();

if(request.getParameter("btn-save") != null) {
	cliS.addCliente(rsTipo);
	if(rsTipo.equals("Persona"))
		perS.addPersona(rsNombre, rsApellido, rsDNI, rsPertenece);
	else
		empS.addEmpresa(rsRazon, rsActividad, rsCUIT);
}



%>

<form class="form form-cliente p-5" method="post" action="#">

    <h2>COMPLETE LOS CAMPOS DEL CLIENTE</h2>

    <div class="div-dropdown d-flex justify-content-end">
        <div class="dropdown">
			<label>¿Persona o Empresa?</label>
			&nbsp;
			<input type="hidden" name="input-dropdown" id="input-dropdown"/>
          <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">Persona</button>
          <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
            <li value="0"><a class="dropdown-item" href="#" id="dropdown-cliente-persona">Persona</a></li>
            <li value="1"><a class="dropdown-item" href="#" id="dropdown-cliente-empresa">Empresa</a></li>
          </ul>
        </div>
    </div>

    <hr>

    <div class="row mb-4">

      <div class="col">
        <!--PERSONA-->
        <div class="form-outline form-cliente-persona">
          <input type="text" id="inputNombre" name="nombre-persona" class="form-control" 
          onkeypress="return valideKeyString(event);"/>
          <label class="form-label" for="inputNombre">Nombre</label>
        </div>
        <!--EMPRESA-->
        <div class="form-outline form-cliente-empresa">
          <input type="text" id="inputRazonSocial" name="nombre-empresa" class="form-control" 
          onkeypress="return valideKeyString(event);"/>
          <label class="form-label" for="inputRazonSocial">Raz&oacute;n Social</label> 
        </div>
      </div>

      <div class="col">
        <!--PERSONA-->
        <div class="form-outline form-cliente-persona">
          <input type="text" id="inputApellido" name="apellido-persona" class="form-control" 
          onkeypress="return valideKeyString(event);"/>
          <label class="form-label" for="inputApellido">Apellido</label>
        </div>
        <!--EMPRESA-->
        <div class="input-group date form-cliente-empresa" id="datepicker">
          <input type="text" class="form-control" name="actividades-empresa" id="date"/>
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
          <input type="number" min="0" id="inputDni" class="form-control" name="documento-persona" onkeypress="return valideKeyNumber(event);"/>
          <label class="form-label" for="inputDni">DNI</label>
        </div>

          <!--EMPRESA-->
        <div class="form-outline form-cliente-empresa">
          <input type="number" min="0" id="inputCuit" class="form-control" name="documento-empresa" onkeypress="return valideKeyNumber(event);"/>
          <label class="form-label" for="inputCuit">CUIT</label>
        </div>
      </div>                 
      
    </div>
    
    
    <div class="form-outline form-cliente-persona">
		<label class="form-label" for="select-cliente">¿Pertenece a una Empresa?</label>
	    <select class="form-select " aria-label="Default select example" name="select-cliente" id="select-cliente">
	    <option value="0" selected>Ninguna</option>
		
		<% 
			List<List<String>> lst = empS.getEmpresas();
	      	for(int i = 0; i < lst.size(); i++) { %>
	      		<option value="<%=lst.get(i).get(0)%>"><%=lst.get(i).get(1)%></option>
	      <%} 
	    %>
	    </select>
    </div>
	
    <button type="submit" class="btn btn-dark btn-block mt-5 mb-3 text-white" id="btn-submit" name="btn-save">ACTUALIZAR DATOS</button>

</form>
