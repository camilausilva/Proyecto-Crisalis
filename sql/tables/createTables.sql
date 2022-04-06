USE master

CREATE DATABASE db

USE db

CREATE TABLE [cliente] (
  id INT NOT NULL IDENTITY(1,1),
  tipo INT NOT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE [persona] (
  id INT NOT NULL IDENTITY(1,1),
  idCliente INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  apellido VARCHAR(45) NOT NULL,
  DNI INT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(idCliente) REFERENCES cliente(id)
)

CREATE TABLE [empresa] (
  id INT NOT NULL IDENTITY(1,1),
  idCliente INT NOT NULL,
  razonSocial VARCHAR(45) NOT NULL,
  inicioActividad DATE NOT NULL,
  CUIT INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(idCliente) REFERENCES cliente(id)    
)

CREATE TABLE [pedido] (
  id INT NOT NULL,
  idCliente INT NOT NULL,
  montoBase DECIMAL NOT NULL,
  costoAdicional DECIMAL NULL,
  estado TINYINT NOT NULL,
  fecha DATE NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(idCliente) REFERENCES cliente(id)
)

CREATE TABLE [producto]  (
  id INT NOT NULL,
  cantAnios INT NULL,
  PRIMARY KEY (id),
)

CREATE TABLE [servicio] (
  id INT NOT NULL,
  cantMeses INT NULL,
  PRIMARY KEY (id)
)

CREATE TABLE [pedido_producto] (
  idProducto INT NOT NULL,
  idPedido INT NOT NULL,
  PRIMARY KEY (idProducto, idPedido),
  FOREIGN KEY(idProducto) REFERENCES producto(id),
  FOREIGN KEY(idPedido) REFERENCES pedido(id)
)

CREATE TABLE [pedido_servicio] (
  idServicio INT NOT NULL,
  idPedido INT NOT NULL,
  PRIMARY KEY (idServicio, idPedido),
  FOREIGN KEY(idServicio) REFERENCES servicio(id),
  FOREIGN KEY(idPedido) REFERENCES pedido(id)
)

CREATE TABLE [empresa_persona] (
  idPersona INT NOT NULL,
  idEmpresa INT NOT NULL,
  PRIMARY KEY (idPersona, idEmpresa),
  FOREIGN KEY(idPersona) REFERENCES persona(id),
  FOREIGN KEY(idEmpresa) REFERENCES empresa(id)
)