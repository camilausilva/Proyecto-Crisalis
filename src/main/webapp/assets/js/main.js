console.log(document.querySelector('title').textContent)

var elemento = document.getElementById('elemento');
var posicion = elemento.getBoundingClientRect();
var navbar = document.getElementById('navbar');
var navlink = document.getElementsByClassName('nav-link');
var formPersona = $('.form-cliente-persona');
var formEmpresa = $('.form-cliente-empresa');

formEmpresa.hide();

navbar.style.height = `${posicion.top + elemento.style.height}px`;

Array.prototype.filter.call(navlink, imprimir)

function imprimir(obj) {
    if(obj.innerText.toUpperCase() !== " ACERCA DE...") {
        obj.addEventListener('click', function(){    
            document.getElementById('sitio').innerHTML = this.innerText.toUpperCase();
        })
    }
}

document.getElementById('dropdown-cliente-persona').addEventListener('click', function(){
  formEmpresa.hide();
  formPersona.show();
  $("#dropdownMenuButton1").html("Persona");
  
  this.classList.add("active");
  $("#dropdown-cliente-empresa").removeClass(" active");
})

document.getElementById('dropdown-cliente-empresa').addEventListener('click', function(){
  formPersona.hide();
  formEmpresa.show();
  $("#dropdownMenuButton1").html("Empresa");
  this.classList.add("active");
  $("#dropdown-cliente-persona").removeClass(" active");
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
          '<i class="fa fa-thumbs-up"></i> <span class="gracias">¡GRACIAS!</span>',
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
  $('#datepicker').datepicker();
});