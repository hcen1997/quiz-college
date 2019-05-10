﻿# Host: localhost  (Version: 5.5.53)
# Date: 2019-05-07 16:29:14
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "person"
#

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `exp` int(11) DEFAULT NULL,
  `hint` int(11) DEFAULT NULL,
  `heart` int(11) DEFAULT NULL,
  `heartp` int(11) DEFAULT NULL,
  `medle` int(11) DEFAULT NULL,
  `treastrl` int(11) DEFAULT NULL,
  `ranking` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "person"
#

/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'hcen',355,29,5,30,1,4,12000),(2,'xiaoming',0,20,5,15,0,0,999);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
