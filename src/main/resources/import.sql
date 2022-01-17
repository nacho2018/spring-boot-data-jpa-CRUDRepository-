/* Populate tables */
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(1, 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2017-08-28');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(2, 'John', 'Doe', 'john.doe@gmail.com', '2017-08-28');
/* Populate tables */
INSERT INTO facturas (id, descripcion, observacion, create_at, cliente_id) values (1, 'zapatos de deporte' , 'marcas: nike y adidas', '2022-01-01', 1);
INSERT INTO facturas (id, descripcion, observacion, create_at, cliente_id) values (2, 'maletas de viaje' , 'entrega rápida', '2022-01-01', 2);
/* Populate tables */
INSERT INTO factura_items (id, cantidad, factura_id) values (1, 2, 1);
INSERT INTO factura_items (id, cantidad, factura_id) values (2, 3, 2);
