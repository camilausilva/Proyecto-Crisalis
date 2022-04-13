<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<form class="form form-pedido p-5">

    <h2>COMPLETE LOS CAMPOS DEL PEDIDO</h2>

    <hr>

    <select class="form-select mb-4" aria-label="Default select example">
      <option selected>A nombre del Cliente</option>
      <option value="0">Ninguna</option>
      <option value="1">One</option>
      <option value="2">Two</option>
      <option value="3">Three</option>
    </select>
    
    <div class="col-12 d-flex container-fluid justify-content-center">
      <div class="col-6 me-5">
        <div class="list-group">
          <a href="#" class="list-group-item list-group-item-action">An item</a>
          <a href="#" class="list-group-item list-group-item-action">A second link item</a>
          <a href="#" class="list-group-item list-group-item-action">A third link item</a>
          <a href="#" class="list-group-item list-group-item-action">A fourth link item</a>
          <a href="#" class="list-group-item list-group-item-action">And a fifth one</a>
        </div>
      </div>

      <div class="col-6 ">
        <div class="list-group">
          <a href="#" class="list-group-item list-group-item-action">An item</a>
          <a href="#" class="list-group-item list-group-item-action">A second link item</a>
          <a href="#" class="list-group-item list-group-item-action">A third link item</a>
          <a href="#" class="list-group-item list-group-item-action">A fourth link item</a>
          <a href="#" class="list-group-item list-group-item-action">And a fifth one</a>
        </div>
      </div>

    </div>

    <div class="row mt-4 mb-4">

      <div class="col">
        <div class="form-outline form-cliente-persona">
          <input type="number" min="0" id="inputDni" class="form-control"/>
          <label class="form-label" for="inputDni">Monto</label>
        </div>
      </div>

    </div>

    <button type="submit" class="btn btn-dark btn-block mb-3 text-white">ACTUALIZAR DATOS</button>

</form>
