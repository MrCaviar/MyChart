/*
Navicat MySQL Data Transfer

Source Server         : MyChart
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : mycharttest

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-01-13 17:49:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bwsi
-- ----------------------------
DROP TABLE IF EXISTS `bwsi`;
CREATE TABLE `bwsi` (
  `wsi_id` int(11) NOT NULL AUTO_INCREMENT,
  `sec_name` varchar(8) NOT NULL COMMENT '证券简称',
  `trade_code` varchar(10) NOT NULL COMMENT '证券代码',
  `time` datetime NOT NULL COMMENT '时刻',
  `open` float(10,6) DEFAULT NULL COMMENT '开盘价',
  `high` float(10,6) DEFAULT NULL COMMENT '最高价',
  `low` float(10,6) DEFAULT NULL COMMENT '最低价',
  `close` float(10,6) DEFAULT NULL COMMENT '收盘价',
  `volume` float(26,6) DEFAULT NULL COMMENT '成交量',
  `amt` float(26,6) DEFAULT NULL COMMENT '成交额',
  `average` float(10,6) DEFAULT NULL COMMENT '均价',
  PRIMARY KEY (`wsi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=767 DEFAULT CHARSET=utf8 COMMENT='分钟序列';
