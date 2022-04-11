<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="dao.imp.ClienteDAOImp" %>

<%@page import="service.ClienteService" %>

<%@page import="java.util.List"%>

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
	    		ClienteService cliS;
	    		cliS = new ClienteService();
	    		List<List<String>> lst = cliS.getClientes();
	    		for(int i=0; i < lst.size(); i++) { %>
				<tr>
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
					  <button type="button" class="btn btn-light" id="btn-table">
					    <i class="fas fa-pen"></i>
					  </button>
					  <button type="button" class="btn btn-light" id="btn-table">
					    <i class="fas fa-trash"></i>
					  </button>
					</td>
				</tr>
	    		<%}
	    	%>
            
    </tbody>

</table>