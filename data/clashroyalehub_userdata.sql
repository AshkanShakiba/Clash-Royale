-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: clashroyalehub
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `userdata`
--

DROP TABLE IF EXISTS `userdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userdata` (
  `UserUniqueID` int NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Xp` int(10) unsigned zerofill NOT NULL,
  `Card1` varchar(45) NOT NULL,
  `Card2` varchar(45) NOT NULL,
  `Card3` varchar(45) NOT NULL,
  `Card4` varchar(45) NOT NULL,
  `Card5` varchar(45) NOT NULL,
  `Card6` varchar(45) NOT NULL,
  `Card7` varchar(45) NOT NULL,
  `Card8` varchar(45) NOT NULL,
  `Title` int NOT NULL,
  `Game1` int unsigned NOT NULL,
  `Game2` int unsigned NOT NULL,
  `Game3` int unsigned NOT NULL,
  `Game4` int unsigned NOT NULL,
  `Game5` int unsigned NOT NULL,
  PRIMARY KEY (`UserUniqueID`,`Username`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  UNIQUE KEY `UserUniqueID_UNIQUE` (`UserUniqueID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdata`
--

LOCK TABLES `userdata` WRITE;
/*!40000 ALTER TABLE `userdata` DISABLE KEYS */;
INSERT INTO `userdata` VALUES (1,'AMIR','8888',0000000740,'BARBARIANS','BABYDRAGON','GIANT','MINIPEKKA','FIREBALL','RAGE','ARROWS','INFERNOTOWER',95,10,11,30,3,10),(4,'Mammad','6728',0000000000,'','','','','','','','',0,0,0,0,0,0),(5,'Soltan','7898',0000000200,'','','','','','','','',43,30,0,0,0,0),(6,'why?','7898',0000000000,'BARBARIANS','ARCHERS','BABYDRAGON','WIZARD','MINIPEKKA','GIANT','CANNON','ARROWS',0,0,0,0,0,0),(9,'why?!','7898',0000000000,'','','','','','','','',0,0,0,0,0,0),(10,'why?!userdataUserUniqueID','7898',0000000000,'','','','','','','','',0,0,0,0,0,0),(13,'amir12','8888',0000000000,'','','','','','','','',0,0,0,0,0,0),(14,'hfh','hfh',0000000000,'','','','','','','','',0,0,0,0,0,0),(15,'fsf','fsf',0000000000,'','','','','','','','',0,0,0,0,0,0),(17,'aaa','845',0000000000,'BABYDRAGON','WIZARD','MINIPEKKA','GIANT','ARCHERS','BARBARIANS','CANNON','INFERNOTOWER',0,0,0,0,0,0),(18,'alimohammad','845sf',0000000000,'','','','','','','','',0,0,0,0,0,0),(22,'ali78','9898',0000000000,'','','','','','','','',22,0,0,0,0,0),(23,'saba','moradi',0000000000,'ARCHERS','BABYDRAGON','ARROWS','MINIPEKKA','VALKYRIE','FIREBALL','BARBARIANS','INFERNOTOWER',89,0,0,0,0,0),(24,'jojo','4444',0000000000,'','','','','','','','',19,0,0,0,0,0),(25,'mostafa','8974',0000000000,'','','','','','','','',0,0,0,0,0,0),(26,'aliHashem','7879',0000000000,'BARBARIANS','ARCHERS','ARROWS','VALKYRIE','BABYDRAGON','GIANT','WIZARD','FIREBALL',0,0,0,0,0,0),(27,'manni','moghimi85',0000000000,'BARBARIANS','ARCHERS','','','','BABYDRAGON','','GIANT',85,0,0,0,0,0),(28,'ali76','6543',0000000000,'BABYDRAGON','','','','','','','',0,0,0,0,0,0),(29,'ali99','9999',0000000000,'','','','','','','','',0,0,0,0,0,0),(30,'shahryar','2676',0000000000,'BARBARIANS','ARCHERS','BABYDRAGON','WIZARD','MINIPEKKA','GIANT','RAGE','VALKYRIE',0,0,0,0,0,0),(31,'sabz','3030',0000000000,'ARROWS','FIREBALL','INFERNOTOWER','GIANT','BARBARIANS','ARCHERS','WIZARD','MINIPEKKA',0,0,0,0,0,0),(32,'ashkan','3333',0000000140,'BARBARIANS','GIANT','WIZARD','ARROWS','RAGE','BABYDRAGON','ARCHERS','VALKYRIE',-58,1,11,0,0,0),(33,'erfan','2222',0000000200,'BARBARIANS','GIANT','BABYDRAGON','MINIPEKKA','ARROWS','ARCHERS','INFERNOTOWER','WIZARD',29,10,0,0,0,0);
/*!40000 ALTER TABLE `userdata` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-23 13:44:23
