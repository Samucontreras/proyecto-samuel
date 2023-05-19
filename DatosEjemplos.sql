use listcoches;

INSERT INTO cliente (nombre, apellido, correo) VALUES
('Juan', 'Pérez', 'juanperez@example.com'),
('María', 'González', 'mariagonzalez@example.com'),
('Pedro', 'Ramírez', 'pedroramirez@example.com'),
('Ana', 'López', 'analopez@example.com'),
('Carlos', 'Martínez', 'carlosmartinez@example.com');

INSERT INTO marca (nombre) VALUES
('Ford'),
('Chevrolet'),
('Kia'),
('Fiat'),
('Citroen');

INSERT INTO modelo (nombre, marca_id) VALUES
('Fiesta', 1),
('Camaro', 2),
('Picanto', 3),
('Punto', 4),
('Picasso', 5);

INSERT INTO tipo_coche (nombre) VALUES
('Particular'),
('industrial'),
('empresarial');

INSERT INTO tipo_motor (nombre) VALUES
('Gasolina'),
('Diesel'),
('Eléctrico'),
('Híbrido'),
('Gasolina/Electricidad');

INSERT INTO coche (marca_id, modelo_id, tipo_coche_id, tipo_motor_id) VALUES
(1, 1, 1, 1),
(2, 2, 1, 1),
(3, 3, 3, 3),
(4, 4, 2, 2),
(5, 5, 1, 5);

INSERT INTO listapersonal (cliente_id, coche_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(5, 3);




