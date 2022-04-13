var elemento = document.getElementById('elemento');
var posicion = elemento.getBoundingClientRect();
var navbar = document.getElementById('navbar');
var navlink = document.getElementsByClassName('nav-link');

var tableCliente = $('.table-cliente');
var formCliente = $('.form-cliente');
var formPersona = $('.form-cliente-persona');
var formEmpresa = $('.form-cliente-empresa');
var tablePedido = $('.table-pedido');
var formPedido = $('.form-pedido');
var tableSubPedido = $('.table-subpedido');
var btnCollapse = $('.btn-collapse');
var formSubpedido = $('.form-subpedido');
var formProducto = $('.form-subpedido-producto');
var formServicio = $('.form-subpedido-servicio');
var jumbotron = $('.container-presentacion');

tableCliente.hide();
formCliente.hide();
formEmpresa.hide();

tablePedido.hide();
formPedido.hide();

tableSubPedido.hide();
formSubpedido.hide();

btnCollapse.hide();

formServicio.hide();

$("#input-dropdown").val("Persona");
$("#btn-submit").val(null);

document.getElementById('sitio').innerHTML = " HOME";

navbar.style.height = `${posicion.top + elemento.style.height}px`;

Array.prototype.filter.call(navlink, imprimir)

function imprimir(obj) {
	
    if(obj.innerText.toUpperCase() !== " ACERCA DE...") {
        obj.addEventListener('click', function(){ 
	   
        var msg = this.innerText.toUpperCase();
        
        document.getElementById('sitio').innerHTML = msg;   

		jumbotron.hide();
		tableCliente.hide();
		formCliente.hide();
		tablePedido.hide();
		formPedido.hide();
		tableSubPedido.hide();
		formSubpedido.hide();
		formEmpresa.hide();
		btnCollapse.show();

        if(msg == " CLIENTES") {
          tableCliente.show();
          formCliente.show();
        } else if(msg == " PEDIDOS") {
          tablePedido.show();
          formPedido.show();
        } else {
          tableSubPedido.show();
          formSubpedido.show();
        }

      })

    }
}


if ( $(".form-cliente").length ) {
  document.getElementById('dropdown-cliente-persona').addEventListener('click', function(){
    formEmpresa.hide();
    formPersona.show();
    $("#dropdownMenuButton1").html("Persona");
	$("#input-dropdown").val("Persona");
    this.classList.add("active");
    $("#dropdown-cliente-empresa").removeClass(" active");
  })
  
  document.getElementById('dropdown-cliente-empresa').addEventListener('click', function(){
    formPersona.hide();
    formEmpresa.show();
	$("#dropdownMenuButton1").html("Empresa");
	$("#input-dropdown").val("Empresa");
    this.classList.add("active");
    $("#dropdown-cliente-persona").removeClass(" active");
  })
}

if($('.form-subpedido').length) {
  document.getElementById('dropdown-producto').addEventListener('click',function(){
    formProducto.show();
    formServicio.hide();
    $("#dropdownMenuButton2").html("Producto");
    this.classList.add("active");
    $("#dropdown-servicio").removeClass(" active");
  })

  document.getElementById('dropdown-servicio').addEventListener('click',function(){
    formServicio.show();
    formProducto.hide();
    $("#dropdownMenuButton2").html("Servicio");
    this.classList.add("active");
    $("#dropdown-producto").removeClass(" active");
  })
}

 document.getElementById('btn-submit').addEventListener('click', function(){ 
	$("#btn-submit").val("ok");
})

document.getElementById('btn-acerca-de').addEventListener('click', function(){
    Swal.fire({
        title: '<strong>ACERCA DE NOSOTROS</strong>',
        icon: 'info',
        iconColor: '#99b9e9e5',
        html:
            'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatem maiores aliquam quasi ipsum? Numquam pariatur asperiores adipisci, earum voluptas aliquid assumenda. Enim, adipisci error? Sint veniam vel quod non fugiat.',
        showCloseButton: true,
        focusConfirm: false,
        confirmButtonText:
          '<i class="fa fa-thumbs-up"></i> <span class="gracias">GRACIAS</span>',
        confirmButtonAriaLabel: 'Thumbs up, great!',
        confirmButtonColor: '#99b9e9e5',
        background: '#212529',
        color: '#fff'
      })
})

function valideKeyNumber(evt){
    var code = (evt.which) ? evt.which : evt.keyCode;
    if(code==8) {
      return true;
    } else if(code>=48 && code<=57) {
      return true;
    } else{
      return false;
    }
}

function valideKeyString(evt){
    var code = (evt.which) ? evt.which : evt.keyCode;
    if(code==8 || code==32) {
      return true;
    } else if(code>=65 && code<=90 || code>=97 && code<=122) {
      return true;
    } else{
      return false;
    }
}

$(function(){
  $('#datepicker').datepicker({
	format: 'yyyy/mm/dd', 
	startDate: '-3d'
	});
});
