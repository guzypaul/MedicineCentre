-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: medicine_centre
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `appointments`
--

DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `client_id` int NOT NULL,
  `doctor_id` int NOT NULL,
  `date` date NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `procedure_id` int NOT NULL,
  `status` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`) /*!80000 INVISIBLE */,
  UNIQUE KEY `Unique_date_start_time` (`date`,`start_time`,`doctor_id`),
  KEY `appontments_users_idx` (`client_id`),
  KEY `appointments_procedures_idx` (`procedure_id`),
  KEY `appointment_doctors_idx` (`doctor_id`),
  CONSTRAINT `appointment_doctors` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  CONSTRAINT `appointments_procedures` FOREIGN KEY (`procedure_id`) REFERENCES `procedures` (`id`),
  CONSTRAINT `appontments_users` FOREIGN KEY (`client_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (1,5,1,'2022-03-01','09:00:00','09:40:00',1,'CONFIRMED'),(3,8,5,'2022-03-02','09:00:00','11:00:00',2,'CLAIMED'),(4,9,6,'2022-03-03','09:00:00','09:05:00',4,'CANCELED'),(8,10,7,'2022-03-03','09:00:00','10:00:00',6,'CONFIRMED'),(9,11,8,'2022-03-03','09:00:00','09:30:00',7,'CLAIMED');
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_schedules`
--

DROP TABLE IF EXISTS `doctor_schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor_schedules` (
  `id` int NOT NULL AUTO_INCREMENT,
  `doctor_id` int NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `info` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `doctor_schedule_id_UNIQUE` (`id`),
  KEY `doctor_schedules_doctors_idx` (`doctor_id`),
  CONSTRAINT `doctor_schedules_doctors` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_schedules`
--

