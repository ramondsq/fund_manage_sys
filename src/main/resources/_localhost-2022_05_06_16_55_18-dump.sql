-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fund_manage_system
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) NOT NULL,
  `admin_pwd` varchar(20) NOT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_login_admin_name_uindex` (`admin_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10003 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (10001,'admin1','123456'),(10002,'admin2','123456');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(20) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20016 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (20001,'设备'),(20002,'材料'),(20003,'加工'),(20004,'差旅'),(20005,'专家咨询'),(20006,'劳务'),(20007,'会务'),(20008,'评审'),(20009,'管理'),(20010,'启动资金');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logs`
--

DROP TABLE IF EXISTS `logs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logs` (
  `log_no` int NOT NULL AUTO_INCREMENT,
  `log_user_id` int NOT NULL,
  `log_opt` varchar(20) NOT NULL,
  `log_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`log_no`),
  KEY `logs_user_user_id_fk` (`log_user_id`),
  CONSTRAINT `logs_user_user_id_fk` FOREIGN KEY (`log_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30030 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logs`
--

LOCK TABLES `logs` WRITE;
/*!40000 ALTER TABLE `logs` DISABLE KEYS */;
INSERT INTO `logs` VALUES (30001,60001,'测试','2022-04-10 14:45:51'),(30007,60001,'登录','2022-04-13 23:09:21'),(30008,60001,'登录','2022-04-13 23:10:10'),(30009,60001,'登录','2022-04-13 23:21:47'),(30010,60001,'登录','2022-04-13 23:22:59'),(30011,60001,'登录','2022-04-16 20:17:48'),(30012,60001,'登录','2022-04-16 20:24:22'),(30013,60001,'登录','2022-04-16 20:26:10'),(30014,60001,'登录','2022-04-16 20:26:42'),(30015,60001,'登录','2022-04-16 20:27:39'),(30016,60001,'登录','2022-04-16 20:28:38'),(30017,60001,'登录','2022-04-16 20:28:45'),(30018,60001,'登录','2022-04-16 20:32:27'),(30019,60001,'登录','2022-04-16 20:33:16'),(30020,60001,'登录','2022-04-16 20:34:21'),(30021,60001,'登录','2022-04-18 17:59:58'),(30022,60001,'登录','2022-04-19 15:51:37'),(30023,60001,'登录','2022-04-19 16:46:02'),(30026,60001,'登录','2022-04-20 14:50:20'),(30027,60001,'登录','2022-04-24 19:39:10'),(30028,60001,'登录','2022-04-30 17:20:14'),(30029,60001,'登录','2022-05-01 01:27:33');
/*!40000 ALTER TABLE `logs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(20) NOT NULL,
  `project_status` int NOT NULL DEFAULT '1' COMMENT '1：启动\n2：停用',
  `project_user_id` int DEFAULT NULL,
  `project_budget` decimal(8,2) DEFAULT NULL COMMENT '预算',
  `project_balance` decimal(8,2) DEFAULT NULL COMMENT '余额',
  `project_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `project_deadline` datetime DEFAULT NULL COMMENT '截止时间',
  PRIMARY KEY (`project_id`),
  UNIQUE KEY `project_project_name_uindex` (`project_name`),
  KEY `project_user_user_id_fk` (`project_user_id`),
  CONSTRAINT `project_user_user_id_fk` FOREIGN KEY (`project_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40021 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (40018,'项目1',1,60001,10000.00,1600.00,'2022-04-22 20:45:29','2022-05-01 20:45:00'),(40019,'项目2',1,60001,20000.00,19886.00,'2022-04-22 20:45:46','2022-05-02 20:45:00'),(40020,'项目3',1,60002,10000.00,10000.00,'2022-04-22 20:46:13','2022-05-03 20:46:00');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `record` (
  `fund_id` int NOT NULL AUTO_INCREMENT,
  `fund_amount` decimal(8,2) NOT NULL,
  `fund_date` datetime NOT NULL,
  `fund_category_id` int NOT NULL,
  `fund_manager` varchar(20) NOT NULL COMMENT '经办人',
  `fund_audit` int NOT NULL DEFAULT '1' COMMENT '1：未审核\n2：已通过\n3：已拒绝',
  `fund_change_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fund_proj_id` int NOT NULL,
  PRIMARY KEY (`fund_id`),
  KEY `record_category_category_id_fk` (`fund_category_id`),
  KEY `record_project_project_id_fk` (`fund_proj_id`),
  KEY `record_user_user_id_fk` (`fund_manager`),
  CONSTRAINT `record_category_category_id_fk` FOREIGN KEY (`fund_category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `record_project_project_id_fk` FOREIGN KEY (`fund_proj_id`) REFERENCES `project` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50032 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (50017,10000.00,'2022-04-22 12:45:30',20010,'user1',2,'2022-04-22 20:45:29',40018),(50018,20000.00,'2022-04-22 12:45:47',20010,'user1',2,'2022-04-22 20:45:46',40019),(50019,10000.00,'2022-04-22 12:46:14',20010,'user2',2,'2022-04-22 20:46:13',40020),(50020,-100.00,'2022-04-22 20:48:00',20001,'qr',2,'2022-04-22 20:48:19',40018),(50021,-200.00,'2022-04-22 20:50:00',20002,'qr',2,'2022-04-22 20:50:52',40018),(50022,-4000.00,'2022-04-22 20:51:00',20003,'qr',2,'2022-04-22 20:51:37',40018),(50023,-2000.00,'2022-04-22 20:51:00',20004,'qr',2,'2022-04-22 20:51:54',40018),(50024,-2000.00,'2022-04-22 20:52:00',20005,'qr',2,'2022-04-22 20:52:23',40018),(50025,-100.00,'2022-04-22 20:52:00',20006,'qr',2,'2022-04-22 20:52:40',40018),(50030,-2000.00,'2022-04-22 21:08:00',20009,'qr',1,'2022-04-22 21:08:45',40018),(50031,-114.00,'2022-04-25 00:36:00',20001,'qr',2,'2022-04-25 00:36:45',40019);
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_pwd` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_login_user_name_uindex` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=60009 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (60001,'user1','654321'),(60002,'user2','123456'),(60003,'user3','123456'),(60004,'user4','123456'),(60005,'user5','123456');
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

-- Dump completed on 2022-05-06 16:55:19
