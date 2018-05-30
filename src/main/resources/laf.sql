/*
SQLyog Community v12.5.1 (64 bit)
MySQL - 5.0.67-community-nt : Database - laf
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`laf` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `laf`;

/*Table structure for table `album` */

DROP TABLE IF EXISTS `album`;

CREATE TABLE `album` (
  `album_id` int(11) NOT NULL,
  `album_name` varchar(255) default NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY  (`album_id`),
  KEY `FK2d903rg52flpckd72p1dqqyq6` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `album` */

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `id` int(11) NOT NULL,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `emp` */

/*Table structure for table `images` */

DROP TABLE IF EXISTS `images`;

CREATE TABLE `images` (
  `image_id` int(11) NOT NULL,
  `image_name` varchar(255) default NULL,
  `album_id` int(11) default NULL,
  PRIMARY KEY  (`image_id`),
  KEY `FK86jr9sdu9k7sxdnch2lai7vm8` (`album_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `images` */

/*Table structure for table `postinfo` */

DROP TABLE IF EXISTS `postinfo`;

CREATE TABLE `postinfo` (
  `postId` decimal(50,0) NOT NULL,
  `userId` decimal(50,0) NOT NULL,
  `postName` varchar(50) default NULL,
  PRIMARY KEY  (`postId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `postinfo` */

insert  into `postinfo`(`postId`,`userId`,`postName`) values 
(2000,1000,'found data');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `pwd` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `user` */

/*Table structure for table `user_data` */

DROP TABLE IF EXISTS `user_data`;

CREATE TABLE `user_data` (
  `id` decimal(50,0) NOT NULL,
  `name` varchar(50) default NULL,
  `pwd` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `user_data` */

insert  into `user_data`(`id`,`name`,`pwd`) values 
(1000,'srinivas','srinivas');

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `user_info` */

/*Table structure for table `userdashboard` */

DROP TABLE IF EXISTS `userdashboard`;

CREATE TABLE `userdashboard` (
  `postId` int(11) NOT NULL,
  `postType` char(1) NOT NULL,
  `post_id` int(11) NOT NULL,
  `post_type` char(1) NOT NULL,
  PRIMARY KEY  (`postId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `userdashboard` */

insert  into `userdashboard`(`postId`,`postType`,`post_id`,`post_type`) values 
(2000,'f',0,'');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
