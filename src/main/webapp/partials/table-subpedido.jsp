
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="dao.imp.SubPedidoDAOImp" %>

<%@page import="service.SubPedidoService" %>

<%@page import="java.util.List"%>

<table class="table table-subpedido text-white">

    <thead class="thead">
      <tr>
        <th scope="col">#</th>
        <th scope="col">Tipo</th>
        <th scope="col">Nombre</th>
        <th scope="col">Precio</th>
        <th scope="col">Descripci&oacute;n</th>
        <th scope="col">Acciones</th>
      </tr>
    </thead>

    <tbody class="tbody">
    
     	    <% 
	    		SubPedidoService subS;
	    		subS = new SubPedidoService();
	    		List<List<String>> lst = subS.getSubPedidos();
	    		for(int i=0; i < lst.size(); i++) { %>
				<tr>
	    			<td>
	    				<%=lst.get(i).get(0)%> <!-- ID -->
	    			</td>
	    			<td>
	    				<%=lst.get(i).get(1)%> <!-- Tipo -->
	    			</td>
	    			<td>
	    				<%=lst.get(i).get(2)%> <!-- Nombre -->
	    			</td>
	    			<td>
	    				$ &nbsp;
	    				<%=lst.get(i).get(3)%> <!-- Precio -->
	    			</td>
	    			<td>
	    				<%=lst.get(i).get(4)%> <!-- Descripcion -->
	    			</td>
			      	<td>
			      		<!-- Acciones -->
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
    
    
<!--       <tr>
        <th scope="row">1</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
        <td>
          <button type="button" class="btn btn-light" id="btn-table">
            <i class="fas fa-pen"></i>
          </button>
          <button type="button" class="btn btn-light" id="btn-table">
            <i class="fas fa-trash"></i>
          </button>
        </td>
      </tr>
      <tr>
        <th scope="row">2</th>
        <td>Jacob</td>
        <td>Thornton</td>
        <td>@fat</td>
        <td class="">
          <button type="button" class="btn btn-light" id="btn-table">
            <i class="fas fa-pen"></i>
          </button>
          <button type="button" class="btn btn-light" id="btn-table">
            <i class="fas fa-trash"></i>
          </button>
        </td>
      </tr>
      <tr>
        <th scope="row">3</th>
        <td colspan="2">Lucas the Bird</td>
        <td>@twitter</td>
        <td>
          <button type="button" class="btn btn-table btn-light">
            <i class="fas fa-pen"></i>
          </button>
          <button type="button" class="btn btn-table btn-light">
            <i class="fas fa-trash"></i>
          </button>
        </td>
      </tr> -->
    </tbody>

</table>