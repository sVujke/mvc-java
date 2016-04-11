/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.6.17 : Database - g1-2012
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`g1-2012` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `g1-2012`;

/*Table structure for table `tpolozio` */

DROP TABLE IF EXISTS `tpolozio`;

CREATE TABLE `tpolozio` (
  `BrojPrijave` varchar(30) DEFAULT NULL,
  `GodinaUpisa` varchar(30) DEFAULT NULL,
  `BrojIndexa` varchar(30) DEFAULT NULL,
  `SifraPredmeta` varchar(30) DEFAULT NULL,
  `Ocena` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tpolozio` */

insert  into `tpolozio`(`BrojPrijave`,`GodinaUpisa`,`BrojIndexa`,`SifraPredmeta`,`Ocena`) values ('10000','2012','47','1','10'),('15000','2012','47','2','10'),('12563','2008','43','1','10'),('68958','2047','47','1','9');

/*Table structure for table `tpredmet` */

DROP TABLE IF EXISTS `tpredmet`;

CREATE TABLE `tpredmet` (
  `SifraPredmeta` varchar(30) DEFAULT NULL,
  `NazivPredmeta` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tpredmet` */

insert  into `tpredmet`(`SifraPredmeta`,`NazivPredmeta`) values ('1','ITEH'),('2','ProSoft');

/*Table structure for table `tstudent` */

DROP TABLE IF EXISTS `tstudent`;

CREATE TABLE `tstudent` (
  `GodinaUpisa` varchar(30) DEFAULT NULL,
  `BrojIndexa` varchar(30) DEFAULT NULL,
  `Ime` varchar(30) DEFAULT NULL,
  `Prezime` varchar(30) DEFAULT NULL,
  `Godina` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tstudent` */

insert  into `tstudent`(`GodinaUpisa`,`BrojIndexa`,`Ime`,`Prezime`,`Godina`) values ('2012','47','Stefan','Vujovic','4'),('2047','47','Piter','Popovic','2'),('2011','43','Baki','Vidojevic','1'),('2008','43','Milic','Radovic','4');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
