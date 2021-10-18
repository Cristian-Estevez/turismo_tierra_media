PRAGMA foreign_keys = ON;

CREATE TABLE `tipo_atraccion` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nombre`	VARCHAR ( 30 ) NOT NULL
);

CREATE TABLE `tipo_promocion` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nombre`	VARCHAR ( 50 ) NOT NULL
);

CREATE TABLE `usuario` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nombre`	VARCHAR ( 50 ) NOT NULL,
	`tiempo`	REAL NOT NULL,
	`cantidad_monedas`	INTEGER NOT NULL,
	`tipo_atraccion_favorita`	INTEGER NOT NULL,
	 FOREIGN KEY (tipo_atraccion_favorita)
       REFERENCES tipo_atraccion (id) 
);

CREATE TABLE `atraccion` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nombre`	VARCHAR ( 100 ) NOT NULL,
	`costo`	REAL NOT NULL,
	`cupo`	INTEGER NOT NULL,
	`duracion`	REAL NOT NULL,
	`tipo`	INTEGER NOT NULL,
	FOREIGN KEY (tipo)
       REFERENCES tipo_atraccion (id)
);

CREATE TABLE `promocion` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nombre`	VARCHAR ( 100 ) NOT NULL,
	`descuento`	REAL,
	`tipo_promocion`	INTEGER NOT NULL,
	`tipo_atraccion`	INTEGER NOT NULL,
	FOREIGN KEY (tipo_promocion)
       REFERENCES tipo_promocion (id),
    FOREIGN KEY (tipo_atraccion)
       REFERENCES tipo_atraccion (id)   
);


CREATE TABLE `atraccion_promocion` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`promocion_id`	INTEGER NOT NULL,
	`atraccion_id`	INTEGER NOT NULL,
	FOREIGN KEY (promocion_id)
       REFERENCES promocion (id),
	FOREIGN KEY (atraccion_id)
	  REFERENCES atraccion (id)
);

-- insertar data

INSERT INTO tipo_atraccion (nombre)
VALUES
("AVENTURA"),
("PAISAJE"),
("DEGUSTACION");

INSERT INTO tipo_promocion (nombre)
VALUES
("porcentual"),
("absoluta"),
("AxB");

INSERT INTO atraccion (nombre, costo, duracion, cupo, tipo) 
VALUES
("Moria", 10, 2, 6, 1),
("Minas de Tirith", 5, 2.5, 25, 2),
("La Comarca", 3, 6.5, 150, 3),
("Mordor", 25, 3, 4, 1),
("Abismo de Helm", 5, 2, 15, 2),
("Lothlórien", 35, 1,30, 3),
("Erebor", 12, 3, 32,2 ),
("Bosque Negro", 3, 4, 12, 1),
("Mar del Plata", 4, 5, 13, 3),
("Chascomus", 5, 3, 65, 2),
("Bolivia", 3, 2, 60, 1),
("Chile", 7, 30, 7, 2);


INSERT INTO usuario (nombre, cantidad_monedas, tiempo, tipo_atraccion_favorita) 
VALUES
("Eowyn", 10, 8, 1),
("Gandalf", 100, 5, 2),
("Sam", 36, 8, 3),
("Galadriel", 120, 4, 2),
("Ivan", 85, 7, 3),
("Nahuel", 30, 6, 2),
("Cristian Joel", 95, 3, 1),
("Juanjo", 200, 5, 3),
("Cristian Rigoberto",100, 2, 2),
("Cristian", 62, 60, 1),
("Micaela", 98, 10, 2),
("Federico", 68, 6, 3),
("Lucas", 160, 9, 2),
("Quique", 98, 8, 1),
("Evita", 46, 9, 1),
("Frida", 320, 9, 2),
("Silvina", 200, 9, 3),
("Chavela", 50, 10, 3),
("Alfonsina", 93, 8, 1);

INSERT INTO promocion (tipo_promocion, nombre, tipo_atraccion, descuento)
VALUES
(1, "Promo Aventura", 1, 20),
(2, "Todo Aventura", 1, 30),
(1, "Promo Paisajes",2, 20),
(3, "Pack Paisajes", 2, NULL),
(2, "Sabores de Tierra Media", 3, 36);


INSERT INTO atraccion_promocion (promocion_id, atraccion_id)
VALUES
(1, 8),
(1, 4),
(2, 8),
(2, 4),
(2, 1),
(3, 2),
(3, 5),
(4, 2),
(4, 5),
(4, 7),
(5, 6),
(5, 3);