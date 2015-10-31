# SQL Manager 2005 Lite for MySQL 3.7.0.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : java_ajedrez


SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `java_ajedrez`;

CREATE DATABASE `java_ajedrez`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `java_ajedrez`;

#
# Structure for the `jugadores` table : 
#

DROP TABLE IF EXISTS `jugadores`;

CREATE TABLE `jugadores` (
  `dni` varchar(50) NOT NULL,
  PRIMARY KEY  (`dni`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for the `jugadores` table  (LIMIT 0,500)
#

INSERT INTO `jugadores` (`dni`) VALUES 
  ('36010738'),
  ('36010739'),
  ('36010740'),
  ('36010741');

COMMIT;

#
# Structure for the `partida` table : 
#

DROP TABLE IF EXISTS `partida`;

CREATE TABLE `partida` (
  `dni1` varchar(50) NOT NULL,
  `dni2` varchar(50) NOT NULL,
  `turno` varchar(10) default NULL,
  PRIMARY KEY  (`dni1`,`dni2`),
  KEY `dni2` (`dni2`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for the `partida` table  (LIMIT 0,500)
#

INSERT INTO `partida` (`dni1`, `dni2`, `turno`) VALUES 
  ('36010739','36010738','Negro');

COMMIT;

#
# Structure for the `piezas` table : 
#

DROP TABLE IF EXISTS `piezas`;

CREATE TABLE `piezas` (
  `dni1` varchar(50) NOT NULL,
  `dni2` varchar(50) NOT NULL,
  `id_pieza` varchar(10) default NULL,
  `pieza` varchar(10) default NULL,
  `color` varchar(10) default NULL,
  `posicion` varchar(4) default NULL,
  KEY `fk_dni1` (`dni1`,`dni2`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for the `piezas` table  (LIMIT 0,500)
#

INSERT INTO `piezas` (`dni1`, `dni2`, `id_pieza`, `pieza`, `color`, `posicion`) VALUES 
  ('36010739','36010738','R','Rey','Negro','d1'),
  ('36010739','36010738','A1','Alfil','Negro','c1'),
  ('36010739','36010738','A2','Alfil','Negro','f1'),
  ('36010739','36010738','T1','Torre','Negro','a1'),
  ('36010739','36010738','T2','Torre','Negro','h1'),
  ('36010739','36010738','C1','Caballo','Negro','b1'),
  ('36010739','36010738','C2','Caballo','Negro','g1'),
  ('36010739','36010738','P1','Peon','Negro','a2'),
  ('36010739','36010738','P2','Peon','Negro','b2'),
  ('36010739','36010738','P3','Peon','Negro','c2'),
  ('36010739','36010738','P4','Peon','Negro','d2'),
  ('36010739','36010738','P5','Peon','Negro','e2'),
  ('36010739','36010738','P6','Peon','Negro','f2'),
  ('36010739','36010738','P7','Peon','Negro','g2'),
  ('36010739','36010738','P8','Peon','Negro','h2'),
  ('36010739','36010738','R','Rey','Blanco','d8'),
  ('36010739','36010738','D','Dama','Blanco','e1'),
  ('36010739','36010738','A1','Alfil','Blanco','c8'),
  ('36010739','36010738','A2','Alfil','Blanco','f8'),
  ('36010739','36010738','T1','Torre','Blanco','a8'),
  ('36010739','36010738','T2','Torre','Blanco','h8'),
  ('36010739','36010738','C1','Caballo','Blanco','b8'),
  ('36010739','36010738','C2','Caballo','Blanco','g8'),
  ('36010739','36010738','P1','Peon','Blanco','a7'),
  ('36010739','36010738','P2','Peon','Blanco','b7'),
  ('36010739','36010738','P3','Peon','Blanco','c7'),
  ('36010739','36010738','P4','Peon','Blanco','d7'),
  ('36010739','36010738','P5','Peon','Blanco','e7'),
  ('36010739','36010738','P6','Peon','Blanco','f7'),
  ('36010739','36010738','P7','Peon','Blanco','g7'),
  ('36010739','36010738','P8','Peon','Blanco','h7');

COMMIT;

