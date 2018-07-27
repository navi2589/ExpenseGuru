-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: TaxConsultant
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `account_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(45) DEFAULT NULL,
  `account_type_id` bigint(20) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`),
  KEY `account_type_fk_idx` (`account_type_id`),
  KEY `created_by_fk_idx` (`created_by`),
  KEY `modified _by_fk_idx` (`modified_by`),
  CONSTRAINT `FK1q1c1nt2iwpftc7ea79oo0bqy` FOREIGN KEY (`account_type_id`) REFERENCES `mlov` (`mlov_id`),
  CONSTRAINT `account_type_fk` FOREIGN KEY (`account_type_id`) REFERENCES `mlov_type` (`mlov_type_id`),
  CONSTRAINT `created_by_fk` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `modified _by_fk` FOREIGN KEY (`modified_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'First Account',2,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mlov`
--

DROP TABLE IF EXISTS `mlov`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mlov` (
  `mlov_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL,
  `value` varchar(45) DEFAULT NULL,
  `mlov_type_id` bigint(20) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_by` bigint(20) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified _by` bigint(20) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`mlov_id`),
  UNIQUE KEY `mlov_id_UNIQUE` (`mlov_id`),
  KEY `mlov_type_fk_idx` (`mlov_type_id`),
  KEY `mlov_created_by_fk_idx` (`created_by`),
  KEY `mlov_modified_by_fk_idx` (`modified _by`),
  CONSTRAINT `mlov_created_by_fk` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `mlov_modified_by_fk` FOREIGN KEY (`modified _by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `mlov_type_fk` FOREIGN KEY (`mlov_type_id`) REFERENCES `mlov_type` (`mlov_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mlov`
--

LOCK TABLES `mlov` WRITE;
/*!40000 ALTER TABLE `mlov` DISABLE KEYS */;
INSERT INTO `mlov` VALUES (1,'TRIAL ','TRIAL ACCOUNT',1,0,NULL,NULL,NULL,NULL),(2,'PREMIUM','PREMIUM ACCOUNT',1,0,NULL,NULL,NULL,NULL),(3,'M','Male',2,0,NULL,NULL,NULL,NULL),(4,'F','Female',2,0,NULL,NULL,NULL,NULL),(5,'U','Unknown ',2,0,NULL,NULL,NULL,NULL),(6,'MR','Mister',3,0,NULL,NULL,NULL,NULL),(7,'MISS','Misses',3,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `mlov` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mlov_type`
--

DROP TABLE IF EXISTS `mlov_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mlov_type` (
  `mlov_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mlov_type` varchar(45) DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `created_by` bigint(20) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified _by` bigint(20) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mlov_type_id`),
  UNIQUE KEY `mlov_type_id_UNIQUE` (`mlov_type_id`),
  KEY `mlov_type_created_by_fk_idx` (`created_by`),
  KEY `mlov_type_modified_by_fk_idx` (`modified _by`),
  CONSTRAINT `mlov_type_created_by_fk` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `mlov_type_modified_by_fk` FOREIGN KEY (`modified _by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mlov_type`
--

LOCK TABLES `mlov_type` WRITE;
/*!40000 ALTER TABLE `mlov_type` DISABLE KEYS */;
INSERT INTO `mlov_type` VALUES (1,'accountType',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'Gender',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'Prefix',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `mlov_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) DEFAULT NULL,
  `mname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `gender_id` bigint(20) DEFAULT NULL,
  `prefix_id` bigint(20) DEFAULT NULL,
  `isDeleted` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `created_by` bigint(20) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `modified _by` bigint(20) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `person_id_UNIQUE` (`person_id`),
  KEY `gender_fk_idx` (`gender_id`),
  KEY `prefix_fk_idx` (`prefix_id`),
  KEY `created_by_kf_idx` (`created_by`),
  KEY `modified _by_fk_idx` (`modified _by`),
  CONSTRAINT `gender_fk` FOREIGN KEY (`gender_id`) REFERENCES `mlov` (`mlov_id`),
  CONSTRAINT `person_created_by_fk` FOREIGN KEY (`created_by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `person_modified_by_fk` FOREIGN KEY (`modified _by`) REFERENCES `user` (`user_id`),
  CONSTRAINT `prefix_fk` FOREIGN KEY (`prefix_id`) REFERENCES `mlov` (`mlov_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (4,'navnath',NULL,'chinchore',3,6,0,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `modified` datetime DEFAULT NULL,
  `modified_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  KEY `FKir5g7yucydevmmc84i788jp79` (`person_id`),
  KEY `FKc3b4xfbq6rbkkrddsdum8t5f0` (`account_id`),
  CONSTRAINT `FKc3b4xfbq6rbkkrddsdum8t5f0` FOREIGN KEY (`account_id`) REFERENCES `account` (`account_id`),
  CONSTRAINT `FKir5g7yucydevmmc84i788jp79` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (3,'nchinchore','navi2589',4,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-27 19:32:44
