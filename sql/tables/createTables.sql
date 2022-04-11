USE MASTER

CREATE DATABASE crisalis_db

USE crisalis_db

CREATE TABLE [cliente] (
  id INT NOT NULL IDENTITY(1,1),
  tipo INT NOT NULL,
  estado TINYINT NOT NULL,
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
  razon_social VARCHAR(45) NOT NULL,
  inicio_actividad DATE NOT NULL,
  CUIT INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(idCliente) REFERENCES cliente(id)    
)

CREATE TABLE [empresa_persona] (
  idPersona INT NOT NULL,
  idEmpresa INT NOT NULL,
  PRIMARY KEY (idPersona, idEmpresa),
  FOREIGN KEY(idPersona) REFERENCES persona(id),
  FOREIGN KEY(idEmpresa) REFERENCES empresa(id)
)

CREATE TABLE [pedido] (
  id INT NOT NULL IDENTITY(1,1),
  idCliente INT NOT NULL,
  monto DECIMAL NOT NULL,
  estado TINYINT NOT NULL,
  fecha DATE NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY(idCliente) REFERENCES cliente(id)
)

CREATE TABLE [sub_pedido] (
	id INT NOT NULL IDENTITY(1,1),
	tipo INT NOT NULL,
	nombre VARCHAR(45) NOT NULL,
	precio DECIMAL NOT NULL,
	tiempo INT NULL,
	descripcion VARCHAR(255) NULL,
	estado TINYINT NOT NULL,
	PRIMARY KEY(id)
)

CREATE TABLE [pedido_sub_pedido] (
	idPedido INT NOT NULL,
	idSubPedido INT NOT NULL,
	PRIMARY KEY (idPedido, idSubPedido),
	FOREIGN KEY (idPedido) REFERENCES pedido(id),
	FOREIGN KEY (idSubPedido) REFERENCES sub_pedido(id)
)