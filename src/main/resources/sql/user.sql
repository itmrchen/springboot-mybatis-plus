/*
Navicat MySQL Data Transfer

Source Server         : yun
Source Server Version : 50720
Source Host           : 106.13.101.17:3306
Source Database       : javazx

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-09-23 00:31:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `manager_id` bigint(20) DEFAULT NULL COMMENT '直属上级id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `version` int(11) DEFAULT '1' COMMENT '版本',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除标识(0.未删除,1.已删除)',
  PRIMARY KEY (`id`),
  KEY `manager_fk` (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1087982257332887553', '大boss', '40', 'boss@baomidou.com', null, '2019-01-11 14:20:20', null, '1', '0');
INSERT INTO `user` VALUES ('1088248166370832385', '王天风', '89', 'wtf@baomidou.com', '1087982257332887553', '2019-02-05 11:12:22', '2019-09-21 10:12:20', '2', '0');
INSERT INTO `user` VALUES ('1088250446457389058', '李艺伟', '28', 'lyw@baomidou.com', '1088248166370832385', '2019-02-14 08:31:16', null, '1', '0');
INSERT INTO `user` VALUES ('1094590409767661570', '张雨琪', '31', 'zjq@baomidou.com', '1088248166370832385', '2019-01-14 09:15:15', null, '1', '0');
INSERT INTO `user` VALUES ('1094592041087729666', '刘红雨', '32', 'lhm@baomidou.com', '1088248166370832385', '2019-01-14 09:48:16', null, '1', '1');
INSERT INTO `user` VALUES ('1175102582711279617', '李海', '21', '3232323@qq.com', '1088248166370832385', null, null, '1', '0');
INSERT INTO `user` VALUES ('1175103405952495617', '李海', '21', '3232323@qq.com', '1088248166370832385', null, null, '1', '0');
INSERT INTO `user` VALUES ('1175103735939358722', '李海', '21', '3232323@qq.com', '1088248166370832385', null, null, '1', '0');
INSERT INTO `user` VALUES ('1175103954538110978', '李海', '21', '3232323@qq.com', '1088248166370832385', null, null, '1', '0');
INSERT INTO `user` VALUES ('1175104096922128385', '李海', '21', '3232323@qq.com', '1088248166370832385', '2019-09-20 12:47:04', null, '1', '0');
INSERT INTO `user` VALUES ('1175104188987084801', '李海', '21', '3232323@qq.com', '1094592041087729666', '2019-09-20 12:47:26', null, '1', '0');
INSERT INTO `user` VALUES ('1175425994172289025', '李海', '21', '3232323@qq.com', '1088248166370832385', '2019-09-21 10:06:10', null, '1', '0');
INSERT INTO `user` VALUES ('1175427543766294530', '李海', '21', '3232323@qq.com', '1088248166370832385', '2019-09-21 10:12:19', null, '1', '0');
