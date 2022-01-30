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
  KEY `appontments_users_idx` (`client_id`),
  KEY `appointments_procedures_idx` (`procedure_id`),
  KEY `appointment_doctors_idx` (`doctor_id`),
  CONSTRAINT `appointment_doctors` FOREIGN KEY (`doctor_id`) REFERENCES `doctors` (`id`),
  CONSTRAINT `appointments_procedures` FOREIGN KEY (`procedure_id`) REFERENCES `procedures` (`id`),
  CONSTRAINT `appontments_users` FOREIGN KEY (`client_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (3,8,5,'2022-02-02','12:10:00','14:10:00',2,'CONFIRMED'),(4,9,6,'2022-03-12','09:00:00','09:05:00',4,'CANCELED'),(8,10,7,'2022-03-03','09:00:00','10:00:00',6,'CONFIRMED'),(9,11,8,'2022-03-03','09:00:00','09:30:00',7,'CLAIMED'),(10,8,8,'2022-03-11','11:00:00','11:30:00',7,'CONFIRMED'),(11,13,8,'2022-03-23','11:00:00','11:30:00',7,'CONFIRMED'),(12,14,8,'2022-04-15','11:00:00','11:30:00',7,'CONFIRMED'),(73,10,7,'2022-04-13','09:00:00','10:00:00',6,'CONFIRMED'),(74,11,7,'2022-04-23','09:00:00','10:00:00',6,'CLAIMED'),(75,12,7,'2022-04-14','09:00:00','10:00:00',6,'CONFIRMED'),(77,8,6,'2022-03-03','09:00:00','09:05:00',4,'CONFIRMED'),(78,11,6,'2022-03-04','09:00:00','09:05:00',4,'CONFIRMED'),(79,14,6,'2022-03-05','09:00:00','09:05:00',4,'CONFIRMED'),(80,12,5,'2022-04-06','10:00:00','12:00:00',2,'CONFIRMED'),(81,13,5,'2022-04-07','09:00:00','11:00:00',2,'CONFIRMED'),(82,14,5,'2022-04-08','09:00:00','11:00:00',2,'CONFIRMED'),(83,15,5,'2022-04-09','09:00:00','11:00:00',2,'CONFIRMED'),(84,12,1,'2022-02-10','09:18:00','09:58:00',1,'CLAIMED'),(96,8,1,'2022-03-25','11:12:00','11:52:00',1,'CANCELED'),(97,8,8,'2022-04-02','15:00:00','15:40:00',7,'CLAIMED'),(98,8,8,'2022-04-02','10:15:00','10:55:00',7,'CLAIMED'),(99,8,8,'2022-03-17','15:04:00','15:44:00',7,'CLAIMED'),(100,8,5,'2022-03-21','15:04:00','17:04:00',2,'CLAIMED'),(101,8,5,'2022-02-07','09:17:00','11:17:00',2,'CLAIMED'),(102,8,8,'2022-03-17','09:33:00','09:43:00',4,'CLAIMED');
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_schedules`
--

LOCK TABLES `doctor_schedules` WRITE;
/*!40000 ALTER TABLE `doctor_schedules` DISABLE KEYS */;
INSERT INTO `doctor_schedules` VALUES (1,1,'09:00:00','18:00:00','all week'),(2,5,'09:00:00','19:00:00','friday'),(3,6,'11:00:00','20:00:00','all week'),(4,7,'10:00:00','20:00:00','all week'),(6,8,'11:00:00','19:00:00','all week');
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,'Dentist','Unknown',2,'doctor_ivan_zubnov.jpg'),(5,'Ophthalmologist','Doubtful',3,'doctor_dmitriy_glaznov.jpg'),(6,'Surgeon','Low',4,'doctor_serge_surgeonov.jpg'),(7,'Psychologist','Normal',27,'doctor_karl_psyhonov.jpg'),(8,'Narcologist','Super professional',29,'doctor_danila_buhnov.jpg');
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
  `image_name` varchar(260) COLLATE utf8_bin NOT NULL,
  `doctor_qualification` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procedures`
--

LOCK TABLES `procedures` WRITE;
/*!40000 ALTER TABLE `procedures` DISABLE KEYS */;
INSERT INTO `procedures` VALUES (1,'Tooth filling',55.00,'tooth filling with using innovative technologies ',40,'procedure_tooth_filling.jpg','Dentist'),(2,'Vision correction',900.00,'laser equipment using only',120,'procedure_vision_correction.jpg','Ophthalmologist'),(4,'Surgery',20.00,'removing any part of the body',10,'procedure_surgery.jpg','Surgeon'),(6,'Psycho help',2000.00,'psychological help',60,'procedure_psycho_help.jpg','Psychologist'),(7,'Alcoholism treatment',500.00,'alcoholism treatment',40,'procedure_alcoholism_treatment.jpg','Narcologist');
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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Admin','Admin','$2a$10$pp0bJ6L8blkinUzFylBXd.1OOSpjAzZxzdRJ7JZfgD3MSO7ipNmAi','admin@gmail.com','+375298882265','ADMIN'),(2,'Ivan','Zubnov','$2a$10$QYwol5LemomyBX4qBv2PK.F0Ad83vAW2IMWYcr5Ht/sCwIuUPw1Ka','zubnov@gmail.com','+375295959292','DOCTOR'),(3,'Dmitriy','Glaznov','$2a$10$sIw5NSjuKZFWN0MfXfALtunZYIVPXwvMvisMXL6wLGcXthI35puM2','glaznov@mail.com','+375298958989','DOCTOR'),(4,'Serge','Surgeonov','$2a$10$sUkv4yJOqVrh20SkhpTb/eLvvO0ZM6BUNkj7R9RYAqVtuqt9NnYzq','surgeonov@gmail.com','+375298957877','DOCTOR'),(5,'user1','userov1','$2a$10$eSF6XnNNHMxZmVj0G9SsWOMBzxGbp/kGLDfT.0N4bbvRe.CNxalSq','user1@gmail.com','+37525123121','USER'),(6,'Receptionist1','moder1','$2a$10$w/1FbOnlzmY/YrVoCR5SO.MviQJkkghOBjfM3UtUm5F0z/oYHcVDq','rcp1@gmail.com','+375254556989','MODERATOR'),(7,'Receptionist2','moder2','$2a$10$0SFkknX955BlKJ4HvQtwDOLneBUd2ZRQ0lPc9IsdmHc/7z54ENUU6','rcp2@gmail.com','+375256565896','MODERATOR'),(8,'user2','userov2','$2a$10$vlwRQ7bVTwk37SDsQhb9LOgF2HfPaW3mAvFOjCQW8qbIQb2CiR0R6','user2@gmail.com','+3752988888','USER'),(9,'user3','userov3','$2a$10$CVF6rCRJEgR5JDWHla8hr.XDpyTAu393WIEBfaXkPCk.QdGx3XzHa','user3@gmail.com','+375290008','USER'),(10,'user4','userov4','$2a$10$gT9fgJkzwCyJAe5w5DUyH.abbDp8dVYQgL3WMMzQpR2f6YHYg7pAq','user4@gmail.com','+375257778888','USER'),(11,'user5','userov5','$2a$10$vOY1MtVb5Ri9SC3uPvyAG.jmht2iCqYCe4QhXG71h7zDn3vyCGDf6','user5@gmail.com','+375255551122','USER'),(12,'user6','userov6','$2a$10$r0LwJfLJujJ6h1GQ3INAMOBFqypk4KyimF2f5Ew.i7qNSwziKM5bC','user6@gmail.com','+375258529637','USER'),(13,'user7','userov7','$2a$10$QctKbdCjMXlpIwhKFGFkI.cDxKkvSGJD1jqD/jn2aeCKSjlIv6P06','user7@gmail.com','+375258529631','USER'),(14,'user8','userov8','$2a$10$jQTnf2AcVshAUhFdXZ0UCujATqfLDK.mPor78c3xL52hv5h9xxw8u','user8@gmail.com','+375258529632','USER'),(15,'user9','userov9','$2a$10$FlRTMrejXS4kDPuKW/dp8.vaZpfuLji6ykN5pfaTJE2wjsipneNOe','user9@gmail.com','+375258529633','USER'),(16,'user10','userov10','$2a$10$BjNQx41I3DKM965JlD6ET.k6u0dIXXLzMTc6u1y4AaQ7c6VMNgrmG','user10@gmail.com','+375258529634','USER'),(27,'Karl','Psyhonov','$2a$10$YYvtJSYVOAnNRBMAzuczoOIKN8REnjW1YdeMZabiALB3hlswNONE.','psychonov@gmail.com','+321000','DOCTOR'),(29,'Danila','Buhnov','$2a$10$Y1hlHGacQBe5F7cEygbuk.4edXuTORSKQFUB3/vHPOZSPfvsFCqZa','buhnov@gmail.com','+33330909','DOCTOR'),(33,'Paul','Guzy','$2a$10$pUx31Z7bZ///NAzpMjGwduhtTzijAiQytw05eKJg2mMcypmWXyQNu','admin2@gmail.com','+375298634430','ADMIN');
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

-- Dump completed on 2022-01-30 13:47:43
