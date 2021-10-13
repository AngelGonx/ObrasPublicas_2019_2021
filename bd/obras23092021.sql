-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: obras
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `tabla_banios`
--

DROP TABLE IF EXISTS `tabla_banios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_banios` (
  `idtabla_banios` int NOT NULL,
  `codigo_banios` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtabla_banios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_banios`
--

LOCK TABLES `tabla_banios` WRITE;
/*!40000 ALTER TABLE `tabla_banios` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_banios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_cocina`
--

DROP TABLE IF EXISTS `tabla_cocina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_cocina` (
  `idtabla_cocina` int NOT NULL,
  `codigo_cocina` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtabla_cocina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_cocina`
--

LOCK TABLES `tabla_cocina` WRITE;
/*!40000 ALTER TABLE `tabla_cocina` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_cocina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_dormitorio`
--

DROP TABLE IF EXISTS `tabla_dormitorio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_dormitorio` (
  `idtabla_dormitorio` int NOT NULL,
  `codigo_dormitorio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtabla_dormitorio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_dormitorio`
--

LOCK TABLES `tabla_dormitorio` WRITE;
/*!40000 ALTER TABLE `tabla_dormitorio` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_dormitorio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_info_obras`
--

DROP TABLE IF EXISTS `tabla_info_obras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_info_obras` (
  `idtabla_info_obras` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `tipo_de_obra` varchar(45) DEFAULT NULL,
  `archivos` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idtabla_info_obras`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_info_obras`
--

LOCK TABLES `tabla_info_obras` WRITE;
/*!40000 ALTER TABLE `tabla_info_obras` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_info_obras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_techos`
--

DROP TABLE IF EXISTS `tabla_techos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_techos` (
  `idtabla_techos` int NOT NULL,
  `codigo_techos` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtabla_techos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_techos`
--

LOCK TABLES `tabla_techos` WRITE;
/*!40000 ALTER TABLE `tabla_techos` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_techos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_usuario_sesion`
--

DROP TABLE IF EXISTS `tabla_usuario_sesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_usuario_sesion` (
  `idtabla_usuario` int NOT NULL,
  `usuario_nombre` varchar(80) DEFAULT NULL,
  `contraseña` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtabla_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_usuario_sesion`
--

LOCK TABLES `tabla_usuario_sesion` WRITE;
/*!40000 ALTER TABLE `tabla_usuario_sesion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_usuario_sesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabla_usuarios_info`
--

DROP TABLE IF EXISTS `tabla_usuarios_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tabla_usuarios_info` (
  `idtabla_usuarios_info` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `documentos` varchar(100) DEFAULT NULL,
  `fotos` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idtabla_usuarios_info`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabla_usuarios_info`
--

LOCK TABLES `tabla_usuarios_info` WRITE;
/*!40000 ALTER TABLE `tabla_usuarios_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `tabla_usuarios_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-30 17:09:48
