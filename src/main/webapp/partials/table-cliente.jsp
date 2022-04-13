<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="dao.imp.ClienteDAOImp" %>

<%@page import="service.ClienteService" %>

<%@page import="java.sql.ResultSet" %>

<%@page import="jdbc.CRUD" %>

<%@page import="java.util.List"%>

<% 
	ClienteService cliS;
	cliS = new ClienteService();
	String id = request.getParameter("btn-borrar");
	if(id != null){
		String query = "select estado from cliente where id = " + id;
		ResultSet rs = CRUD.executeQuery(query);
		Integer estado = 0;
		if(rs.next())
			estado = rs.getInt("estado");
		if(estado == 0)
			cliS.updateEstado(Integer.valueOf(id), 1);
		else
			cliS.updateEstado(Integer.valueOf(id), 0);			
	}	
%>

<table class="table table-cliente text-white">

    <thead class="thead">
      <tr>
        <th scope="col">#</th>
        <th scope="col">Tipo Cliente</th>
        <th scope="col">Nombre Completo / Raz&oacute;n Social</th>
        <th scope="col">DNI / CUIT</th>
        <th scope="col">Inicio de Actividades</th>
        <th scope="col">Pertenece A</th>
        <th scope="col">Acciones</th>
      </tr>
    </thead>

    <tbody class="tbody">
    
	    	<% 
	    		List<List<String>> lst = cliS.getClientes();
	    		for(int i=0; i < lst.size(); i++) { 
	    			if(lst.get(i).get(6).equals("1")) {
			%>
				<tr class="usuario-activo">
				
				<% } else { %>
				
				<tr class="usuario-inactivo">
				
				<% } %>
					
	    			<td>
	    				<%=lst.get(i).get(0)%> <!-- ID -->
	    			</td>
	    			<td>
	    				<%=lst.get(i).get(1)%> <!-- Nombre -->
	    			</td>
	    			<td>
	    				<%=lst.get(i).get(2)%> <!-- Documento -->
	    			</td>
	    			<td>
	    				<%=lst.get(i).get(3)%> <!-- Actividades -->
	    			</td>
	    			<td>
	    				<%=lst.get(i).get(4)%> <!-- Pertenece a -->
	    			</td>
	    			<td>
	    				<%=lst.get(i).get(5)%> <!-- Acciones -->
	    			</td>
			      	<td>
				      	<form method="post" action="#clientes">
						  <button type="submit" class="btn btn-light" id="btn-table" name="btn-editar" value="<%=lst.get(i).get(0)%>">
						    <i class="fas fa-pen"></i>
						  </button>
						  <button type="submit" class="btn btn-light" id="btn-table" name="btn-borrar" value="<%=lst.get(i).get(0)%>">
						    <i class="fas fa-trash" name="btn-borrar-value" value="<%=lst.get(i).get(6)%>"></i>
						  </button>
				      	</form>
					</td>
				</tr>
	    		<%}
	    	%>
            
    </tbody>

</table>

<%-- <% System.out.println(request.getParameter("btn-editar")); %>
<% System.out.println(request.getParameter("btn-borrar")); %> --%>