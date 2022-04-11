<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
    
	    <c:forEach items="${clientes}" var="cliente">
	    		<tr>
	    			<td>
	    				${cliente}
	    			</td>
	    		</tr>
	    </c:forEach>
	    
    
    <!-- 
				<tr> -->
<%-- 			<% for(int i = 0; i <= clientes.length - 1; i++) { %>
				
					<td> <%  clientes[i][0]  %> </td>
				
			<% } %>
				</tr> --%>
			
			
    	<%-- <c:forEach items="${clientes}" var="cliente"> --%>

			
			
				
<%-- 				
	
				<td>${usuario.nombre}</td>

				<c:choose>
				<c:when test="${usuario.isAdmin}">
				<td>ADMIN</td>
				</c:when>
				<c:otherwise>
				<td>-</td>
				</c:otherwise>
				</c:choose>

<td>${usuario.cantidadMonedas}</td>
<td>${usuario.tiempoDisponible}</td>
<td>${usuario.preferencia}</td>
<c:choose>
<c:when test="${usuario.activo}">
<td>ACTIVO</td>
</c:when>
<c:otherwise>
<td>-</td>
</c:otherwise>
</c:choose>
<td><c:choose>
<c:when test="${usuario.id == id}">

</c:when>
<c:otherwise>
<form method="GET" action="admin-editar.admin" class="d-inline">
	<input type="hidden" name="id" value="${usuario.id}" />
	<button class="btn btn-primary ">
		<i class="fas fa-edit"></i>
	</button>
</form>

<form method="POST" action="admin-baja.admin" class="d-inline">
	<input type="hidden" name="id" value="${usuario.id}" />
<c:choose>
<c:when test="${usuario.activo}">
<input type="hidden" name="activo" value="0" />
<button class="btn btn-danger ">
	<i class="fas fa-trash"></i>
</button>
</c:when>
<c:otherwise>
<input type="hidden" name="activo" value="1" />
<button class="btn btn-success ">
	<i class="fas fa-trash-restore"></i>
</button>
</c:otherwise>
</c:choose>
</form>
</c:otherwise>
</c:choose></td>
</tr> --%>
<%-- </c:forEach>
     --%>
    
    
    
<!--       <tr>
        <th scope="row">1</th>
        <td>Mark</td>
        <td>Otto</td>
        <td>@mdo</td>
        <td>Finnegans S.A.</td>
        <td>Fechita</td>
        <td>
          <button type="button" class="btn btn-light" id="btn-table">
            <i class="fas fa-pen"></i>
          </button>
          <button type="button" class="btn btn-light" id="btn-table">
            <i class="fas fa-trash"></i>
          </button>
        </td>
      </tr> -->
      
      
    </tbody>

</table>