/*
Navicat MySQL Data Transfer

Source Server         : localhost mysql
Source Server Version : 50561
Source Host           : localhost:3306
Source Database       : zhurong

Target Server Type    : MYSQL
Target Server Version : 50561
File Encoding         : 65001

Date: 2019-04-17 17:05:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for project_data_source
-- ----------------------------
DROP TABLE IF EXISTS `project_data_source`;
CREATE TABLE `project_data_source` (
  `data_source_id` varchar(32) NOT NULL COMMENT '数据源标识',
  `project_id` varchar(32) NOT NULL COMMENT '项目标识',
  `db_type` varchar(32) NOT NULL COMMENT '数据库类型（mysql|oracle|sqlserver）',
  `env_type` varchar(32) NOT NULL COMMENT '环境类型（product=生产环境|dev=测试环境）',
  `host` varchar(15) NOT NULL COMMENT '数据库IP地址',
  `port` decimal(5,0) NOT NULL COMMENT '数据库端口',
  `sid` varchar(32) NOT NULL COMMENT 'sid/数据库名',
  `db_user` varchar(32) NOT NULL COMMENT '数据库用户名',
  `db_password` varchar(64) NOT NULL COMMENT '数据库密码',
  PRIMARY KEY (`data_source_id`),
  KEY `fk_datasource_ref_project` (`project_id`),
  CONSTRAINT `fk_datasource_ref_project` FOREIGN KEY (`project_id`) REFERENCES `project_info` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目数据源';

-- ----------------------------
-- Records of project_data_source
-- ----------------------------
INSERT INTO `project_data_source` VALUES ('11934815793356517341546174916717', 'p1', 'sqlserver', 'dev', '192.168.0.4', '1433', 'hdmis', 'sa', 'eUVLsPyCvmF44GSCMwkOkA==');
INSERT INTO `project_data_source` VALUES ('11938971576718217341546101681721', 'p1', 'mysql', 'dev', '192.168.0.183', '3306', 'edop', 'root', 'Y2Stg7pVXC2qDklrjBzXxQ==');
INSERT INTO `project_data_source` VALUES ('11942519875401917341546151889594', 'p1', 'mysql', 'dev', '192.168.0.183', '3306', 'hdrr', 'root', 'Y2Stg7pVXC2qDklrjBzXxQ==');
INSERT INTO `project_data_source` VALUES ('19436653188737820521420590472887', 'p1', 'oracle', 'dev', '192.168.0.181', '1521', 'orcl', 'cdflood', 'Y2Stg7pVXC2qDklrjBzXxQ==');
INSERT INTO `project_data_source` VALUES ('19447980978421120521420200774531', 'p1', 'sqlserver', 'dev', '192.168.0.4', '1433', 'hdmis', 'sa', 'eUVLsPyCvmF44GSCMwkOkA==');
INSERT INTO `project_data_source` VALUES ('19457482944434320521420188326119', 'p1', 'mysql', 'dev', '192.168.0.183', '3306', 'edop', 'root', 'Y2Stg7pVXC2qDklrjBzXxQ==');
INSERT INTO `project_data_source` VALUES ('2006536518563420521232204668219', 'p1', 'mysql', 'dev', '192.168.0.183', '3306', 'hdrr', 'root', 'Y2Stg7pVXC2qDklrjBzXxQ==');
INSERT INTO `project_data_source` VALUES ('2955773608684017341465197888987', 'p1', 'mysql', 'product', '192.168.0.87', '3306', 'datasource', 'root', 'aVGIHnSfdzxJjcaCVsQWXA==');
INSERT INTO `project_data_source` VALUES ('d1', 'p1', 'mysql', 'dev', '192.168.0.183', '3306', 'hdrr', 'root', 'Y2Stg7pVXC2qDklrjBzXxQ==');

-- ----------------------------
-- Table structure for tb_book_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_book_info`;
CREATE TABLE `tb_book_info` (
  `ID` varchar(32) NOT NULL COMMENT '表数据主键',
  `CATEGORY_CODE` varchar(32) DEFAULT NULL COMMENT '图书类别标准编码',
  `BOOK_NAME` varchar(128) NOT NULL COMMENT '书名',
  `ISBN` varchar(16) DEFAULT NULL COMMENT '图书ISBN号',
  `BOOK_WRITER` varchar(128) DEFAULT NULL COMMENT '作者',
  `BOOK_TRANSLATOR` varchar(128) DEFAULT NULL COMMENT '译者',
  `BOOK_PRESS` varchar(64) DEFAULT NULL COMMENT '出版社',
  `BOOK_PRICE` float(8,2) DEFAULT NULL COMMENT '图书定价',
  `PUBLISH_DATE` date DEFAULT NULL COMMENT '出版日期',
  `COVER_PIC_PATH` varchar(128) DEFAULT NULL COMMENT '封面图片路径',
  `CONTENT_BRIEF` varchar(1024) DEFAULT NULL COMMENT '内容简介',
  `WRITER_BRIEF` varchar(1024) DEFAULT NULL COMMENT '作者简介',
  `BOOK_CATALOG` varchar(1024) DEFAULT NULL COMMENT '图书目录',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `index_book_isbn` (`ISBN`) USING BTREE,
  KEY `index_book_name_author_press` (`BOOK_NAME`,`BOOK_WRITER`,`BOOK_PRESS`) USING BTREE,
  KEY `index_book_name` (`BOOK_NAME`) USING BTREE,
  KEY `index_book_writer` (`BOOK_WRITER`) USING BTREE,
  KEY `index_book_press` (`BOOK_PRESS`) USING BTREE,
  KEY `index_book_name_author` (`BOOK_NAME`,`BOOK_WRITER`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='图书表，本表存储所有图书信息';

-- ----------------------------
-- Records of tb_book_info
-- ----------------------------

-- ----------------------------
-- Table structure for tb_merch_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_merch_user`;
CREATE TABLE `tb_merch_user` (
  `ID` varchar(32) NOT NULL COMMENT '表数据主键',
  `MERCH_USER_ID` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `MERCH_ID` varchar(16) DEFAULT NULL COMMENT '商户号，图书馆商户以L开头，出版社商户以P开头',
  `MERCH_USER_NAME` varchar(32) DEFAULT NULL COMMENT '用户姓名',
  `ACCOUNT_PWD` varchar(32) DEFAULT NULL COMMENT '登录密码密文',
  `NICK_NAME` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `USER_BIRTHDAY` date DEFAULT NULL COMMENT '用户出生日期',
  `BIRTHPLACE` varchar(32) DEFAULT NULL COMMENT '出生地',
  `GENDER` varchar(1) DEFAULT '3' COMMENT '性别，1男，2女，3未知',
  `MERCH_USER_EMAIL` varchar(128) DEFAULT NULL COMMENT '商户用户邮箱',
  `MERCH_USER_EMAIL_AUTH` varchar(1) DEFAULT NULL COMMENT '商户用户邮箱认证状态 0：未认证 1：已认证',
  `ALLOW_EMAIL_LOGIN` varchar(1) DEFAULT '1' COMMENT '是否允许使用邮箱登录0：不允许，1：允许',
  `MERCH_USER_MOBILE` varchar(16) DEFAULT NULL COMMENT '商户用户手机号码',
  `MERCH_USER_MOBILE_AUTH` varchar(1) DEFAULT NULL COMMENT '商户用户手机号码认证状态 0：未认证 1：已认证',
  `ALLOW_MOBILE_LOGIN` varchar(1) DEFAULT '1' COMMENT '是否允许使用手机号登录0：不允许，1：允许',
  `ACCOUNT_STATUS` varchar(1) DEFAULT NULL COMMENT '账户状态，0 未激活，1 已激活，2 已失效',
  `ROLE_CODE` varchar(32) DEFAULT NULL COMMENT '商户用户角色',
  `IS_FIRST_LOGIN` varchar(1) DEFAULT NULL COMMENT '是否为首次登录，0 首次，1 非首次',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最后登录时间',
  `LAST_FAIL_TIMES` int(11) DEFAULT NULL COMMENT '登录失败次数，默认为0，登录失败一次增加1，登录成功后重置为0',
  `RESET_PWD_FLAG` varchar(1) DEFAULT NULL COMMENT '密码设置标识  0：未设置密码  1：已设置完密码',
  `ID_FRONT_FACE_PIC_PATH` varchar(128) DEFAULT NULL COMMENT '身份证正面',
  `ID_BACK_FACE_PIC_PATH` varchar(128) DEFAULT NULL COMMENT '背面',
  `ID_AUTH_FLAG` varchar(1) DEFAULT NULL COMMENT '身份证是否经过认证，0：未认证 1：已认证',
  `IS_VIP` varchar(1) DEFAULT '1' COMMENT '是否为VIP，0 是，1否',
  `CREATOR` varchar(32) DEFAULT NULL COMMENT '创建者',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATER` varchar(32) DEFAULT NULL COMMENT '修改者',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `uindex_user_mobile` (`MERCH_USER_MOBILE`) USING BTREE,
  UNIQUE KEY `uindex_user_email` (`MERCH_USER_EMAIL`) USING BTREE,
  KEY `index_merch_id` (`MERCH_ID`) USING BTREE,
  KEY `index_user_name` (`MERCH_USER_NAME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='商户用户表';

-- ----------------------------
-- Records of tb_merch_user
-- ----------------------------
INSERT INTO `tb_merch_user` VALUES ('2e26ef1e1f314b06b34f7c4ec7448588', null, null, '曾疟', null, null, null, null, null, 'rvj8m390@263.net', null, null, '13386054363', null, null, null, null, null, null, null, null, null, null, null, null, null, '2019-03-18 11:58:08', null, null, null);
INSERT INTO `tb_merch_user` VALUES ('b69fad0d12794212a44d555d8fc2dca4', null, null, '陈岗奢', null, null, null, null, null, 'r8i2406@googlemail.com', null, null, '18020134498', null, null, null, null, null, null, null, null, null, null, null, null, null, '2019-03-19 16:44:26', null, null, null);
