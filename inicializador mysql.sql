DROP DATABASE IF EXISTS listadeseos;

CREATE DATABASE IF NOT EXISTS listadeseos;

use listadeseos;


CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(80),
    apellido VARCHAR(80)
);

CREATE TABLE marca (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);


CREATE TABLE tipo_coche (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL
);

CREATE TABLE fuente_energia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);


CREATE TABLE modelo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
	marca_id INT,
	tipo_coche_id INT,
    fuente_energia_id INT
);

CREATE TABLE lista_coche (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
	fecha DATE NOT NULL,
	cliente_id INT NOT NULL
);

CREATE TABLE detalle_lista (
    id INT AUTO_INCREMENT PRIMARY KEY,
    lista_coche_id INT NOT NULL,
    modelo_id INT NOT NULL
);
    
  
    




