-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: obras
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `tabla_archivos`
--

DROP TABLE IF EXISTS `tabla_archivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_archivos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `archivo_uno` longblob,
  `archivo_dos` longblob,
  `archivo_tres` longblob,
  `archivo_cuatro` longblob,
  `archivo_cinco` longblob,
  `archivo_seis` longblob,
  `archivo_siete` longblob,
  `id_obra` int DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_archivos_obra_idx` (`id_obra`),
  CONSTRAINT `tbl_archivos_obra` FOREIGN KEY (`id_obra`) REFERENCES `tabla_obras_informacion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tabla_beneficiarios`
--

DROP TABLE IF EXISTS `tabla_beneficiarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_beneficiarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `localidad` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `id_obra` int DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_bene_info_obra_idx` (`id_obra`),
  CONSTRAINT `tbl_bene_info_obra` FOREIGN KEY (`id_obra`) REFERENCES `tabla_obras_informacion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tabla_doc_beneficiarios`
--

DROP TABLE IF EXISTS `tabla_doc_beneficiarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_doc_beneficiarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `doc_uno` longblob,
  `doc_dos` longblob,
  `doc_tres` longblob,
  `doc_cuatro` longblob,
  `doc_cinco` longblob,
  `id_beneficiario` int DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_doc_bene_idx` (`id_beneficiario`),
  CONSTRAINT `tbl_doc_bene` FOREIGN KEY (`id_beneficiario`) REFERENCES `tabla_beneficiarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tabla_fotos_beneficiarios`
--

DROP TABLE IF EXISTS `tabla_fotos_beneficiarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_fotos_beneficiarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `foto_uno` longblob,
  `foto_dos` longblob,
  `foto_tres` longblob,
  `foto_cuatro` longblob,
  `foto_cinco` longblob,
  `id_beneficiario` int DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_foto_bene_idx` (`id_beneficiario`),
  CONSTRAINT `tbl_foto_bene` FOREIGN KEY (`id_beneficiario`) REFERENCES `tabla_beneficiarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tabla_obras_informacion`
--

DROP TABLE IF EXISTS `tabla_obras_informacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_obras_informacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `obra` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `localidad` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fondo` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `folio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `numero` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `inicio` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fin` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `age` int DEFAULT NULL,
  `id_tipo_obra` int DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_info_obra_idx` (`id_tipo_obra`),
  CONSTRAINT `tbl_info_obra` FOREIGN KEY (`id_tipo_obra`) REFERENCES `tabla_tipo_obra` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tabla_tipo_obra`
--

DROP TABLE IF EXISTS `tabla_tipo_obra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_tipo_obra` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `tabla_tipo_obra` WRITE;
/*!40000 ALTER TABLE `tabla_tipo_obra` DISABLE KEYS */;
INSERT INTO `tabla_tipo_obra` VALUES (1,'Cuartos Dormitorio','2011-12-18 13:17:17'),(2,'Techos de Concreto','2011-12-18 13:17:17'),(3,'Cuartos para Cocina','2011-12-18 13:17:17'),(4,'Baños','2011-12-18 13:17:17');
/*!40000 ALTER TABLE `tabla_tipo_obra` ENABLE KEYS */;
UNLOCK TABLES;
--
-- Table structure for table `tabla_usuarios`
--

DROP TABLE IF EXISTS `tabla_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `username` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'obras'
--

--
-- Dumping routines for database 'obras'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-11 22:01:42
