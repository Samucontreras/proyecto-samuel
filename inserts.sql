use listadeseos;

INSERT INTO listadeseos.cliente (nombre, apellido)
VALUES 
	('Michelli', 'Prieto'),
    ('Juan', 'Carlos'),
    ('Samuel', 'Contreras'),
    ('Victor', 'Rodriguez');
    
    INSERT INTO listadeseos.fuente_energia (nombre)
VALUES 
	('Gasolina'),
    ('Diesel'),
    ('Hibrido'),
    ('Electrico'),
    ('Gas');
    
    INSERT INTO listadeseos.lista_coche (nombre, cliente_id, fecha)
VALUES 
	('Regalo familia', 1, '2023-05-05'),
    ('Cumpleaños', 2, '2023-05-04'),
    ('Auto Regalo', 1, '2023-05-03'),
    ('Futuro', 4, '2023-05-02');
    
    INSERT INTO listadeseos.detalle_lista (lista_coche_id, modelo_id)
VALUES
	(1, 1),
    (1, 2),
    (2, 2),
    (3, 3),
    (4, 4);
    
    INSERT INTO listadeseos.marca (nombre)
VALUES
	('Ford'),
    ('Chevrolet'),
    ('Nissan'),
    ('Toyota');
    
     INSERT INTO listadeseos.tipo_coche (tipo)
VALUES
	('Sedán'),
	('SUV'),
	('Pickup'),
	('Hatchback'),
	('Coupe');
    
 INSERT INTO listadeseos.modelo (nombre, marca_id, tipo_coche_id, fuente_energia_id)
VALUES

('Mustang', 1, 5, 1),
('Camaro', 2, 1, 4),
('Sentra', 3, 2, 5),
('Corolla', 4, 2, 3);
    

    
    
    insert into modelo(nombre,marca_id,tipoCocheId,fuenteEnergiaId) values ('camaro', 2, 1, 2);
    
