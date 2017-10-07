-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: diosfinance
-- ------------------------------------------------------
-- Server version	5.7.17-0ubuntu0.16.04.1

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
-- Table structure for table `expenses`
--

DROP TABLE IF EXISTS `expenses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expenses` (
  `expense_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `item` varchar(100) NOT NULL,
  `category` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `rate` decimal(20,2) DEFAULT '0.00',
  `paid_to` varchar(100) DEFAULT NULL,
  `paid_on` date DEFAULT NULL,
  `created_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `users_userid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`expense_id`,`users_userid`),
  KEY `fk_expenses_users1_idx` (`users_userid`),
  CONSTRAINT `fk_expenses_users1` FOREIGN KEY (`users_userid`) REFERENCES `users` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expenses`
--

LOCK TABLES `expenses` WRITE;
/*!40000 ALTER TABLE `expenses` DISABLE KEYS */;
INSERT INTO `expenses` VALUES (1,'SALARY','WAGE',1,150000.00,'EMMA','2016-03-31','2017-02-26 08:05:09',1);
/*!40000 ALTER TABLE `expenses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revenue`
--

DROP TABLE IF EXISTS `revenue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `revenue` (
  `revenue_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(45) NOT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `medical_condition` varchar(45) DEFAULT NULL,
  `charge` decimal(20,2) DEFAULT '0.00',
  `date_of_visit` date DEFAULT NULL,
  `created_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `users_userid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`revenue_id`,`users_userid`),
  KEY `fk_revenue_users_idx` (`users_userid`),
  CONSTRAINT `fk_revenue_users` FOREIGN KEY (`users_userid`) REFERENCES `users` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revenue`
--

LOCK TABLES `revenue` WRITE;
/*!40000 ALTER TABLE `revenue` DISABLE KEYS */;
INSERT INTO `revenue` VALUES (1,'KASAGGA PATRICK','0773796678','KASANGATI',' ',65000.00,'2016-03-01','2017-02-26 07:50:31',1),(2,'AMINAH','0702023690','NAKULABYE',' ',50000.00,'2016-03-05','2017-02-26 08:02:34',1),(3,'NSHUTI JOSEPHINE','0783565586','RUBAGA',' ',100000.00,'2016-03-07','2017-02-26 08:03:48',1),(4,'MUKASA AHRAF',' ','MUTUNDWE',' ',25000.00,'2016-03-07','2017-02-26 08:10:18',1),(5,'NAMATA EVE','0776687987','MUTUNDWE',' ',20000.00,'2016-03-11','2017-02-26 08:12:10',1),(6,'KAYEMBA AUGUSTINE','0757098544','MUTUNDWE',' ',10000.00,'2016-03-12','2017-02-26 08:16:11',1),(7,'WARREN RAYMOS','0707565756','NALUKOLONGO',' ',30000.00,'2016-03-13','2017-02-26 08:17:08',1),(8,'ANONY-ENGINEER',' ','NALUKOLONGO',' ',60000.00,'2016-03-14','2017-02-26 08:17:57',1),(9,'SSENTONGO ROBERT','0758318322','MAKINDYE',' ',30000.00,'2016-03-16','2017-02-26 08:18:52',1),(10,'ANONY-MUSAWO',' ','NALUKOLONGO',' ',30000.00,'2016-03-16','2017-02-26 08:19:39',1),(11,'EJONG DENNIS',' ','RUBAGA',' ',10000.00,'2016-03-17','2017-02-26 08:22:38',1),(12,'NAKITO JAZRAH','0702238032','MUTUNDWE',' ',40000.00,'2016-03-18','2017-02-26 08:23:46',1),(13,'NANYONJO JACKIE','0772884414','MUTUNDWE',' ',40000.00,'2016-03-19','2017-02-26 08:25:13',1),(14,'NSHUTI JOSEPHINE',' ','RUBAGA',' ',20000.00,'2016-03-19','2017-02-26 08:25:54',1),(15,'SEKABEMBE SIRAJE','0753589073','MUTUNDWE',' ',19000.00,'2016-03-20','2017-02-26 08:26:49',1),(16,'KITYO DENNIS',' ','RUBAGA',' ',40000.00,'2016-03-25','2017-02-26 08:27:39',1),(17,'SEGIRINYA ABDUL','0788243717','MUTUNDWE',' ',10000.00,'2016-03-31','2017-02-26 08:29:06',1),(18,'NAKIDE SHARON',' ','MUTUNDWE','  ',50000.00,'2016-04-02','2017-02-26 08:29:57',1),(19,'NASSANGA ROSE',' ','BIRA KIREKA',' ',50000.00,'2016-04-04','2017-02-26 08:47:28',1),(20,'MUTYABA BOB','0703896370','NAMASUBA',' ',50000.00,'2016-04-06','2017-02-26 08:48:34',1),(21,'LUCKY',' ',' ',' ',10000.00,'2016-04-06','2017-02-26 08:49:20',1),(22,'NAMALE MICHELLE VICTORIA','0750789589','MUTUNDWE',' ',75000.00,'2016-04-11','2017-02-26 08:50:22',1),(23,'ZALWANGO FLAVIA','0706328303','MUTUNDWE',' ',20000.00,'2016-04-13','2017-02-26 08:51:45',1),(24,'LUYIMA MARK','0751290523','KABUUSU',' ',20000.00,'2016-04-14','2017-02-26 08:53:07',1),(25,'MUSIMENTA JENNIFER','0783625442','NALUKOLONGO',' ',60000.00,'2016-04-14','2017-02-26 08:54:01',1),(26,'NAMAKULA AISHA',' ','KABAWO',' ',18000.00,'2016-04-16','2017-02-26 08:54:44',1),(27,'SSALI GEORGE',' ','NALUKOLONGO',' ',50000.00,'2016-04-16','2017-02-26 08:55:28',1),(28,'NAKISEKA DORCUS','0787013507','BUKOTO',' ',70000.00,'2016-04-18','2017-02-26 08:56:20',1),(29,'KIZZA HENRY','0772409480','MAYA',' ',40000.00,'2016-04-18','2017-02-26 08:56:57',1),(30,'MUTYABA RONALD','0700558016',' KITAWULUZI',' ',20000.00,'2016-04-19','2017-02-26 09:31:37',1),(31,'MUTESI PATIENCE','0769711217','MUTUNDWE',' ',120000.00,'2016-04-20','2017-02-26 09:33:09',1),(32,'LWASE VINCENT','0703584936','BUKENGA',' ',20000.00,'2016-04-21','2017-02-26 09:34:06',1),(33,'NAMUBIRU MAIMUNA','0788227573','KASENGE',' ',15000.00,'2016-04-23','2017-02-26 09:35:09',1),(34,'NABUSO TINA','0701318944','MUTUNDWE',' ',20000.00,'2016-04-25','2017-02-26 09:36:28',1),(35,'LUKWAGO LAWRENCE','0755675072','MUTUNDWE',' ',190000.00,'2016-04-25','2017-02-26 09:37:31',1),(36,'LUTAKOME BRIAN','0753050158','SEGUKU',' ',150000.00,'2016-04-26','2017-02-26 09:38:23',1),(37,'AGNES. M','0756436057','NALUKOLONGO',' ',20000.00,'2016-04-26','2017-02-26 09:39:32',1),(38,'KYALIGONZA MAX','0772957737','BUGOLOBI',' ',15000.00,'2016-04-27','2017-02-26 09:40:30',1),(39,'KABALEGA DAVID',' ','MENGO',' ',50000.00,'2016-04-28','2017-02-26 09:42:25',1),(40,'JJUUKO FRANCIS','0752500447','KANSANGA',' ',40000.00,'2016-04-28','2017-02-26 09:43:18',1),(41,'NABAKOOZA PAULINE','0701359050','LUMBUSA',' ',20000.00,'2016-04-29','2017-02-26 09:44:19',1),(42,'SOFIA','0784680687','BUSEGA',' ',20000.00,'2016-04-29','2017-02-26 09:45:19',1),(43,'NAKIBIRA KATE','0759069177','KIGOMA',' ',35000.00,'2016-04-30','2017-02-26 09:46:16',1),(44,'LUKWAGO LAWRENCE',' ','MUTUNDWE',' ',50000.00,'2016-05-02','2017-02-26 09:47:12',1),(48,'KAMBALE NSERIMA','0774976837','LUNGUJJA',' ',35000.00,'2016-05-03','2017-02-26 11:14:22',1),(49,'TUGULUMIZE MOUNTAIN',' ','BWEYOGERERE',' ',70000.00,'2016-05-02','2017-02-26 11:15:18',1),(50,'LUBEGA FAZIL',' ','MUTUNDWE',' ',50000.00,'2016-05-02','2017-02-26 11:15:50',1),(51,'BUHIRWE DERRICK','0705622425','MUTUNDWE',' ',40000.00,'2016-05-04','2017-02-26 12:40:18',1),(52,'NAKITTO CATHY',' ','KANSAGA',' ',35000.00,'2016-05-05','2017-02-26 12:42:53',1),(53,'SSIMBWA SOLOMON','0758293261','MUTUNDWE',' ',45000.00,'2016-05-06','2017-02-26 12:43:35',1),(54,'KIZZA',' ',' ',' ',20000.00,'2016-05-07','2017-02-26 12:44:04',1),(55,'MUGERWA GRACE',' ','MUTUNDWE',' ',20000.00,'2016-05-10','2017-02-26 12:44:35',1),(56,'NALULE REBECCA','0755581442','MUTUNDWE',' ',30000.00,'2016-05-10','2017-02-26 12:45:07',1),(57,'NANGOBI BETTY','0758144669','MUTUNDWE',' ',150000.00,'2016-05-13','2017-02-26 12:46:27',1),(58,'MIWANDA BAGENDA','0778372461','RUBAGA',' ',50000.00,'2016-05-14','2017-02-26 12:47:05',1),(59,'NANTONGO REMMY','0750308205','NALUKOLONGO',' ',10000.00,'2016-05-14','2017-02-26 12:47:44',1),(60,'WASSWA ISAAC','0750569360','MUTUNDWE',' ',20000.00,'2016-05-17','2017-02-26 12:48:17',1),(61,'NANTONGO VANESSA','0752876053','MUTUNDWE',' ',25000.00,'2016-05-17','2017-02-26 12:48:52',1),(62,'KIMERA',' ','NALUKOLNGO',' ',20000.00,'2016-05-19','2017-02-26 12:49:34',1),(63,'YIGA PATRICK','0752807285','NABINGO',' ',20000.00,'2016-05-19','2017-02-26 12:54:05',1),(64,'NAMYA CHRISTINE','0774582430','LUGAZI',' ',50000.00,'2016-05-19','2017-02-26 12:55:02',1),(65,'NAMAKULA OLIVER','0781526051','MUTUNDWE',' ',14000.00,'2016-05-19','2017-02-26 12:55:36',1),(66,'NABULYA MARGERET','0752514860','NALUKOLONGO',' ',20000.00,'2016-05-20','2017-02-26 12:56:19',1),(67,'SERWANKAMBO HARUNA','0702918442','ZANA',' ',20000.00,'2016-05-20','2017-02-26 12:56:54',1),(68,'KALUNGI MOSES','0758412135','NALUKOLONGO',' ',30000.00,'2016-05-21','2017-02-26 12:57:25',1),(69,'WAGABA CAROLINE','0706821565','KASANGATI',' ',150000.00,'2016-05-25','2017-02-26 12:57:59',1),(70,'OWERE DENNIS','0709679220','NALUKOLONGO',' ',100000.00,'2016-05-25','2017-02-26 12:58:30',1),(71,'NYANZI ABUBAKER','0706411343','MAYA',' ',60000.00,'2016-05-26','2017-02-26 12:59:05',1),(72,'LUKWAGO LUKEMAN','O752546119','KYENGERA',' ',40000.00,'2016-05-26','2017-02-26 13:00:03',1),(73,'NANTONGO VANNESA',' ','MUTUNDWE',' ',20000.00,'2016-05-27','2017-02-26 13:00:30',1),(74,'NTANDA EDRON','0756503448','RUBAGA',' ',20000.00,'2016-05-28','2017-02-26 13:01:15',1),(75,'NABBIRO ZAINAB','0777150444','MUTUNDWE',' ',20000.00,'2016-05-28','2017-02-26 13:02:35',1),(76,'MUSOKE DAN','0782509145','NALUKOLONGO',' ',20000.00,'2016-06-01','2017-02-26 13:03:14',1),(77,'BATTE TIMOTHY','0758952177','RUBAGA',' ',20000.00,'2016-06-04','2017-02-26 13:03:36',1),(78,'KYALUHAZI JANET','0705258377','MUTUNDWE',' ',50000.00,'2016-06-06','2017-02-26 13:04:19',1),(79,'KATENDE DAVID','0756496058','MUTUNDWE',' ',40000.00,'2016-06-06','2017-02-26 13:05:22',1),(80,'BUWEMBO JULIET','0706586118','MUTUNDWE',' ',20000.00,'2016-06-07','2017-02-26 13:05:45',1),(81,'KIBERU RACHEAL MARGARET','0772498243',' KANSANGA',' ',50000.00,'2016-06-09','2017-02-26 13:06:33',1),(82,'WASSWA BERNARD','0773415626','BUSEGA',' ',100000.00,'2016-06-09','2017-02-26 13:07:27',1),(83,'KAMOGA BRIAN',' ',' ',' ',20000.00,'2016-06-09','2017-02-26 13:07:54',1),(84,'KATENDE HAMZA','0700206676','BUNGA',' ',90000.00,'2016-06-11','2017-02-26 13:08:26',1),(85,'EMODYO CEASAR','0705082788','BWEYOGERERE',' ',60000.00,'2016-06-11','2017-02-26 13:09:09',1),(86,'MAGEMBER AISHA','0705082788','KAYUNGA',' ',50000.00,'2016-06-12','2017-02-26 13:09:50',1),(87,'SSENYONDO EMMANUEL','0752615261','MUTUNDWE',' ',20000.00,'2016-06-12','2017-02-26 13:10:19',1),(88,'MUMBA DOUGLAS','0751552026','KABOJJA',' ',20000.00,'2016-06-15','2017-02-26 13:10:50',1),(89,'MUTGWANYA SHABAN','0785280006','MUTUNDWE',' ',55000.00,'2016-06-16','2017-02-26 13:11:20',1),(90,'KIBERU RACHEAL','0772498243','KANSANGA',' ',20000.00,'2016-06-16','2017-02-26 13:12:15',1),(91,'MUSITU ANJERU','0705054232','KABOWA',' ',20000.00,'2016-06-17','2017-02-26 13:13:37',1),(92,'LUWEDDE MUTYABA','0750780131','MUTUNDWE',' ',20000.00,'2016-06-17','2017-02-26 13:14:24',1),(93,'MAGEMBER AISHA',' ','KAYUNGU',' ',20000.00,'2016-06-19','2017-02-26 13:14:53',1),(94,'NAKIYIMBA PELLUSI','0759142736','NALUKOLONGO',' ',20000.00,'2016-06-22','2017-02-26 13:15:43',1),(95,'LUBEGA WILLIAM','0758051135','KYENGERA',' ',20000.00,'2016-06-22','2017-02-26 13:16:23',1),(96,'SSENTONGO BUHANI','0750780118','MUTUNDWE',' ',20000.00,'2016-06-23','2017-02-26 13:17:05',1),(97,'NAKAMI HAJARAH','0772426465','MUTUNDWE',' ',20000.00,'2016-06-23','2017-02-26 13:17:33',1),(98,'NSUBUGA LAWRENCE','0755381478','MUTUNDWE',' ',50000.00,'2016-06-23','2017-02-26 13:18:04',1),(99,'NTAGUBYA STEVEN','0775164092','KASENGE',' ',150000.00,'2016-06-23','2017-02-26 13:19:34',1),(100,'BABIRYE JAMIRAH','0779360408','MUTUNDWE',' ',20000.00,'2016-06-25','2017-02-26 13:20:02',1),(101,'NAMUBIRU MAIMUNA',' ','KASENGE',' ',15000.00,'2016-06-25','2017-02-26 13:20:30',1),(102,'MUJABI BETTY','0782998780','MULAGO',' ',50000.00,'2016-06-25','2017-02-26 13:20:59',1),(103,'KIYIMBA CRANMAR',' ',' NALUKOLONGO',' ',50000.00,'2016-06-25','2017-02-26 13:21:35',1),(104,'NKALUBO DERRICK','0755228255','KABOJJA',' ',20000.00,'2016-06-28','2017-02-26 13:22:13',1),(105,'NSUBUGA TIMOTHY','0706407627','RUBAGA',' ',20000.00,'2016-06-28','2017-02-26 13:22:35',1),(106,'WAKIDA EBO','0701980026','BUKOTO',' ',20000.00,'2016-06-29','2017-02-26 13:23:16',1),(107,'DEO',' ','MUTUNDWE',' ',20000.00,'2016-06-30','2017-02-26 13:23:58',1),(108,'LAMBARA YIISA',' ','MUTUNDWE',' ',20000.00,'2016-07-04','2017-02-26 13:24:41',1),(109,'MUBIRU RICHARD','0781000717','NALUKOLONGO',' ',20000.00,'2016-07-05','2017-02-26 13:29:59',1),(110,'AINA SHERA','070260778','NATEETE',' ',25000.00,'2016-07-05','2017-02-26 13:30:30',1),(111,'JEMBA ROBERT','0750111625','BUSEGA',' ',20000.00,'2016-07-06','2017-02-26 13:30:53',1),(112,'SSEWAKIRAYANGA GEOFFREY','0756329081','NDEEBA',' ',40000.00,'2016-07-07','2017-02-26 13:31:22',1),(113,'NAKIYIMBA PROSSY',' ','KALERWE',' ',20000.00,'2016-07-08','2017-02-26 13:31:43',1),(114,'NSUBUGA LAWRENCE','0755381498','MUTUNDWE',' ',65000.00,'2016-07-08','2017-02-26 13:32:08',1),(115,'MUKASA RAMADHAN','0702279850','MUTUNDWE',' ',50000.00,'2016-07-09','2017-02-26 13:32:45',1),(116,'SSERULYO STANLEY','0704806536','LUWEERO',' ',120000.00,'2016-07-09','2017-02-26 13:33:21',1),(117,'SEBWANA ALEX','0751585217','WAKALIGA',' ',20000.00,'2016-07-10','2017-02-26 13:33:55',1),(118,'NAJJINGO HARRIET','0758097033','NALUKOLONGO ',' ',20000.00,'2016-07-10','2017-02-26 13:34:25',1),(119,'NANTEZA MARIA JACINTA','0700984369','RUBAGA',' ',20000.00,'2016-07-13','2017-02-26 13:35:06',1),(120,'NAKIWALA MONICA','0700984369','RUBAGA',' ',20000.00,'2016-07-13','2017-02-26 13:35:53',1),(121,'MUBIRU JAMES','0758030484','NALUKOLOGO',' ',15000.00,'2016-07-13','2017-02-26 13:36:21',1),(122,'ELENG ANTHONY','0775320967','NAKASERO',' ROOT CANAL',250000.00,'2016-07-14','2017-02-26 13:37:25',1),(123,'SSANYU IMMACULATE',' ','MUTUNDWE',' ROOT CANAL',200000.00,'2016-07-14','2017-02-26 16:01:10',1),(124,'NABUSIBA FATUMA','0777591300','MUTUNDWE','EXTRACTION',20000.00,'2016-07-15','2017-02-26 16:01:46',1),(125,'SEWAKIRAYNGA. G','0750111625','NDEEBA','FILLING',60000.00,'2016-07-15','2017-02-26 16:02:28',1),(126,'MUBIRU JAMES',' ','NALUKOLONGO ','EXTRACTION',20000.00,'2016-07-15','2017-02-26 16:03:00',1),(127,'NAGAWA PAULINE','0759827885','NALUKOLONGO','EXTRACTTION',30000.00,'2016-07-16','2017-02-26 16:03:42',1),(128,'MIRE KALEMBA','0774869293','MUTUNDWE','RCT',150000.00,'2016-07-19','2017-02-26 16:04:28',1),(129,'KOBUSINGE SHAMIM','0783884870','NALOKOLONGO','EXTRACTION',30000.00,'2016-07-24','2017-02-26 16:05:13',1),(130,'JILAH EMAH',' ','KABUUSU','EXTRACTION',20000.00,'2016-07-25','2017-02-26 16:05:57',1),(131,'BANAALEKA KENNETH','0754711217','NALUKOLONGO','EXTRACTION',18000.00,'2016-07-25','2017-02-26 16:06:41',1),(132,'NANTEZA CATHERINE','0752949199','MUTUNDWE','SCALING',50000.00,'2016-07-26','2017-02-26 16:07:17',1),(133,'MUTESI PATIENCE',' ','NALUKOLONGO','EXTRACTION',20000.00,'2016-07-26','2017-02-26 16:07:57',1),(134,'TUMUSIIME ALVIN','0755645473','RUBAGA','EXTRACTION',40000.00,'2016-07-26','2017-02-26 16:08:40',1),(135,'BASHIR','0792367658','NALUKOLONGO','FILLING',40000.00,'2016-07-26','2017-02-26 16:10:03',1),(136,'NAMAGEMBE. M','0777050773','KASENGE','EXTRACTION',30000.00,'2016-07-26','2017-02-26 16:10:33',1),(137,'NAMUYINDA WINNIE','0752436308','KASENDE','EXTRACTION',20000.00,'2016-07-27','2017-02-26 16:11:10',1),(138,'MWESIGWA JEREMIAH','0752401201','RUBAGA','EXTRACTION',20000.00,'2016-07-28','2017-02-26 16:11:51',1),(139,'KANAMWANJE. L','0712572158','NYANAMA','TEMPORARY FILLING',25000.00,'2016-07-28','2017-02-26 16:12:41',1),(140,'NAKAYI JANAT','0756080839','NALUKOLONGO','EXTRACTION',15000.00,'2016-07-28','2017-02-26 16:13:15',1),(141,'KAYONGA GERALD','0706571920','BULENGA','EXTRACTION',40000.00,'2016-07-28','2017-02-26 16:13:43',1),(142,'KAMOGA MUSA','0774789351','MUTUNDWE','EXTRACTION',20000.00,'2016-07-28','2017-02-26 16:14:11',1),(143,'KABUSINGA GRACE','0751027820','BULENGA','EXTRACTION',20000.00,'2016-07-29','2017-02-26 16:14:43',1),(144,'MIREMBE GLADYS','07065650761','MUTUNDWE','EXTRACTION',20000.00,'2016-07-29','2017-02-26 16:16:13',1),(145,'SSENTONGO BUHANI',' ','MUTUNDWE','FILLING',160000.00,'2016-07-29','2017-02-26 16:16:46',1),(146,'KIBERU MUSA','0759505136','MUTUNDWE','EXTRACTION',20000.00,'2016-07-29','2017-02-26 16:17:43',1),(147,'BALYA ISAAC','0704881247','MUTUNDWE','COMPOSITE FILLINGS',170000.00,'2016-07-30','2017-02-26 16:18:18',1),(148,'SSENTAMU LAWRENCE','0784399409','KABOJJA','EXTRACTION',30000.00,'2016-08-01','2017-02-26 16:20:10',1),(149,'NALWANGA IMMACULATE',' ','MUTUNDWE','DRUGS',5000.00,'2016-08-01','2017-02-26 16:20:38',1),(150,'SSEKULIMA FRED','0756139645','MUTUNDWE','EXTRACTION',30000.00,'2016-08-02','2017-02-26 16:21:10',1),(151,'KIZZA HENRY',' ','MUTUNDWE','TEMPORARY FILLING',20000.00,'2016-08-02','2017-02-26 16:21:39',1),(152,'MUSTAFA,.A',' ','MUTUNDWE','EXTRACTION',20000.00,'2016-08-02','2017-02-26 16:22:12',1),(153,'NAMUGGA CHLOE','0703081939','MUTUNDWE','EXTRACTION',20000.00,'2016-08-06','2017-02-26 16:22:44',1),(154,'BANABWONA HALIMA','0700176228','NATEETE','EXTRACTION',20000.00,'2016-08-07','2017-02-26 16:23:40',1),(155,'ANONY',' ',' ','RCT',150000.00,'2016-08-07','2017-02-26 16:24:29',1),(156,'BOGERE WINNIE','0754502617','BUNNAMWAYA','FILLING',40000.00,'2016-08-07','2017-02-26 16:25:06',1),(157,'NALUBEGA NADIA','0752908861','NAKULABYE','EXTRACTION',40000.00,'2016-08-08','2017-02-26 16:25:40',1),(158,'BABIRYE SARAH',' ',' KANYANYA','SCALING',50000.00,'2016-08-08','2017-02-26 16:26:17',1),(159,'AMINA BASHIR','0792367658','NALUKOLONGO','EXTRACTION',20000.00,'2016-08-09','2017-02-26 16:27:03',1),(160,'BIRUNGI GORETTI',' ','MUTUNDWE','RCT',70000.00,'2016-08-11','2017-02-26 16:27:32',1),(161,'NAMWANJE JUDITH',' ','NATEETE','EXTRACTION',20000.00,'2016-08-11','2017-02-26 16:27:58',1),(162,'KAKEMBO AHMED','0753522235','JINJA','FILLING',40000.00,'2016-08-13','2017-02-26 16:28:27',1),(163,'MARTHA GLIDDEN','075495239','NALUKOLONGO','EXTRACTION',55000.00,'2016-08-13','2017-02-26 16:29:11',1),(164,'SSEGIRINYA ABDUL',' ','MUTUNDWE','EXRACTION',40000.00,'2016-08-15','2017-02-26 16:29:43',1),(165,'MPALANYI ENOCH','0701120224','NALUKOLONGO','EXTRACTION',30000.00,'2016-08-17','2017-02-26 16:30:15',1),(166,'KOBUSINGE SANDRA','0701295926','MUTNDWE','EXTRACTION',20000.00,'2016-08-18','2017-02-26 16:32:10',1),(167,'SSEGIRINYA ABDUL',' ','NALUKOLONGO','EXTRACTION',35000.00,'2016-08-18','2017-02-26 16:32:58',1),(168,'NSUBUGA LAWRENCE','  ','MUTUNDWE','FILLING',0.00,'2016-08-18','2017-02-26 16:34:05',1),(169,'NAGUDI JACKIE','0758288194','LUNGUJJA','EXTRACTION',20000.00,'2016-08-19','2017-02-26 16:35:54',1),(170,'NABUKENYA MAGERI',' ','MUTUNDWE','EXTRACTION',20000.00,'2016-08-20','2017-02-26 16:36:18',1),(171,'KIMBUGWE RONALD','0752036409','KYENGERA','FILLING ',70000.00,'2016-08-23','2017-02-26 16:36:51',1),(172,'NALWOGA SOFI','0785844772','NALUKOLONGO','RCT',150000.00,'2016-08-24','2017-02-26 16:37:28',1),(173,'SEKIRANDA RONALD','0756757502','KALAMBI','EXTRACTION',20000.00,'2016-08-25','2017-02-26 16:38:07',1),(174,'NAKUYA FAITH','0775235029','BUNNAMWAYA','EXTRACTION',25000.00,'2016-08-26','2017-02-26 16:38:50',1),(175,'MUTAGAMBA LAWRENCE','0787372862','KASANGATI','FILLING',65000.00,'2016-08-26','2017-02-26 16:39:18',1),(176,'SEKIRANDA RONALD','0756757502','KALAMBI','X-RAY',15000.00,'2016-08-27','2017-02-26 16:40:07',1),(177,'NASSONKO ANITA','0701332245','NYANAMA','EXTRACTION',20000.00,'2016-08-27','2017-02-26 16:40:35',1),(178,'KATO SHAFIQ','0756468047','NALUKOLONGO','EXTRACTION',30000.00,'2016-08-29','2017-02-26 16:41:08',1),(179,'LUYIMA SIRAJE','0772487532','MUTUNDWE','EXTRACTION',20000.00,'2016-08-30','2017-02-26 16:41:38',1),(180,'KATO SHAFIQ','0756468047','NALUKOLONGO','EXTRACTION',15000.00,'2016-08-31','2017-02-26 16:42:02',1),(181,'MAAMA ENOCH','075693222','NALUKOLONGO','PARODONTAX PASTE',15000.00,'2016-08-31','2017-02-26 16:42:40',1),(182,'MPALANYI ENOCH','0701022420','NALUKOLONGO','EXTRACTION',20000.00,'2016-08-31','2017-02-26 16:43:14',1);
/*!40000 ALTER TABLE `revenue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `password` varchar(200) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `created_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'nicholas','NICHOLAS','KALINGE','nicholas',1,'2017-02-26 07:49:48');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'diosfinance'
--

--
-- Dumping routines for database 'diosfinance'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-26 19:55:01