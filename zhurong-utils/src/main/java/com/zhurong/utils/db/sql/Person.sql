/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50131
Source Host           : localhost:3306
Source Database       : cacheauth

Target Server Type    : MYSQL
Target Server Version : 50131
File Encoding         : 65001

Date: 2018-06-13 17:47:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '陆小凤', '28', '骚气');
INSERT INTO `person` VALUES ('2', '花满楼', '32', '花谢花飞花满天');
INSERT INTO `person` VALUES ('3', '上官飞燕', '22', '一个妹子');
INSERT INTO `person` VALUES ('4', '叶孤城', '26', '我是通过Java命令而修改的记录');
INSERT INTO `person` VALUES ('5', '西门吹雪', '22', '我是通过Java命令而增加的记录');