LOCK TABLES `doctor_schedules` WRITE;
/*!40000 ALTER TABLE `doctor_schedules` DISABLE KEYS */;
INSERT INTO `doctor_schedules` VALUES (1,1,'09:00:00','18:00:00','all week'),(2,5,'10:00:00','19:00:00','all week'),(3,6,'11:00:00','20:00:00','all week'),(4,7,'10:00:00','20:00:00','all week');
/*!40000 ALTER TABLE `doctor_schedules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `id` int NOT NULL AUTO_INCREMENT,
  `qualification` varchar(45) COLLATE utf8_bin NOT NULL,
  `rank` varchar(45) COLLATE utf8_bin NOT NULL,
  `doctor_info` int NOT NULL,
  `photo_name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `doctors_users_idx` (`doctor_info`),
  CONSTRAINT `doctors_users` FOREIGN KEY (`doctor_info`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,'Dentist','unknown',2,'ivan_zubnov.jpg'),(5,'Ophthalmologist','doubtful',3,'dmitriy_glaznov.jpg'),(6,'Surgeon','low',4,'serge_surgeonov.jpg'),(7,'Psychologist','normal',27,'karl_psyhonov.jpg'),(8,'Expert in narcology','professional',29,'danila_buhnov.jpg');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procedures`
--

DROP TABLE IF EXISTS `procedures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `procedures` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_bin NOT NULL,
  `price` decimal(8,2) NOT NULL,
  `description` varchar(350) COLLATE utf8_bin NOT NULL,
  `duration` int NOT NULL,
  `image_name` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procedures`
--

LOCK TABLES `procedures` WRITE;
/*!40000 ALTER TABLE `procedures` DISABLE KEYS */;
INSERT INTO `procedures` VALUES (1,'Tooth filling',50.00,'tooth filling with using innovative technologies ',40,'tooth_filling.jpg'),(2,'Vision correction',900.00,'laser equipment using only',120,'vision_correction.jpg'),(4,'Surgery',20.00,'removing any part of the body',5,'surgery.jpg'),(6,'Psycho help',2000.00,'psychological help',60,'depression.jpg'),(7,'Alcoholism treatment',500.00,'alcoholism treatment',30,'glass_of_vodka.jpg');
/*!40000 ALTER TABLE `procedures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8_bin NOT NULL,
  `surname` varchar(30) COLLATE utf8_bin NOT NULL,
  `password` varchar(60) COLLATE utf8_bin NOT NULL,
  `email` varchar(45) COLLATE utf8_bin NOT NULL,
  `phone` varchar(15) COLLATE utf8_bin NOT NULL,
  `role` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Admin','Admin','$2a$10$pp0bJ6L8blkinUzFylBXd.1OOSpjAzZxzdRJ7JZfgD3MSO7ipNmAi','admin@gmail.com','+375298882265','ADMIN'),(2,'Ivan','Zubnov','$2a$10$QYwol5LemomyBX4qBv2PK.F0Ad83vAW2IMWYcr5Ht/sCwIuUPw1Ka','zubnov@gmail.com','+375295959292','DOCTOR'),(3,'Dmitriy','Glaznov','$2a$10$sIw5NSjuKZFWN0MfXfALtunZYIVPXwvMvisMXL6wLGcXthI35puM2','glaznov@mail.com','+375298958989','DOCTOR'),(4,'Serge','Surgeonov','$2a$10$sUkv4yJOqVrh20SkhpTb/eLvvO0ZM6BUNkj7R9RYAqVtuqt9NnYzq','surgeonov@gmail.com','+375298957877','DOCTOR'),(5,'user1','userov1','$2a$10$eSF6XnNNHMxZmVj0G9SsWOMBzxGbp/kGLDfT.0N4bbvRe.CNxalSq','user1@gmail.com','+375251231212','USER'),(6,'Receptionist1','moder1','$2a$10$w/1FbOnlzmY/YrVoCR5SO.MviQJkkghOBjfM3UtUm5F0z/oYHcVDq','rcp1@gmail.com','+375254556989','MODERATOR'),(7,'Receptionist2','moder2','$2a$10$0SFkknX955BlKJ4HvQtwDOLneBUd2ZRQ0lPc9IsdmHc/7z54ENUU6','rcp2@gmail.com','+375256565896','MODERATOR'),(8,'user2','userov2','$2a$10$vlwRQ7bVTwk37SDsQhb9LOgF2HfPaW3mAvFOjCQW8qbIQb2CiR0R6','user2@gmail.com','+375298686985','USER'),(9,'user3','userov3','$2a$10$CVF6rCRJEgR5JDWHla8hr.XDpyTAu393WIEBfaXkPCk.QdGx3XzHa','user3@gmail.com','+375254545454','USER'),(10,'user4','userov4','$2a$10$gT9fgJkzwCyJAe5w5DUyH.abbDp8dVYQgL3WMMzQpR2f6YHYg7pAq','user4@gmail.com','+375257778888','USER'),(11,'user5','userov5','$2a$10$vOY1MtVb5Ri9SC3uPvyAG.jmht2iCqYCe4QhXG71h7zDn3vyCGDf6','user5@gmail.com','+375255551122','USER'),(12,'user6','userov6','$2a$10$r0LwJfLJujJ6h1GQ3INAMOBFqypk4KyimF2f5Ew.i7qNSwziKM5bC','user6@gmail.com','+375258529637','USER'),(13,'user7','userov7','$2a$10$QctKbdCjMXlpIwhKFGFkI.cDxKkvSGJD1jqD/jn2aeCKSjlIv6P06','user7@gmail.com','+375258529631','USER'),(14,'user8','userov8','$2a$10$jQTnf2AcVshAUhFdXZ0UCujATqfLDK.mPor78c3xL52hv5h9xxw8u','user8@gmail.com','+375258529632','USER'),(15,'user9','userov9','$2a$10$FlRTMrejXS4kDPuKW/dp8.vaZpfuLji6ykN5pfaTJE2wjsipneNOe','user9@gmail.com','+375258529633','USER'),(16,'user10','userov10','$2a$10$BjNQx41I3DKM965JlD6ET.k6u0dIXXLzMTc6u1y4AaQ7c6VMNgrmG','user10@gmail.com','+375258529634','USER'),(27,'Karl','Psyhonov','$2a$10$YYvtJSYVOAnNRBMAzuczoOIKN8REnjW1YdeMZabiALB3hlswNONE.','psychonov@gmail.com','+321000','DOCTOR'),(29,'Danila','Buhnov','$2a$10$Y1hlHGacQBe5F7cEygbuk.4edXuTORSKQFUB3/vHPOZSPfvsFCqZa','buhnov@gmail.com','+33330909','DOCTOR');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-07 10:33:41
