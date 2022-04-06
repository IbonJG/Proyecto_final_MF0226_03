-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: mf0226_3
-- ------------------------------------------------------
-- Server version	8.0.28
drop database if exists mf0226_3;
create database mf0226_3;
use mf0226_3;
/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `id_alumno` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  PRIMARY KEY (`id_alumno`),
  UNIQUE KEY `id_alumno_UNIQUE` (`id_alumno`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'Ibon','Juarrero'),(2,'Oscar','De Marcos'),(3,'Mikel','Balenziaga'),(4,'Raul','Garcia'),(5,'Unai','Simon'),(6,'Iñaki','Williams'),(7,'Federico','Valverde'),(8,'Ousmane','Dembele'),(9,'Iñigo','Martinez'),(10,'Karim','Benzema');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id_curso` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `horas` float NOT NULL,
  PRIMARY KEY (`id_curso`),
  UNIQUE KEY `id_curso_UNIQUE` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Bases de Datos',80),(2,'Desarrollo Web',120),(3,'JAVA',350),(4,'PYTHON',350),(5,'C++',350);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imparticiones`
--

DROP TABLE IF EXISTS `imparticiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imparticiones` (
  `id_curso` int NOT NULL,
  `id_profesor` int NOT NULL,
  `cod_curso` varchar(45) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  PRIMARY KEY (`id_curso`,`id_profesor`,`cod_curso`),
  UNIQUE KEY `cod_curso_UNIQUE` (`cod_curso`),
  KEY `fk_curso_has_profesor_profesor1_idx` (`id_profesor`),
  KEY `fk_curso_has_profesor_curso1_idx` (`id_curso`),
  CONSTRAINT `fk_curso_has_profesor_curso1` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`),
  CONSTRAINT `fk_curso_has_profesor_profesor1` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id_profesor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imparticiones`
--

LOCK TABLES `imparticiones` WRITE;
/*!40000 ALTER TABLE `imparticiones` DISABLE KEYS */;
INSERT INTO `imparticiones` VALUES (1,2,'JAVAEE-33','2022-02-05','2022-07-01'),(2,1,'DESWEB-45','2022-02-17','2022-05-16'),(2,3,'DESWEB-11','2022-01-03','2022-04-16');
/*!40000 ALTER TABLE `imparticiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participantes`
--

DROP TABLE IF EXISTS `participantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participantes` (
  `cod_curso` varchar(45) NOT NULL,
  `id_alumno` int NOT NULL,
  `resenia_valoracion` int NOT NULL,
  `resenia_descripcion` varchar(150) NOT NULL,
  CHECK (`resenia_valoracion` >=1 and `resenia_valoracion` <= 10), 
  PRIMARY KEY (`cod_curso`,`id_alumno`),
  KEY `fk_profesor_imparte_curso_has_alumno_alumno1_idx` (`id_alumno`),
  KEY `fk_profesor_imparte_curso_has_alumno_profesor_imparte_curso_idx` (`cod_curso`),
  CONSTRAINT `fk_profesor_imparte_curso_has_alumno_alumno1` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`),
  CONSTRAINT `fk_profesor_imparte_curso_has_alumno_profesor_imparte_curso1` FOREIGN KEY (`cod_curso`) REFERENCES `imparticiones` (`cod_curso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participantes`
--

LOCK TABLES `participantes` WRITE;
/*!40000 ALTER TABLE `participantes` DISABLE KEYS */;
INSERT INTO `participantes` VALUES ('DESWEB-11',1,8,'Muy contento'),('DESWEB-11',4,8,'Muy Bien'),('DESWEB-11',5,7,'Bien'),('DESWEB-11',6,9,'Excelente'),('DESWEB-11',9,8,'Muy bien'),('DESWEB-45',2,1,'Pesimo'),('DESWEB-45',4,1,'Lamentable'),('DESWEB-45',6,1,'Una verguenza'),('DESWEB-45',8,5,'Justito'),('DESWEB-45',10,4,'Profesor inepto'),('JAVAEE-33',1,9,'Excelente'),('JAVAEE-33',3,5,'Suficiente'),('JAVAEE-33',4,8,'Muy Bien'),('JAVAEE-33',5,3,'Muy Mal'),('JAVAEE-33',7,7,'Bien'),('JAVAEE-33',9,6,'Normal'),('JAVAEE-33',10,9,'Excelente');
/*!40000 ALTER TABLE `participantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `id_profesor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  PRIMARY KEY (`id_profesor`),
  UNIQUE KEY `id_profesor_UNIQUE` (`id_profesor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'Carlo','Ancelotti'),(2,'Jose','Mourinho'),(3,'Xavier','Hernandez');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-05 10:54:10
