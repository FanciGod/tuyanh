-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: computershopmanagement
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `Account_ID` int NOT NULL AUTO_INCREMENT,
  `Account_name` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `Is_deleted` int DEFAULT '0',
  PRIMARY KEY (`Account_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (3,'admin','1',NULL,0),(4,'letien','123',NULL,0),(5,'tienle','123',NULL,0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `Bill_ID` int NOT NULL AUTO_INCREMENT,
  `Client_ID` int NOT NULL,
  `Account_ID` int NOT NULL,
  `Create_time` date DEFAULT NULL,
  `Total_price` double DEFAULT NULL,
  PRIMARY KEY (`Bill_ID`),
  KEY `Client_ID_idx` (`Client_ID`),
  KEY `Account_ID_idx` (`Account_ID`),
  CONSTRAINT `bill-account` FOREIGN KEY (`Account_ID`) REFERENCES `account` (`Account_ID`),
  CONSTRAINT `bill-client` FOREIGN KEY (`Client_ID`) REFERENCES `client` (`Client_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill_detail`
--

DROP TABLE IF EXISTS `bill_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill_detail` (
  `Bill_detail_ID` int NOT NULL AUTO_INCREMENT,
  `Bill_ID` int NOT NULL,
  `Product_ID` int NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Bill_detail_ID`),
  KEY `bill-fk_idx` (`Bill_ID`),
  KEY `bill-product_idx` (`Product_ID`),
  CONSTRAINT `bill-fk` FOREIGN KEY (`Bill_ID`) REFERENCES `bill` (`Bill_ID`),
  CONSTRAINT `bill-product` FOREIGN KEY (`Product_ID`) REFERENCES `product` (`Product_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill_detail`
--

LOCK TABLES `bill_detail` WRITE;
/*!40000 ALTER TABLE `bill_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `Category_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Category_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Smart Phone'),(2,'Laptop'),(3,'Desktop'),(5,'Headphone'),(6,'Earphone'),(7,'Charger'),(8,'Screen');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `Client_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Phone` varchar(45) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Client_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `Product_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Sell_price` double DEFAULT NULL,
  `Import_price` double DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `Category_ID` int NOT NULL,
  `Image` text,
  `Supplier_ID` int NOT NULL,
  `Description` varchar(450) DEFAULT NULL,
  `Is_deleted` int DEFAULT '0',
  PRIMARY KEY (`Product_ID`),
  KEY `product-category_idx` (`Category_ID`),
  KEY `product-supplier_idx` (`Supplier_ID`),
  CONSTRAINT `product-category` FOREIGN KEY (`Category_ID`) REFERENCES `category` (`Category_ID`),
  CONSTRAINT `product-supplier` FOREIGN KEY (`Supplier_ID`) REFERENCES `supplier` (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'MSI Bravo15',15000000,10000000,12,2,NULL,2,NULL,0),(2,'Iphone Xr',10000000,8000000,10,1,NULL,4,NULL,0),(3,'VGA RTX 3060',30000000,25000000,12,3,NULL,1,NULL,0),(4,'Iphone 15',50000000,47000000,30,1,NULL,1,NULL,0),(8,'AirPod Pro',3000000,3200000,10,6,NULL,4,NULL,0),(13,'AirPod 3',3400000,3000000,100,6,NULL,4,NULL,0),(14,'Sony WH-CH520',1290000,1100000,30,5,NULL,1,NULL,0),(16,'Galaxy Z Flip5',14990000,12890000,30,1,NULL,5,NULL,0),(17,'Dell Vostro 15 V3520 i5',18000000,16000000,10,2,NULL,3,NULL,0),(18,'Iphone X',8000000,6000000,100,1,NULL,4,NULL,0),(19,'Iphone 8',6000000,5000000,10,1,NULL,4,NULL,0),(20,'Iphone Xs',10000000,8000000,100,1,NULL,4,NULL,0),(21,'Iphone 14',34000000,30000000,19,1,NULL,4,NULL,0),(22,'Iphone 13',29999000,25000000,10,1,NULL,4,NULL,0),(23,'Sony UCH20C',899000,700000,100,7,NULL,1,NULL,0),(24,'Samsung Galaxy Buds 2 Pro',4000000,3390000,13,6,NULL,5,NULL,0),(25,'Iphone 13 Promax',32000000,30000000,20,1,NULL,4,NULL,0),(26,'Iphone 14 Promax',38000000,35000000,20,1,NULL,4,NULL,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase` (
  `Purchase_ID` int NOT NULL AUTO_INCREMENT,
  `Supplier_ID` int NOT NULL,
  `Account_ID` int NOT NULL,
  `Create_time` date DEFAULT NULL,
  `Total_price` double DEFAULT NULL,
  PRIMARY KEY (`Purchase_ID`),
  KEY `purchase-account_idx` (`Account_ID`),
  CONSTRAINT `purchase-account` FOREIGN KEY (`Account_ID`) REFERENCES `account` (`Account_ID`),
  CONSTRAINT `purchase-supplier` FOREIGN KEY (`Purchase_ID`) REFERENCES `supplier` (`Supplier_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_detail`
--

DROP TABLE IF EXISTS `purchase_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_detail` (
  `Purchase_detail_ID` int NOT NULL AUTO_INCREMENT,
  `Purchase_ID` int NOT NULL,
  `Product_ID` int NOT NULL,
  `Quantity` int DEFAULT NULL,
  PRIMARY KEY (`Purchase_detail_ID`),
  KEY `Purchase-fk_idx` (`Purchase_ID`),
  KEY `Purchase-product_idx` (`Product_ID`),
  CONSTRAINT `Purchase-fk` FOREIGN KEY (`Purchase_ID`) REFERENCES `purchase` (`Purchase_ID`),
  CONSTRAINT `Purchase-product` FOREIGN KEY (`Product_ID`) REFERENCES `product` (`Product_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_detail`
--

LOCK TABLES `purchase_detail` WRITE;
/*!40000 ALTER TABLE `purchase_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `Supplier_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Phone` varchar(45) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'Sony','Korea','0948247756',NULL),(2,'MSI','HN','0773567789',NULL),(3,'Dell','HN','0341231245',NULL),(4,'Apple','US','0112314142',NULL),(5,'Samsung','Korea','0758446373',NULL),(6,'Asus','taiwan','0948663545',NULL);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-12 19:53:51
