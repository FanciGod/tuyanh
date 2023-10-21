-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: projectv4
-- ------------------------------------------------------
-- Server version	8.0.34

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
  `Quantity` int DEFAULT '0',
  `Category_ID` int NOT NULL DEFAULT '1',
  `Image` varchar(100) DEFAULT NULL,
  `Supplier_ID` int NOT NULL DEFAULT '1',
  `Description` varchar(450) DEFAULT NULL,
  `Is_deleted` int DEFAULT '0',
  PRIMARY KEY (`Product_ID`),
  KEY `product-category_idx` (`Category_ID`),
  KEY `product-supplier_idx` (`Supplier_ID`),
  CONSTRAINT `product-category` FOREIGN KEY (`Category_ID`) REFERENCES `category` (`Category_ID`),
  CONSTRAINT `product-supplier` FOREIGN KEY (`Supplier_ID`) REFERENCES `supplier` (`Supplier_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'MSI Bravo15',15000000,10000000,12,2,NULL,2,NULL,0),(2,'Iphone Xr',10000000,8000000,10,1,NULL,4,NULL,0),(3,'VGA RTX 3060',30000000,25000000,12,3,NULL,1,NULL,0),(4,'Iphone 15',50000000,47000000,30,1,NULL,1,NULL,0),(8,'AirPod Pro',3000000,3200000,10,6,NULL,4,NULL,0),(13,'AirPod 3',3400000,3000000,100,6,NULL,4,NULL,0),(14,'Sony WH-CH520',1290000,1100000,30,5,NULL,1,NULL,1),(16,'Galaxy Z Flip5',14990000,12890000,30,1,NULL,5,NULL,0),(17,'Dell Vostro 15 V3520 i5',18000000,16000000,10,2,NULL,3,NULL,0),(18,'Iphone X',8000000,6000000,100,1,NULL,4,NULL,0),(19,'Iphone 8',6000000,5000000,10,1,NULL,4,NULL,0),(20,'Iphone Xs',10000000,8000000,100,1,NULL,4,NULL,0),(21,'Iphone 14',34000000,30000000,19,1,NULL,4,NULL,0),(22,'Iphone 12',29999000,23000000,10,1,'C:\\Users\\ADMIN\\IdeaProjects\\projectv4\\src\\main\\resources\\image\\apple-iphone-12-256gb-blue.png',4,NULL,0),(23,'Sony UCH20C',899000,700000,100,7,NULL,1,NULL,0),(24,'Samsung Galaxy Buds 2 Pro',4000000,3390000,13,6,NULL,5,NULL,0),(25,'Iphone 13 Promax',32000000,30000000,20,1,NULL,4,NULL,0),(26,'Iphone 14 Promax',38000000,35000000,20,1,NULL,4,NULL,0),(32,'Laptop zenbook 14',17190000,15000000,1,2,NULL,1,NULL,0),(36,'Samsung Galaxy Z Flip5',19490000,17000000,2,1,'src/main/resources/image/galaxy-z-flip5-highlights-design-end-mo.jpg',1,NULL,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-21 11:30:26
