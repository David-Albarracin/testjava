DROP DATABASE IF EXISTS cinecampus;
CREATE DATABASE cinecampus;
USE cinecampus;

DROP TABLE IF EXISTS `genero`;
CREATE TABLE `genero` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `pais`;
CREATE TABLE `pais` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `pelicula`;
CREATE TABLE `pelicula` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codinterno` varchar(5) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `duracion` varchar(20) DEFAULT NULL,
  `sinopsis` TEXT DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `actor`;
CREATE TABLE `actor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `idnacionalidad` int,
  `edad` int,
  `idgenero` int,
  CONSTRAINT FK_actor_genero FOREIGN KEY (`idgenero`) REFERENCES `genero` (`id`),
  CONSTRAINT FK_actor_pais FOREIGN KEY (`idnacionalidad`) REFERENCES `pais` (`id`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `formato`;
CREATE TABLE `formato` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `tipoactor`;
CREATE TABLE `tipoactor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `peliculaformato`;
CREATE TABLE `peliculaformato` (
  `idpelicula` int,
  `idformato` int,
  `cantidad` int,
  CONSTRAINT FK_pelicula FOREIGN KEY (`idpelicula`) REFERENCES `pelicula` (`id`),
  CONSTRAINT FK_formato FOREIGN KEY (`idformato`) REFERENCES `formato` (`id`),
  PRIMARY KEY (`idformato`, `idpelicula`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `peliculaprotagonista`;
CREATE TABLE `peliculaprotagonista` (
  `idpelicula` int,
  `idprotagonista` int,
  `idtipoactor` int,
  CONSTRAINT FK_tipoactor FOREIGN KEY (`idtipoactor`) REFERENCES `tipoactor` (`id`),
  CONSTRAINT FK_pelicula_protagonist FOREIGN KEY (`idpelicula`) REFERENCES `pelicula` (`id`),
  CONSTRAINT FK_actor_protagonist FOREIGN KEY (`idprotagonista`) REFERENCES `actor` (`id`),
  PRIMARY KEY (`idpelicula`, `idprotagonista`)
) ENGINE=InnoDB;

INSERT INTO cinecampus.pais
(id, descripcion)
VALUES(1, 'Colombia');
INSERT INTO cinecampus.pais
(id, descripcion)
VALUES(2, 'EEUU');

INSERT INTO cinecampus.tipoactor
(id, descripcion)
VALUES(1, 'protagonista ');
INSERT INTO cinecampus.tipoactor
(id, descripcion)
VALUES(2, 'actor secundario');

INSERT INTO cinecampus.formato
(id, descripcion)
VALUES(1, 'DVD');
INSERT INTO cinecampus.formato
(id, descripcion)
VALUES(2, 'BlueRay');

INSERT INTO cinecampus.genero
(id, descripcion)
VALUES(1, 'Terror');
INSERT INTO cinecampus.genero
(id, descripcion)
VALUES(2, 'Suspenso');
