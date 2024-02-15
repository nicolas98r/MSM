CREATE EXTENSION IF NOT EXISTS "uuid-ossp";CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
INSERT INTO client_type (type_name) VALUES ('Administrador'), ('Vendedor');
INSERT INTO audit_type (type_name) VALUES ('Productos'), ('Ventas'), ('Usuarios');
INSERT INTO supplier_type (type_name) VALUES ('Repuestos'), ('Insumos');
