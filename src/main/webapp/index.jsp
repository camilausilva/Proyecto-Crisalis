<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
	<jsp:include page="partials/head.jsp"></jsp:include>
</head>

<body>

	<main class="container-fluid row min-vh-100 m-0 p-0 bg-dark">
	
		<jsp:include page="partials/aside.jsp"></jsp:include>
		
			<section class="col p-0 vh-100 overflow-auto">
			
				<jsp:include page="partials/navbar.jsp"></jsp:include>
				
				<section class="partial- mt-5 ms-5 me-5 shadow">
				
					<!-- TABLES Y FORMS -->
					<jsp:include page="partials/table-cliente.jsp"></jsp:include>
					<jsp:include page="partials/form-cliente.jsp"></jsp:include>
					
				</section>		
				
			</section>
		
		
	</main>
		
</body>

</html>