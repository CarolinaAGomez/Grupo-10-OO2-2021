-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: grupo-10-bdd-oo2-2021
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.14-MariaDB

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
-- Table structure for table `lugar`
--

DROP TABLE IF EXISTS `lugar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugar` (
  `id_lugar` int(11) NOT NULL AUTO_INCREMENT,
  `codigo_postal` varchar(255) DEFAULT NULL,
  `lugar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_lugar`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` VALUES (1,'1834','Temperley'),(2,'1824','Lanus'),(3,'1820','Banfield'),(4,'1819','Adrogue');
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) NOT NULL,
  `nombre_rol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,_binary '','ROLE_ADMIN'),(2,_binary '','ROLE_AUDITOR');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permiso` (
  `id_permiso` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `id_persona` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_permiso`),
  KEY `FK8woob4cm5meiecdgbmeej96am` (`id_persona`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
INSERT INTO `permiso` VALUES (1,'2021-06-24',1),(2,'2021-06-18',2),(3,'2021-06-23',1);
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso_diario`
--

DROP TABLE IF EXISTS `permiso_diario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permiso_diario` (
  `motivo` varchar(255) DEFAULT NULL,
  `id_permiso` int(11) NOT NULL,
  PRIMARY KEY (`id_permiso`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso_diario`
--

LOCK TABLES `permiso_diario` WRITE;
/*!40000 ALTER TABLE `permiso_diario` DISABLE KEYS */;
INSERT INTO `permiso_diario` VALUES ('Turno Medico',2),('Asistir familiar',3);
/*!40000 ALTER TABLE `permiso_diario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso_lugar`
--

DROP TABLE IF EXISTS `permiso_lugar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permiso_lugar` (
  `permiso_id` int(11) NOT NULL,
  `lugar_id` int(11) NOT NULL,
  PRIMARY KEY (`permiso_id`,`lugar_id`),
  KEY `FK27s7237vhwg87mfbtq7rfvxbo` (`lugar_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso_lugar`
--

LOCK TABLES `permiso_lugar` WRITE;
/*!40000 ALTER TABLE `permiso_lugar` DISABLE KEYS */;
INSERT INTO `permiso_lugar` VALUES (1,1),(1,3),(2,1),(2,2),(3,1),(3,4);
/*!40000 ALTER TABLE `permiso_lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso_periodo`
--

DROP TABLE IF EXISTS `permiso_periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permiso_periodo` (
  `cant_dias` int(11) DEFAULT NULL,
  `vacaciones` bit(1) DEFAULT NULL,
  `id_permiso` int(11) NOT NULL,
  `id_rodado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_permiso`),
  KEY `FK890qoe4e6tppibfo5nvqf828t` (`id_rodado`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso_periodo`
--

LOCK TABLES `permiso_periodo` WRITE;
/*!40000 ALTER TABLE `permiso_periodo` DISABLE KEYS */;
INSERT INTO `permiso_periodo` VALUES (5,_binary '',1,2);
/*!40000 ALTER TABLE `permiso_periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `dni` bigint(20) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_persona`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'DiGangi',33333333,'Mariano'),(2,'Gonzalez Canosa',44444444,'Juan Manuel');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rodado`
--

DROP TABLE IF EXISTS `rodado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rodado` (
  `id_rodado` int(11) NOT NULL AUTO_INCREMENT,
  `dominio` varchar(255) DEFAULT NULL,
  `vehiculo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_rodado`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rodado`
--

LOCK TABLES `rodado` WRITE;
/*!40000 ALTER TABLE `rodado` DISABLE KEYS */;
INSERT INTO `rodado` VALUES (1,'ae123aa','Palio'),(2,'ab123aa','Fiat'),(3,'ac777aa','Ford KA');
/*!40000 ALTER TABLE `rodado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `id_perfil` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FK131gkl0dt1966rsw6dmesnsxw` (`id_perfil`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Gomez',NULL,11111111,'caro@unla','Carolina','$2a$10$tWZt9k58O5Afz/2QvGqckuBJxpW9SYUM7ng4IY.e8.FnuTpgd974C',NULL,'admin',1),(2,'Crespi','2021-06-13 15:13:31',22222222,'seba@unla.com','Sebastian','$2a$10$.zEqhOwk43M2FQPUXf1GaeLXf8kL3WUbUpIY08yV8cxZF3lnfotKm','2021-06-13 15:13:31','seba',2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'grupo-10-bdd-oo2-2021'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-13 15:30:13
