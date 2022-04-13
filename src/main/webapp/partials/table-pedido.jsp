<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
<table class="table table-pedido text-white">

            <thead class="thead">
              <tr>
                <th scope="col">#</th>
                <th scope="col">Cliente</th>
                <th scope="col">Monto</th>
                <th scope="col">Fecha</th>
                <th scope="col">Productos y Servicios Asignados</th>
                <th scope="col">Acciones</th>
              </tr>
            </thead>

            <tbody class="tbody">
              <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
                <td>a</td>
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
                <td>a</td>
                <td class="">
                  <button type="button" class="btn btn-light">
                    <i class="fas fa-pen"></i>
                  </button>
                  <button type="button" class="btn btn-light">
                    <i class="fas fa-trash"></i>
                  </button>
                </td>
              </tr>
              <tr>
                <th scope="row">3</th>
                <td colspan="2">Larry the Bird</td>
                <td>@twitter</td>
                <td>a</td>
                <td>
                  <button type="button" class="btn btn-table btn-light">
                    <i class="fas fa-pen"></i>
                  </button>
                  <button type="button" class="btn btn-table btn-light">
                    <i class="fas fa-trash"></i>
                  </button>
                </td>
              </tr>
            </tbody>
</table>