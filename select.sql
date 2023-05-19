-- Todas las tablas

use listadeseos;




SELECT * FROM cliente;
SELECT * FROM detalle_lista;
SELECT * FROM fuente_energia;
SELECT * FROM lista_coche;
SELECT * FROM marca;
SELECT * FROM modelo;
SELECT * FROM tipo_coche;


SELECT modelo.nombre AS modelo_nombre, marca.nombre AS marca_nombre, tipo_coche.nombre_tipo AS tipo_coche_nombre, fuente_energia.nombre_energia AS fuente_energia_nombre
FROM detalle_lista
JOIN lista_coche ON detalle_lista.lista_coche_id = lista_coche.id
JOIN modelo ON detalle_lista.modelo_id = modelo.id
JOIN marca ON modelo.marca_id = marca.id
JOIN tipo_coche ON modelo.tipo_coche_id = tipo_coche.id
JOIN fuente_energia ON modelo.fuente_energia_id = fuente_energia.id
WHERE lista_coche.cliente_id = 2;


SELECT cliente.nombre AS Cliente ,lista_coche.nombre_lista AS lista, modelo.nombre AS modelo, marca.nombre AS marca, tipo_coche.nombre_tipo AS tipo_coche, fuente_energia.nombre_energia AS fuente_energia
FROM detalle_lista
JOIN lista_coche ON detalle_lista.lista_coche_id = lista_coche.id
JOIN modelo ON detalle_lista.modelo_id = modelo.id
JOIN marca ON modelo.marca_id = marca.id
JOIN tipo_coche ON modelo.tipo_coche_id = tipo_coche.id
JOIN fuente_energia ON modelo.fuente_energia_id = fuente_energia.id
JOIN cliente ON lista_coche.cliente_id = cliente.id
WHERE lista_coche.cliente_id =4;

SELECT m.id, m.nombre AS modelo, mc.nombre AS marca, tc.tipo AS tipo_coche, fe.nombre AS fuente_energia
FROM modelo AS m
JOIN marca AS mc ON m.marca_id = mc.id
JOIN tipo_coche AS tc ON m.tipo_coche_id = tc.id
JOIN fuente_energia AS fe ON m.fuente_energia_id = fe.id;
