/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.32 : Database - roledata
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`roledata` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `roledata`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` int(11) NOT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `nickName` varchar(255) DEFAULT NULL,
  `headIcon` varchar(255) DEFAULT NULL,
  `roomCard` int(11) NOT NULL,
  `unionid` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `sex` int(1) NOT NULL,
  `prizecount` int(11) NOT NULL,
  `manager_up_id` int(11) NOT NULL DEFAULT '0',
  `actualCard` int(11) NOT NULL,
  `totalCard` int(11) NOT NULL,
  `createTime` datetime NOT NULL,
  `lastLoginTime` datetime DEFAULT NULL,
  `status` char(1) NOT NULL DEFAULT '0',
  `isGame` varchar(255) DEFAULT NULL,
  `invite` int(11) NOT NULL DEFAULT '0',
  `inviteReward` int(11) NOT NULL DEFAULT '0',
  `inviteGettedReward` int(11) NOT NULL DEFAULT '0',
  `playTimes` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `gameaccountindex` */

DROP TABLE IF EXISTS `gameaccountindex`;

CREATE TABLE `gameaccountindex` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `accountIndex` int(1) NOT NULL,
  `cardList` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_GAME_INDEX_ID` (`game_id`),
  KEY `PK_ACCOUNT_INDEX_ID` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `gamerecord` */

DROP TABLE IF EXISTS `gamerecord`;

CREATE TABLE `gamerecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_id` int(11) NOT NULL,
  `type` char(1) NOT NULL,
  `cardIndex` varchar(11) NOT NULL,
  `acountindex_id` int(11) NOT NULL,
  `curentTime` datetime NOT NULL,
  `playerList_one` varchar(255) NOT NULL,
  `playerList_two` varchar(255) NOT NULL,
  `playerList_three` varchar(255) NOT NULL,
  `playerList_four` varchar(255) NOT NULL,
  `status` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `PK_GAMERECORD_GAME_ID` (`game_id`),
  KEY `PK_GAMERECORD_ACCOUNTINDEX_ID` (`acountindex_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `invite` */

DROP TABLE IF EXISTS `invite`;

CREATE TABLE `invite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inviteId` int(11) NOT NULL,
  `invitedid` int(11) NOT NULL,
  `inviteTime` datetime NOT NULL,
  `reward` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `power_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `actualCard` int(11) NOT NULL DEFAULT '0',
  `totalCards` int(11) NOT NULL DEFAULT '0',
  `manager_up_id` int(11) DEFAULT '1',
  `status` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `PK_MANANGER_MANAGER_ID` (`manager_up_id`),
  KEY `PK_MANAGER_POWER_M_ID` (`power_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `noticetable` */

DROP TABLE IF EXISTS `noticetable`;

CREATE TABLE `noticetable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `type` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `operatelog` */

DROP TABLE IF EXISTS `operatelog`;

CREATE TABLE `operatelog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_id` int(11) NOT NULL,
  `manager_down_id` int(11) DEFAULT NULL,
  `account_id` int(11) DEFAULT NULL,
  `createTime` datetime NOT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `type` char(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_OPERATELOG_MANAGER` (`manager_id`),
  KEY `PK_OPERATELOG_MANAGER_DOWN` (`manager_down_id`),
  KEY `PK_OPERATELOG_ACCOUNT` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `paylog` */

DROP TABLE IF EXISTS `paylog`;

CREATE TABLE `paylog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `send_manager_Id` int(11) DEFAULT NULL,
  `reced_Id` int(11) DEFAULT NULL,
  `receType` int(11) DEFAULT NULL,
  `payCount` int(11) DEFAULT NULL,
  `payTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_PAYLOG_MANAGER_ID` (`send_manager_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `orderNum` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `ticket` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `finished` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`orderNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `playrecord` */

DROP TABLE IF EXISTS `playrecord`;

CREATE TABLE `playrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `playrecord` longtext,
  `standingsDetail_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_STANDINGSDETAIL_PLAYRECORDID` (`standingsDetail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `power` */

DROP TABLE IF EXISTS `power`;

CREATE TABLE `power` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `status` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `prize` */

DROP TABLE IF EXISTS `prize`;

CREATE TABLE `prize` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `index_id` int(11) NOT NULL,
  `prize_name` varchar(255) NOT NULL,
  `image_url` varchar(255) NOT NULL,
  `probability` int(6) NOT NULL DEFAULT '100',
  `status` char(1) NOT NULL DEFAULT '0',
  `prizecount` int(11) NOT NULL DEFAULT '1',
  `type` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `prizerule` */

DROP TABLE IF EXISTS `prizerule`;

CREATE TABLE `prizerule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `precount` int(11) DEFAULT NULL,
  `status` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `roominfo` */

DROP TABLE IF EXISTS `roominfo`;

CREATE TABLE `roominfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gameType` char(1) DEFAULT NULL,
  `isHong` char(1) DEFAULT '0',
  `roomid` int(11) DEFAULT NULL,
  `sevenDouble` char(1) DEFAULT '0',
  `ma` int(11) DEFAULT NULL,
  `zimo` char(1) DEFAULT NULL,
  `xiayu` int(2) DEFAULT '0',
  `addWordCard` char(1) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `cardNumb` int(11) DEFAULT NULL,
  `totalPlayers` int(4) NOT NULL DEFAULT '4',
  `shengyu20` char(1) DEFAULT NULL,
  `threefornext` char(1) DEFAULT NULL,
  `showTingPai` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `standings` */

DROP TABLE IF EXISTS `standings`;

CREATE TABLE `standings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roomid` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `createTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_ROOM_STANDINGS_ID` (`roomid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `standingsaccountrelation` */

DROP TABLE IF EXISTS `standingsaccountrelation`;

CREATE TABLE `standingsaccountrelation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `standings_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_STANDINGS_ACCOUNT_ID` (`standings_id`),
  KEY `PK_ACCOUNT_STANDINGS_ID` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `standingsdetail` */

DROP TABLE IF EXISTS `standingsdetail`;

CREATE TABLE `standingsdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `standingsrelation` */

DROP TABLE IF EXISTS `standingsrelation`;

CREATE TABLE `standingsrelation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `standings_id` int(11) NOT NULL,
  `standingsDetail_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_STANDINGS_⁯ID` (`standings_id`),
  KEY `PK_STANDINGSDETAIL_ID` (`standingsDetail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `techargerecord` */

DROP TABLE IF EXISTS `techargerecord`;

CREATE TABLE `techargerecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_id` int(11) DEFAULT NULL,
  `manager_id` int(11) DEFAULT NULL,
  `manager_up_id` int(11) NOT NULL DEFAULT '0',
  `createtime` datetime NOT NULL,
  `techargeMoney` int(11) NOT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `status` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `PK_TECHARGEREORD_ACCOUNT_ID` (`account_id`),
  KEY `PK_TECHARGEREORD_MANAGER_ID` (`manager_id`),
  KEY `PK_TECHARGEREORD_MANAGER_UP_ID` (`manager_up_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `winnersinfo` */

DROP TABLE IF EXISTS `winnersinfo`;

CREATE TABLE `winnersinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prize_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `createTime` datetime NOT NULL,
  `awardTime` datetime DEFAULT NULL,
  `status` char(1) NOT NULL DEFAULT '0',
  `mark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `PK_PRIZE_WINNERSINFO_ID` (`prize_id`),
  KEY `PK_ACCOUNT_WINNERSINFO_ID` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
