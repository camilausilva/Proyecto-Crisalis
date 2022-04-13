<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
<p class="btn-collapse">
  <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample" id="btn-collapse">
	  <strong>
	  	NUEVO...
	  </strong>
  </button>
</p>
<div class="collapse bg-dark" id="collapseExample">
  <div class="card card-body">
	<jsp:include page="form-cliente.jsp"></jsp:include>
	<jsp:include page="form-pedido.jsp"></jsp:include>
	<jsp:include page="form-subpedido.jsp"></jsp:include>
  </div>
</div>
