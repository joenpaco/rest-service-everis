/* Creamos algunos usuarios con sus roles */
INSERT INTO usuario (username, password, enabled) VALUES ('andres','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO usuario (username, password, enabled) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);

INSERT INTO role (authority) VALUES ('ROLE_USER');
INSERT INTO role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO usuario_roles (usuario_id, roles_id) VALUES (1, 1);
INSERT INTO usuario_roles (usuario_id, roles_id) VALUES (2, 2);