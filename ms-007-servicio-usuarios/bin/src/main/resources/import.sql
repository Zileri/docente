INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('jhon', '12345', 1, 'Jhon', 'Luna', 'jhonluna@gamil.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin', '12345', 1, 'Zileri', 'Arapa', 'zileriar@gamil.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1); 

