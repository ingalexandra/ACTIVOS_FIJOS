CREATE DATABASE  IF NOT EXISTS `grupo_asd_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `grupo_asd_db`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: grupo_asd_db
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `activos_fijos`
--

DROP TABLE IF EXISTS `activos_fijos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activos_fijos` (
  `id_activo_fijo` int NOT NULL AUTO_INCREMENT,
  `fk_tipo` int NOT NULL,
  `fk_area` int DEFAULT NULL,
  `fk_persona` int DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  `serial` varchar(30) NOT NULL,
  `numero_inventario` int NOT NULL,
  `peso` float(5,2) unsigned NOT NULL,
  `alto` float(5,2) unsigned NOT NULL,
  `ancho` float(5,2) unsigned NOT NULL,
  `largo` float(5,2) unsigned NOT NULL,
  `valor_compra` bigint unsigned NOT NULL,
  `fecha_compra` date NOT NULL,
  PRIMARY KEY (`id_activo_fijo`),
  UNIQUE KEY `serial_UNIQUE` (`serial`),
  UNIQUE KEY `id_activo_fijo_UNIQUE` (`id_activo_fijo`),
  UNIQUE KEY `numero_inventario_UNIQUE` (`numero_inventario`),
  KEY `fk_activofijos_personas_idx` (`fk_persona`),
  KEY `fk_activos_fijos_areas_idx` (`fk_area`),
  KEY `fk_activos_fijos_tipos_activos_idx` (`fk_tipo`),
  CONSTRAINT `fk_activos_fijos_areas` FOREIGN KEY (`fk_area`) REFERENCES `areas` (`id_area`),
  CONSTRAINT `fk_activos_fijos_personas` FOREIGN KEY (`fk_persona`) REFERENCES `personas` (`id_persona`),
  CONSTRAINT `fk_activos_fijos_tipos_activos` FOREIGN KEY (`fk_tipo`) REFERENCES `tipos_activos` (`id_tipo_activo_fijo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activos_fijos`
--

LOCK TABLES `activos_fijos` WRITE;
/*!40000 ALTER TABLE `activos_fijos` DISABLE KEYS */;
INSERT INTO `activos_fijos` VALUES (1,1,1,NULL,'Activo 1','Descripcion activo 1','S00001',1,50.56,52.60,32.50,56.30,500000,'2021-06-28'),(2,2,NULL,1,'Activo 2','Descripcion activo 2','S00002',2,45.23,56.30,51.20,12.30,210000,'2021-06-29'),(3,3,NULL,NULL,'Activo 3','Descripcion activo 3','S00003',3,520.00,45.21,25.60,62.30,8500000,'2021-06-30');
/*!40000 ALTER TABLE `activos_fijos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas` (
  `id_area` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `fk_ciudad` int NOT NULL,
  PRIMARY KEY (`id_area`),
  UNIQUE KEY `id_area_UNIQUE` (`id_area`),
  UNIQUE KEY `fk_ciudad_UNIQUE` (`fk_ciudad`),
  KEY `fk_areas_ciudades_idx` (`fk_ciudad`),
  CONSTRAINT `fk_areas_ciudades` FOREIGN KEY (`fk_ciudad`) REFERENCES `ciudades` (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES (1,'AREA 1',1),(2,'AREA 2',2),(3,'AREA 3',3);
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudades`
--

DROP TABLE IF EXISTS `ciudades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudades` (
  `id_ciudad` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_ciudad`),
  UNIQUE KEY `id_ciudad_UNIQUE` (`id_ciudad`),
  UNIQUE KEY `nombre_ciudad_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudades`
--

LOCK TABLES `ciudades` WRITE;
/*!40000 ALTER TABLE `ciudades` DISABLE KEYS */;
INSERT INTO `ciudades` VALUES (1,'BOGOTA'),(3,'MEDELLIN'),(2,'VILLAVICENCIO');
/*!40000 ALTER TABLE `ciudades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `id_persona` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_persona`),
  UNIQUE KEY `numero_documento_UNIQUE` (`id_persona`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,'Alexandra Sarmiento'),(2,'Jonathan Sarmiento'),(3,'Paola Sarmiento'),(4,'Maritza Ortiz'),(5,'Efreen Sarmiento');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_activos`
--

DROP TABLE IF EXISTS `tipos_activos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_activos` (
  `id_tipo_activo_fijo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_activo_fijo`),
  UNIQUE KEY `id_tipo_activo_fijo_UNIQUE` (`id_tipo_activo_fijo`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_activos`
--

LOCK TABLES `tipos_activos` WRITE;
/*!40000 ALTER TABLE `tipos_activos` DISABLE KEYS */;
INSERT INTO `tipos_activos` VALUES (1,'TIPO 1'),(2,'TIPO 2'),(3,'TIPO 3');
/*!40000 ALTER TABLE `tipos_activos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-28 20:25:00
